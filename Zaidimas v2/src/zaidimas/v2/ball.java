package zaidimas.v2;

public class ball extends ballProperties{
    
    @Override
    void changeHorizontalDirection(){
        directionX = !directionX;
    }
    
    void changeVerticalDirection(){
        directionY = !directionY;
    }
    
    void moveHorizontaly(){
        if(directionX){
            horizontal++;
        } else {
            horizontal--;
        }
    }
    
    void moveVerticaly(){
        if(directionY){
            vertical++;
        } else {
            vertical--;
        }
    }
    
    void move(ball movedBall, map mapping, paddleMove paddle){
        moveHorizontaly();
        moveVerticaly();
        if(mapping.notHitWallHorizontal(movedBall.horizontal)){
            movedBall.changeHorizontalDirection();
            movedBall.moveHorizontaly();
            movedBall.moveHorizontaly();
        }
        if(mapping.hitWallVertical(movedBall.vertical)){
            movedBall.changeVerticalDirection();
            movedBall.moveVerticaly();
            movedBall.moveVerticaly();
        }
        if((vertical == 8) && 
                ((horizontal == paddle.getLeft()) || 
                 (horizontal == paddle.getMiddle()) || 
                 (horizontal == paddle.getRight()))){
            changeVerticalDirection();
            moveVerticaly();
            moveVerticaly();
        }
        mapping.brickBreak(movedBall);
    }
    
}
