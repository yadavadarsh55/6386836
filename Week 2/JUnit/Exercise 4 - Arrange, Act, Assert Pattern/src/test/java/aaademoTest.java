import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class aaademoTest {

    private aaademo demo;
    @Before
    public void setUp(){
        System.out.println("Setting up test...");
        demo = new aaademo();
    }

    @After
    public void tearDown(){
        System.out.println("Tearing Down the test...");
        demo = null;
    }

    @Test
    public void testCalc (){
        int result = demo.add(5, 6);
        System.out.println("Test Started...");
        assertEquals(11, result);
    }

}