package zaidimas.v2;

public class UI {
    public static void main(String[] args) {
        game start = new game();
        
        System.out.println("Zaidimas vyksta naudojant A S D klavisus");
        System.out.println("A - eiti i kaire");
        System.out.println("S - Likti vietoje");
        System.out.println("D - eiti i desne");
        System.out.println("-Spauskite bet koki klavisa-");
        
        start.playGame();
    }
}
