//This class handles the Customer Management RelationshipManagement

package CustomerRelationshipManagement;

import Common.DetailsDisplayable;

/**
 * This is the customer class that holds all information about the customer
 * And it implements the DetailsDisplayable interface from the common
 * package that has the DetailsDisplayable interface
 */
public class Customer implements DetailsDisplayable {

    private String customerID; //String for the Type of customer ID
    private String name;  //String for name of customer
    private String email; //String for customer email
    private String PhoneNumber; //String holds customers phone number
    private String address; //Holds the address of the customer
    private String TypeOfCustomer; //String holds what type of customer

    //Constructor

    /**
     * Customer Constructor that holds parameters
     *
     * @param customerID holds the unique ID for the Customer
     * @param name Stores the customers name
     * @param email Stores the Customers email
     * @param PhoneNumber Holds the Customers Phone number
     * @param address Holds the Customers address
     * @param TypeOfCustomer Holds the type of customer (normal, VIP, Business)
     */
    public Customer(String customerID, String name, String email, String PhoneNumber, String address
    , String TypeOfCustomer){
        this.customerID = customerID;
        this.name = name;
        this.email = email;
        this.PhoneNumber = PhoneNumber;
        this.address = address;
        this.TypeOfCustomer = TypeOfCustomer;
    }

    /**
     * Overloaded constructor that defaults TypeOfCustomer to Unspecified
     *
     * @param customerID holds the unique ID for the Customer
     * @param name Stores the customers name
     * @param email Stores the Customers email
     * @param PhoneNumber Holds the Customers Phone number
     * @param address Holds the Customers address
     *  TypeOfCustomer String is set to Unspecified
     */
    // Overloaded constructor — TypeOfCustomer defaults to "Unspecified"
    public Customer(String customerID, String name, String email, String PhoneNumber, String address) {
        this(customerID, name, email, PhoneNumber, address, "Unspecified");
    }

    //Getters

    /**
     *
     * @return the customer ID
     */
    public String getCustomerID(){
        return customerID;
    }

    /**
     *
     * @return the Name String
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return the email string
     */
    public String getEmail(){
        return email;
    }

    /**
     *
     * @return the PhoneNumber String
     */
    public String getPhoneNumber(){
        return PhoneNumber;
    }

    /**
     *
     * @return the Address String
     */
    public String getAddress(){
        return address;
    }

    /**
     *
     * @return the TypeOfCustomer String
     */
    public String getTypeOfCustomer(){
        return TypeOfCustomer;
    }

    //setters

    /**
     * sets the String CustomerID
     *
     * @param customerID Customers unique ID
     */
    public void setCustomerID( String customerID ){this.customerID = customerID;}

    /**
     * sets the String name
     *
     * @param name  String name for the customer
     */
    public void setName(String name ){this.name = name;}

    /**
     *  sets the email String
     *
     * @param email Email for the Customer
     */
    public void setEmail(String email){this.email = email;}

    /**
     *  sets the Phone number String
     *
     * @param PhoneNumber Phone number for the customer
     */
    public void setPhoneNumber(String PhoneNumber){this.PhoneNumber = PhoneNumber;}

    /**
     * sets the customers address
     *
     * @param address Customers address
     */
    public void setAddress(String address){this.address = address;}

    /**
     *
     * @param TypeOfCustomer sets the TypeOfCustomer String
     */
    public void setTypeOfCustomer(String TypeOfCustomer){this.TypeOfCustomer = TypeOfCustomer;}

    //Prints out the customers information

    /**
     * Displays the Customers Info
     */
    @Override
   public void displayInfo(){
        System.out.println("Customer ID: " + customerID);
        System.out.println("Customer Name: " + name);
        System.out.println("Customer Email: " + email);
        System.out.println("Customer Phone Number " + PhoneNumber);
        System.out.println("Customer Address: " + address);

       //if the type of customer is missing it will show up as "Unspecified"
       System.out.println("Customer Type: " +
               (TypeOfCustomer == null || TypeOfCustomer.isEmpty() ? "Unspecified" : TypeOfCustomer));
   }


    /**
     *
     * @return the customer ID with the name and what type of customer
     */
    @Override
    public String toString() {
        String type = (TypeOfCustomer == null || TypeOfCustomer.isEmpty()) ? "Unspecified" : TypeOfCustomer;
        return "[" + customerID + "] " + name + " - " + type;
    }

}
