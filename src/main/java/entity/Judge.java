package entity;

public class Judge {
    private int wordLength;
    private String originalWord;
    private String secretedWord;

    public String getSecretedWord(){
        return secretedWord;
    }

    public void setOriginalWord(String originalWord){
        this.originalWord = originalWord;
        wordLength = originalWord.length();
    }

    public void openRandomLetter(){
        StringBuilder secretedWordBuilder = new StringBuilder();
        char randomLetterFromWord = chooseRandomLetterFromWord();

        for(int i=0;i<wordLength;i++){
            secretedWordBuilder.append("_");
            if(originalWord.charAt(i) == randomLetterFromWord){
                secretedWordBuilder.setCharAt(i, randomLetterFromWord);
            }
            secretedWord = secretedWordBuilder.toString();
        }
    }

    public boolean isLetterInWord(char letter){
        for(int i=0;i<wordLength;i++){
            if(originalWord.charAt(i) == letter){
                return true;
            }
        }
        return false;
    }

    public void updateSecretedWord(char letter){
        StringBuilder secretedWordBuilder = new StringBuilder(secretedWord);
        for(int i=0;i<wordLength;i++){
            if(originalWord.charAt(i) == letter){
                secretedWordBuilder.setCharAt(i, letter);
            }
            secretedWord = secretedWordBuilder.toString();
        }
    }

    private char chooseRandomLetterFromWord(){
        return originalWord.charAt((int) (Math.random() * wordLength));
    }


}
