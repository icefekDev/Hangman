package entity;

public class Judge {
    private int wordLength;
    private String wordOriginal;
    private String wordForUser;

    public String getWordForUser(){
        return wordForUser;
    }

    public void setUp(String wordOriginal){
        this.wordOriginal = wordOriginal;
        wordLength = wordOriginal.length();
        updateWordForUserOrGetFalse(chooseRandomLetterFromWord(),true);
    }

    public boolean checkIsLetterHere(char letter){
        return updateWordForUserOrGetFalse(letter,false);
    }

    private boolean updateWordForUserOrGetFalse(char letterToCheck, boolean newTurn){
        boolean wordForUserHasChanged = false;

        wordForUser = newTurn ? "" : wordForUser;

        StringBuilder wordForUserBuilder = new StringBuilder(wordForUser);

        for(int i=0;i<wordLength;i++){

            if(newTurn){
                wordForUserBuilder.append("_");
            }

            // Open a letter if true
            if(wordOriginal.charAt(i) == letterToCheck){
                wordForUserBuilder.setCharAt(i, letterToCheck);
                wordForUserHasChanged = true;
            }
        }

        wordForUser = wordForUserBuilder.toString();

        return wordForUserHasChanged;
    }

    private char chooseRandomLetterFromWord(){
        return wordOriginal.charAt((int) (Math.random() * wordLength));
    }


}
