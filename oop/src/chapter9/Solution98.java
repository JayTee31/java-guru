package chapter9;

public class Solution98 {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.turnOn();

        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5);

        System.out.println(fan1);
        System.out.println(fan2);

    }

    public static class Fan {
        final static int SLOW = 1;
        final static int MEDIUM = 2;
        final static int FAST = 3;

        private int speed;
        private boolean on;
        private double radius;
        String color;

        Fan() {
            speed = SLOW;
            on = false;
            radius = 5;
            color = "blue";
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            if (speed >= SLOW && speed <= FAST) {
                this.speed = speed;
            }
        }

        public boolean isOn() {
            return on;
        }

        public void turnOn() {
            if (!on) {
                on = true;
            }
        }

        public void turnOff() {
            if (on) {
                on = false;
            }
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            if (on) {
                return "The Fan's" +
                        " speed = " + speed +
                        ", radius = " + radius +
                        ", color = " + color;
            }

            return "The Fan's" +
                    ", radius = " + radius +
                    ", color = " + color+
                    "\nThe fan is off";
        }
    }
}
