package entity;

public class WordMaker {
    private String word;

    public String getWord(){
        return  word;
    }

    public void setWord(){
        word = pickWordFrom(extractResources());
    }

    private String pickWordFrom(String[] words){
        String pickedWord;
        int index = (int) (Math.random() * words.length-1);
        pickedWord = words[index];
        return pickedWord;
    }

    private String[] extractResources(){
        
        return new String[1];
    }
}
