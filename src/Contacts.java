public class Contacts {
    String firstName;
    String lastName;
    String phoneNumber;

    //constructor
    public Contacts(String firstName, String lastName, String phoneNumber){
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
