import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void add() {
        MathUtils mathObject = new MathUtils();
        int addOutput = mathObject.add(2,2);
        assertEquals(4, addOutput);

    }

    @Test
    void subtract() {
        MathUtils mathObject = new MathUtils();
        int addOutput = mathObject.subtract(4,2);
        assertEquals(2, addOutput);
    }

    @Test
    void multiply() {
    }

    @Test
    void divide() {
    }
}