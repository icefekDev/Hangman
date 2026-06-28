package entity;

public class HangmanUI {
    private int state;

    public void drawWelcomeMessage(){
        System.out.println();
        System.out.println("================================");
        System.out.println("=   Game session was started   =");
        System.out.println("================================");
        System.out.println();
    }

    public void drawPlayerWon(){
        System.out.println();
        System.out.println("================================");
        System.out.println("=    !!YOU WON THIS GAME!!     =");
        System.out.println("================================");
        System.out.println();
    }

    public void drawPlayerWasRight(){
        System.out.println();
        System.out.println("================================");
        System.out.println("=CONGRATULATIONS! YOU ARE RIGHT=");
        System.out.println("================================");
        System.out.println();
    }

    public void drawPreviousAssumptions(Character[] assumptions){
        System.out.println("================================");
        System.out.println("    YOU HAVE ALREADY ENTER:");
        for(char assumption : assumptions){
            System.out.print(" " + assumption + ",");
        }
        System.out.println();
        System.out.println("================================");
        System.out.println();
    }

    public void drawPlayerWasWrong(int mistakes){
        System.out.println();
        System.out.println("================================");
        System.out.println("=I'M SORRY! YOU DID A MISTAKE..=");
        System.out.println("=    you have "+(5-mistakes)+" lives left    =");
        System.out.println("================================");
        System.out.println();
    }

    public void drawRestartSuggestion(){
        System.out.println("==============================================");
        System.out.println("=  Please type 'Старт' if you want to continue \n 'Выход'" +
                " to close the application            =");
        System.out.println("==============================================");
    }

    public void drawUserAnswerHeader(){
        System.out.println("================================");
        System.out.println("=    ENTER YOUR LETTER HERE:   =");
    }
    public void drawUserAnswerFooter(){
        System.out.println("================================");
        System.out.println();
    }

    public void drawHangman(int userMistakes,String word){
        System.out.println("================================");
        switch (userMistakes){
            case 0 ->{
                System.out.println("""
                           ┌──────────┐
                           │          │
                           │          \s
                           │          \s
                           │          \s
                           │          \s
                           │          \s
                        ───┴───────────""");
            }
            case 1 ->{
                System.out.println("""
                           ┌──────────┐
                           │          │
                           │         ( )
                           │          \s
                           │          \s
                           │          \s
                           │          \s
                        ───┴───────────""");
            }
            case 2 ->{
                System.out.println("""
                           ┌──────────┐
                           │          │
                           │         ( )
                           │          │
                           │          │
                           │          \s
                           │          \s
                        ───┴───────────""");
            }
            case 3 ->{
                System.out.println("""
                           ┌──────────┐
                           │          │
                           │         ( )
                           │         \\│/
                           │          │
                           │          \s
                           │          \s
                        ───┴───────────""");
            }
            case 4 ->{
                System.out.println("""
                           ┌──────────┐
                           │          │
                           │        \\( )/
                           │         \\│/
                           │          │
                           │         ╱ ╲
                           │        ╱   ╲
                        ───┴───────────""");
            }
            case 5 ->{
                System.out.println("""
                           ┌──────────┐
                           │          │
                           │        \\(x)/
                           │         \\│/
                           │          │
                           │         ╱ ╲
                           │        ╱   ╲
                        ───┴───────────
                        ===================
                        =    GAME OVER    =
                        ===================""");
                System.out.print("The word was: ");
            }

        }
        System.out.println(" "+word);
        System.out.println("================================");
        System.out.println();
    }

}
