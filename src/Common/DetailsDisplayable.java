package Common;

/**
 * Defines a contract for objects that can display their own details.
 *
 * <p>Any class that implements this interface is expected to provide a
 * human-readable summary of its state to standard output when
 * {@link #displayInfo()} is called. This interface is used across multiple
 * packages to enforce a consistent display convention.
 *
 * @author IS247 Group Project Team
 * @version 1.0
 * @see HumanResources.Employee
 * @see CustomerRelationshipManagement.Customer
 */
public interface DetailsDisplayable {

    /**
     * Displays a human-readable summary of this object's details to standard output.
     *
     * <p>Implementing classes should include all type-specific fields relevant
     * to the object's identity and state (e.g., ID, name, department, pay rate).
     */
    void displayInfo();
}