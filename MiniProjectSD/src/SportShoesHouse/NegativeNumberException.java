/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportShoesHouse;

/**
 *
 * @author haiqal
 */
public class NegativeNumberException extends Exception {

    /**
     * Creates a new instance of <code>NegativeNumberException</code> without
     * detail message.
     */
    public NegativeNumberException() {
    }

    /**
     * Constructs an instance of <code>NegativeNumberException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NegativeNumberException(String msg) {
        super(msg);
    }
}
