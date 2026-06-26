package entity;
import tool.WordsExtracter;
public class WordMaker {
    private String word;
    private int length;
    public String getWord(){
        return  word;
    }

    public void setWord(){
        word = pickWordFrom(WordsExtracter.getExtracted());
        length = word.length();
    }
    public int getLength(){
        return length;
    }

    private String pickWordFrom(String[] words){
        String pickedWord;
        int index = (int) (Math.random() * words.length-1);
        pickedWord = words[index];
        return pickedWord;
    }

}
