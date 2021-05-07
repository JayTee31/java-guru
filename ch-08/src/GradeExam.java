public class GradeExam {
    public static void main(String[] args) {
        final char[][] answers = {
                {'A', 'B', 'A'},
                {'D', 'B', 'A'},
                {'E', 'D', 'D'},
                {'C', 'B', 'A'},
                {'A', 'B', 'D'},
        };
        final char[] keys = {'D', 'B', 'D'};

        for (final char[] student : answers) {
            int studentPoints = 0;

            for (int i = 0; i < student.length; i++) {
                if (student[i] == keys[i]) {
                    studentPoints++;
                }
            }
            System.out.println(studentPoints);
        }
    }
}
