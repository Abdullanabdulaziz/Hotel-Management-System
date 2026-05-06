/**
 * IRoomService.java
 * This is an interface for room services.
 * Interface is used for bonus points (2 bonus points).
 * An interface defines a contract that classes must follow.
 * Any class implementing this interface must provide implementations for all its methods.
 */

public interface IRoomService {
    
    /**
     * Abstract method to clean a room
     * Classes implementing this interface must provide their own implementation
     */
    void cleanRoom();
    
    /**
     * Abstract method to provide room service
     * Classes implementing this interface must provide their own implementation
     * @param serviceType The type of service requested
     */
    void provideService(String serviceType);
    
    /**
     * Abstract method to get the service charge
     * Classes implementing this interface must provide their own implementation
     * @return The service charge amount
     */
    double getServiceCharge();
}
