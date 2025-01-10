package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
* @author Nguyen Hoai An - CE190990
*/

public class Lib {
    Lib(){}
    
    public void menu(){
        System.out.print(
            "----- GROUP MANAGEMENT -----\n"
            + "A: Adds new group.\n"
            + "V: Views all groups.\n"
            + "S: Search group.\n"
            + "Q: Quit.\n"
            + "Please select a function: "
        );
    }
    
    public void listGroup(ArrayList<Group> list){
        System.out.println(
            "----- List of groups -----\n"
            + "-- ID -- Group name -- Number of members --"
        );
        
        for(Group item : list)
            item.printGroup();
    }
    
    public void searchGroup(ArrayList<Group> list){
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print(
            "----- Search group -----\n"
            + "ID: "
        );
        
        String target = keyboard.nextLine();
        
        System.out.print("Result: ");
        
        boolean isFound = false;
        for(Group item : list)
            if(item.getID().equalsIgnoreCase(target)){
                isFound = true;
                item.printData();
            }
        
        if(!isFound)
            System.out.println("Not found");
    }
    
    public String entryData(String type, String field){
        Scanner keyboard = new Scanner(System.in);

        String input = "";
        switch(type.toLowerCase()){
            case "member":
                while(true){
                    System.out.printf("Input %s: ", field);
                    input = keyboard.nextLine();
                    
                    if(field.equalsIgnoreCase("ID")){
                        if(input.length() == 5)
                            break;
                        else
                            System.out.println("ID must be exactly 5 chars");
                    } else if(field.equalsIgnoreCase("name")){
                        if(!input.isEmpty())
                            break;
                        else
                            System.out.println("Name must be not empty");
                    }
                }
                break;
            case "group":
                while(true){
                    System.out.printf("Input %s: ", field);
                    input = keyboard.nextLine();
                    
                    if(field.equalsIgnoreCase("ID")){
                        if(input.length() == 2){
                            if(input.toLowerCase().startsWith("g"))
                                break;
                            else
                                System.out.println("ID must be start with the letter \"G\"");
                        } else
                            System.out.println("ID must be exactly 2 chars");
                    } else if(field.equalsIgnoreCase("name")){
                        if(!input.isEmpty())
                            break;
                        else
                            System.out.println("Name must be not empty");
                    } else if(field.equalsIgnoreCase("number of members")){
                        int asNumber = Integer.parseInt(input);
                        
                        if(asNumber >= 1)
                            break;
                        else
                            System.out.println("Number of members must be geater than 0");
                    }
                }
                break;
            default:
                break;
        }
        
        return input;
    }
}
