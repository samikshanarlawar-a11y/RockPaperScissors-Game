import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userScore = 0;
        int computerScore = 0;

        System.out.println("🎮 Welcome to Rock Paper Scissors Game 🎮");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Rock🪨");
            System.out.println("2. Paper📄");
            System.out.println("3. Scissors✂️");
            System.out.println("0. Exit");

            System.out.print("Your choice: ");

            // Input validation
            if (!scanner.hasNextInt()) {
                System.out.println("❌ Please enter a valid number!");
                scanner.next(); // clear invalid input
                continue;
            }

            int userChoice = scanner.nextInt();

            if (userChoice == 0) {
                System.out.println("\nGame Over!");
                System.out.println("Final Score:");
                System.out.println("You: " + userScore);
                System.out.println("Computer: " + computerScore);
                break;
            }

            if (userChoice < 1 || userChoice > 3) {
                System.out.println("❌ Invalid choice! Try again.");
                continue;
            }

            int computerChoice = random.nextInt(3) + 1;

            System.out.println("Computer chose: " + getChoiceName(computerChoice));

            if (userChoice == computerChoice) {
                System.out.println("🤝 It's a Draw!");
            } 
            else if (
                (userChoice == 1 && computerChoice == 3) ||
                (userChoice == 2 && computerChoice == 1) ||
                (userChoice == 3 && computerChoice == 2)
            ) {
                System.out.println("🎉 You Win!");
                userScore++;
            } 
            else {
                System.out.println("💻 Computer Wins!");
                computerScore++;
            }

            System.out.println("Score → You: " + userScore + " | Computer: " + computerScore);
        }

        scanner.close();
    }

    // Method to return choice name
    public static String getChoiceName(int choice) {
        if (choice == 1) {
            return "Rock";
        } else if (choice == 2) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }
}