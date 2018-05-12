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
public class members  {
    // variables 
    private int member_ID;
    private String Member_name;
    
    
    
    
    
   

    public members(int member_ID, String Member_name) {

        this.member_ID = member_ID;
        this.Member_name = Member_name;
        
       
    }
    
    
    //Getters and setters for my variables
    public int getMember_ID() {
        return member_ID;
    }

    public void setMember_ID(int member_ID) {
        this.member_ID = member_ID;
    }

    public String getMember_name() {
        return Member_name;
    }

    public void setMember_name(String Member_name) {
        this.Member_name = Member_name;
    }

   


    

    

    @Override
    public String toString() {
        return  member_ID + "," + Member_name;
    }
    
    
    

    
 
    
    
}
