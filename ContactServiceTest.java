package cs320contact;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private cs320contact.ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new cs320contact.ContactService();
    }

    @Test
    void testDeleteContact_ValidContactID() {
        Contact contact = new Contact("123456", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        assertTrue(contactService.deleteContact("123456"));
        assertFalse(contactService.getListOfContacts().contains(contact));
    }

    @Test
    void testDeleteContact_InvalidContactID() {
        assertFalse(contactService.deleteContact("invalidID"));
    }

    @Test
    void testAddContact_ValidContact() {
        Contact contact = new Contact("123456", "John", "Doe", "1234567890", "123 Main St");

        assertTrue(contactService.addContact(contact));
        assertTrue(contactService.getListOfContacts().contains(contact));
    }

    @Test
    void testAddContact_ExistingContact() {
        Contact contact = new Contact("123456", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        assertFalse(contactService.addContact(contact));
    }

    @Test
    void testUpdateContact_ValidContactID() {
        Contact contact = new Contact("123456", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        assertTrue(contactService.updateContact("123456", "Jane", "Smith", "0987654321", "456 Elm St"));
        assertEquals("Jane", contact.getFName());
        assertEquals("Smith", contact.getLName());
        assertEquals("0987654321", contact.getPNumber());
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    void testUpdateContact_InvalidContactID() {
        assertFalse(contactService.updateContact("invalidID", "Jane", "Smith", "0987654321", "456 Elm St"));
    }

    @Test
    void testUpdateContact_InvalidAttributes() {
        // Create a new contact with valid attributes
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");

        // Add the contact to the contact service
        contactService.addContact(contact);

        // Attempt to update the contact with invalid attributes
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("123", "InvalidFirstNameThatExceedsMaxLength", "Doe", "1234567890", "123 Main St");
        });

        // Ensure that the contact's attributes remain unchanged
        assertEquals("John", contact.getFName());
        assertEquals("Doe", contact.getLName());
        assertEquals("1234567890", contact.getPNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

}
