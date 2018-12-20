package zaidimas.v2;

public class ballProperties {
    int horizontal = 4;
    int vertical = 7;
    boolean directionX;
    boolean directionY;

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public boolean isDirectionX() {
        return directionX;
    }

    public boolean isDirectionY() {
        return directionY;
    }
    
    void changeHorizontalDirection(){
        System.out.println("No");
    }
    
    void changeVerticalDirection(){
        System.out.println("No");
    }
}
