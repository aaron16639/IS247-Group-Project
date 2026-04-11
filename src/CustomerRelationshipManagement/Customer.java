//This class handles the Customer Management RelationshipManagement

package CustomerRelationshipManagement;

public class Customer {

    private String customerID; //String for the Type of customer ID
    private String name;  //String for name of customer
    private String email; //String for customer email
    private String PNUM; //String holds customers phone number
    private String address; //Holds the address of the customer
    private String TypeOfCustomer; //String holds what type of customer

    //Constructor
    public Customer(String customerID, String name, String email, String PNUM, String address
    , String TypeOfCustomer){
        this.customerID = customerID;
        this.name = name;
        this.email = email;
        this.PNUM = PNUM;
        this.address = address;
        this.TypeOfCustomer = TypeOfCustomer;
    }

    //Getters
    public String getCustomerID(){
        return customerID;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPNUM(){
        return PNUM;
    }
    public String getAddress(){
        return address;
    }
    public String getTypeOfCustomer(){
        return TypeOfCustomer;
    }

    //setters
    public void setCustomerID(){
        this.customerID = customerID;
    }
    public void setName(){
        this.name = name;
    }
    public void setEmail(){
        this.email = email;
    }
    public void setPNUM(){
        this.PNUM = PNUM;
    }
    public void setAddress(){
        this.address = address;
    }
    public void setTypeOfCustomer(){
        this.TypeOfCustomer = TypeOfCustomer;
    }

    //Prints out the customers information
   public void PrintInfo(){
        System.out.println("Customer ID: " + customerID);
        System.out.println("Customer Name: " + name);
        System.out.println("Customer Email: " + email);
        System.out.println("Customer Phone Number " + PNUM);
        System.out.println("Customer Address: " + address);
   }
}
