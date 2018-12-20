package zaidimas.v2;

public class game {
    
    public void playGame(){
        input inputClass = new input();
        map mapClass = new map();
        ball ballClass = new ball();
        paddleMove paddle = new paddleMove();
        String move;
        
        inputClass.startGame();
        
        while(true){
            mapClass.printMap(ballClass, paddle);
            move = inputClass.scanNextLine();
            
            paddle.paddleMoveDirection(move, mapClass);
            ballClass.move(ballClass, mapClass, paddle);
            if (mapClass.endGame(ballClass.getVertical())){
                System.out.println("Game Over");
                mapClass.printMap(ballClass, paddle);
                break;
            }
        }
    }
}
