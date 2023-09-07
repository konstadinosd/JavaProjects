/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skaki;

/**
 *
 * @author theo
 */
public abstract class Piece {
    private final Color color;
    private final Board board;
    private Location location;
    
    public Piece(Color color, Board board, Location location){
        this.color = color;
        this.board = board;
        this.location = location;
    }
    
    public Location getLocation(){
        return location;
    }
    public void setLocation(Location newLocation){
        location = newLocation;
    }
    public Color getColor(){
        return color;
    }
    
    public Board getBoard() {
        return board;
    }
    
    public abstract void moveTo(Location newLoc) throws InvalidMoveException;
    public abstract String getName();
}
