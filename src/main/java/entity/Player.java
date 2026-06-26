package entity;
import tool.ConsoleHandler;
public class Player {
    private int lives;

    public int getLives(){
        return lives;
    }

    public void setLives(int lives){
        this.lives = lives;
    }

    public String makeAGuess(){
        return ConsoleHandler.getInput();
    }

}
