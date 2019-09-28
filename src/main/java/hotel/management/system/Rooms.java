package hotel.management.system;

/**
 *
 * @author Manish
 */
public class Rooms extends Room
{

    public Room roomBook (String adhaarNumber, String roomName,  RoomType type) {
            this.adhaarNumber =  adhaarNumber;
            this.RoomName = roomName;
            this.type = type;
            return this;
           
    }
}