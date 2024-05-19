// import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static double calculate(String sum) {
        System.out.println("Calculate: " + sum + "\n");
        String[] arrayDigit = sum.split(" ");
        List<String> digits = new ArrayList(Arrays.asList(arrayDigit));
        String operatorReg = "+-*/()";
        String mulDiv = "*/";
        double total = 0;

        boolean isCompleted = false;
        boolean isBodMas = true;
        boolean isEnd = false;

        while (!isCompleted) {
            boolean isBracket = false;

            for (int i = 0; i < digits.size(); i++) {
                if (operatorReg.contains(digits.get(i))) {
                    boolean isCalculated = false;
                    
                    // Check for bracket first, prioritize parenthesis according to BODMAS
                    if (digits.get(i).equals("(")) {
                        List<String> subSum = new ArrayList<String>();
                        isBracket = true;
                        int bracketLength = digits.lastIndexOf(")");

                        // Create a sublist for equation in parenthesis
                        for (int j = i + 1; j < bracketLength; j++) {
                            subSum.add(digits.get(j));
                        }

                        total = calculate(String.join(" ", subSum));
                        isCalculated = true;
                        
                        // Set the parenthesis operation total
                        digits.set(bracketLength, String.valueOf(total));
                        digits.subList(i, bracketLength).clear();
                    }
                    else {
                        if (!isBracket) {
                            // Check for multiply or Division
                            if (mulDiv.contains(digits.get(i))) {
                                // To maker sure there is no bracker after first scanning
                                if (isEnd) {
                                    total = arimethericOperation(Double.parseDouble(digits.get(i - 1)), Double.parseDouble(digits.get(i + 1)), digits.get(i));
                                    isCalculated = true;
                                    isBodMas = true;
                                }
                            }
                            else {
                                // Only do add or substract if already done the first scanning and no multiply or division found
                                if (!isBodMas && isEnd) {
                                    total = arimethericOperation(Double.parseDouble(digits.get(i - 1)), Double.parseDouble(digits.get(i + 1)), digits.get(i));
                                    isCalculated = true;
                                }
                            }
                        }
                    }
                    
                    // If any calculation done, replace the first digit, operator and second digit to the result of operation
                    if (isCalculated) {
                        if (!isBracket) {
                            digits.set(i, String.valueOf(total));
                            digits.remove(i-1);
                            digits.remove(i);
                        }
                    }
                }
            }

            // Reset the bodmas after first scanning
            if (isEnd) {
                isBodMas = false;
            }

            isEnd = true;

            // If only 1 element in list (it is the result), end the while loop
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
