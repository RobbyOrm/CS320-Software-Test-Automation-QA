package cs320contact;

import java.util.ArrayList;
import java.util.Iterator;

public class ContactService {
    private ArrayList<Contact> listOfContacts;

    // Constructor initializes an empty list of contacts
    public ContactService() {
        listOfContacts = new ArrayList<>();
    }

    // Method to delete a contact based on its contact ID
    public boolean deleteContact(String contactID) {
        // Using iterator to avoid ConcurrentModificationException
        Iterator<Contact> iterator = listOfContacts.iterator();

        while (iterator.hasNext()) {
            Contact contact = iterator.next();

            if (contact.getContactID().equals(contactID)) {
                iterator.remove(); // Use iterator to remove the contact safely
                return true; // Contact deleted successfully
            }
        }

        return false; // Contact with specified ID not found
    }

    // Method to add a contact to the list
    public boolean addContact(Contact newContact) {
        boolean contactExists = listOfContacts.contains(newContact);

        // If the contact doesn't exist, add it to the list
        if (!contactExists) {
            listOfContacts.add(newContact);
            return true; // Contact added successfully
        } else {
            return false; // Contact already exists
        }
    }

    // Method to update contact information based on contact ID
    public boolean updateContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        Iterator<Contact> iterator = listOfContacts.iterator();

        while (iterator.hasNext()) {
            Contact contact = iterator.next();

            if (contact.getContactID().equals(contactID)) {
                if (!firstName.isEmpty() && firstName.length() <= 10) {
                    contact.setFName(firstName);
                } else {
                    throw new IllegalArgumentException("Invalid first name");
                }

                if (!lastName.isEmpty() && lastName.length() <= 10) {
                    contact.setLName(lastName);
                } else {
                    throw new IllegalArgumentException("Invalid last name");
                }

                if (!phoneNumber.isEmpty() && phoneNumber.length() <= 10) {
                    contact.setPNumber(phoneNumber);
                } else {
                    throw new IllegalArgumentException("Invalid phone number");
                }

                if (!address.isEmpty() && address.length() <= 30) {
                    contact.setAddress(address);
                } else {
                    throw new IllegalArgumentException("Invalid address");
                }

                return true;
            }
        }

        return false;
    }

    // Getter method to retrieve the list of contacts
    public ArrayList<Contact> getListOfContacts() {
        return listOfContacts;
    }
}
