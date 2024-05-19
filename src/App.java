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
        // System.out.println("test1 " + test1 + ": " + calculate(test1));
        // System.out.println("test2 " + test2 + ": " + calculate(test2));
        // System.out.println("test3 " + test3 + ": " + calculate(test3));
        // System.out.println("test4 " + test4 + ": " + calculate(test4));
        // System.out.println("test5 " + test5 + ": " + calculate(test5));
        // System.out.println("test6 " + test6 + ": " + calculate(test6));
        // System.out.println("test7 " + test7 + ": " + calculate(test7));
        // System.out.println("test8 " + test8 + ": " + calculate(test8));
        // System.out.println("test9 " + test9 + ": " + calculate(test9));
        // System.out.println("test10 " + test10 + ": " + calculate(test10));
        // System.out.println("test11 " + test11 + ": " + calculate(test11));
        // System.out.println("test12 " + test12 + ": " + Calculator.calculate(test12));
    }

    public static double calculate(String sum) {
        double total = 0;
        String[] values = sum.split(" ");
        Stack<String> digitStack = new Stack<String>();
        Stack<String> operatorStack = new Stack<String>();
        String operatorRegex = "+-*/()";
        String arimetheric = "+-*/";
        int operatorCount = 0;
        boolean isBodmas = false;
        boolean isBracket = false;
        boolean isCompleted = false;
        
        
        while (!isCompleted) {
            System.out.println("sum value: " + sum);
            operatorCount = 0;
            isBodmas = false;
            for (int i = 0; i < sum.length(); i++) {
                String character = String.valueOf(sum.charAt(i));
                if (arimetheric.contains(character)) {
                    if (character.equals("*") || character.equals("/")) {
                        isBodmas = true;
                    }
                    operatorCount++;
                }
            }

            if (operatorCount > 1 && isBodmas) {
                int divideIndex = sum.indexOf("/");
                int multiplyIndex = sum.indexOf("*");
                
                if (divideIndex >= 0) {
                    String newSum = sum.substring(divideIndex - 2, divideIndex + 3);
                    double result = arimethericOperation(newSum);
                    sum = sum.replace(newSum, String.valueOf(result));
                }
                else if (multiplyIndex >= 0) {
                    String newSum = sum.substring(multiplyIndex - 2, multiplyIndex + 3);
                    double result = arimethericOperation(newSum);
                    // total += result;
                    sum = sum.replace(newSum, String.valueOf(result));
                    // isCompleted = true;
                }
            }
            else {
                total += arimethericOperation(sum);
                isCompleted = true;
            }
        }

        // System.out.println("peek: " + digitStack.peek());
        // total = Double.parseDouble(digitStack.pop());
        return total;
    }

    public static double arimethericOperation(String sum) {
        System.out.println("arimethericOperation: " + sum);
        double total = 0;
        String[] values = sum.split(" ");
        Stack<Double> digitStack = new Stack<Double>();
        Stack<String> operatorStack = new Stack<String>();
        String operatorRegex = "+-*/()";
        
        for (String a : values) {
            if (!operatorRegex.contains(a)) {
                // System.out.println("digitStack size: " + digitStack.size());
                if (digitStack.isEmpty()) {
                    // System.out.println("push digit: " + a);
                    digitStack.push(Double.parseDouble(a));
                }
                else {
                    if (!operatorStack.empty()) {
                        String operation = operatorStack.pop();
                        double digit = Double.parseDouble(a);
                        // System.out.println("operation: " + operation);
                        switch (operation) {
                            case "+":
                                double add = digitStack.pop() + digit;
                                total += add;
                                digitStack.push(add);
                                break;
                            case "-":
                                double minus = digitStack.pop() - digit;
                                total += minus;
                                digitStack.push(minus);
                                break;
                            case "*":
                                double multiply = digitStack.pop() * digit;
                                total += multiply;
                                digitStack.push(multiply);
                                break;
                            case "/":
                                double divide = digitStack.pop() / digit;
                                total += divide;
                                digitStack.push(divide);
                                break;
                            case "(":
                                
                                break;
                            case ")":
                                break;
                        }
                    }
                }
            }
            else {
                operatorStack.push(a);
            }
        }
        
        // System.out.println("peek arithmethric operation: " + digitStack.peek());
        total = digitStack.pop();
        return total;
    }
}
