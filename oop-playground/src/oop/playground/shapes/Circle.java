package oop.playground.shapes;

public class Circle {
    private static final double PI = 3.14;

    private final double radius;
    private final Point center;

    /**
     * Makes a new circle.
     * @param radius the radius of the circle
     * @param center the center of the circle
     * @return a new circle
     * @throws IllegalArgumentException when radius is lower than zero, or center has a null value
     */
    public static Circle makeCircle(final double radius, final Point center) {
        if (radius < 0) {
            throw new IllegalArgumentException("meh");
        }

        if (center == null) {
            throw new IllegalArgumentException("piff");
        }

        return new Circle(radius, center);
    }

    private Circle(final double radius, final Point center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public String toString() {
        return "Circle {" +
                "radius = " + radius +
                ", center = " + center +
                "}";
    }

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public double calculatePerimeter() {
        return 2 * radius * PI;
    }

    public double calculateArea() {
        return radius * radius * Circle.PI;
    }

    public Circle withChangedRadius(final double delta) {
        return Circle.makeCircle(radius + delta, center);
    }

    public Circle withChangedCenter(final Point delta) {
        return Circle.makeCircle(radius, Point.of(center.getX() + delta.getX(), center.getY() + delta.getY()));
    }


}
