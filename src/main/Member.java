package main;

import java.util.ArrayList;

/**
* @author Nguyen Hoai An - CE190990
*/

public class Member {
    private String ID;
    private String name;
    private Lib lib = new Lib();
    private ArrayList<Member> previousList = new ArrayList<>();

    
    Member(){}
    
    Member(String ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setPreviousList(ArrayList<Member> previousList){
        this.previousList = previousList;
    }
    
    public void entryData(){
        boolean isDuplicated = false;
        while(true) {
            this.ID = lib.entryData("Member", "ID");
            isDuplicated = false;

            for(Member item : this.previousList)
                if(item.getID().equalsIgnoreCase(this.ID)){
                    isDuplicated = true;
                    System.out.println("ID duplicated");
                    break;
                }

            if(!isDuplicated)
                break;
        }
        this.name = lib.entryData("Member", "name");
    }
    
    public void printData(){
        System.out.printf("-- %s -- %s --\n", this.ID, this.name);
    }
}
