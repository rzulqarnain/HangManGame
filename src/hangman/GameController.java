package hangman;

/**
 * This class manages the state of a game of hangman.
 * 
 * @author Stephen Monk
 * @version 22-Feb-2014
 */
public class GameController {

    private String word;
    private String guess;
    private int chancesRemaining;

    /**
     * Creates a new hangman game using the specified word.
     * 
     * @param word the word that is to be guessed
     */
    public GameController(String word) {
        this.word = word.toUpperCase();
        chancesRemaining = Constants.MAX_GUESSES;
        // The guess starts as all blanks.
        guess = "";
        for (int i = 0; i < this.word.length(); i++) {
            guess += Constants.BLANK;
        }
    }

    /**
     * Applies the specified letter to the state of the guessed word. 
     * In other words, if the letter is part of the solution, then
     * all occurrences of the letter are revealed; if the letter is not
     * part of the solution, the number of chances remaining is decremented.
     * 
     * @param letter the letter to reveal
     */
    public void processLetter(char letter) {
        if (word.contains(String.valueOf(letter))) {
            char[] guessArr = guess.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    guessArr[i] = letter;
                }
            }
            guess = new String(guessArr);
        }
        else {
            chancesRemaining--;
        }
    }

    /**
     * Determines whether the game is in progress, finished with win, 
     * or finished with lose.
     * 
     * @return a number representing the game status
     */
    public int checkGameStatus() {
        int res = Constants.GAME_IN_PROGRESS;

        if (chancesRemaining == 0) {
            res = Constants.GAME_OVER_LOSE;
        }
        else if (word.equals(guess)) {
            res = Constants.GAME_OVER_WIN;
        }

        return res;
    }

    /**
     * Gets the number of chances remaining to guess the word.
     * 
     * @return the number of chances remaining
     */
    public int getChancesRemaining() {
        return chancesRemaining;
    }

    /**
     * Gets the current state of guess, with correct letters revealed,
     * and all other letters represented as blanks.
     * 
     * @return the current guess
     */
    public String getGuess() {
        return guess;
    }

    /**
     * Gets the same information as getGuess, but formatted by inserting 
     * a space between each two characters.
     * 
     * @return the formatted guess
     */
    public String getGuessSpaced() {
        String res = "";

        res += guess.charAt(0);
        for (int i = 1; i < guess.length(); i++) {
            res += " " + guess.charAt(i);
        }

        return res;
    }

    /**
     * Gets the word that the game is based on.
     * 
     * @return the word the game is based on
     */
    public String getWord() {
        return word;
    }

} // end class GameController
