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
public class Room {
    private final int number;
    private final int numBeds;
    private final int type;
    private Client client;
    private int checkOutDate;
    
    public Room(int number, int numBeds, int type){
        this.numBeds = numBeds;
        this.number = number;
        this.type = type;
        client = null;
        checkOutDate = 0;
    }

    public int getNumber() {
        return number;
    }

    public int getNumBeds() {
        return numBeds;
    }

    public int getType() {
        return type;
    }

    public int getCheckOutDate() {
        return checkOutDate;
    }
    
    public void checkIn(Client client, int checkOutDate){
        this.client = client;
        this.checkOutDate = checkOutDate;
        System.out.println("Client " + client.getId() + " is in room " + number + " until day " + checkOutDate);
    }
    
    public void checkOut(){
        System.out.println("Client " + client.getId() + " is leaving room " + number + " today ");
        client = null;
        
        checkOutDate = 0;
    }
    
    public boolean isEmpty(){
        if (client == null){
            return true;
        }
        else {
            return false;
        }
    }
}
