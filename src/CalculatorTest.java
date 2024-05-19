import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void calculateTest1() {
        String sumString = "1 + 1";
        double total = Calculator.calculate(sumString);
        double sum = 1 + 1;
        assertEquals(sum, total, 0.00001);
    }

    @Test
    public void calculateTest2() {
        String sumString = "2 * 2";
        double total = Calculator.calculate(sumString);
        double sum = 2 * 2;
        assertEquals(sum, total, 0.00001);
    }

    @Test
    public void calculateTest3() {
        String sumString = "1 + 2 + 3";
        double total = Calculator.calculate(sumString);
        double sum = 1 + 2 + 3;
        assertEquals(sum, total, 0.00001);
    }

    @Test
    public void calculateTest4() {
        String sumString = "6 / 2";
        double total = Calculator.calculate(sumString);
        double sum = 6 / 2;
        assertEquals(sum, total, 0.00001);
    }

    @Test
    public void calculateTest5() {
        String sumString = "11 + 23";
        double total = Calculator.calculate(sumString);
        double sum = 11 + 23;
        assertEquals(sum, total, 0.00001);
    }

    @Test
    public void calculateTest6() {
        String sumString = "11.1 + 23";
        double total = Calculator.calculate(sumString);
        double sum = 11.1 + 23;
        assertEquals(sum, total, 0.00001);
    }

    @Test
    public void calculateTest7() {
        String sumString = "1 + 1 * 3";
        double total = Calculator.calculate(sumString);
        double sum = 1 + 1 * 3;
        assertEquals(sum, total, 0.00001);
    }

    @Test
    public void calculateTest8() {
        String sumString = "( 11.5 + 15.4 ) + 10.1";
        double total = Calculator.calculate(sumString);
        double sum = (11.5 + 15.4) + 10.1;
        assertEquals(sum, total, 0.00001);
    }

    @Test
    public void calculateTest9() {
        String sumString = "23 - ( 29.3 - 12.5 )";
        double total = Calculator.calculate(sumString);
        double sum = 23 - (29.3 - 12.5);
        assertEquals(sum, total, 0.00001);
    }

    @Test
    public void calculateTest10() {
        String sumString = "10 - ( 2 + 3 * ( 7 - 5 ) )";
        double total = Calculator.calculate(sumString);
        double sum = 10 - (2 + 3 * (7-5));
        
        assertEquals(sum, total, 0.00001);
    }
}

