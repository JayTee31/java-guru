public class Solution425 {
    public static void main(String[] args) {
        final int plateNumbers = (int)(Math.random() * 10000);
        char[] plateLettersInChar = new char[3];

        for (int i = 0; i < 3; i++) {
            final char letter = (char)((int)(Math.random() * ((int)'Z' + 1 - (int)'A') + (int)'A'));
            plateLettersInChar[i] = letter;
        }

        final String plateLettersInString = String.valueOf(plateLettersInChar);

        System.out.println(plateLettersInString + plateNumbers);
    }
}
