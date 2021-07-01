package data.structure;

import data.structure.stack.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        final String input1 = "()[]{}";
        final String input2 = "array[Math.max(1, 2)] = {([]())}";
        final String input3 = "[1, 2, [3, 4, (5 * 5)]]";
        final String input4 = "((";
        final String input5 = "[(])";
        final String input6 = "ab[cd(dd(aff)as})]";

        System.out.println(isBracketsBalanced(input1));
        System.out.println(isBracketsBalanced(input2));
        System.out.println(isBracketsBalanced(input3));
        System.out.println(isBracketsBalanced(input4));
        System.out.println(isBracketsBalanced(input5));
        System.out.println(isBracketsBalanced(input6));
    }

    public static boolean isBracketsBalanced(final String input) {
        final Stack<Character> bestDataStructure = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (isCharABracket(input.charAt(i))) {
                if (bestDataStructure.isEmpty()) {
                    bestDataStructure.push(input.charAt(i));

                } else if (areBracketsPairs(bestDataStructure.peek(), input.charAt(i))) {
                    bestDataStructure.pop();

                } else {
                    bestDataStructure.push(input.charAt(i));
                }
            }
        }

        return bestDataStructure.isEmpty();
    }

    public static boolean areBracketsPairs(final char bracket1, final char bracket2) {
        return (bracket1 == '(' && bracket2 == ')')
                || (bracket1 == '[' && bracket2 == ']')
                || (bracket1 == '{' && bracket2 == '}');
    }

    public static boolean isCharABracket(final char character) {
        return character == '('
                || character == ')'
                || character == '['
                || character == ']'
                || character == '{'
                || character == '}';
    }
}
