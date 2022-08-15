//Montana Williams
//CS 145
//7/26/22
//Phonebook assignment.
//See MainPhone for additional notes

public class ContactNode {

    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String phoneNumber;

    public ContactNode next;

    //constructor empty
    public ContactNode(){
        firstName=null;
    }//constructor end

    //constructor to develop a full contact
    public ContactNode(String firstName,String lastName, String streetAddress, String city, String phoneNumber){
        this.firstName=firstName;
        this.lastName=lastName;
        this.streetAddress=streetAddress;
        this.city=city;
        this.phoneNumber=phoneNumber;
        this.next=null;
    }//constructor end

    //displays this contact
    public void display(){
        System.out.println(firstName+" "+lastName+", "+streetAddress+", "+city+" "+phoneNumber);
    }//end display

    //returns first name
    public String getFirstName(){
        return firstName;
    }//end getFirstName

    //returns last name
    public String getLastName(){
        return lastName;
    }//end getLastName

    //returns the address
    public String getStreetAddress(){
        return streetAddress;
    }//end getStreetAddress

    //returns the city
    public String getCity(){
        return city;
    }//end getCity

    //returns phone number
    public String getPhoneNumber(){
        return phoneNumber;
    }//end getPhoneNumber

    //changes a first name
    public void setFirstName(String firstNameNew){
        this.firstName=firstNameNew;
    }//end setFirstName

    //changes a last name
    public void setLastName(String lastNameNew){
        this.lastName=lastNameNew;
    }//end setLastName

    //changes a street address
    public void setStreetAddress(String streetAddressNew){
        this.streetAddress=streetAddressNew;
    }//end setStreetAddress

    //changes city
    public void setCity(String cityNew){
        this.city=cityNew;
    }//end setCity

    //changes phone number
    public void setPhoneNumber(String phoneNumberNew){
        this.phoneNumber=phoneNumberNew;
    }//end setPhoneNumber

    //Sets next node
    public void setNext(ContactNode nextOne){
        this.next=nextOne;
    }//end setNext

}//end contact node
