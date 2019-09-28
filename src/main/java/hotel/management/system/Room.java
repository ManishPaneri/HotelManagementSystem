package hotel.management.system;

/**
 *
 * @author Manish
 */
public abstract class Room
{ 
      protected String adhaarNumber;
      public RoomType type;
      protected String RoomName;
      public RoomType getType()
      { 
          return type;
      }
      public abstract Room  roomBook(String adhaarNumber, String roomName,  RoomType type);
} 
  

    