package hotel.management.system;

import java.util.*;

/**
 *
 * @author Manish
 */
public class RoomAvailability
{
    Vector<RoomSpace> vacantRoomSpaces = new Vector();
    Vector<RoomSpace> fullRoomSpaces = new Vector();
     
    int roomSpaceCount = 0;
    boolean isFull;
    boolean isEmpty;
    
    public int setRoomSpace(int rows, RoomType type, int level){
        for (int i=1;i<=rows*level;i++){
            RoomSpace space = new RoomSpace();
            space.distance = roomSpaceCount+i;
            space.roomType = type;
            space.level = level;
            space.rows = rows;
            try {
                vacantRoomSpaces.add(space);
            }
            catch(Exception e) {
                System.out.println("error"+ e);
            }
            
        }
        roomSpaceCount = roomSpaceCount+(rows*level);
        return this.roomSpaceCount;
        
    }
    
    
    public  RoomSpace findNearestVacant(RoomType type)
    {
        try{
            Iterator<RoomSpace> itr = vacantRoomSpaces.iterator();

            while(itr.hasNext())
            {
                RoomSpace  roomSpace = itr.next();

                if(roomSpace.roomType == type)
                {
                    return roomSpace;
                }
            }
        } catch(Exception e) {
            System.out.println("error"+ e);
        }
        
        return null;
    }
        

   public int spaceRooms(RoomType type, Room room)
    {
        if(!isFull())
        {
          
            RoomSpace roomSpace = findNearestVacant(type);
            
            if(roomSpace != null)
            {
                roomSpace.room = room;
                roomSpace.isVacant = false;
                vacantRoomSpaces.remove(roomSpace);
                fullRoomSpaces.add(roomSpace);
                if(fullRoomSpaces.size() == roomSpaceCount){
                    isFull = true;
                }
                isEmpty = false;
                return roomSpace.distance;
            }
        }
        return 0;
    }

    public int releaseRoom(int spaceCount)
    {
        if(!isEmpty())
        {
            Iterator<RoomSpace> itr = fullRoomSpaces.iterator();

            while(itr.hasNext())
            {
                RoomSpace roomSpace = itr.next();
                if(roomSpace.distance==spaceCount)
                {
                    roomSpace.isVacant = true;
                    roomSpace.room = null;
                    fullRoomSpaces.remove(roomSpace);
                    vacantRoomSpaces.add(roomSpace);
                    isFull = false;
                    if(vacantRoomSpaces.size() == roomSpaceCount)
                        isEmpty = true;
                    return roomSpace.distance;

                }
            }
        }
        return 0;
    }

    public String SearchWithNameRoom(String name){
        Iterator<RoomSpace> itr = fullRoomSpaces.iterator();
        List<String> vehicleRegistrationNumber = new ArrayList<String>();
        while(itr.hasNext()) {
            RoomSpace roomSpace = itr.next();
            if (roomSpace.room != null && roomSpace.room.RoomName.equalsIgnoreCase(name)) {
                vehicleRegistrationNumber.add(roomSpace.room.adhaarNumber);
            }
        }
        return String.join(", ", vehicleRegistrationNumber);
    }


    public int searchWithAdhaarNumber(String number){
        Iterator<RoomSpace> itr = fullRoomSpaces.iterator();
        while(itr.hasNext()) {
            RoomSpace parkingSpace = itr.next();
            if (parkingSpace.room != null && parkingSpace.room.adhaarNumber.equalsIgnoreCase(number)) {
                return parkingSpace.distance;
            }
        }
        return 0;
    }

    public String roomStatus(){
        Iterator<RoomSpace> itr = fullRoomSpaces.iterator();
        List<String> roomDetails = new ArrayList<>();
        roomDetails.add("Slot No.  Registration No  RoomName RoomType Floor");
        while(itr.hasNext())
        {
            RoomSpace roomSpace = itr.next();
            int floor = 1;
            int i=1;
            while(i <= roomSpace.level){
                if(i<roomSpace.distance && roomSpace.distance>i*roomSpace.rows ){
                    floor = i+1;
                }
                i++;
            }

            roomDetails.add(roomSpace.distance +"          "+roomSpace.room.adhaarNumber +"  "+ roomSpace.room.RoomName+"   "+roomSpace.room.type+" "+floor );
        }
        return String.join("\n", roomDetails);

    }

    public String searchByRoomType(RoomType type){
        Iterator<RoomSpace> itr = fullRoomSpaces.iterator();
        List<String> roomDetails = new ArrayList<>();
        while(itr.hasNext())
        {
            RoomSpace roomSpace = itr.next();
            if(type==roomSpace.roomType){
                roomDetails.add(String.valueOf(roomSpace.distance));
            }

        }
        return String.join(", ", roomDetails);
    }

    boolean isFull()
    {
        return isFull;
    }

    boolean isEmpty()
    {
        return isEmpty;
    }
}



