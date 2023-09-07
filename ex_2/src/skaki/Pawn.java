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
public class Pawn extends Piece{
    private final String name;
    
    
    public Pawn(Color color, Board board, Location location){
        super( color, board, location);
        if (color.equals(Color.BLACK)) name = "μαύρος στρατιώτης";
        else name = "άσπρος στρατιώτης";
    }
    
    public String getName(){
        return name;
    }
    
    public void moveTo(Location loc) throws InvalidMoveException{
        //Piece p = loc.getPiece();
        
        int or = getLocation().getRow();
        int oc = getLocation().getCol();
        
        
        int nr = loc.getRow();
        int nc = loc.getCol();
        //System.out.println("or: " + or + ", oc: " + oc + ",  nr: " + nr + ", nc" + nc + ", vertical: " + getBoard().freeVerticalPath(getLocation(), loc));
        if (getColor().equals(Color.WHITE) && loc.isEmpty() && or == 1 && oc == nc && nr == or + 2 && getBoard().freeVerticalPath(getLocation(), loc)){ // arxiki  kinisi aspra
            getBoard().movePiece(getLocation(), loc);
            setLocation(loc);
        }
        else if (getColor().equals(Color.WHITE) && loc.isEmpty() && oc == nc && nr == or + 1 ){
            getBoard().movePiece(getLocation(), loc);
            setLocation(loc);
        }
        else if (getColor().equals(Color.WHITE) && loc.isEmpty() == false && nr == or + 1 && (nc - oc == 1 || nc - oc == -1)){
            getBoard().movePieceCapturing(getLocation(), loc);
            setLocation(loc);
        }
        else if (getColor().equals(Color.BLACK) && loc.isEmpty() && oc == nc && or == 6 && nr == or - 2 && getBoard().freeVerticalPath(getLocation(), loc)){ // arxiki  kinisi aspra
            getBoard().movePiece(getLocation(), loc);
            setLocation(loc);
        }
        else if (getColor().equals(Color.BLACK) && loc.isEmpty() && oc == nc &&  nr == or - 1 ){
            getBoard().movePiece(getLocation(), loc);
            setLocation(loc);
        }
        else if (getColor().equals(Color.BLACK) && loc.isEmpty() == false && nr == or - 1 && (nc - oc == 1 || nc - oc == -1)){
            getBoard().movePieceCapturing(getLocation(), loc);
            setLocation(loc);
        }
        else throw new InvalidMoveException("H κίνηση του στρατιώτη δεν είναι σωστή!");
    }
    
    
    public String toString(){
        if (getColor().equals(Color.WHITE)) return "P";
        return "p";
    }
    
}
