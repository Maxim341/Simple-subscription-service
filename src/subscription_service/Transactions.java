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
public class Transactions {
    
    
    //variables
    private int transactionID;
    private String itemID;
    private int userID;
    private String time;

    //getters and setters
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    //constructors

    public Transactions(int transactionID, String itemID, int userID, String time) {
        this.transactionID = transactionID;
        this.itemID = itemID;
        this.userID = userID;
        this.time = time;
    }

    //to string
    @Override
    public String toString() {
        return    transactionID + ","+ itemID +","  + userID + "," + time;
    }
    
    
    
    
    
    
}
