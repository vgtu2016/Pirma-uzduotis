package zaidimas;

import java.util.Scanner;

public class Zaidimas {
    
    public static void main(String[] args) {
        int[][] map = {
            {1,1,1,1,1,1,1,1,1,1}, //0
            {1,0,0,0,0,0,0,0,0,1}, //1
            {1,0,2,2,2,2,2,2,0,1}, //2
            {1,0,2,2,2,2,2,2,0,1}, //3
            {1,0,0,0,0,0,0,0,0,1}, //4
            {1,0,0,0,0,0,0,0,0,1}, //5
            {1,0,0,0,0,0,0,0,0,1}, //6
            {1,0,0,3,0,0,0,0,0,1}, //7
            {1,0,0,0,0,0,0,0,0,1}, //8
            {1,1,1,1,1,1,1,1,1,1}, //9 
           //0 1 2 3 4 5 6 7 8 9
        };
        System.out.println("Zaidimas vyksta naudojant A S D klavisus");
        System.out.println("A - eiti i kaire");
        System.out.println("S - Likti vietoje");
        System.out.println("D - eiti i desne");
        System.out.println("-Spauskite bet koki klavisa-");
        Scanner scan = new Scanner(System.in);
        String move;
        boolean directionX = true; //true - desne, false - kaire
        boolean directionY = true; //true - virsun, false - apacion
        int[] block = {4,5,6};
        int[] ball = {7,3};
        move = scan.nextLine();   
        int winCondition = 12;
        while(true){
            map[8][block[0]] = 4;
            map[8][block[1]] = 4;
            map[8][block[2]] = 4;
            for(int i = 0; i<10; i++){
                for(int j = 0; j<10; j++){
                    if(map[i][j] == 1){
                        System.out.print("#");
                    }else if (map[i][j] == 0) {
                        System.out.print(" ");
                    }else if (map[i][j] == 2) {
                        System.out.print("@");
                    }else if (map[i][j] == 3) {
                        System.out.print("o");
                    }else if (map[i][j] == 4) {
                        System.out.print("T");
                    }
                    System.out.print(" ");
                }
                System.out.println("");
        }
            move = scan.next();
            if(move.toUpperCase().equals("A")){
                if (block[0] != 1){
                    map[8][block[2]] = 0;
                    block[0]--;
                    block[1]--;
                    block[2]--;
                }
            }else if (move.toUpperCase().equals("D")){
                if (block[2] != 8){
                    map[8][block[0]] = 0;
                    block[0]++;
                    block[1]++;
                    block[2]++;
                }
            }else{
            }
            // kamuolio judejimas ----------------------------------------------------
            map[ball[0]][ball[1]] = 0;
            if(directionX == true){
                ball[1]++;
            }else{
                ball[1]--;
            }
            if(directionY == true){
                ball[0]--;
            }else{
                ball[0]++;
            }
            
            //END GAME
            if(ball[0] == 9){
                System.out.println("---GAME OVER---");
                break;
            }
            
            //Jei istrizai i bloka is apacios
            if((map[ball[0]][ball[1]] == 2) && (directionY == true)){
                map[ball[0]][ball[1]] = 0;
                directionX = !directionX;
                directionY = !directionY;
                winCondition--;
                if(directionX == true){
                    ball[1]++;
                }else{
                    ball[1]--;
                }
                if(directionY == true){
                    ball[0]--;
                }else{
                    ball[0]++;
                }
            }
            
            //Jei istrizai i bloka is virsaus
            if((map[ball[0]][ball[1]] == 2) && (directionY == false)){
                map[ball[0]][ball[1]] = 0;
                directionX = !directionX;
                directionY = !directionY;
                winCondition--;
                if(directionX == true){
                    ball[1]++;
                }else{
                    ball[1]--;
                }
                if(directionY == true){
                    ball[0]--;
                }else{
                    ball[0]++;
                }
            }
            
            //atsimusimas i lubas
            if (ball[0] == 0){
                directionY = !directionY;
                ball[0] = 2;
            }
            //atsimusimas i sienas
            if ((ball[1] == 0) || (ball[1] == 9)){
                directionX = !directionX;
                if(directionX == true){
                    ball[1] += 2;
                }else{
                    ball[1] -= 2;
                }
                if (map[ball[0]][ball[1]] == 2) {
                    if(directionX == true){
                        ball[1]--;
                    }else{
                        ball[1]++;
                }
                }
            }
            //Destroy blocks
            //is apacios
            if ((map[ball[0]-1][ball[1]] == 2)&&(directionY == true)){
                directionY = !directionY;
                map[ball[0]-1][ball[1]] = 0; 
                winCondition--;
            }
            //is virsaus
            if ((map[ball[0+1]][ball[1]] == 2)&&(directionY == true)){
                directionY = !directionY;
                map[ball[0+1]][ball[1]] = 0;
                winCondition--;
            }
            //is kaires
            if (map[ball[0]][ball[1]+1] == 2){
                directionX = !directionX;
                map[ball[0]][ball[1]+1] = 0;
                winCondition--;
            }
            //is desnes
            if (map[ball[0]][ball[1]-1] == 2){
                directionX = !directionX;
                map[ball[0]][ball[1]-1] = 0;
                winCondition--;
            }


            //atsimusimas i lenta
            if ((map[ball[0]][ball[1]] == 4) && (directionY == false)){
                directionY = !directionY;
                ball[0] -= 2;
            }

            map[ball[0]][ball[1]] = 3;
            
            
            if(winCondition == 0){
                System.out.println("---YOU WIN---");
                break;
            }
            System.out.print(winCondition);
        }
    }
    
}
