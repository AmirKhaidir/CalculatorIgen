// import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    // public static void main(String[] args) throws Exception {
        // String test1 = "1 + 1";
        // String test2 = "2 * 2";
        // String test3 = "1 + 2 + 3";
        // String test4 = "6 / 2";
        // String test5 = "11 + 23";
        // String test6 = "11.1 + 23";
        // String test7 = "1 + 1 * 3";
        // String test8 = "( 11.5 + 15.4 ) + 10.1";
        // String test9 = "23 - ( 29.3 - 12.5 )";
        // String test10 = "10 - ( 2 + 3 * ( 7 - 5 ) )";
        // String test11 = "2 * 3 / 4 + 8 - 1";
        // String test12 = "4 + 8 - 1 * 2 / 2";
        // String test13 = "2 * 2 * 2";
        // System.out.println("test1 " + test1 + ": " + calculate(test1) + "\n");
        // System.out.println("test2 " + test2 + ": " + calculate(test2) + "\n");
        // System.out.println("test3 " + test3 + ": " + calculate(test3) + "\n");
        // System.out.println("test4 " + test4 + ": " + calculate(test4) + "\n");
        // System.out.println("test5 " + test5 + ": " + calculate(test5) + "\n");
        // System.out.println("test6 " + test6 + ": " + calculate(test6) + "\n");
        // System.out.println("test7 " + test7 + ": " + calculate(test7) + "\n");
        // System.out.println("test8 " + test8 + ": " + calculate(test8) + "\n");
        // System.out.println("test9 " + test9 + ": " + calculate(test9) + "\n");
        // System.out.println("test10 " + test10 + ": " + calculate(test10) + "\n");
        // System.out.println("test11 " + test11 + ": " + calculate(test11) + "\n");
        // System.out.println("test12 " + test12 + ": " + calculate(test12) + "\n");
        // System.out.println("test13 " + test13 + ": " + calculate(test13) + "\n");
    // }

    public static double calculate(String sum) {
        System.out.println("Calculate: " + sum + "\n");
        String[] arrayDigit = sum.split(" ");
        List<String> digits = new ArrayList(Arrays.asList(arrayDigit));
        String operatorReg = "+-*/()";
        String pmReg = "+-";
        double total = 0;

        boolean isCompleted = false;
        boolean isBodMas = true;
        boolean isEnd = false;
        while (!isCompleted) {
            boolean isBracket = false;
            for (int i = 0; i < digits.size(); i++) {
                if (operatorReg.contains(digits.get(i))) {
                    boolean isCalculated = false;
                    if (digits.get(i).equals("(")) {
                        List<String> subSum = new ArrayList<String>();
                        isBracket = true;
                        int bracketLength = digits.lastIndexOf(")");
                        for (int j = i + 1; j < bracketLength; j++) {
                            subSum.add(digits.get(j));
                        }
                        System.out.println(String.join("subSum: " + subSum));
                        total = calculate(String.join(" ", subSum));
                        isCalculated = true;

                        digits.set(bracketLength, String.valueOf(total));
                        digits.subList(i, bracketLength).clear();
                        System.out.println(digits);
                    }
                    else {
                        if (!isBracket) {
                            if (digits.get(i).equals("/")) {
                                total = arimethericOperation(Double.parseDouble(digits.get(i - 1)), Double.parseDouble(digits.get(i + 1)), digits.get(i));
                                isCalculated = true;
                                isBodMas = true;
                            }
                            else if (digits.get(i).equals("*")) {
                                if (isEnd) {
                                    total = arimethericOperation(Double.parseDouble(digits.get(i - 1)), Double.parseDouble(digits.get(i + 1)), digits.get(i));
                                    isCalculated = true;
                                    isBodMas = true;
                                } 
                            }
                            else {
                                if (!isBodMas && isEnd) {
                                    total = arimethericOperation(Double.parseDouble(digits.get(i - 1)), Double.parseDouble(digits.get(i + 1)), digits.get(i));
                                    isCalculated = true;
                                }
                            }
                        }
                    }

                    if (isCalculated) {
                        if (!isBracket) {
                            digits.set(i, String.valueOf(total));
                            digits.remove(i-1);
                            digits.remove(i);
                        }
                    }
                }
            }
            if (isEnd) {
                isBodMas = false;
            }
            isEnd = true;
            // System.out.println("digits.size: " + digits.size());
            if (digits.size() == 1) {
                isCompleted = true;
            }
        }         
 
        return total;
    }

    public static double arimethericOperation(double first, double second, String operation) {
        double total = 0;
        switch (operation) {
            case "+":
            total += first + second;
            break;
            case "-":
            total += first - second;
            break;
            case "*":
            total += first * second;
            break;
            case "/":
            total += first / second;
            break;
        }
        System.out.println("arithmethric: " + first + " " + operation + " " + second + " total: " + total);
        return total;
    }

}
