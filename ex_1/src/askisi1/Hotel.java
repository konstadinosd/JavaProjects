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
public class Hotel {
    private final String name;
    private final Floor floors[];
    
    public Hotel(String name, int numFloors){
        this.name = name;
        floors = new Floor[numFloors];
    }
    
    public void setFloorRooms(int floorNumber, int numberOfRooms){
        floors[ floorNumber - 1] = new Floor(floorNumber, numberOfRooms);
    }
    
    public Floor getFloor(int numFloor){
        return floors[numFloor-1];
    }
    
    private Room searchRoom(int beds, int type){
        Room r;
        for (Floor floor : floors){
            r = floor.searchRoom(beds, type);
        }
        return null;
    }
    
    private Room searchRoom(int floorNumber, int beds, int type){
        Room r = floors[floorNumber - 1].searchRoom(beds, type);
        return r;
    }
    
    private void bookRoom(Room room, Client client, int checkOutDate){
        room.checkIn(client, checkOutDate);
    }
    
    public void emptyRooms(int today){
        for (Floor floor : floors){
            floor.emptyRooms(today);
        }
    }
    
    public void serviceClient(Client client, int today){
        if (client.isHasFloor() == true){
            Room r = searchRoom(client.getFloor(), client.getBeds(), client.getType());
            if (r != null){
                bookRoom(r, client, today + client.getDays());
            }
            else {
                System.out.println("Client " + client.getId() + " cannot book any room!");
            }
        }
        else {
            Room r = searchRoom(client.getBeds(), client.getType());
            if (r != null){
                bookRoom(r, client, today + client.getDays());
            }
            else {
                System.out.println("Client " + client.getId() + " cannot book any room!");
            }
        }
    }
}
