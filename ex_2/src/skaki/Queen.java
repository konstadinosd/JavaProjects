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
public class Queen extends Piece{
    public final String name;
    
    public Queen(Color color, Board board, Location location){
        super( color, board, location);
        if (color.equals(Color.BLACK)) name = "μαύρη βασίλισσα";
        else name = "άσπρη βασίλισσα";
    }
    
    public String getName(){
        return name;
    }
    
    public void moveTo(Location loc)  throws InvalidMoveException{
        
    }
    
    
    public String toString(){
        if (getColor().equals(Color.WHITE)) return "Q";
        return "q";
    }
    
}
