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
public class Knight extends Piece{
    public final String name;
    
    public Knight(Color color, Board board, Location location){
        super( color, board, location);
        if (color.equals(Color.BLACK)) name = "μαύρος ίππος";
        else name = "άσπρος ίππος";
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
        
        if (Math.abs(nc-oc) == 2 && Math.abs(nr-or) == 1 || Math.abs(nc-oc) == 1 && Math.abs(nr-or) == 2){ // arxiki  kinisi aspra
            if (loc.isEmpty())
                getBoard().movePiece(getLocation(), loc);
            else 
                getBoard().movePieceCapturing(getLocation(), loc);
            setLocation(loc);
        }
        
        else throw new InvalidMoveException("Ο ίππος κινείται σε σχήμα Γ!");
    }
    
    
    public String toString(){
        if (getColor().equals(Color.WHITE)) return "N";
        return "n";
    }
    
}
