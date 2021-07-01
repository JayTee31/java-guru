package oop.playground.shapes;

public class Point {
    private final double x;
    private final double y;

    public static Point of(final double x, final double y) {
        return new Point(x, y);
    }

    private Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }





    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
