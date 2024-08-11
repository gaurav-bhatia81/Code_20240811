package jpmc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem2Tests {

    @Test
    public void checkValidInputs() {
        assertEquals(3, Problem2.apply(88));
        assertEquals(4, Problem2.apply(156));
    }

    @Test
    public void worksWithNoOnes() {
        assertEquals(-1, Problem2.apply(0));
    }

    @Test
    public void worksWithAllOnes() {
        assertEquals(1, Problem2.apply(65535));
    }
}
