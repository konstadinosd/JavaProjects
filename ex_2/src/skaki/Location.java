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
public class Location {
    private final int row, column;
    private final String loc;
    private Piece piece;
    private final static String columns = "abcdefgh";
    
    public Location(int r, int c){
        row = r;
        column = c;
        
        loc = columns.charAt(c) + String.valueOf(r+1);
    }
    
    public Location(String loc) throws InvalidLocationException{
        row = Integer.parseInt(loc.substring(1)) - 1;
        column = columns.indexOf(loc.substring(0, 1));
        this.loc = loc;
        
        
        if (row < 0 || row > 7 || column < 0 || column > 7)
            throw new InvalidLocationException("Οι συντεταγμένες του σημείου " + loc + " είναι εκτός ορίων a-h, 1, 8");
    }
    
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return column;
    }
    
    public Piece getPiece(){
        return piece;
    }
    
    public void setPiece(Piece p){
        piece = p;
    }
    
    public String toString(){
        return loc;
    }
    
    public boolean isEmpty(){
        if (piece == null) return true;
        return false;
    }
}
