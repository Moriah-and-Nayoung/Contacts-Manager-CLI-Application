import java.nio.file.Path;
import java.nio.file.Paths;

public class Contact {
    String firstName;
    String lastName;
    String phoneNumber;


    //constructor
    public Contact(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    //getter
    public String getFirstName(){
        return this.firstName;
    }

    //setter
    public void setFirstName(String firstName){
        this. firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }





}
