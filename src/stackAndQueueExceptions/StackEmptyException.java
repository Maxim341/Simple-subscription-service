/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stackAndQueueExceptions;

/**
 *
 * @author Jane
 */
public class StackEmptyException extends Exception {

    /**
     * Creates a new instance of <code>StackEmptyException</code> without detail message.
     */
    public StackEmptyException() {
    }


    /**
     * Constructs an instance of <code>StackEmptyException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public StackEmptyException(String msg) {
        super(msg);
    }
}
