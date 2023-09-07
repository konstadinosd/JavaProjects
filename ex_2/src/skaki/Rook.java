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
public class Rook extends Piece{
    public final String name;
    
    public Rook(Color color, Board board, Location location){
        super( color, board, location);
        if (color.equals(Color.BLACK)) name = "μαύρος πύργος";
        else name = "άσπρος πύργος";
    }
    
    public String getName(){
        return name;
    }
    
    public void moveTo(Location loc)  throws InvalidMoveException{
        int or = getLocation().getRow();
        int oc = getLocation().getCol();
        
        
        int nr = loc.getRow();
        int nc = loc.getCol();
        //System.out.println("or: " + or + ", oc: " + oc + ",  nr: " + nr + ", nc" + nc + ", vertical: " + getBoard().freeVerticalPath(getLocation(), loc));
        
        if (nr == or && nc != oc && getBoard().freeHorizontalPath(getLocation(), loc)){ // arxiki  kinisi aspra
            if (loc.isEmpty())
                getBoard().movePiece(getLocation(), loc);
            else 
                getBoard().movePieceCapturing(getLocation(), loc);
            setLocation(loc);
        }
        else if (nr != or && nc == oc && getBoard().freeVerticalPath(getLocation(), loc)){ // arxiki  kinisi aspra
            if (loc.isEmpty())
                getBoard().movePiece(getLocation(), loc);
            else 
                getBoard().movePieceCapturing(getLocation(), loc);
            setLocation(loc);
        }
        else throw new InvalidMoveException("Ο πύργος κινείται οριζόντια ή κάθετα μόνο και όχι πάνω από άλλα πιόνια!");
    }
    
    
    public String toString(){
        if (getColor().equals(Color.WHITE)) return "R";
        return "r";
    }
    
}
