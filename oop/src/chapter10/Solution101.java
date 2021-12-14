package chapter10;

import javax.xml.crypto.Data;
import java.util.Date;

public class Solution101 {
    public static void main(String[] args) {
        Time time = new Time(555550000);

        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
    }

    public static class Time {
        private int hour;
        private int minute;
        private int second;

        public Time() {
            setTime(System.currentTimeMillis());
        }

        public Time(final long elapsedTime) {
            setTime(elapsedTime);
        }

        public Time (final int hour, final int minute, final int second) {
            setHour(hour);
            setMinute(minute);
            setSecond(second);
        }

        public void setTime(long elapsedTime) {
            final int MS_TO_SECOND = 1000;
            final int MS_TO_MINUTE = 60 * MS_TO_SECOND;
            final int MS_TO_HOUR = 60 * MS_TO_MINUTE;
            final int MS_TO_DAY = 24 * MS_TO_HOUR;

            hour = (int)(elapsedTime % MS_TO_DAY / MS_TO_HOUR);
            minute = (int)(elapsedTime % MS_TO_DAY % MS_TO_HOUR / MS_TO_MINUTE);
            second = (int)(elapsedTime % MS_TO_DAY % MS_TO_HOUR % MS_TO_MINUTE / MS_TO_SECOND);
        }

        public long getHour() {
            return hour;
        }

        public void setHour(int hour) {
            if (hour <= 24 && hour >= 0) {
                this.hour = hour;
            }

            throw new IllegalArgumentException();
        }

        public long getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            if (minute <= 60 && minute >= 0) {
                this.minute = minute;
            }

            throw new IllegalArgumentException();
        }

        public long getSecond() {
            return second;
        }

        public void setSecond(int second) {
            if (second <= 60 && second >= 0) {
                this.second = second;
            }

            throw new IllegalArgumentException();
        }
    }
}
