package chapter13;

public class Solution135 {
    public static void main(String[] args) {

    }

    public static abstract class GeometricObject2 implements Comparable<GeometricObject2> {
        private String color;
        private boolean filled;

        public GeometricObject2() {
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

        public static GeometricObject2 max(final GeometricObject2 o1, final GeometricObject2 o2) {
            if (o1.compareTo(o2) > 0) {
                return o1;
            } else if (o1.compareTo(o2) < 0) {
                return o2;
            }

            return o1;
        }

        public abstract double getArea();

        @Override
        public int compareTo(GeometricObject2 o) {
            return Double.compare(this.getArea(), o.getArea());
        }
    }
}
