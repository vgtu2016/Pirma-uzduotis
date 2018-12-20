package zaidimas.v2;

public class map {
    private int[][] staticMap = {
            {1,1,1,1,1,1,1,1,1,1}, //0
            {1,0,0,0,0,0,0,0,0,1}, //1
            {1,0,2,2,2,2,2,2,0,1}, //2
            {1,0,2,2,2,2,2,2,0,1}, //3
            {1,0,0,0,0,0,0,0,0,1}, //4
            {1,0,0,0,0,0,0,0,0,1}, //5
            {1,0,0,0,0,0,0,0,0,1}, //6
            {1,0,0,0,0,0,0,0,0,1}, //7
            {1,0,0,0,0,0,0,0,0,1}, //8
            {1,1,1,1,1,1,1,1,1,1}, //9 
           //0 1 2 3 4 5 6 7 8 9
        };
    private int winCondition = 12;
    
    void brickBreak(ball ball){
        if(staticMap[ball.getVertical()][ball.getHorizontal()] == 2){
            staticMap[ball.getVertical()][ball.getHorizontal()] = 0;
            winCondition--;
            ball.changeVerticalDirection();
            ball.changeHorizontalDirection();
        } else
        if(staticMap[ball.getVertical()-1][ball.getHorizontal()] == 2){
            staticMap[ball.getVertical()-1][ball.getHorizontal()] = 0;
            winCondition--;
            ball.changeVerticalDirection();
        } else
        if(staticMap[ball.getVertical()+1][ball.getHorizontal()] == 2){
            staticMap[ball.getVertical()+1][ball.getHorizontal()] = 0;
            winCondition--;
            ball.changeVerticalDirection();
        } else
        if(staticMap[ball.getVertical()][ball.getHorizontal()-1] == 2){
            staticMap[ball.getVertical()][ball.getHorizontal()-1] = 0;
            winCondition--;
            ball.changeHorizontalDirection();
        } else
        if(staticMap[ball.getVertical()][ball.getHorizontal()+1] == 2){
            staticMap[ball.getVertical()][ball.getHorizontal()+1] = 0;
            winCondition--;
            ball.changeHorizontalDirection();
        }
    }
    
    
    
    boolean notHitWallHorizontal(int horizontal){
        if((horizontal == 0) || (horizontal == 9)){    
            return true;
        }
        return false;
    }
    
    boolean hitWallVertical(int vertical){
        if(vertical == 0){
            return true;
        }
        return false;        
    }
    
    
    boolean endGame(int vertical){
        if((vertical == 8) || (winCondition == 0)){
            return true;
        } 
        return false;
    }
    
    void printMap(ball ball, paddleMove paddle){
        
        staticMap[ball.getVertical()][ball.getHorizontal()] = 3;
        
        staticMap[8][paddle.getLeft()] = 4;
        staticMap[8][paddle.getMiddle()] = 4;
        staticMap[8][paddle.getRight()] = 4;
        
        for(int vertical = 0; vertical<10; vertical++){
            for(int horizontal = 0; horizontal<10; horizontal++){
                if(staticMap[vertical][horizontal] == 1){
                    System.out.print("#");
                }else if (staticMap[vertical][horizontal] == 0) {
                    System.out.print(" ");
                }else if (staticMap[vertical][horizontal] == 2) {
                    System.out.print("@");
                }else if (staticMap[vertical][horizontal] == 3) {
                    System.out.print("o");
                }else if (staticMap[vertical][horizontal] == 4) {
                    System.out.print("T");
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
        
        staticMap[ball.getVertical()][ball.getHorizontal()] = 0;
    
        
        staticMap[8][paddle.getLeft()] = 0;
        staticMap[8][paddle.getMiddle()] = 0;
        staticMap[8][paddle.getRight()] = 0;
    }
}
