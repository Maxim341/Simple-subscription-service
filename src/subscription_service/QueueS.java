/*
 * QueueS.java
 */

package subscription_service;
import stackAndQueueExceptions.*;

/**
 *
 * @author Jane
 */
public class QueueS
{
    // an Array implementation of a QueueS
    // the queue is circular, that is repeated joining and leaving of the queue will
    // cause the rear to wrap round to the begining of the array.
    private int front;
    private int rear;
    private int capacity;   // could use theQueue.length
    private int [] theQueue;
    private int size; //number of items currently in the queue



    /** Creates a new instance of Stack
     * @param aCapacity passes the maximum capacity of the queue
     */
    public QueueS(int aCapacity)
    {
        capacity = aCapacity;
        theQueue= new int[capacity];
        front = 0;
        rear = size - 1;
        size = 0;
    }
    
    public QueueS()
    {
        capacity = 20;
        theQueue = new int[capacity];
        front = 0;
        rear = size - 1;
        size = 0;
    }

  // Protected getters and setters

    protected int[] getTheQueue() {
        return theQueue;
    }

    protected void setTheQueue(int[] theQueue) {
        this.theQueue = theQueue;
    }

    protected void setFront(int aFront)
    {
        front = aFront;
    }
    
    protected int getFront()
    {
        return front;
    }
    
    protected void setRear(int aRear)
    {
        rear= aRear;
    }
    
    protected int getRear()
    {
        return rear;
    }
    
    protected void setCapacity(int aCapacity) 
    {
        capacity = aCapacity;
    }
    
    protected int getCapacity() 
    {
        //return capacity;
        return theQueue.length;
    }

    // ADT operations

    public int size(){
        return this.size;
    }
    public void enqueue(int newEntry) throws QueueFullException
    {
        if (! this.isFull() ) 
        {
            rear = (rear + 1) % capacity;
            theQueue[rear] = newEntry;
            size = size + 1;
        }else{
            throw new QueueFullException();
        }
    }
    
    public int dequeue() throws QueueEmptyException
    {
       int result;
        if (! this.isEmpty() ) 
        {
            result = this.theQueue[front];
            front = (front + 1)% capacity;
            size = size-1;
        }else{
            throw new QueueEmptyException();
        }
        return result;
    }
    
    public int front() throws QueueEmptyException
    {int result;
        if (! this.isEmpty() ) 
        {
            result = theQueue[front];
        }else{
            throw new QueueEmptyException();
        }
        return result;
    }
    
    public boolean isEmpty()
    {
        return front == ( rear + 1) % capacity;
    }
    
    public boolean isFull()
    {
        return ( this.size == this.capacity);
    }
    
    public void clear() 
    {
        front = 0;
        rear= capacity- 1;
    }
    
    @Override
    public String toString() 
    {
        String result = "Queue contains:  ";
        for (int ix = front; ix < front+size; ix++)
        {
            result = result + this.theQueue[ix%capacity] + " ";
        }
        result = result + "\n";
        return result;
    }
    
    public int getElementAt(int offset) {
        return theQueue[(front+offset)%capacity];
    }
}