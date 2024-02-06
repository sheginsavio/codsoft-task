import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Welcome to Guess the Number!");
        boolean playAgain = true;
        int attempt = 0;
        int totalRounds = 0;

        while (playAgain) {
            int secretNumber = r.nextInt(100) + 1;
            int attempts = 0;
            boolean roundWin = false;

            System.out.println("Try to guess the number between 1 and 100.");

            while (true) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + secretNumber +
                            " in " + attempts + " attempts.");
                    roundWin = true;
                    totalRounds++;
                    attempt += attempts;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = sc.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        if (totalRounds > 0) {
            double averageAttempt = (double) attempt / totalRounds;
            System.out.println("Game over! You played " + totalRounds +
                    " rounds and your average attempts per round was " + String.format("%.2f", averageAttempt) + ".");
        } else {
            System.out.println("Thanks for playing!");
        }
    }
}
