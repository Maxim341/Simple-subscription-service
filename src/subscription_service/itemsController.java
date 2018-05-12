/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscription_service;


import java.util.ArrayList;

import java.util.Scanner;

import javax.swing.JOptionPane;
import stackAndQueueExceptions.QueueEmptyException;

/**
 *
 * @author maxnethercott
 */
public class itemsController {
//declare variabes and some getters and setters. 
    private int alreadyRequested = 0;

    public int getAlreadyRequested() {
        return alreadyRequested;
    }

    public void setAlreadyRequested(int alreadyRequested) {
        this.alreadyRequested = alreadyRequested;
    }

    int member;

    transactionsController tc;
    membersController mc;

    private int transOK = 0;

    public int getTransOK() {
        return transOK;
    }

    public void setTransOK(int transOK) {
        this.transOK = transOK;
    }

    //this is the items arraylist
    private ArrayList<Items> items = new ArrayList<>();

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public itemsController() {
        tc = new transactionsController();
        mc = new membersController();
     
        items = new ArrayList<>();
    }

    
    /*
    Refresh items uses the items.csv to fill the items arrayList
    uses extract and /split mainly. 
    */
    
    public void RefreshItems() {

        //use scanner to read the file
        Scanner sc = new Scanner(Welcome.class.getResourceAsStream("items.csv"));

        String line;

        //loop through the file 
        while (sc.hasNextLine()) {

            //add the lines of the text file into the arrayList
            line = sc.nextLine();

            //split the string either side of the commas
            String[] extract = line.split(",");

            try {
                //first bit is ID number
                int itemNo = Integer.parseInt(extract[0]);

                //second bit is title
                String title = extract[1];

                //third bit is number available
                int numAvailable = Integer.parseInt(extract[2]);

                Items item = new Items(itemNo, title, numAvailable);
                //add this to the items arraylist
                items.add(item);

            } catch (NumberFormatException e) {
                System.out.println("caught");
            }

        }

    }

    
    /*
    searcItems allows us to minus the number available if certain aspects are met. 
    it also allows us to find the item in the array we are looking for. 
    
    Quite a few flags are used here, so that it only decrements the number available 
    if all these elements are met. 
    
    This was quite troublesome. 
    
    */
    
 
    public int searchItems(int itemID, int stop, int Fiveitems, int total) {

        //loop items
        for (Items item : items) {

            //if number available is 0 then produce unavailable
            if (item.getItemNo() == (itemID) && item.getNumAvailable() == 0 ) {
                transOK = 0;
                JOptionPane.showMessageDialog(null, "unavailable");
                break;
              
            }

         
            
            
            //if the item ID matches in the arraylist and the number available is more than 0 then -1 from the numberavailable 
            if (item.getItemNo() == (itemID) && item.getNumAvailable() > 0 && stop == 0 && Fiveitems == 0 && total < 5) {
                transOK = 1;

                item.setNumAvailable(item.getNumAvailable() - 1);

                //  System.out.println("yes");
            }

        }

        

        return transOK;
        
    }

    /*This is not used, but shows binary search algorithm*/

    public int binarySearch(int num) {

        if (num < items.indexOf(0)) {
            return -1;
        }
        int start = 0;
        int end = items.size() - 1;
        int mid = (start + end) / 2;
        while (items.indexOf(mid) != num) {
            if (num < mid) {
                end = mid;
            } else {
                start = mid;
            }
            mid = (start + end) / 2;

        }
        return mid;

    }
    
    
    /*
    This method checks the queue to see if we are trying to request an item that we have already 
    requested.
    */

    public void checkForDuplicate(int itemid) throws QueueEmptyException {
        int personCount = 0;
        int check5 = 0;
        int test = 0;
        //loop through items 
    
        for (Items i : items) {

            int ix;

            //loop through the queue
            for (ix = i.getItemQ().getFront(); ix < i.getItemQ().size(); ix++) {

                    alreadyRequested = 0;
                test++;

                if(i.getItemQ().getElementAt(ix) == mc.getCurrentUser() && i.getItemNo() == itemid){
                    personCount++;

                  //  System.out.println("This is person count " + personCount);
                }
                
                //if the front of the queue for the item has the user already... increase the count
//                if (i.getItemQ(). == mc.getCurrentUser() && i.getItemNo() == itemid) {
//
//                    personCount++;
//
//                    System.out.println("This is person count " + personCount);
//                }
                //if the current user has already requested the item dont allow them to request again.
                if (personCount == 1) {
                    alreadyRequested = 1;
                    JOptionPane.showMessageDialog(null, "you have already requested this item.");
                    break;
                }

            }

        }

    }

    /*
    This checks that we have not requested more than 5 items
     */
    public void checkForRequestLimit() {
        int personCount = 0;
        int queueCount = 0;
        for (Items i : items) {
            int ix;

            for (ix = i.getItemQ().getFront(); ix < i.getItemQ().size(); ix++) {
                // System.out.println(i.getItemQ().getFront());
                System.out.println("This is ix" + ix);

                if (ix == mc.getCurrentUser()) {

                    personCount++;

                    System.out.println("This is the person count: " + personCount);
                }

            }

            if (personCount >= 5) {
                queueCount = 1;

                JOptionPane.showMessageDialog(null, "You have requested 5 items");
                break;
            }

        }

    }

}
