// import java.io.InputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class CCWC {
    
    public static void main(String[] args){
        System.out.println(countWords("test.txt"));
    }

    private static long countBytes(String fileName) {
        File file = new File(fileName);
        if (file.exists()){
            return file.length();
        }
        else{
            return -1;
        }
    }

    private static long countLines(String fileName){
        long count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            while(br.readLine() != null) {
                count++;
            }
        }
        catch (IOException e){
            System.out.println("Error reading file.");
        }
        return count;
    }

    private static long countWords(String fileName){
        long count = 0;

        try{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                scanner.next();
                count++;
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.err.println("File not found: " + fileName);
        }

        return count;
    }
}
