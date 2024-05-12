import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMathTest {

    @BeforeEach
    void setUp() {

    }


    @Test
    void add() {
        SimpleMath mySimpleMath = new SimpleMath();
        assertNotEquals(5, mySimpleMath.add(2,2));
        //assertEquals(5, mySimpleMath.add(2,2));
        assertEquals(4, mySimpleMath.add(2,2));
    }

    @Test
    void subtract() {
        SimpleMath mySimpleMath = new SimpleMath();
        assertEquals(2, mySimpleMath.subtract(6,2));
    }

    @Test
    void multiply() {
        SimpleMath mySimpleMath = new SimpleMath();
        assertEquals(10, mySimpleMath.multiply(5,2));
    }

    @Test
    void divide() {
        SimpleMath mySimpleMath = new SimpleMath();
        mySimpleMath.divide(10, 0);
        assertEquals(5, mySimpleMath.divide(10,2));

    }
}