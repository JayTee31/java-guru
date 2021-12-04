package chapter13;

import chapter11.Solution111;

import java.util.ArrayList;
import java.util.List;

public class Solution137 {
    public static void main(String[] args) {
        final List<Solution111.GeometricObject> list = new ArrayList<>();

        list.add(new Rectangle(5));
        list.add(new Solution111.Triangle());

        for (Solution111.GeometricObject geometricObject : list) {
            if (geometricObject instanceof Colorable) {
                ((Colorable) geometricObject).howToColor();
            }
        }
    }

    public interface Colorable {

        void howToColor();
    }

    public static class Rectangle extends Solution111.GeometricObject implements Colorable {
        private double side;

        public Rectangle(final double side) {
            this.side = side;
        }

        public Rectangle() {
            this(0);
        }

        public double getSide() {
            return side;
        }

        public void setSide(double side) {
            this.side = side;
        }

        public void howToColor() {
            System.out.println("Color all four sides");
        }
    }
}
