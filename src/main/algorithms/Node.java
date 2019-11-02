package algorithms;

import java.time.LocalDateTime;

/**
 * Interface primarily to help my ShortestRoute class, forces 
 * a class with a postcode to give information about it's distance 
 * to and from other classes.
 * 
 * @author Thomas
 * 
 */
public interface Node {
    
    /**
     * Method to return the time to travel to another node.
     * 
     * @param toHere the node to go to.
     * @return the time it would take to get to the specified node.
     */
    public LocalDateTime getTimeTo(Node toHere);
    
    /**
     * Method to receive the final location of a node, in the form of 
     * a postcode.
     * 
     * @return the specified postcode.
     */
    public String getEndPostcode();
    
    /** Method to receive the initial location of a node, in the form 
     * of a postcode.
     * 
     * @return the specified postcode.
     */
    public String getStartPostcode();
}
