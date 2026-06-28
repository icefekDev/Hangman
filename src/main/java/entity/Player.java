package entity;
import tool.ConsoleHandler;
import java.util.HashSet;
public class Player implements Resetable {
    private int mistakes=0;
    private final HashSet<Character> assumptions = new HashSet<Character>();
    public int getMistakes(){
        return mistakes;
    }

    //Reset player stats
    public void reset(){
        assumptions.clear();
        mistakes = 0;
    }

    public void addLetterToAssumptions(char letter){
        assumptions.add(letter);
    }

    public Character[] getAssumptions(){
        return assumptions.toArray(new Character[0]);
    }

    public void increaseMistakes(int count){
        mistakes = mistakes+count;
    }

    public String getInput(){
        return ConsoleHandler.getInput();
    }

    // getInput() until it's only one symbol
    public char makeAssumption(){
        String playerInput = getInput();
        while(playerInput.length() != 1){
            playerInput = getInput();
        }
        return playerInput.charAt(0);
    }

}
