package zaidimas.v2;

public class paddleMove {
    private int left = 4;
    private int middle = 5;
    private int right = 6;

    public int getLeft() {
        return left;
    }

    public int getMiddle() {
        return middle;
    }

    public int getRight() {
        return right;
    }
    
    public void paddleMoveDirection(String moveDirectionInput, map checkingForWall){
        if(moveDirectionInput.toUpperCase().equals("A")){
            paddleMoveLeft(checkingForWall);
        } else if(moveDirectionInput.toUpperCase().equals("D")){
            paddleMoveRight(checkingForWall);
        }
    }
    
    void paddleMoveRight(map checking){
        if(!checking.notHitWallHorizontal(right+1)){
            left++;
            middle++;
            right++;
        }
    }
    
    void paddleMoveLeft(map checking){
        if(!checking.notHitWallHorizontal(left-1)){
            left--;
            middle--;
            right--;
        }
    }
}
