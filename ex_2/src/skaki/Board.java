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
public class Board {
    private final Location locs[][];
    private final Piece pieces[][];
    
    public Board(){
        locs = new Location[8][8];
        pieces = new Piece[4][8];
        
        for (int i = 0 ; i < 8 ; i++)
            for (int j = 0 ; j < 8 ; j++)
                locs[i][j] = new Location(i, j);
    }
    
    public void init(){
        int i, j, r = 6;
        Color color = Color.BLACK;
        
        for (i = 1 ; i < 3 ; i++){
            for (j = 0 ; j < 8 ; j++){
                pieces[i][j] = new Pawn(color,this, locs[r][j]);
                locs[r][j].setPiece(pieces[i][j]);
            }
            r = 1;
            color = color.nextColor();
        }
        
        pieces[0][0] = new Rook(color, this, locs[7][0]);
        pieces[0][7] = new Rook(color, this, locs[7][7]);
        
        pieces[0][1] = new Knight(color, this, locs[7][1]);
        pieces[0][6] = new Knight(color, this, locs[7][6]);
        
        pieces[0][2] = new Bishop(color, this, locs[7][2]);
        pieces[0][5] = new Bishop(color, this, locs[7][5]);
        
        pieces[0][3] = new Queen(color, this, locs[7][3]);
         
        pieces[0][4] = new King(color, this, locs[7][4]);
        
        color = color.nextColor();
        
        pieces[3][0] = new Rook(color, this, locs[0][0]);
        pieces[3][7] = new Rook(color, this, locs[0][7]);
        
        pieces[3][1] = new Knight(color, this, locs[0][1]);
        pieces[3][6] = new Knight(color, this, locs[0][6]);
        
        pieces[3][2] = new Bishop(color, this, locs[0][2]);
        pieces[3][5] = new Bishop(color, this, locs[0][5]);
        
        pieces[3][3] = new Queen(color, this, locs[0][3]);
         
        pieces[3][4] = new King(color, this, locs[0][4]);
        
        Location l;
        for (i = 0 ; i < 4 ; i += 3){
            for (j = 0 ; j < 8 ; j++){
                l = pieces[i][j].getLocation();
                l.setPiece(pieces[i][j]);
            }
        }
        
    }
    
    public Location getLocation(int r, int c){
        return locs[r][c];
    }
    public void movePiece(Location from, Location to){
        Piece p = from.getPiece();
        
        from.setPiece(null);
        to.setPiece(p);
    }
    
    public void movePieceCapturing(Location from, Location to){
        Piece p1 = from.getPiece();
        Piece p2 = to.getPiece();
        
        from.setPiece(null);
        to.setPiece(p1);
        
       
        System.out.println("To κομμάτι " + p1.getName() + " ρίχνει το κομμάτι " + p2.getName() );
    }
    public boolean freeVerticalPath(Location from, Location to){
        int or = from.getRow();
        int oc = from.getCol();
        
        int nr = to.getRow();
        int nc = to.getCol();
        
        if (or > nr) {
            int temp = or;
            or = nr;
            nr = temp;
        }
        
        for (int i = or + 1 ; i < nr ; i++)
            if (locs[i][oc].isEmpty() == false) return false;
        
        return true;
    }
    
    public boolean freeHorizontalPath(Location from, Location to){
        int or = from.getRow();
        int oc = from.getCol();
        
        int nr = to.getRow();
        int nc = to.getCol();
        
        if (oc > nc) {
            int temp = oc;
            oc = nc;
            nc = temp;
        }
        
        for (int i = oc + 1 ; i < nc ; i++)
            if (locs[or][i].isEmpty() == false) return false;
        
        return true;
    }
    public String toString(){
        String r = "  a b c d e f g h\n";
        
        for (int i = 7 ; i >= 0 ; i--){
            r += (i+1) + " ";
            for (int j = 0 ; j < 8 ; j++){
                if (locs[i][j].isEmpty()) r += "  ";
                else r += locs[i][j].getPiece() + " ";
            }
            r += (i+1) + "\n";
        }
        r += "  a b c d e f g h\n";
        return r;
    }
}
