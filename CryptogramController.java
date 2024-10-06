/*
 * Name: Pri Vaghela
 * Description: CryptogramController manages the flow of the game, connecting the model and view by handling 
 * user actions and updating the game's state accordingly.
 */

public class CryptogramController {
    private CryptogramModel model;

    // Constructor
    public CryptogramController(CryptogramModel model) {
        this.model = model;
    }

    // Check if the cryptogram is solved
    public boolean isGameOver() {
        return model.getCurrentGuess().equals(model.getAnswer());
    }

    // Makes guess
    public void makeReplacement(char letterToReplace, char guess) {
        model.setReplacement(letterToReplace, guess);
    }

    // Gets the encrypted quote
    public String getEncryptedQuote() {
        return model.getEncryptedString();
    }

    // Gets the user's progress for display
    public String getUsersProgress() {
        return model.getCurrentGuess();
    }
}
