/*
 * Name: Pri Vaghela
 * Description: Cryptograms calls the methods made in model and controller and serves as the code executor.
 */

import java.util.Scanner;

public class Cryptograms {
    public static void main(String[] args) {
        CryptogramModel model = new CryptogramModel();
        CryptogramController controller = new CryptogramController(model);
        Scanner scanner = new Scanner(System.in);

        while (!controller.isGameOver()) {
            // Display encrypted quote and current progress
            System.out.println(controller.getEncryptedQuote());
            System.out.println(controller.getUsersProgress());

            // Get user input for which letter to replace
            System.out.print("Enter the letter to replace: ");
            char letterToReplace = scanner.nextLine().toUpperCase().charAt(0);

            // Get user input for the replacement letter
            System.out.print("Enter its replacement: ");
            char guess = scanner.nextLine().toUpperCase().charAt(0);

            // Make the replacement
            controller.makeReplacement(letterToReplace, guess);

            // Display progress after each guess
            System.out.println();
        }

        // Congratulate the player when the game is complete
        System.out.println("You got it!");
        scanner.close();
    }
}
