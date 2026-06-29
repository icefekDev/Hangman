package entity;

public class Judge {
    private int wordLength;
    private String originalWord;
    private String maskedWord;

    public String getMaskedWord(){
        return maskedWord;
    }

    public void setOriginalWord(String originalWord){
        this.originalWord = originalWord;
        wordLength = originalWord.length();
    }

    public void openRandomLetter(){
        StringBuilder maskedWordBuilder = new StringBuilder();
        char randomLetterFromWord = chooseRandomLetterFromWord();

        for(int i=0;i<wordLength;i++){
            maskedWordBuilder.append("_");
            if(originalWord.charAt(i) == randomLetterFromWord){
                maskedWordBuilder.setCharAt(i, randomLetterFromWord);
            }
            maskedWord = maskedWordBuilder.toString();
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

    public void updateMaskedWord(char letter){
        StringBuilder maskedWordBuilder = new StringBuilder(maskedWord);
        for(int i=0;i<wordLength;i++){
            if(originalWord.charAt(i) == letter){
                maskedWordBuilder.setCharAt(i, letter);
            }
            maskedWord = maskedWordBuilder.toString();
        }
    }

    private char chooseRandomLetterFromWord(){
        return originalWord.charAt((int) (Math.random() * wordLength));
    }


}
