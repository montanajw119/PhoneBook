//Montana Williams
//CS 145
//7/26/22
//Phonebook assignment.
//See MainPhone for additional notes

public class PhoneBook {

    private ContactNode front;

    //add contact to the phone book and sorts into book.
    //requires all information for the contact
    public void add(String firstName, String lastName, String streetAddress, String city, String phoneNumber) {
        ContactNode newNode = new ContactNode(firstName, lastName, streetAddress, city, phoneNumber);
        ContactNode temp;
        ContactNode prev=front;
        ContactNode current = front;

        if (front == null) {
            front = newNode;
        } else if (front.getLastName().compareToIgnoreCase(newNode.getLastName()) > 0) {
            temp = front;
            front = newNode;
            front.next = temp;
        }else {
            sortInto(prev,newNode,current);
        }//end if

    }//end add

    //This method sorts the nodes in alphabetical order by last name when the node goes
    //in the middle of the list.
    //Requires previous, newNode, and current node.
    public void sortInto(ContactNode prev, ContactNode newNode, ContactNode current){
        ContactNode temp;
        while (current != null&&current.next!=null) {
            if (current.getLastName().compareToIgnoreCase(newNode.getLastName()) > 0) {
                temp = current;
                prev.next=newNode;
                current=newNode;
                current.next=temp;
                return;
            }//end if
            prev=current;
            current = current.next;
        }//end
        prev.next=newNode;
    }//end sortInto


    //remove a contact from the phone book
    //needs input of first and last name
    public void remove(String firstName, String lastName) {
        int index = findIndex(firstName, lastName);
        if(index==-1){
            System.out.println("This contact does not exist.");
        }else if (index == 0) {
            front = front.next;
        } else {
            ContactNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }//end for
            current.next = current.next.next;
        }//end else
    }//end remove

    //display all contacts in the phone book
    public void displayAll() {
        ContactNode current = front;
        while (current != null) {
            current.display();
            current = current.next;
        }//end while
    }//end displayAll

    //display a specific contact
    //needs input of first and second name
    public void display(String firstName, String lastName) {
        int index = findIndex(firstName, lastName);
        if (index == -1) {
            System.out.println("This contact does not exist.");
        }else if (index == 0) {
            front.display();
        } else {
            ContactNode current = front;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }//end for
            current.display();
        }//end else
    }


    //Returns a contact node
    //requires input of first and last name
    public ContactNode getContact(String firstName,String lastName) {
        int index = findIndex(firstName, lastName);
        if (index == -1) {
            System.out.println("This contact does not exist.");
            return new ContactNode();
        } else if (index == 0) {
            return front;
        } else {
            ContactNode current = front;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }//end for
            return current;
        }
    }

    //finds the index of a contact.
    //requires input of first and last name and returns the index
    public int findIndex(String firstName, String lastName) {
        int index = 0;
        int size=size();
        ContactNode current = front;
        while (current != null) {

            if (current.getFirstName().equalsIgnoreCase(firstName) &&
                    current.getLastName().equalsIgnoreCase(lastName)) {
                return index;
            } else {
                current = current.next;
            }
            index++;
        }//end while
        if(current==null){
            index=-1;
        }
        return index;
    }//end findIndex

    //returns the size of the phonebook
    public int size() {
        int size = 0;
        ContactNode current = front;

        while (current.next != null) {
            current = current.next;
            size++;
        }//end while

        return size;
    }//end size

}//end phone book