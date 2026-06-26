package tool;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public abstract class WordsExtracter {
     private static final Path filePath = Paths.get("src","main","resources","Nouns.txt");

     public static String[] getExtracted(){
          return  extract();
     }

     private static String[] extract(){
          List<String> wordsList = new ArrayList<>();

          try(BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))){
               while(br.ready()){
                    wordsList.add(br.readLine());
               }
          }catch (IOException e){
               System.out.println(e.getMessage());
          }
          return wordsList.toArray(new String[0]);
     }
}
