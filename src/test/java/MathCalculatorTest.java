import static org.junit.jupiter.api.Assertions.*;
import Calculator.MathCalculator;

class MathCalculatorTest {

    MathCalculator calculator = new MathCalculator();
    private static final double DELTA = 1e-15;
    @org.junit.jupiter.api.Test
    void computeFactorial() {
        assertEquals( 120, MathCalculator.computeFactorial(5), DELTA);
        assertEquals( 1, MathCalculator.computeFactorial(0), DELTA);
        assertEquals( 2, MathCalculator.computeFactorial(2), DELTA);
        assertEquals( 3628800, MathCalculator.computeFactorial(10), DELTA);
        assertEquals( 720, MathCalculator.computeFactorial(6), DELTA);

        assertNotEquals(1,MathCalculator.computeFactorial(7),DELTA);
        assertNotEquals(1190,MathCalculator.computeFactorial(8),DELTA);
        assertNotEquals(1000,MathCalculator.computeFactorial(14),DELTA);


    }

    @org.junit.jupiter.api.Test
    void computeSquareRoot() {
        assertEquals( 4, MathCalculator.computeSquareRoot(16), DELTA);
        assertEquals( 1, MathCalculator.computeSquareRoot(1), DELTA);
        assertEquals( 9, MathCalculator.computeSquareRoot(81), DELTA);
        assertEquals( 6, MathCalculator.computeSquareRoot(36), DELTA);

        assertNotEquals( 6, MathCalculator.computeSquareRoot(35), DELTA);
        assertNotEquals( 0.75, MathCalculator.computeSquareRoot(0.25), DELTA);
        assertNotEquals( 10, MathCalculator.computeSquareRoot(101), DELTA);


    }

    @org.junit.jupiter.api.Test
    void computePower() {
        assertEquals(8, MathCalculator.computePower(2, 3), DELTA);
        assertEquals( 1, MathCalculator.computePower(1, 3), DELTA);
        assertEquals(81, MathCalculator.computePower(3, 4), DELTA);
        assertEquals( 64, MathCalculator.computePower(4, 3), DELTA);
        assertEquals( 64, MathCalculator.computePower(4, 3), DELTA);

        assertNotEquals( 64, MathCalculator.computePower(4, 3), DELTA);
        assertNotEquals( 64, MathCalculator.computePower(4, 3), DELTA);
        assertNotEquals( 64, MathCalculator.computePower(4, 3), DELTA);


    }

    @org.junit.jupiter.api.Test
    void computeNaturalLog() {
        assertEquals( 0, MathCalculator.computeNaturalLog(1), DELTA);
        assertEquals( 3.91202300543, MathCalculator.computeNaturalLog(50), DELTA);
        assertEquals( 11.6952470218, MathCalculator.computeNaturalLog(120000), DELTA);

        assertNotEquals( 4, MathCalculator.computeNaturalLog(44), DELTA);
        assertNotEquals( 8, MathCalculator.computeNaturalLog(7041), DELTA);
        assertNotEquals( 8.5, MathCalculator.computeNaturalLog(5274), DELTA);



    }


}