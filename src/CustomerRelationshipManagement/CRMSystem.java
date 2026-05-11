package CustomerRelationshipManagement;

import java.util.*;

/**
 * CRM System class holds the methods for the Customer
 * Relationship Management System
 */
public class CRMSystem {

//Stores all the Customers
    /**
     * ArrayList that holds customer
     */
private static final List<Customer> customers = new ArrayList<>();

//User input

    /**
     * Scanner for Input
      */
private static final Scanner scan = new Scanner(System.in);

//The menu for user to interact with

    /**
     * Method for the CRM menu that allows the user
     * to select what the user wanted to do
      */
public static void Menu(){
    int selection;

    do{
        System.out.println("Customer Relationship Management");
        System.out.println("1. Add Customer");
        System.out.println("2. View Customers");
        System.out.println("3. Search for Customer by ID");
        System.out.println("4. Search for Customer by name");
        System.out.println("5. Update Customer");
        System.out.println("6. Delete Customer ");
        System.out.println("7. View Customer Summary");
        System.out.println("0. Return to the Main Menu");
        System.out.println("Enter Selection:");

        //Reads only valid Selection Integers
        selection = ReadSelection();

        switch(selection) {
            case 1 -> AddCustomer();
            case 2 -> ViewCustomers();
            case 3 -> SearchCustomerID();
            case 4 -> SearchCustomerByName();
            case 5 -> UpdateCustomer();
            case 6 -> deleteCustomer();
            case 7 -> Summary();
            case 0 -> System.out.println("Returning to ERP Menu...");
            default -> System.out.println("Invalid selection, please try again.");
        }


    } while (selection != 0);
}

//Checks to see if the user enter a valid number

    /**
     * Method that is used for selecting the number from the menu
     * selecting a number that isn't a vaild number from the selection menu
     * will ask you to enter a vaild number from
     *
      * @return returns the number input
     */
private static int ReadSelection(){
while(!scan.hasNextInt()){
    System.out.print("Enter a valid number from the selection menu");
    scan.next();
}
int num = scan.nextInt();
scan.nextLine();
return num;
}

//Helps returns a customer if their ID matches

    /**
     * Method for finding a customer that is already in the system
      * @param customerID Holds the Customer unique ID
     * @return null
     */
private static Customer findCustomer(String customerID){
    for (Customer c : customers){
        if(c.getCustomerID().equalsIgnoreCase(customerID)) {
            return c;
        }
    }
    return null;
}


//Method adds a new customer
    /**
     * Method for adding Customers into the System
      */
public static void AddCustomer(){
    System.out.println("Add new Customer");

    System.out.println("Customer ID: ");
    String customerID = scan.nextLine().trim();

    if(findCustomer(customerID) != null){
        System.out.println("A customer with that ID is already in our System. Please use a different ID");
        return;
    }

    System.out.println("Name: ");
    String name = scan.nextLine().trim();

    System.out.println("Email: ");
    String email = scan.nextLine().trim();

    System.out.println("Phone Number: ");
    String PhoneNumber = scan.nextLine().trim();

    System.out.println("Address: ");
    String address = scan.nextLine().trim();

    System.out.println("Type of Customer (e.g., Regular, VIP, Corporate, etc)");
    String TypeOfCustomer = scan.nextLine().trim();

    //Stores the new Customer
    Customer newCustomer = new Customer(customerID, name, email, PhoneNumber, address, TypeOfCustomer);
    customers.add(newCustomer);
    System.out.println("New Customer added. ");
}

//Views all the customers in the list

    /**
     * Method for viewing a customer in the system
      */
private static void ViewCustomers(){
    System.out.println("Customer List: ");

    if(customers.isEmpty()){
        System.out.print("No customers are currently in the system");
        return;
    }

    int index = 1;
    for(Customer c : customers){
        System.out.println("Customer #" + index++);
        c.displayInfo();//Show us details about the customer
    }
}

//Search customer using ID

    /**
     * Method for searching a Customers ID
      */
 private static void SearchCustomerID(){
    System.out.println("Enter Customer ID: ");
    String customerID = scan.nextLine().trim();

    Customer customer = findCustomer(customerID);

    if(customer == null){
        System.out.println("Customer not found.");
    }else{
        System.out.println("Customer found");
        customer.displayInfo();
    }
 }

//Search by partial or by their full name

