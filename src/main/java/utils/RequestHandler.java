package utils;

import hotel.management.system.RoomAvailability;
import hotel.management.system.RoomType;
import hotel.management.system.Rooms;

import static utils.Constains.*;

public class RequestHandler {
    private static RoomAvailability room = new RoomAvailability();

    public static void requestMapping( String input){
        String[] inputArr = input.split(" ");

        if (input.contains(CREATE_ROOM) && inputArr.length == 3) {
            int count = room.setRoomSpace(Integer.valueOf(inputArr[2]), RoomType.DELUXE, Integer.valueOf(inputArr[1]));
            System.out.println("Created a Room Number With "+count+" available");
            System.out.println("\n");

        } else if (input.contains(ROOM_BOOK) && inputArr.length == 4) {
            if(inputArr[2].length()<12){
                System.out.println("Sorry, Adhaar number is incorrect");
                return;
            }
            Rooms room1 = new Rooms();

            RoomType type;
            if(inputArr[1].equalsIgnoreCase("DELUXE")){
                type = RoomType.DELUXE;
            }else if(inputArr[1].equalsIgnoreCase("SUPERDELUXE")){
                type = RoomType.SUPERDELUXE;
            }else if(inputArr[1].equalsIgnoreCase("REGULAR")){
                type = RoomType.REGULAR;
            }else{
                System.out.println("Sorry, this type of room not available in system");
                return;
            }

            room1.roomBook(inputArr[2], inputArr[3],type);
            int spaceCount = room.spaceRooms(room1.type, room1);
            if(spaceCount != 0){
                System.out.println("Allocated Room Number: "+ spaceCount);
            }else{
                System.out.println("Sorry, Rooms Is Full");
            }
            System.out.println("\n");

        } else if (input.contains(LEAVE_ROOM) && inputArr.length == 2) {
            int spaceCount = room.releaseRoom(Integer.valueOf(inputArr[1]));
            if(spaceCount !=0){
                System.out.println("Room Number: "+ spaceCount +" is free");
            }else{
                System.out.println("Room Not Found");
            }
            System.out.println("\n");

        } else if (input.contains(ROOMS_STATUS)) {
            System.out.println(room.roomStatus());
            System.out.println("\n");

        } else if (input.contains(SEARCH_ROOM_NAME) && inputArr.length == 2) {
            System.out.println(room.SearchWithNameRoom(inputArr[1]));
            System.out.println("\n");

        } else if (input.contains(SEARCH_ROOM_ADDHAAR_NUMBER) && inputArr.length == 2) {
            int spaceCount = room.searchWithAdhaarNumber(inputArr[1]);
            if(spaceCount !=0){
                System.out.println(spaceCount);
            }else{
                System.out.println("Room Not Found");
            }
            System.out.println("\n");

        }else if(input.contains(SEARCH_ROOM_TYPE) && inputArr.length == 2 ){
            RoomType type;
            if(inputArr[1].equalsIgnoreCase("DELUXE")){
                System.out.println(room.searchByRoomType(RoomType.DELUXE));
            }else if(inputArr[1].equalsIgnoreCase("SUPERDELUXE")){
                System.out.println(room.searchByRoomType(RoomType.SUPERDELUXE));
            }else if(inputArr[1].equalsIgnoreCase("REGULAR")){
                System.out.println(room.searchByRoomType(RoomType.REGULAR));
            }else{
                System.out.println("Sorry, this type of room not available in system");
            }
            System.out.println("\n");

        } else if (input.contains(APPLICATION_EXIT)) {
            System.exit(0);
        }
    }
}
