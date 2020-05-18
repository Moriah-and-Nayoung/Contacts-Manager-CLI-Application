import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactTest {
    static String directory = "data";
    static String filename = "contacts.txt";
    static Path dataDirectory = Paths.get(directory);
    static Path dataFile = Paths.get(directory, filename);

    public static void main(String[] args) {




//        Manually add to file
//        contacts.add("Nayo | 123-234-2344");
//        contacts.add("MH | 123-234-2344");

        boolean running = true;
        while (running) {
            System.out.println(returnMenuDisplay());
            int userInput = promptUserForChoice();
            running = executeUserChoice(userInput);
        }


        //Method - create directory
        createDir(dataDirectory);

        //Method - create file
        createFile(dataFile);

        //Method - read file
        readFile(dataFile);

//        System.out.println("contactsArray = " + contactsArray.isEmpty());
//        System.out.println("contactsArrayREALTest = " + contactsArray);
    }

    // User input selection

    private static boolean executeUserChoice(int choice) {
        boolean continueRunningApp = true;

        switch (choice) {
            case 1://view  contacts
                List<String> lines = readFile(dataFile);
                for (String line : lines) {
                    System.out.printf("TEST %s\n", line);
//                    Contact contact1 = new Contact("nayo","kim","123-123-1238");
//                    contactArray.add(contact1);
//                    System.out.println(contacts.getFirstName() + " " + contacts.getLastName() + " " + contacts.getPhoneNumber());
                }
                break;
            case 2: // add new contact

                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter your contact's first name");
                String enteredFirstName = scanner.nextLine();
                System.out.println("Enter your contact's last name");
               String enteredLastName = scanner.nextLine();
                System.out.println("Enter your contact's phone number");
               String enteredPhoneNumber = scanner.nextLine();
                System.out.println("enteredFirstName = " + enteredFirstName);
                System.out.println("enteredLastName = " + enteredLastName);
                System.out.println("enteredPhoneNumber = " + enteredPhoneNumber);
                List<String> contactsArray = new ArrayList<>();

                contactsArray.add(enteredFirstName);
                contactsArray.add(enteredLastName);
                contactsArray.add(enteredPhoneNumber);
                List<String> contactArray = Arrays.asList(enteredFirstName, enteredLastName, enteredPhoneNumber);
                System.out.println("ContactsArray: " + contactArray);
                break;

        }

        return true;
    }

    public static List<String> readFile(Path aFile) {
        try {
            return (Files.readAllLines(aFile));
        } catch (IOException e) {
            System.out.println("Problem reading the file");
            e.printStackTrace();
        }
        return null;
    }

    //creating contacts menu
    public static String returnMenuDisplay() {
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

    public static void createFile(Path aFile) {
        if (!Files.exists(aFile)) {
            try {
                Files.createFile(aFile);
            } catch (IOException e) {
                System.out.println("Problems creating the file ");
                e.printStackTrace();
            }
        }
    }

    public static void writeFile(Path aFile, List<String> aList) {
        try {
            Files.write(aFile, aList, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Problems writing the file");
            e.printStackTrace();
        }
    }

    //prompt for a response
    private static int promptUserForChoice() {
        Scanner scanner = new Scanner(System.in);
        int response = Integer.parseInt(scanner.nextLine());
        return response;
    }

}
