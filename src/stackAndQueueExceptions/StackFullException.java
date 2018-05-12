/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stackAndQueueExceptions;

/**
 *
 * @author Jane
 */
public class StackFullException extends Exception {

    /**
     * Creates a new instance of <code>StackFullException</code> without detail message.
     */
    public StackFullException() {
    }


    /**
     * Constructs an instance of <code>StackFullException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public StackFullException(String msg) {
        super(msg);
    }
}
