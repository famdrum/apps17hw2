import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class SkiPassCreateTest extends TestCase {
    @Test
    public void test() {
        assertEquals(new SkiPassCreate().get_secret_current_date(), new SkiPassCreate().get_secret_current_date());
    }

}