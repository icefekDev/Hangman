import entity.HangmanUI;
import entity.Judge;
import entity.Player;
import entity.WordPicker;
import tool.ConsoleHandler;

public class Launcher {
    public static void main(String[] args){
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
                playerInput = player.getInput();

                if(playerInput.equals("выход")){
                    ConsoleHandler.closeScanner();
                    return;
                }
            }

            // Do when new game starts
            hangmanUI.drawWelcomeMessage();
            wordPicker.pickWord();
            judge.setUp(wordPicker.getWord());

            // Round loop
            while(isRoundContinue){
                // Draw hangman block with hints
                hangmanUI.drawHangman(player.getMistakes(),judge.getWordForUser());
                hangmanUI.drawPreviousAssumptions(player.getAssumptions());

                //User input block
                hangmanUI.drawUserAnswerHeader();
                char playerAssumption = player.makeAssumption();
                hangmanUI.drawUserAnswerFooter();

                player.addLetterToAssumptions(playerAssumption);

                // Answer checking block
                if(judge.checkIsLetterHere(playerAssumption)){
                    hangmanUI.drawPlayerWasRight();
                    if(judge.getWordForUser().equals(wordPicker.getWord())){
                        hangmanUI.drawHangman(player.getMistakes(), wordPicker.getWord());
                        hangmanUI.drawPlayerWon();
                        isRoundContinue = false;
                    }
                }
                else{
                    player.increaseMistakes(1);
                    hangmanUI.drawPlayerWasWrong(player.getMistakes());
                    if(player.getMistakes() == 5){
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
