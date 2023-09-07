/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package askisi1;

import java.util.Random;

/**
 *
 * @author theo
 */
public class Client {
    private final int id;
    private int beds;
    private int type;
    private int days;
    private int floor;
    private boolean hasFloor;
    
    private static int serial = 1;
    
    public Client(){
        id = serial++;
    }
    
    public void decideBooking(int numFloors, int numTypes){
        Random r = new Random();
        
        beds = r.nextInt(2) + 2;
        type = r.nextInt(2) + 1;
        days = r.nextInt(10) + 1;
        
        hasFloor = r.nextBoolean();
        if (hasFloor == true) {
            floor = r.nextInt(numFloors) + 1;
            System.out.println("Client " + id + " wants " + beds + " beds of type " + type + " for " + days + " days at floor " + floor);
        }
        else {
            floor = 0;
            System.out.println("Client " + id + " wants " + beds + " beds of type " + type + " for " + days + " days ");
        }
                
    }

    public int getId() {
        return id;
    }
    
    public int getType() {
        return type;
    }

    public int getBeds() {
        return beds;
    }

    public int getDays() {
        return days;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isHasFloor() {
        return hasFloor;
    }
    
    
}
