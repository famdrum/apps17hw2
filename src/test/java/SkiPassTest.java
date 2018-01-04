import junit.framework.TestCase;

import static org.junit.Assert.*;

public class SkiPassTest extends TestCase {
    public static void test(){
        SkiPass skiPass = new SkiPass(1,1,1,"weekendtimes");
        assertEquals(skiPass.type, "weekendtimes");
        assertEquals(skiPass.index,1);
        assertEquals(skiPass.times,1);
        assertEquals(skiPass.deadline, 1);
    }
}