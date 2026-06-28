package entity;
import tool.WordsExtracter;
public class WordPicker {
    private String word;
    public String getWord(){
        return  word;
    }

    public void pickWord(){
        word = pickWordFrom(WordsExtracter.getExtracted());
    }

    private String pickWordFrom(String[] words){
        String pickedWord;
        int index = (int) (Math.random() * words.length-1);
        pickedWord = words[index];
        return pickedWord;
    }

}
