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
public class Askisi1 {
    private static Hotel hotel;
    private static final int NUM_FLOORS = 4;
    private static final int NUM_FLOOR_ROOMS = 10;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createHotel();
        runSimulation();
    }
    
    private static void runSimulation(){
        Client client;
        int r;
        Random random = new Random();
        
        for (int day = 1 ; day < 20 ; day++){
            System.out.println("    -- BEGINING DAY " + day + " --");
            
            hotel.emptyRooms(day);
            
            r = random.nextInt(10) + 1;
            
            for (int i = 0 ; i < r ; i++){
                client = new Client();
                client.decideBooking(NUM_FLOORS, 2);
                hotel.serviceClient(client, day);
            }
        }
    }
    
    private static void createHotel(){
        hotel = new Hotel("Ariadni", NUM_FLOORS);
        
        for (int i = 1 ; i <= NUM_FLOORS ; i++){
            hotel.setFloorRooms(i, NUM_FLOOR_ROOMS);
            
            Floor f = hotel.getFloor(i);
            
            f.setRoomData(100 * i + 1, 2, 1);
            f.setRoomData(100 * i + 2, 2, 2);
            f.setRoomData(100 * i + 3, 3, 1);
            f.setRoomData(100 * i + 4, 3, 2);
            
            f.setRoomData(105, 107, 2, 2);
            f.setRoomData(108, 110, 3, 2);
        }
    }
}
