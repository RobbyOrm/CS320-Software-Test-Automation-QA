// Robert Ormond CS320
// 1/26/2024 Module 3 Milestone

package cs320contact;

public class Contact {
    // Private instance variables for contact information
    private String contactID;
    private String fName;
    private String lName;
    private String pNumber;
    private String address;

    // Constructor to initialize the Contact object with provided values
    public Contact(String contactID, String fName, String lName, String pNumber, String address) {
        // Validate input values for contact ID, first name, last name, phone number, and address
        validateInput(contactID, "ID");
        validateInput(fName, "first name");
        validateInput(lName, "last name");
        validateInput(pNumber, "phone number");
        validateAddress(address);

        // Assign values to instance variables
        this.contactID = contactID;
        this.fName = fName;
        this.lName = lName;
        this.pNumber = pNumber;
        this.address = address;
    }

    // Getter methods to retrieve values of private fields
    public String getContactID() {
        return contactID;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public String getPNumber() {
        return pNumber;
    }

    public String getAddress() {
        return address;
    }

    // Setter methods to update values of private fields
    public void setContactID(String contactID) {
        this.contactID = contactID;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setPNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // Private method to validate input values for null and length
    private void validateInput(String value, String field) {
        if (value == null || value.length() > 10) {
            throw new IllegalArgumentException(field + " invalid null or length greater than 10");
        }
    }

    // Private method to validate the address field
    private void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("address invalid null or length greater than 30");
        }
    }
}
