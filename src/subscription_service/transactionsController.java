/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscription_service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author maxnethercott
 */
public class transactionsController {
    
    private membersController mc;
 
    
    
    private int personCount =0;

    public int getPersonCount() {
        return personCount;
    }
    
    
    
    
    
    
    private int stop =0;

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }
    
    
private int fiveItems =0;

    public int getFiveItems() {
        return fiveItems;
    }

    public void setFiveItems(int fiveItems) {
        this.fiveItems = fiveItems;
    }



    
    private ArrayList<Transactions> transactions = new ArrayList<>();

    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transactions> transactions) {
        this.transactions = transactions;
    }

    public transactionsController() {
        
       
        mc = new membersController();
        transactions=new ArrayList<>();
    }
    
    
    
    
    
       public void writeToFileTransactions() throws IOException{
    // declare file writer. 
        FileWriter fw = null;
        try {

            //assign path to file
            File file = new File("src/subscription_service/transactions.csv");

            fw = new FileWriter(file, true);
            //BufferedWriter writer give better performance
            BufferedWriter bw = new BufferedWriter(fw);
            //get the user ID from the login gui, so we know who is logged in and borrowing items.
            //If the nameID is is in the file 5 times then 
           
                //write the item ID and the person borrowing it to the text file.
                String temp ="";
              for (Transactions trans : transactions) {
                
           //put each count on a new line
             temp = trans.toString() + "\n";
                  //System.out.println(temp);
            
             
        }
               
                
                bw.write(temp);
                bw.flush();
              
                //bw.write("\n");
                bw.close();

              

            }

         catch (IOException ex) {
             System.out.println("caught IOException");
        } finally {
           
        }

     }
    
    
       public int gen() {
    Random r = new Random( System.currentTimeMillis() );
    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
}
       
       /*This function checks to see if we have already borrowed an item */
          public void searchTran(String itemID){
       
       //loop tranactions to find the one that has the same tranID.
       for (Transactions tran : transactions) {
            stop =0;
           //check if both cid matches
           int count =0;
           if(tran.getUserID() == (mc.getCurrentUser()) && tran.getItemID().equals(itemID) ){
               count ++;
              
               
               
              
            }
           if(count ==1){
               setStop(1);
               JOptionPane.showMessageDialog(null, "You have already borrowed this item");
               break;
           }
           
           
           
           
        }
       
       
       
    }
          
          /*
          This function checks to see how many items is currently in the transactions array under 
          the users ID.
          
          */

   public void checkFor5(){
         personCount =0;
         fiveItems =0;
      for (Transactions trans : transactions){
          
        
          
          if(trans.getUserID() == mc.getCurrentUser()){
              personCount++;
              
              System.out.println(personCount);
          }
          
          if(personCount  >= 5 ){
              
              //when we have borrowed the maximum amount set five items flag to 1. 
              //we will then use this in the GUI. 
              fiveItems=1;
              
             JOptionPane.showMessageDialog(null, "You cannot borrow anymore items");
              break;
          }
          
          
          
      }
       
       
       
   }
         
          
     public void RefreshTransactions() {

        //use scanner to read the file
        Scanner sc = new Scanner(Welcome.class.getResourceAsStream("transactions.csv"));

        String line;

        //loop through the file 
         sc.nextLine();
        while (sc.hasNextLine()) {
           
            //add the lines of the text file into the arrayList
            line = sc.nextLine();

            //split the string either side of the commas
            String[] extract = line.split(",");

            try {
                
                
                //first bit is ID number
                int tranID = Integer.parseInt(extract[0]);

                //second bit is title
                String itemID = extract[1];

                //third bit is number available
                int userID = Integer.parseInt(extract[2]);
                
                String date = extract[3];

                Transactions trans = new Transactions (tranID, itemID, userID, date);
                //add this to the items arraylist
                transactions.add(trans);
                System.out.println(transactions);

            } catch (NumberFormatException e) {
                System.out.println("caught");
            }

        }

    }   

        }

         

     
          
          
          
         


  
















