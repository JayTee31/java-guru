import java.util.Scanner;

public class Solution71 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        final int numberOfStudents = input.nextInt();

        if (numberOfStudents == 0) {
            System.out.println("0 student makes no sense");
            System.exit(0);
        }

        final int[] scoreOfStudents = new int[numberOfStudents];

        System.out.printf("Enter the %d scores: \n", numberOfStudents);
        for (int i = 0; i < numberOfStudents; i++) {
            scoreOfStudents[i] = input.nextInt();
        }

        final char[] gradeOfStudents = getGradeOfStudents(scoreOfStudents, findGreatestScore(scoreOfStudents));
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf("Student %d score is %d and grade is %c\n", i + 1, scoreOfStudents[i], gradeOfStudents[i]);
        }
    }

    public static char[] getGradeOfStudents(final int[] scoreOfStudents, final int greatestScore) {
        final int SCORE_RANGE_FOR_GRADES = 5;
        final char[] POSSIBLE_GRADES = {'A', 'B', 'C', 'D', 'F'};
        final char[] gradeOfStudents = new char[scoreOfStudents.length];

        for (int i = 0; i < scoreOfStudents.length; i++) {
            int scoreRangeCounter = SCORE_RANGE_FOR_GRADES;
            gradeOfStudents[i] = POSSIBLE_GRADES[POSSIBLE_GRADES.length - 1];

            for (int j = 0; j < POSSIBLE_GRADES.length - 1; j++) {
                final int differenceFromGreatestScore = greatestScore - scoreOfStudents[i];

                if (differenceFromGreatestScore <= scoreRangeCounter) {
                    gradeOfStudents[i] = POSSIBLE_GRADES[j];
                    break;
                } else {
                    scoreRangeCounter += SCORE_RANGE_FOR_GRADES;
                }
            }
        }
        return gradeOfStudents;

        // Basic solution below, heka-meka above.

        /* final char[] gradeOfStudents = new char[scoreOfStudents.length];

        for (int i = 0; i < scoreOfStudents.length; i++) {
            final int differenceFromGreatestScore = greatestScore - scoreOfStudents[i];

            if (differenceFromGreatestScore <= 5) {
                gradeOfStudents[i] = 'A';
            } else if (differenceFromGreatestScore <= 10) {
                gradeOfStudents[i] = 'B';
            } else if (differenceFromGreatestScore <= 15) {
                gradeOfStudents[i] = 'C';
            } else if (differenceFromGreatestScore <= 20) {
                gradeOfStudents[i] = 'D';
            } else {
                gradeOfStudents[i] = 'F';
            }
        }
        return gradeOfStudents; */
    }

    public static int findGreatestScore(final int[] scores) {
        if (scores == null || scores.length == 0) {
            return -1;
        }

        int greatestNumber = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > greatestNumber) {
                greatestNumber = scores[i];
            }
        }
        return greatestNumber;
    }
}
