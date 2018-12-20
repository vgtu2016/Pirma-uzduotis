import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import zaidimas.v2.map;
import zaidimas.v2.paddleMove;


public class Testss {
    
    public Testss() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testCase1(){
        //Tikrinam ar pajuda i kaire
        String move = "A";
        paddleMove paddle = new paddleMove();
        map map_ = new map();
        paddle.paddleMoveDirection(move, map_);
        assertTrue(paddle.getLeft() == 3);
    }
    
    @Test
    public void testCase2(){
        //Tikrinam ar pajuda i desne
        String move = "D";
        paddleMove paddle = new paddleMove();
        map map_ = new map();
        paddle.paddleMoveDirection(move, map_);
        assertTrue(paddle.getRight() == 6);
    }
}
