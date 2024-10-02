import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            playRound(scanner);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thank you for playing! Your total score: " + score);
        scanner.close();
    }

    private static void playRound(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // 
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("A new number has been generated between 1 and 100.");
        
        while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You've guessed the correct number: " + numberToGuess);
                guessedCorrectly = true;
                score += (MAX_ATTEMPTS - attempts + 1); // Increase score based on attempts left
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry! You've used all attempts. The correct number was: " + numberToGuess);
        }

        System.out.println("Your score for this round: " + (MAX_ATTEMPTS - attempts + 1));
    }
}
