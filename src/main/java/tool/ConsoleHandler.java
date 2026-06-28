package tool;
import java.util.Scanner;
public abstract class ConsoleHandler {
    private static final Scanner scanner = new Scanner(System.in);

    //Returns user input in lower case
    public static String getInput() {
        String value = "";
        try {
            value = scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return value.toLowerCase();
    }

    public static void closeScanner(){
        scanner.close();
    }
}
