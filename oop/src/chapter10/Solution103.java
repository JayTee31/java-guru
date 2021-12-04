package chapter10;

public class Solution103 {
    public static void main(String[] args) {
        MyInteger myinteger = new MyInteger(7);

        System.out.println(MyInteger.parseInt("1111122333"));
    }

    public static class MyInteger {
        private final int value;

        public MyInteger(final int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public boolean isEven() {
            return value % 2 == 0;
        }

        public boolean isOdd() {
            return value % 2 == 1;
        }

        public boolean isPrime() {
            if (isEven()) {
                return false;
            }

            for (int i = 3; i <= Math.pow(value, 0.5); i += 2) {
                if (value % i == 0) {
                    return false;
                }
            }

            return true;
        }

        public static boolean isEven(final int value) {
            return value % 2 == 0;
        }

        public static boolean isOdd(final int value) {
            return value % 2 == 1;
        }

        public static boolean isPrime(final int value) {
            if (isEven(value)) {
                return false;
            }

            for (int i = 3; i <= Math.pow(value, 0.5); i += 2) {
                if (value % i == 0) {
                    return false;
                }
            }

            return true;
        }

        public static boolean isEven(final MyInteger myInteger) {
            return myInteger.getValue() % 2 == 0;
        }

        public static boolean isOdd(final MyInteger myInteger) {
            return myInteger.getValue() % 2 == 1;
        }

        public static boolean isPrime(final MyInteger myInteger) {
            final int value = myInteger.getValue();

            if (isEven(value)) {
                return false;
            }

            for (int i = 3; i <= Math.pow(value, 0.5); i += 2) {
                if (value % i == 0) {
                    return false;
                }
            }

            return true;
        }

        public boolean equals(final int value) {
            return this.value == value;
        }

        public boolean equals(final MyInteger myInteger) {
            return this.value == myInteger.getValue();
        }

        public static int parseInt(final char[] array) {
            int value = 0;
            int figure = 1;

            for (int i = array.length - 1; i >= 0; i--) {
                if (Character.isDigit(array[i])) {
                    value += figure * (array[i] - '0');
                    figure *= 10;
                } else {
                    throw new IllegalArgumentException();
                }
            }

            return value;
        }

        public static int parseInt(final String str) {
            int value = 0;

            return parseInt(str.toCharArray());
        }
    }
}
