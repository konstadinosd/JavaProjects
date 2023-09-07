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
public class InvalidLocationException extends Exception {

    /**
     * Creates a new instance of <code>InvalidLocationException</code> without
     * detail message.
     */
    public InvalidLocationException() {
    }

    /**
     * Constructs an instance of <code>InvalidLocationException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidLocationException(String msg) {
        super(msg);
    }
    
}
