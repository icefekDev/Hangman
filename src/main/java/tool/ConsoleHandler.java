package tool;
import java.io.IOException;
import java.util.Scanner;
public abstract class ConsoleHandler {

    public static String getInput(){
        String value = "error";

        try( Scanner scanner = new Scanner(System.in)){
            value = scanner.next();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return value;
    }
}
