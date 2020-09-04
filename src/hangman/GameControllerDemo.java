package hangman;

public class GameControllerDemo {

    public void runDemo() {
        char[] guesses = {'A', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R'};
        System.out.println("\n*** WIN Example ***\n");
        runExample("PROGRAMMING", guesses);
        System.out.println("\n*** LOSE Example ***\n");
        runExample("TECHNOLOGY", guesses);
    }

    public void runExample(String word, char[] guesses) {
        GameController controller = new GameController(word);
        System.out.println("The word to guess is: " + controller.getWord() + "\n");
        System.out.println("Your current game guess is: " + controller.getGuessSpaced());
        System.out.println("There are " + controller.getChancesRemaining() + " chances left.");
        System.out.println();
        int next = 0;
        int status = controller.checkGameStatus();
        while (status == Constants.GAME_IN_PROGRESS) {
            char letter = guesses[next];
            controller.processLetter(letter);
            System.out.println("You guessed the letter: " + letter);
            System.out.println("Your current game guess is: " + controller.getGuessSpaced());
            System.out.println("There are " + controller.getChancesRemaining() + " chances left.");
            System.out.println();
            next++;
            status = controller.checkGameStatus();
        } // end loop
        
        // Game is now over. Determine if win or lose.
        if (controller.checkGameStatus() == Constants.GAME_OVER_WIN) {
            System.out.println("YOU WIN!");
        }
        else {
            System.out.println("YOU LOSE!");
        }
    }

    public static void main(String[] args) {
        new GameControllerDemo().runDemo();
    }

} // end class GameControllerDemo
