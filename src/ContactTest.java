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

        List<String> contactsArray = new ArrayList<>();


//        contacts.add("Nayo | 123-234-2344");
//        contacts.add("MH | 123-234-2344");

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

        //Method - read file

        readFile(dataFile);

        System.out.println("contactsArray = " + contactsArray.isEmpty());
        System.out.println("contactsArrayREALTest = " + contactsArray);
    }

    // User input selection

//    private static boolean executeUserChoice(int choice) {
//        boolean continueRunningApp = true;
//
//        switch (choice) {
//            case 0:
//                continueRunningApp = false;
//                break;
//            case 1: //View contacts
//                System.out.println("\n");
//                for(Contacts contact : contacts.findAll()) {
//                    System.out.printf("%s -- %s\n", movie.getName(), movie.getCategory());
//                }
//                System.out.println("\n");
//                break;
//            case 2: //animated
//                System.out.println("\n");
//                 contactsArray.add("Iggy | 123-1234");
//                viewMoviesByCategory("animated");
//                System.out.println("\n");
//                break;
//            case 3: //drama
//                System.out.println("\n");
//                viewMoviesByCategory("drama");
//                System.out.println("\n");
//                break;
//            case 4: //horror
//                System.out.println("\n");
//                viewMoviesByCategory("horror");
//                System.out.println("\n");
//                break;
//            case 5: //scifi
//                System.out.println("\n");
//                viewMoviesByCategory("scifi");
//                  Method - write File
//                  writeFile(dataFile, contactsArray);
//                System.out.println("\n");
//                break;
//        }
//
//        return continueRunningApp;
//    }
//
//    private static void viewContacts(String category) {
//        for(Movie movie : MoviesArray.findAll()) {
//            if(movie.getCategory().equalsIgnoreCase(category)) {
//                //Display the movie.
//                System.out.printf("%s -- %s\n", movie.getFirstName(), movie.getCategory());
//            }
//        }
//    }




    public static void readFile(Path aFile) {
        try {
            List<String> lines = Files.readAllLines(aFile);
            for (String line : lines) {
                System.out.println("Contacts = " + line);
            }
        } catch (IOException e) {
            System.out.println("Problem reading the file");
            e.printStackTrace();
        }
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



