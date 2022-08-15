//Montana Williams
//CS 145
//7/26/22
//Phonebook assignment.
//
//Coded in IntelliJ, gitHub is now working
//Unfortunately, I wasn't really able to get all the nodes sorted (see method sort in PhoneBook)
//I was also not able to make this totally crash-proof

import java.util.InputMismatchException;
import java.util.Scanner;
public class MainPhone {
    public static void main(String[] args) {

        PhoneBook whatcom = new PhoneBook();

        //Add a bunch of contacts
        whatcom.add("Montana","Williams","123 This St","Bellingham","123456789");
        whatcom.add("Oregon","Smith","123 That Rd", "Bellingham","234567891");
        whatcom.add("Arkansas","Jones","123 Those Blvd","Bellingham","345678912");
        whatcom.add("Nebraska","Doe","123 Wrong Way","Bellingham","456789123");
        whatcom.add("Connecticut","Brown","123 Another St","Ferndale","567891234");
        whatcom.add("Maine","Miller","123 Other Rd","Ferndale","678912345");
        whatcom.add("California","Moore","123 Some Way","Sumas","789123456");

        System.out.println("Hello and welcome to your phonebook of Whatcom County. What would you like to do?");
        menu(whatcom);
        //System.out.println(whatcom.findIndex("montana", "williams"));
    }//end main

    //menu requires phonebook. allows user to choose what to do.
    public static void menu(PhoneBook whatcom) {
        int choice;
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("1.View phonebook\n2.View contact\n3.Add contact\n4.Adjust contact\n5.Delete contact\n6.Quit");
            try{
                choice=input.nextInt();
                choice=menuSelection(choice,whatcom,input);
            }catch(InputMismatchException a){
                System.out.println("Please select a valid option from the menu.");
                choice=-1;
                input.next();
            }//end try catch
        }while(choice<6);

    }//end menu

    //allows for selection and redirection based on choice
    public static int menuSelection(int choice, PhoneBook whatcom, Scanner input){
        switch(choice){
            case 1:
                displayBook(whatcom);
                System.out.println(); return 1;
            case 2:
                contactView(whatcom, input);
                System.out.println(); return 2;
            case 3:
                addContact(whatcom, input);
                System.out.println(); return 3;
            case 4:
                adjustContact(whatcom, input);
                System.out.println(); return 4;
            case 5:
                remove(whatcom, input);
                System.out.println(); return 5;
            case 6: return 6;
            default:
                System.out.println("I'm sorry, please select a valid option.");
        }//end switch/case
        return -1;
    }//end menuSelection

    //display all in the book
    public static void displayBook(PhoneBook whatcom){
        whatcom.displayAll();
    }//end displayBook

    //view just one contact
    public static void contactView(PhoneBook whatcom, Scanner input){
        System.out.println("What is contact's first name?");
        String firstName=input.next();
        System.out.println("What is contact's last name?");
        String lastName=input.next();

        whatcom.display(firstName,lastName);

    }//end view

    //add a contact to the phonebook
    public static void addContact(PhoneBook whatcom,Scanner input){
        System.out.println("What is contact's first name?");
        String firstName=input.next();
        System.out.println("What is contact's last name?");
        String lastName=input.next();
        System.out.println("What is contact's street address?");
        String streetAddress=input.nextLine();
        streetAddress=input.nextLine();
        System.out.println("What is contact's city of residence?");
        String city=input.next();
        System.out.println("What is contact's phone number?");
        String phoneNumber=input.next();

        whatcom.add(firstName,lastName,streetAddress,city,phoneNumber);
        System.out.println("Contact has been added.");

    }//end add

    //modify an existing contact
    public static void adjustContact(PhoneBook whatcom, Scanner input){
        System.out.println("What is the first name of the contact are you adjusting?");
        String firstName=input.next();
        System.out.println("What is the last name of the contact are you adjusting?");
        String lastName=input.next();
        System.out.println("What do you want to adjust?\n1.First name\n2.Last name\n3.Street address\n4.City\n5.Phone number");
        int response=input.nextInt();
        ContactNode modifyee=whatcom.getContact(firstName,lastName);
        modifier(response,input,modifyee);
        modifyee.display();

    }//end adjustContact

    //set a variable in a contact
    public static void modifier(int response, Scanner input, ContactNode modifyee){
        String newInfo;
        if(response==1){
            System.out.println("Please enter new first name for contact.");
            newInfo=input.next();
            modifyee.setFirstName(newInfo);
        }else if(response==2){
            System.out.println("Please enter new last name for contact.");
            newInfo=input.next();
            modifyee.setLastName(newInfo);
        }else if(response==3){
            System.out.println("Please enter new address for contact.");
            newInfo=input.nextLine();
            modifyee.setStreetAddress(newInfo);
        }else if(response==4){
            System.out.println("Please enter new city for contact.");
            newInfo=input.next();
            modifyee.setCity(newInfo);
        }else if(response==5){
            System.out.println("Please enter new phoneNumber for contact.");
            newInfo=input.next();
            modifyee.setPhoneNumber(newInfo);
        }//end if/else
    }//end modifier

    //remove a contact from the phonebook
    public static void remove(PhoneBook whatcom, Scanner input){
        System.out.println("What is the first name of the contact you are removing?");
        String firstName=input.next();
        System.out.println("What is the last name of the contact you are removing?");
        String lastName=input.next();
        whatcom.remove(firstName,lastName);
        System.out.println("Contact has been removed.");
    }//end remove

}

