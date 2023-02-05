/*
Напишите постфиксный калькулятор. Пользователь вводит данные и операции в обратной польской записи. 
Калькулятор вычисляет результат и проверяет, что в стэке получилось единственное число.

Например:
5 4 3 - + => 5 1 + => 6
 */

package hw4;

import java.util.Scanner;
import java.util.Stack;

public class hw4_task_3 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String userExpr = getMathExpression();

        System.out.println("Результат: " + solveMathExpression(userExpr));

    }

    private static String getMathExpression() {
        System.out.println("Введите математическое выражение (обратная польская нотация): ");
        String userMathExpression = scanner.nextLine();
        return userMathExpression;
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int solveMathExpression(String userExpr) {
        int res = 0;
        var mathExpr = userExpr.split(" ");
        // System.out.println(Arrays.toString(mathExpr));

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < mathExpr.length; i++) {

            if (isDigit(mathExpr[i])) {
                stack.push(Integer.parseInt(mathExpr[i]));
            } else {
                switch (mathExpr[i]) {
                    case "+":
                        res = stack.pop() + stack.pop();
                        stack.push(res);
                        break;
                    case "-":
                        res = -stack.pop() + stack.pop();
                        stack.push(res);
                        break;
                    case "*":
                        res = stack.pop() * stack.pop();
                        stack.push(res);
                        break;
                    case "/":
                        res = stack.pop() / stack.pop();
                        stack.push(res);
                        break;
                    default:
                        break;
                }
            }
        }
        if (stack.size() == 1) {
            res = stack.pop();
            return res;
        }
        else {
            System.out.println("Выражение записано некорректно!");
            throw new IllegalStateException();
        }
    }
}
