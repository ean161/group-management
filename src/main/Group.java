package main;

import java.util.ArrayList;

/**
* @author Nguyen Hoai An - CE190990
*/

public class Group {
    private String ID;
    private String name;
    private Lib lib = new Lib();
    private ArrayList<Member> list = new ArrayList<>();
    private ArrayList<Group> previousList = new ArrayList<>();
    
    Group(){}
    
    Group(String ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public String getID(){
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
    
    public void setPreviousList(ArrayList<Group> previousList){
        this.previousList = previousList;
    }
    
    public int getNumberOfMembers(){
        return 0;
    }
    
    public void entryData(){
        System.out.println("----- Add new group -----");
        
        boolean isDuplicated = false;
        while(true) {
            this.ID = lib.entryData("Group", "ID");
            isDuplicated = false;

            for(Group item : this.previousList)
                if(item.getID().equalsIgnoreCase(this.ID)){
                    isDuplicated = true;
                    System.out.println("ID duplicated");
                    break;
                }

            if(!isDuplicated)
                break;
        }

        this.name = lib.entryData("Group", "name");
        int count = Integer.parseInt(lib.entryData("Group", "number of members"));
        
        for(int i = 0; i < count; i++){
            Member newMember = new Member();
            newMember.setPreviousList(list);
            System.out.printf("-- Add member %d --\n", i + 1);
            newMember.entryData();
            list.add(newMember);
        }
        System.out.printf("Group %s created!\n", this.ID);
    }
    
    public void printData(){
        printSearch();
        System.out.println("-- ID -- Member name --");
        
        for(Member item : list)
            item.printData();
    }
    
    public void printGroup(){
        System.out.printf("-- %s -- %s -- %d --\n", this.ID, this.name, this.list.size());
    }
    
    public void printSearch(){
        System.out.printf("%s:%s (%d members)\n", this.ID, this.name, this.list.size());
    }
}
