package cs320contact;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ContactTest {

    private cs320contact.Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("123456", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    void testConstructor_ValidValues() {
        assertEquals("123456", contact.getContactID());
        assertEquals("John", contact.getFName());
        assertEquals("Doe", contact.getLName());
        assertEquals("1234567890", contact.getPNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testSetContactID_ValidValue() {
        contact.setContactID("654321");
        assertEquals("654321", contact.getContactID());
    }

    @Test
    void testSetFName_ValidValue() {
        contact.setFName("Jane");
        assertEquals("Jane", contact.getFName());
    }

    @Test
    void testSetLName_ValidValue() {
        contact.setLName("Smith");
        assertEquals("Smith", contact.getLName());
    }

    @Test
    void testSetPNumber_ValidValue() {
        contact.setPNumber("9876543210");
        assertEquals("9876543210", contact.getPNumber());
    }

    @Test
    void testSetAddress_ValidValue() {
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    void testConstructor_NullContactID() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testConstructor_InvalidContactIDLength() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testConstructor_NullFName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456", null, "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testConstructor_InvalidFNameLength() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456", "JohnJohnJohn", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testConstructor_NullLName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456", "John", null, "1234567890", "123 Main St"));
    }

    @Test
    void testConstructor_InvalidLNameLength() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St"));
    }

    @Test
    void testConstructor_NullPNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456", "John", "Doe", null, "123 Main St"));
    }

    @Test
    void testConstructor_InvalidPNumberLength() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456", "John", "Doe", "12345678901", "123 Main St"));
    }

    @Test
    void testConstructor_NullAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456", "John", "Doe", "1234567890", null));
    }

    @Test
    void testConstructor_InvalidAddressLength() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456", "John", "Doe", "1234567890", "1234567890123456789012345678901"));
    }
}
