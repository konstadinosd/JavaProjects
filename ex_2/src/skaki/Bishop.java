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
public class Bishop extends Piece{
    public final String name;
    
    
    public Bishop(Color color, Board board, Location location){
        super( color, board, location);
        if (color.equals(Color.BLACK)) name = "μαύρος αξιωματικός";
        else name = "άσπρος αξιωματικός";
    }
    
    public String getName(){
        return name;
    }
    
    public void moveTo(Location loc)  throws InvalidMoveException{
        
    }
    
    
    public String toString(){
        if (getColor().equals(Color.WHITE)) return "B";
        return "b";
    }
    
}
