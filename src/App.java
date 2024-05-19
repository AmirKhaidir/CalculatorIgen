import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        String test1 = "1 + 1";
        String test2 = "2 * 2";
        String test3 = "1 + 2 + 3";
        String test4 = "6 / 2";
        String test5 = "11 + 23";
        String test6 = "11.1 + 23";
        String test7 = "1 + 1 * 3";
        String test8 = "( 11.5 + 15.4 ) + 10.1";
        String test9 = "23 - ( 29.3 - 12.5 )";
        String test10 = "10 - ( 2 + 3 * ( 7 - 5 ) )";
        String test11 = "2 * 2 / 4 + 8 - 1";
        String test12 = "4 + 8 - 1 * 2 / 2";
        String test13 = "3 + 5 * ( 12 - 2 * 3 )";
        // System.out.println("test1 " + test1 + ": " + Calcualtor.calculate(test1));
        // System.out.println("test2 " + test2 + ": " + Calcualtor.calculate(test2));
        // System.out.println("test3 " + test3 + ": " + Calcualtor.calculate(test3));
        // System.out.println("test4 " + test4 + ": " + Calcualtor.calculate(test4));
        // System.out.println("test5 " + test5 + ": " + Calcualtor.calculate(test5));
        // System.out.println("test6 " + test6 + ": " + Calcualtor.calculate(test6));
        // System.out.println("test7 " + test7 + ": " + Calcualtor.calculate(test7));
        // System.out.println("test8 " + test8 + ": " + Calcualtor.calculate(test8));
        // System.out.println("test9 " + test9 + ": " + Calcualtor.calculate(test9));
        // System.out.println("test10 " + test10 + ": " + Calculator.calculate(test10));
        // System.out.println("test11 " + test11 + ": " + Calculator.calculate(test11));
        // System.out.println("test12 " + test12 + ": " + Calculator.calculate(test12));
        System.out.println("test13 " + test13 + ": " + Calculator.calculate(test13));
    }
}
