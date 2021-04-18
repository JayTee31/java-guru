import java.util.Scanner;

public class Solution58 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        final int studentsNumber = input.nextInt();
        String StudentsNameWhoScoredTheHighest = "";
        int previousStudentsScore = 0;

        for (int i = 1; i <= studentsNumber; i++) {
            System.out.println("Enter the student's name:");
            String StudentsName = input.next();

            System.out.println("Enter the student's score:");
            int studentsScore = input.nextInt();

            if (studentsScore > previousStudentsScore) {
                StudentsNameWhoScoredTheHighest = StudentsName;
                previousStudentsScore = studentsScore;
            }
        }
        System.out.println("Student with the highest score: " + StudentsNameWhoScoredTheHighest);
    }
}
