/*
 * Name: Pri Vaghela
 * Description: CryptogramModel reads the file, encrypts the the code and returns the current guess progress.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CryptogramModel {
    private String originalText;
    private String encryptedText;
    private ArrayList<String> lines;
    private HashMap<Character, Character> cipherKey;
    private HashMap<Character, Character> userGuesses;

    // Constructor - reads a random text from the input file and encrypts it
    public CryptogramModel() {
        lines = new ArrayList<>();
        readLines("input.txt");
        if (!lines.isEmpty()) {
            originalText = randQuote(lines);
            cipherKey = generateCipherKey();
            encryptedText = encryptText(originalText);
            userGuesses = new HashMap<>();
        } else {
            System.out.println("Error: No quotes to encrypt.");
            originalText = "";
            encryptedText = "";
        }
    }

    // Reads quotes from the input file
    private void readLines(String filename) {
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    lines.add(line.toUpperCase());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not Found");
        }
    }

    // Randomly selects a quote from the list of quotes
    private String randQuote(List<String> quotes) {
        Random random = new Random();
        return quotes.get(random.nextInt(quotes.size()));
    }

    // Generates a random cipher key (substitution cipher)
    private HashMap<Character, Character> generateCipherKey() {
        List<Character> alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".chars().mapToObj(c -> (char) c).toList();
        List<Character> shuffledAlphabet = new ArrayList<>(alphabet);
        Collections.shuffle(shuffledAlphabet);

        HashMap<Character, Character> key = new HashMap<>();
        for (int i = 0; i < alphabet.size(); i++) {
            key.put(alphabet.get(i), shuffledAlphabet.get(i));
        }
        return key;
    }

    // Encrypts the text using the cipher key
    private String encryptText(String text) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (cipherKey.containsKey(Character.toUpperCase(c))) {
                encrypted.append(cipherKey.get(Character.toUpperCase(c)));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    // Sets a guess for the user
    public void setReplacement(char encryptedChar, char guess) {
        userGuesses.put(Character.toUpperCase(encryptedChar), Character.toUpperCase(guess));
    }

    // Returns the encrypted string
    public String getEncryptedString() {
        return encryptedText;
    }

    // Returns the current guess with underscores for missing letters
    public String getCurrentGuess() {
        StringBuilder currentGuess = new StringBuilder();
        for (char c : encryptedText.toCharArray()) {
            if (Character.isLetter(c) && userGuesses.containsKey(c)) {
                currentGuess.append(userGuesses.get(c));
            } else if (Character.isLetter(c)) {
                currentGuess.append(' ');
            } else {
                currentGuess.append(c);
            }
        }
        return currentGuess.toString();
    }

    // Returns the answer (original text)
    public String getAnswer() {
        return originalText;
    }
}
