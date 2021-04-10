import java.util.Scanner;

public class Solution534 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        int computerWinCounter = 0;
        int playerWinCounter = 0;

        do {
            System.out.println("Type 0 for choosing rock, 1 for paper, 2 for scissor");
            int playerChoiceInNumbers = input.nextInt();

            if (playerChoiceInNumbers < 0 || playerChoiceInNumbers > 2) {
                System.out.println("Chose a number from 0, 1 or 2");
                break;
            }

            String playerChoiceInString = "";
            String computersChoiceInString = "";
            int computersChoiceInNumbers = (int)(Math.random() * 2.999999999999);

            if (computersChoiceInNumbers == 0) {
                computersChoiceInString = "rock";
            } else if (computersChoiceInNumbers == 1) {
                computersChoiceInString = "paper";
            } else {
                computersChoiceInString = "scissor";
            }

            if (playerChoiceInNumbers == 0) {
                playerChoiceInString = "rock";
            } else if (playerChoiceInNumbers == 1) {
                playerChoiceInString = "paper";
            } else {
                playerChoiceInString = "scissor";
            }

            if (playerChoiceInNumbers == computersChoiceInNumbers) {
                computerWinCounter++;
                playerWinCounter++;
                System.out.printf("Your choice: %s, computer's choice: %s, its draw!\n", playerChoiceInString, computersChoiceInString);
                System.out.printf("Your points: %d, computers points: %d\n", playerWinCounter, computerWinCounter);
            } else if (playerChoiceInNumbers - computersChoiceInNumbers == 1 || playerChoiceInNumbers - computersChoiceInNumbers == -2) {
                playerWinCounter++;
                System.out.printf("Your choice: %s, computer's choice: %s, you won!\n", playerChoiceInString, computersChoiceInString);
                System.out.printf("Your points: %d, computers points: %d\n", playerWinCounter, computerWinCounter);
            } else {
                computerWinCounter++;
                System.out.printf("Your choice: %s, computer's choice: %s, you lost!\n", playerChoiceInString, computersChoiceInString);
                System.out.printf("Your points: %d, computers points: %d\n", playerWinCounter, computerWinCounter);
            }
        } while (Math.abs(computerWinCounter - playerWinCounter) != 3);
    }
}
