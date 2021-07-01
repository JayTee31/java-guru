package data.structure;

import data.structure.stack.Stack;

public class ReversePolishNotation {
    public static final int DIGITS_ASCII_MODIFIER = 48;

    public static void main(String[] args) {
        final String input = "7832^*++";

        System.out.println(evaluateRPN(input));

    }

    public static double evaluateRPN(final String formula) {
        if (isInputInvalid(formula)) {
            throw new IllegalArgumentException();
        }

        final Stack<Double> bestDataStructure = new Stack<>();

        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '+') {
                if (bestDataStructure.size() < 2) {
                    throw new IllegalArgumentException();
                }

                final double secondNumber = bestDataStructure.pop();
                final double firstNumber = bestDataStructure.pop();

                bestDataStructure.push(firstNumber + secondNumber);
            }

            else if (formula.charAt(i) == '-') {
                if (bestDataStructure.size() < 2) {
                    throw new IllegalArgumentException();
                }

                final double secondNumber = bestDataStructure.pop();
                final double firstNumber = bestDataStructure.pop();

                bestDataStructure.push(firstNumber - secondNumber);
            }

            else if (formula.charAt(i) == '*') {
                if (bestDataStructure.size() < 2) {
                    throw new IllegalArgumentException();
                }

                final double secondNumber = bestDataStructure.pop();
                final double firstNumber = bestDataStructure.pop();

                bestDataStructure.push(firstNumber * secondNumber);
            }

            else if (formula.charAt(i) == '/') {
                if (bestDataStructure.size() < 2) {
                    throw new IllegalArgumentException();
                }

                final double secondNumber = bestDataStructure.pop();
                final double firstNumber = bestDataStructure.pop();

                bestDataStructure.push(firstNumber / secondNumber);
            }

            else if (formula.charAt(i) == '^') {
                if (bestDataStructure.size() < 2) {
                    throw new IllegalArgumentException();
                }

                final double secondNumber = bestDataStructure.pop();
                final double firstNumber = bestDataStructure.pop();

                bestDataStructure.push(Math.pow(firstNumber, secondNumber));
            }

            else {
                if (!Character.isDigit(formula.charAt(i))) {
                    throw new IllegalArgumentException();
                }

                bestDataStructure.push((double)(formula.charAt(i) - DIGITS_ASCII_MODIFIER));
            }
        }

        if (bestDataStructure.size() != 1) {
            throw new IllegalArgumentException();
        }

        return bestDataStructure.pop();
    }

    public static boolean isInputInvalid(final String input) {
        return input == null || input.length() < 2 || !Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(1));
    }
}
