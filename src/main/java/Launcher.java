import entity.HangmanUI;
import entity.Judge;
import entity.Player;
import entity.WordPicker;
import tool.ConsoleHandler;

public class Launcher {
    public static void main(String[] args){
        int MAX_MISTAKES = 5;
        HangmanUI hangmanUI = new HangmanUI();
        Judge judge = new Judge();
        WordPicker wordPicker = new WordPicker();
        Player player = new Player();

        String playerInput = "";

        // The main loop
        while(true){
            boolean isRoundContinue = true;

            //asking for exit or start the game
            while(!playerInput.equals("старт")){
                hangmanUI.drawRestartSuggestion();
                playerInput = player.saySomething();

                if(playerInput.equals("выход")){
                    ConsoleHandler.closeScanner();
                    return;
                }
            }

            // Do when new game starts
            hangmanUI.drawWelcomeMessage();
            wordPicker.pickWord();
            judge.setOriginalWord(wordPicker.getWord());
            judge.openRandomLetter();

            // Round loop
            while(isRoundContinue){
                // Draw hangman block with hints
                hangmanUI.drawHangman(player.getMistakes(),judge.getSecretedWord());
                hangmanUI.drawPreviousAssumptions(player.getAssumptions());

                //User input block
                hangmanUI.drawUserAnswerHeader();
                char playerAssumption = player.makeAssumption();
                for(char assumption : player.getAssumptions()){
                    while (playerAssumption == assumption){
                        playerAssumption = player.makeAssumption();
                    }
                }
                hangmanUI.drawUserAnswerFooter();

                player.addLetterToAssumptions(playerAssumption);

                // Answer checking block
                if(judge.isLetterInWord(playerAssumption)){
                    judge.updateSecretedWord(playerAssumption);
                    hangmanUI.drawPlayerWasRight();
                    if(judge.getSecretedWord().equals(wordPicker.getWord())){
                        hangmanUI.drawHangman(player.getMistakes(), wordPicker.getWord());
                        hangmanUI.drawPlayerWon();
                        isRoundContinue = false;
                    }
                }
                else{
                    player.increaseMistakes(1);
                    hangmanUI.drawPlayerWasWrong(player.getMistakes());
                    if(player.getMistakes() == MAX_MISTAKES){
                        hangmanUI.drawHangman(player.getMistakes(), wordPicker.getWord());
                        isRoundContinue = false;
                    }
                }
            }
            playerInput = "";
            player.reset();
        }
    }
}
