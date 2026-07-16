import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("--- welcome in game!---");

        while (playAgain) {
            int randomNumber = rand.nextInt(100) + 1;
            int attempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\n guess tye number between 1 to 100!");
            System.out.println("you have " + attempts + " attempts.");

            while (attempts > 0) {
                System.out.print("enter your guess");
                int userGuess = sc.nextInt();
                attempts--;

                if (userGuess == randomNumber) {
                    System.out.println("congrats! you have guess correct number");
                    totalScore += (attempts + 1) * 10; // स्कोर कॅल्क्युलेशन
                    guessedCorrectly = true;
                    break;
                } else if (userGuess > randomNumber) {
                    System.out.println("(Too High). remain attempts" + attempts);
                } else {
                    System.out.println("! (Too Low). remain attempts: " + attempts);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("your attempts are over ! the number is " + randomNumber);
            }

            System.out.println("your score: " + totalScore);
            System.out.print("want you play again? (yes/no): ");
            String choice = sc.next();
            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        System.out.println("thank you! your final score is: " + totalScore);
        sc.close();
    }
}
