package chapter11;

public class Solution111 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(1, 1, 1);
        System.out.println(triangle.getArea());
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.toString());
        System.out.println(triangle.getColor());
        System.out.println(triangle.isFilled());

        triangle.setColor("Im blue, da ba dee da ba di");
        triangle.setFilled(true);

        System.out.println(triangle.getColor());
        System.out.println(triangle.isFilled());
    }

    public static class Triangle extends GeometricObject {
        private final double side1;
        private final double side2;
        private final double side3;

        public Triangle() {
            side1 = 1.0;
            side2 = 1.0;
            side3 = 1.0;
        }

        public Triangle(final double side1, final double side2, final double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }

        public double getSide1() {
            return side1;
        }

        public double getSide2() {
            return side2;
        }

        public double getSide3() {
            return side3;
        }

        public double getArea() {
            final double s = (side1 + side2 + side3) / 2;

            return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
        }

        public double getPerimeter() {
            return side1 + side2 + side3;
        }

        @Override
        public String toString() {
            return "Triangle: " +
                    "side1 = " + side1 +
                    ", side2 = " + side2 +
                    ", side3 = " + side3;
        }
    }

    public static class GeometricObject {
        private String color;
        private boolean filled;

        public GeometricObject() {
            color = "white";
            filled = false;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isFilled() {
            return filled;
        }

        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        @Override
        public String toString() {
            return "color = '" + color + '\'' +
                    ", filled =" + filled;
        }
    }
}