    /**
     * Method for searching for a Customer by name
      */
 private static void SearchCustomerByName(){
    System.out.println("Enter full or partial name: ");
    String Names = scan.nextLine().trim().toLowerCase();

    List<Customer> CustomerMatch = new ArrayList<>();

    //Finds Customers names
     for(Customer c : customers) {
         if(c.getName().toLowerCase().contains(Names)) {
             CustomerMatch.add(c);
         }
     }
     if(CustomerMatch.isEmpty()){
         System.out.println("No customer with that name matches.");
         return;
     }

     System.out.println("Matched Customers");
     for(Customer c : CustomerMatch){
         c.displayInfo();
     }
 }

 //Updates the customer fields(Changes only the non-empty inputs)

    /**
     * Method for Updating a Customer name, address, phone number
     * Email, ID, and the type of customer
      */
 private static void UpdateCustomer(){
    System.out.println("Enter Customer ID to update: ");
    String customerID = scan.nextLine().trim();

    Customer customer = findCustomer(customerID);

    if(customer == null){
        System.out.println("Customer not found");
        return;
    }

    System.out.println("Current Info:");
    customer.displayInfo();

    System.out.println("\nLeave it blank to keep the current value");

    System.out.println("New name:(leave blank to keep) ");
    String name = scan.nextLine();
    if(!name.isEmpty()) customer.setName(name.trim());

    System.out.println("New email:(leave blank to keep) ");
    String email = scan.nextLine();
    if(!email.isEmpty()) customer.setEmail(email.trim());

    System.out.println("New Phone Number:(leave blank to keep) ");
    String PhoneNumber = scan.nextLine();
    if(!PhoneNumber.isEmpty()) customer.setPhoneNumber(PhoneNumber.trim());

    System.out.println("New Address:(leave blank to keep) ");
    String address = scan.nextLine();
    if(address.isEmpty()) customer.setAddress(address.trim());

    System.out.println("New Customer Type (leave blank to keep)");
    String TypeOfCustomer = scan.nextLine();
    if(!TypeOfCustomer.isEmpty()) customer.setTypeOfCustomer(TypeOfCustomer.trim());

    System.out.println("Customer updated successfully");
 }

 //Deletes a customer from the list

    /**
     * Method for deleting a customer
     */
 private static void deleteCustomer(){
    System.out.println("Enter Customer ID to delete: ");
    String customerID = scan.nextLine().trim();

    Customer customer = findCustomer(customerID);

    if(customer == null){
        System.out.println("Customer not found.");
        return;
    }

    System.out.println("Customer to be deleted: ");
    customer.displayInfo();

    System.out.println("Is this the customer you want to delete? (y/n):");
    String ConfirmDeletion = scan.nextLine().trim().toLowerCase();

    if(ConfirmDeletion.equals("y")){
        customers.remove(customer);
        System.out.println("Customer deleted");
    } else {
        System.out.println("Deletion cancelled.");
    }
 }

 //Shows the summary about the customers

    /**
     * Method for displaying a Customer Summary
      */
 private static void Summary(){
    System.out.println("Customer Summary");
    System.out.println("Total number of customers: " + customers.size());

    if(customers.isEmpty()){
        return;
    }

    int CompletedProfiles = 0;
    Map<String, Integer> typeCounts = new HashMap<>();

     //Counts the completed profiles and customer types
     for(Customer c : customers){
         boolean hasEmail = c.getEmail() != null && !c.getEmail().isEmpty();
         boolean hasPhoneNumber = c.getPhoneNumber() != null && !c.getPhoneNumber().isEmpty();

         if(hasEmail && hasPhoneNumber) {
             CompletedProfiles++;
         }

         String type = c.getTypeOfCustomer();
         if(type == null || type.isEmpty()){
             type = "Unspecified";
         }

         typeCounts.put(type, typeCounts.getOrDefault(type,0)+ 1);
     }

     System.out.println("Customers with complete contact info (Email + Phone Number): " + CompletedProfiles);

     System.out.println("Customers by type: ");
     for(Map.Entry<String, Integer> entry : typeCounts.entrySet()) {
         System.out.println(" " + entry.getKey() + ": " + entry.getValue());
     }

 }

}
