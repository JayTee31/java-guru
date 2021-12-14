package chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1027 {
    public static void main(String[] args) {
        MyStringBuilder1 str = new MyStringBuilder1("piFF");

        System.out.println(str.append("hajjaj").toString());

        System.out.println(str.toLowerCase().toString());

        System.out.println(str.substring(2, 5).toString());


    }

    public static class MyStringBuilder1 {
        final List<Character> storage = new ArrayList<>();

        public MyStringBuilder1(final String s) {
            append(s);
        }

        public MyStringBuilder1 append(final String s) {
            for (int i = 0; i < s.length(); i++) {
                storage.add(s.charAt(i));
            }

            return this;
        }

        public MyStringBuilder1 append(final int i) {
            String iAsString = String.valueOf(i);

            append(iAsString);

            return this;
        }

        public int length() {
            return storage.size();
        }

        public char charAt(final int index) {
            return storage.get(index);
        }

        public MyStringBuilder1 toLowerCase() {
            for (int i = 0; i < storage.size(); i++) {
                    storage.set(i, Character.toLowerCase(storage.get(i)));
            }

            return this;
        }
        public MyStringBuilder1 substring(int begin, int end) {
            return new MyStringBuilder1(toString().substring(begin, end));
        }

        @Override
        public String toString() {
            char[] charArray = new char[length()];

            for (int i = 0; i < length(); i++) {
                charArray[i] = storage.get(i);
            }

            return new String(charArray);
        }
    }
}
