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
        boolean isValid = false;
        String speech = "";
        while(!isValid){
            speech = getInput();
            while(speech.length() != 1){
                speech = getInput();
            }
            if(isCyrillic(speech.charAt(0))){
                isValid = true;
            }
        }
        return speech.charAt(0);
    }
    private boolean isCyrillic(char letter){
        char  FIRST_RUSSIAN_LETTER = 'а';
        char LAST_RUSSIAN_LETTER = 'я';
        return letter >= FIRST_RUSSIAN_LETTER && letter <= LAST_RUSSIAN_LETTER || letter == 'ё' ;
    }
}
