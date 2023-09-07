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
public enum Color {
    WHITE, BLACK;
    
    public Color nextColor(){
        if (this.equals(WHITE)) return BLACK;
        return WHITE;
    }
    
    
}
