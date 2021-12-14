package chapter9;

public class Solution99 {
    public static void main(String[] args) {
        RegularPolygon regularPolygon = new RegularPolygon(6, 4);

        System.out.println(regularPolygon.getPerimeter());
        System.out.println(regularPolygon.getArea());
    }

    public static class RegularPolygon {
        private int n;
        private double side;
        private double x;
        private double y;

        RegularPolygon(final int n, final double side, final double x, final double y) {
            this.n = n;
            this.side = side;
            this.x = x;
            this.y = y;
        }

        RegularPolygon(final int n, final double side) {
            this(n, side, 0, 0);
        }

        RegularPolygon() {
            this(3, 1);
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public double getSide() {
            return side;
        }

        public void setSide(double side) {
            this.side = side;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getPerimeter() {
            return n * side;
        }

        public double getArea() {
            return n * Math.pow(side, 2) / (4 * Math.tan(Math.PI / n));
        }
    }
}
