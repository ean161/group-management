package main;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* @author Nguyen Hoai An - CE190990
*/

public class Main {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Lib lib = new Lib();
        ArrayList<Group> list = new ArrayList<>(
            Arrays.asList(
                new Group("G1", "Nhan thap cam"),
                new Group("G2", "Nhap dau xanh"),
                new Group("G3", "Goi hut am")
            )
        );
        
        String choice = "";
        
        do {
            lib.menu();
            choice = keyboard.nextLine();
            
            switch(choice.toLowerCase()){
                case "a":
                    Group newGroup = new Group();
                    newGroup.setPreviousList(list);
                    newGroup.entryData();
                    list.add(newGroup);
                    break;
                case "v":
                    lib.listGroup(list);
                    break;
                case "s":
                    lib.searchGroup(list);
                    break;
                case "q":
                    System.out.println(
                        "THANK FOR USING MY APPLICATION!\n"
                        + "SEE YOU AGAIN!"
                    );
                    break;
                default:
                    System.out.println("The function of application must be from 1 to 4!");
                    break;
            }
        } while(!choice.equalsIgnoreCase("q"));
    }
}
