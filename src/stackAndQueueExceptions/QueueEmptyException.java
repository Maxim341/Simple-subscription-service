/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stackAndQueueExceptions;

/**
 *
 * @author Jane
 */
public class QueueEmptyException extends Exception {

    /**
     * Creates a new instance of <code>QueueEmptyException</code> without detail message.
     */
    public QueueEmptyException() {
    }


    /**
     * Constructs an instance of <code>QueueEmptyException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public QueueEmptyException(String msg) {
        super(msg);
    }
}
