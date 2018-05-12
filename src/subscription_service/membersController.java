/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscription_service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author maxnethercott
 */
public class membersController {
  

    
    
    
    private int memberID;
    private ArrayList<members> members = new ArrayList<>();

   
    public static int currentUser;
  
  public int getCurrentUser(){
     
      return currentUser;
  }

    public void setCurrentUser(int currentUser) {
        this.currentUser = currentUser;
     
    }
     
  
  
     
     public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public ArrayList<members> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<members> members) {
        this.members = members;
    }

    public membersController() {
         // myQ=new QueueS();
       
        
  members = new ArrayList<>();
  
    }
    
    /**
     *
     * @param name
     */
    public void createMember(String name){
        
        
        if (name == null) {  
        throw new NullPointerException("name can't be null");   
    }  
        
       
        int newID;
        Scanner sc = new Scanner(loginGUI.class.getResourceAsStream("members.csv"));
        sc.nextLine();
        sc.useDelimiter(",");
        int prev = 0;
        while (sc.hasNextLine()) {
            prev = Integer.parseInt(sc.next());
            sc.nextLine();
        }
        newID = prev + 1;
        
        memberID=newID;
        
        
         members m = new members (memberID, name);
    members.add(m);
        System.out.println(members);
    
    
    
        
    }
    
    
        public void writeToFile() throws IOException{
    // declare file writer. 
        FileWriter fw = null;
        try {

            //assign path to file
            File file = new File("src/subscription_service/members.csv");

            fw = new FileWriter(file, true);
            //BufferedWriter writer give better performance
            BufferedWriter bw = new BufferedWriter(fw);
            //get the user ID from the login gui, so we know who is logged in and borrowing items.
            //If the nameID is is in the file 5 times then 
           
                //write the item ID and the person borrowing it to the text file.
                String temp ="";
              for (members member : members) {
                
           //put each count on a new line
             temp = member.toString() + "\n";
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
        
        
       public void loadMembers(){
          
           getMembers().clear();
           
           
    
            //buffered reader gives better performance
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/subscription_service/members.csv"));
            String line="";
            
            //While the reader has the line assign it to line
            while ((line = br.readLine()) != null) {
            
                String[] extract = line.split(",");
                
                
               try{
                int id = Integer.parseInt (extract[0]);
               
               
               
    
                String user = extract[1];
                
                 members mem = new members(id,user);
                 
                 getMembers().add(mem);
                   
                 
        
               }
                catch(NumberFormatException e) {
                    System.out.println("caught");
               }
           

               

           }

       } catch (FileNotFoundException ex) {
            Logger.getLogger(loginGUI.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(loginGUI.class.getName()).log(Level.SEVERE, null, ex);
       }  
            
       }  

       
       
       public members searchMembers(int memberid){
           
           for (members member : members) {
               
               if(member.getMember_ID()==memberid){
                return member;  
               }
             
           }
           
           
           
        return null;   
       }
       
       
       
}