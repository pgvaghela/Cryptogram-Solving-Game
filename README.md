# Cryptogram-Solving Game

A Java-based command-line game where players decode encrypted quotes using a substitution cipher. The game reads a random quote, encrypts it, and allows players to guess the letter substitutions until they solve the puzzle.

## Features
- **Random Quote Selection**: Reads a list of quotes from an `input.txt` file and randomly selects one to encrypt.
- **Substitution Cipher Encryption**: Generates a random substitution cipher for encrypting the chosen quote.
- **Interactive Gameplay**: Players guess replacements for encrypted letters, and the game updates the encrypted quote with their guesses.
- **Game Progress Display**: Continuously shows the player's progress as they make guesses.
- **Modular Code Design**: Follows the Model-View-Controller (MVC) pattern for a clean separation of concerns.

## How to Play
1. When the game starts, an encrypted version of a random quote is displayed.
2. Players are prompted to enter a letter they want to replace and their guess for the correct letter.
3. The game updates the display to reflect the new guesses.
4. Repeat until the encrypted quote is fully decoded.
5. The game congratulates the player when the quote is successfully solved.

## Code Structure
- **CryptogramModel.java**: Handles the game logic, including reading quotes, generating the substitution cipher, encrypting the text, and tracking user guesses.
- **CryptogramController.java**: Manages the flow of the game by coordinating between the model and user input. It updates game state based on user guesses.
- **Cryptograms.java**: Serves as the entry point, handling user input, and running the game loop.

## Requirements
- Java Development Kit (JDK) 8 or higher.
- An `input.txt` file containing at least 10 quotes (one per line) for the game to encrypt and display.
