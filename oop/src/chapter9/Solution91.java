package chapter9;

public class Solution91 {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4,40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);

        System.out.println(rectangle1);
        System.out.println(rectangle2);

    }

    public static class Rectangle {
        private final double height;
        private final double width;

        Rectangle(final double height, final double width) {
            this.height = height;
            this.width = width;
        }

        Rectangle() {
            this(1,1);
        }

        @Override
        public String toString() {
            return "The Rectangles: " +
                    "height = " + height +
                    ", width = " + width +
                    ", area: " + getArea() +
                    ", perimeter: " + getPerimeter();
        }

        public double getArea() {
            return height * width;
        }

        public double getPerimeter() {
            return (height + width) * 2;
        }

    }
}
