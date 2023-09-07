/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skaki;

import java.util.Scanner;

/**
 *
 * @author theo
 */
public class Game {
    private final Board board;
    private Scanner input = new Scanner(System.in);
    private Color color;
    private boolean haveWinner;
    private boolean quit;
    private Piece p1;
    private Location loc2;
    
    public Game(){
        board = new Board();
        
    }
    
    public void play(){
        String moveString;
        
        board.init();
        color = Color.WHITE;
        haveWinner = false;
        quit = false;
        
        while (haveWinner == false && quit == false){
            System.out.println(board);
            if (color.equals(Color.WHITE)) System.out.println("Εισάγετε την κίνηση των άσπρων");
            else System.out.println("Εισάγετε την κίνηση των μαύρων");
            moveString = input.nextLine();
            if (moveString.equals(":x")) {
                System.out.println("Θέλετε να τερματίσετε την παρτίδα; (y - ναι, n - όχι) ");
                moveString = input.nextLine();
                if (moveString.equalsIgnoreCase("y")) quit = true;
            }
            else if (moveString.contains(":") == false){
                handleMove(moveString);
            }
        }
    }
    
    private void handleMove(String moveString){
        try{
            check(moveString);
            p1.moveTo(loc2);
            color = color.nextColor();
        }
        catch (InvalidMoveException e){
            System.out.println(e.getMessage());
        }
        catch (InvalidLocationException e){
            System.out.println(e.getMessage());
        }
    }
    
    private void check(String moveString) throws InvalidMoveException, InvalidLocationException{
        Piece p2;
        Location loc1;
        
        if (moveString.length() != 4)
            throw new InvalidLocationException("Η κίνηση πρέπει να έχει 4 θέσεις");
        
        
        loc1 = new Location(moveString.substring(0, 2));
        loc2 = new Location(moveString.substring(2, 4));
        loc1 = board.getLocation( Integer.parseInt(moveString.substring(1, 2)) - 1, moveString.charAt(0) - 'a');
        loc2 = board.getLocation( Integer.parseInt(moveString.substring(3, 4)) - 1, moveString.charAt(2) - 'a');
        
        p1 = loc1.getPiece();
        p2 = loc2.getPiece();
        
        //System.out.println(loc1 + " : " + p1);
        
        if (p1 == null)
            throw new InvalidMoveException("Στην αρχική θέση δεν υπάρχει κομμάτι!");
        
        if (p1.getColor().equals(color) == false)
            throw new InvalidMoveException("Δεν μπορείτε να κινήσετε κομμάτι του αντιπάλου!");
        
        if (p2 == null) return;
        
        
        if (p2.getColor().equals(color))
            throw new InvalidMoveException("Δεν μπορείτε να ρίξετε δικό σας κομμάτι!");
    }
}
