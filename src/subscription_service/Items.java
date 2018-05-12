/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscription_service;



/**
 *
 * @author maxnethercott
 */
public class Items {
    
    //Variables
    
    private int itemNo;
    private String title;
    private int numAvailable;
    private QueueS itemQ;

    
    //Getters and setters
    public QueueS getItemQ() {
        return itemQ;
    }

    public void setItemQ(QueueS itemQ) {
        this.itemQ = itemQ;
    }
    
    
    
    
    
    
    
    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumAvailable() {
        return numAvailable;
    }

    public void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }

   //constructors
    public Items(int itemNo, String title, int numAvailable) {
        this.itemNo = itemNo;
        this.title = title;
        this.numAvailable = numAvailable;
        this.itemQ= new QueueS();
    }
    
    
    
    
    
    
    
    
    //to string
    @Override
    public String toString() {
        return  itemNo + "," + title + "," +numAvailable;
    }
    
    
    
    
    
    
    
    
    
}
