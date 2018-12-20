package zaidimas.v2;

import java.util.Scanner;

public class input {
    private  Scanner scan = new Scanner(System.in);
    private String move;
    
    String scanNextLine(){
        move = scan.next();
       return move;
    }
    
    void startGame(){
        move = scan.nextLine();
    }
}
