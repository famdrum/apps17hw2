import junit.framework.TestCase;

import static org.junit.Assert.*;

public class TurniketTest extends TestCase{
    public void test(){
        SkiPass skiPass = new SkiPass(1,1,-1, "weekendtimes");
        SkiPass skiPass1 = new SkiPass(1,-1,2025, "weekenddays");
        SkiPass skiPass2 = new SkiPass(1,-1,2037, "weekendseason");
        Turniket turniket = new Turniket();
        assertEquals(turniket.get_secret_current_date(), new Turniket().get_secret_current_date());
        assertEquals(turniket.process(skiPass), true);
        assertEquals(turniket.process(skiPass), false);
        assertEquals(turniket.process(skiPass1), true);
        assertEquals(turniket.process(skiPass2), true);
    }
}