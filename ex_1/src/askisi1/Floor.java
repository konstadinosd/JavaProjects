/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package askisi1;

/**
 *
 * @author theo
 */
public class Floor {
    private final int number;
    private final Room rooms[];
    
    public Floor(int number, int numberOfRooms){
        this.number = number;
        rooms = new Room[numberOfRooms];
    }
    
    public void setRoomData(int roomNumber, int beds, int type){
        int index = roomNumber % 100 - 1;
        rooms[ index ] = new Room(roomNumber, beds, type);
    }
    
    public void setRoomData(int firstRoomNumber, int lastRoomNumber, int beds, int type){
        lastRoomNumber++;
        int index;
        for (int currentRoomNumber = firstRoomNumber ; currentRoomNumber < lastRoomNumber ; currentRoomNumber++){
            index = currentRoomNumber % 100 - 1;
            rooms[ index ] = new Room(currentRoomNumber, beds, type);
        }
    }
    
    public Room searchRoom(int beds, int type){
        for (Room room: rooms){
            if (room.isEmpty() && room.getNumBeds() == beds && room.getType() == type){
                return room;
            }
        }
        return null;
    }
    
    public void emptyRooms(int today){
        for (Room room : rooms){
            if (room.getCheckOutDate() == today) room.checkOut();
        }
    }
    
    public int roomIndexFromNumber(int roomNumber){
        if (roomNumber % 100 > rooms.length) return -1;
        if (roomNumber / 100 != number) return -1;
        int index = roomNumber % 100 - 1;
        return index;
    }
    
    
}
