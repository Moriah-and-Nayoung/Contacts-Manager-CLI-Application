import java.io.File;
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
        boolean running = true;
        while (running) {
            System.out.println(returnMenuDisplay());
            int userInput = promptUserForChoice();
            running = executeUserChoice(userInput);
        }
    } // end main class

    // User input selection
    private static boolean executeUserChoice(int choice) {
        boolean continueRunningApp = true;
        switch (choice) {
            case 1://view  contacts
                File file = new File("data/contacts.txt");
                boolean emptyRead = file.exists() && file.length() == 0;
                if (!emptyRead == true) {
                    readFile(dataFile);
                } else {
                    System.out.println("your contacts list is empty, Add a friend!");
                }
                break;
            case 2: // add new contact
                writeFile(dataFile);
                break;
            case 3: //search
                file = new File("data/contacts.txt");
                boolean empty = file.exists() && file.length() == 0;
                if (!empty == true) {
                    searchContact();
                } else {
                    System.out.println("your contacts list is empty, try again");
                }
                break;
            case 4: //delete
                file = new File("data/contacts.txt");
                boolean emptyDelete = file.exists() && file.length() == 0;
                if (!emptyDelete == true) {
                    deleteEntry();
                } else {
                    System.out.println("your contacts list is empty, try again");
                }
                break;
            case 5: //end system
                Scanner scanner = new Scanner(System.in);
                System.out.println("Are you sure you want to exit? y/n");
                String userEndSystem = scanner.nextLine();
                if (!userEndSystem.toLowerCase().equals("y")) {
                    continueRunningApp = true;
                } else {
                    System.out.println("Have a good day!");
                    System.exit(0);
                }
                break;
        }
        return true;
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

    //prompt for a response
    public static int promptUserForChoice() {
        Scanner scanner = new Scanner(System.in);
        int response = Integer.parseInt(scanner.nextLine());
        return response;
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

    public static List<String> writeFile(Path aFile) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your contact's first name");
        String enteredFirstName = scanner.nextLine();
        System.out.println("Enter your contact's last name");
        String enteredLastName = scanner.nextLine();
        System.out.println("Enter your contact's phone number");
        String enteredPhoneNumber = scanner.nextLine();

        List<String> newEntry = Arrays.asList(enteredFirstName + " " + enteredLastName + "|" + enteredPhoneNumber);
        try {
            Files.write(aFile, newEntry, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Problems writing the file");
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> reWriteFile(Path file, List<String> list) {
        try {
            Files.write(file, list);
        } catch (IOException e) {
            System.out.println("Problems writing the file");
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> readFile(Path aFile) {
        try {
            List<String> lines = Files.readAllLines(aFile);
            System.out.printf("%-5s %s%n", "Name |", "Phone Number");
            System.out.println("--------------");
            for (String line : lines) {
                System.out.printf("%s\n", line);
            }
        } catch (IOException e) {
            System.out.println("Problem reading the file");
            e.printStackTrace();
        }
        return null;
    }

//    public static void emptyFile(){
//       File file = new File("data/contacts.txt");
//        boolean empty = file.exists() && file.length() == 0;
//        System.out.println(empty);
//    }

    public static String searchContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name you would like to search: ");
        String userSearch = sc.nextLine();

        Path filePath = Paths.get(directory, filename);
        while (true) {
            try {
                List<String> lines = Files.readAllLines(filePath);
                for (String line : lines) {
                    if (line.toLowerCase().contains(userSearch.toLowerCase())) {
                        System.out.println("Found: " + line);
                        return line;
                    }
                }
                System.out.println("Contact not found.");
                return searchContact();
            } catch (IOException e) {
                System.out.println("error in searching for contacts");
                e.printStackTrace();
            }
        }
    }

    public static void deleteEntry() {
        Scanner scanner = new Scanner(System.in);

        Path filePath = Paths.get(directory, filename);
        System.out.println("Who would you like to delete?");
        readFile(dataFile);
        String userDelete = scanner.nextLine();
        try {
            List<String> lines = Files.readAllLines(filePath);
            List<String> newLines = new ArrayList<>();
            for (String line : lines) {
                if (line.toLowerCase().contains(userDelete.toLowerCase())) {
                    System.out.println("Are you sure you want to delete " + userDelete + " ? (y/n)");
                    String userConfirmDelete = scanner.nextLine();
                    if (userConfirmDelete.toLowerCase().equals("y")) {
                        continue;
                    }
                }
                newLines.add(line);
            }
            reWriteFile(filePath, newLines);
        } catch (IOException e) {
            System.out.println("there is something wrong with Delete entry");
            e.printStackTrace();
        }
    }

//    public static void endSystem() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Are you sure you want to exit? y/n");
//        String userEndSystem = scanner.nextLine();
//        if (userEndSystem.toLowerCase().equals("y")) {
//            System.out.println("Have a good day!");
//            System.exit(0);
//        } else {
//            executeUserChoice();
//        }
//    }


}
