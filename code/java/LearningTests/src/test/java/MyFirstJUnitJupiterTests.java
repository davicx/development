import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

class MyFirstJUnitJupiterTests {

    private final Calculator calculator = new Calculator();

    @Test
    void addition() {
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    void additionTwo() {
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    void additionThree() {
        assertEquals(4, calculator.add(2, 2));
    }
}