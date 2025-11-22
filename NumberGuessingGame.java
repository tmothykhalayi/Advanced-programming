import java.io.*;
import java.util.*;

public class NumberGuessingGame {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static final String SCORE_FILE = "highscore.txt";

    public static void main(String[] args) {

        int choice;

        while (true) {
            System.out.println("\n===== ADVANCED NUMBER GUESSING GAME =====");
            System.out.println("1. Easy (1–50, 10 attempts)");
            System.out.println("2. Medium (1–100, 7 attempts)");
            System.out.println("3. Hard (1–500, 5 attempts)");
            System.out.println("4. View High Score");
            System.out.println("5. Exit");
            System.out.print("Choose difficulty: ");
            choice = sc.nextInt();


            switch (choice) {
                case 1: playGame(50, 10); break;
                case 2: playGame(100, 7); break;
                case 3: playGame(500, 8); break;
                case 4: showHighScore(); break;
                case 5:
                    System.out.println("Exiting game... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // -------------------------------------------------
    // Play the actual game
    // -------------------------------------------------
    public static void playGame(int maxRange, int attemptsAllowed) {

        int secret = rand.nextInt(maxRange) + 1;
        int guess, attempts = 0;

        System.out.println("\n🎯 I picked a number between 1 and " + maxRange);
        System.out.println("🔁 You have " + attemptsAllowed + " attempts.\n");

        while (attempts < attemptsAllowed) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            // Correct guess
            if (guess == secret) {
                System.out.println("\n Correct! You guessed the number in " + attempts + " attempts.");
                updateHighScore(attempts);
                return;
            }

            // Hints
            if (Math.abs(guess - secret) <= 5)
                System.out.println(" Very close!");
            else if (Math.abs(guess - secret) <= 15)
                System.out.println(" Close!");
            else
                System.out.println("❄ Far away!");

            // Too high / too low
            if (guess < secret)
                System.out.println("Hint: Try HIGHER.\n");
            else
                System.out.println("Hint: Try LOWER.\n");
        }

        System.out.println(" You've used all " + attemptsAllowed + " attempts!");
        System.out.println("The number was: " + secret);
    }

    // -------------------------------------------------
    // High Score Handling (Save Best Score to File)
    // -------------------------------------------------
    public static void updateHighScore(int score) {
        try {
            int bestScore = getHighScore();

            if (score < bestScore) {
                System.out.println("🏆 NEW HIGH SCORE!");
                PrintWriter pw = new PrintWriter(new FileWriter(SCORE_FILE));
                pw.println(score);
                pw.close();
            } else {
                System.out.println("Best Score: " + bestScore);
            }

        } catch (Exception e) {
            System.out.println("Error updating high score.");
        }
    }

    public static int getHighScore() {
        try {
            File file = new File(SCORE_FILE);
            if (!file.exists()) return Integer.MAX_VALUE;

            BufferedReader br = new BufferedReader(new FileReader(file));
            int score = Integer.parseInt(br.readLine());
            br.close();
            return score;

        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }
    }

    public static void showHighScore() {
        int score = getHighScore();
        if (score == Integer.MAX_VALUE)
            System.out.println("\nNo high score yet. Be the first to set one!");
        else
            System.out.println("\n HIGH SCORE: " + score + " attempts");
    }
}
