import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactTest {
    public static void main(String[] args) {
        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory,filename);

        List<String> contacts = new ArrayList<>();
        contacts.add("Nayo | 123-234-2344");
        contacts.add("MH | 123-234-2344");

        boolean running = true;
        do {
            System.out.println(returnMenuDisplay());
            Scanner scanner = new Scanner(System.in);
            int userInput = Integer.parseInt((scanner.nextLine()));
            System.out.println(userInput);
        }while(running);


        //Method - create directory
        createDir(dataDirectory);

        //Method - create file
        createFile(dataFile);

        //Method - write File
        writeFile(dataFile, contacts);

    }

    //creating contacts menu
    public static String returnMenuDisplay(){
        String userChoices = "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5)";
        return userChoices;
    }

    //creating a directory
    private static void createDir(Path aDir) {
        if (Files.notExists(aDir)) {
            try {
                Files.createDirectory(aDir);
            } catch (IOException e) {
                System.out.println("Problems creating the directory");
                e.printStackTrace();
            }
        }
    }

    public static void createFile(Path aFile){
        if (!Files.exists(aFile)){
            try{
                Files.createFile(aFile);
            } catch (IOException e){
                System.out.println("Problems creating the file ");
                e.printStackTrace();
            }
        }
    }

    public static void writeFile(Path aFile, List<String>aList){
        try{
            Files.write(aFile,aList, StandardOpenOption.APPEND);
        } catch (IOException e){
            System.out.println("Problems writing the file");
            e.printStackTrace();
        }
    }







}



