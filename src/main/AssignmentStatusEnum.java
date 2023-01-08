package main;

/**
 *
 * @author
 */
public enum AssignmentStatusEnum {
    PE("PENDING"), CO("COMPLETED"), DR("DROPPED");
    
    private final String description;
    
    AssignmentStatusEnum(String description) {
        this.description = description;
    }
    
    public String getDescription(){return this.description;}
}
