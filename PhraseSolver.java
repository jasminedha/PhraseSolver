import java.util.Scanner;


public class PhraseSolver {
    private String phrase;
    private String currentGuess;
    private String currentSolution;
    private Player currentPlayer;


    public PhraseSolver(String phrase) {
        this.phrase = phrase;
        this.currentGuess = "";
        this.currentSolution = initializeCurrentSolution(phrase);
        this.currentPlayer = Player.PLAYER_1;
    }


    public void playGame() {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            displayGameState();
            String guess = promptForGuess(scanner);
            if (guess.isEmpty()) {
                System.out.println("Please enter a valid guess.");
                continue;
            }


            if (guess.length() == 1) {
                char letterGuess = guess.charAt(0);
                boolean letterInPhrase = checkLetter(letterGuess);
                if (letterInPhrase) {
                    System.out.println("Letter is in the phrase!");
                    updateCurrentSolution(letterGuess);
                } else {
                    System.out.println("Letter is not in the phrase.");
                    switchPlayers();
                }
            } else {
                boolean phraseSolved = checkPhraseSolved(guess);
                if (phraseSolved) {
                    displayGameState();
                    System.out.println(currentPlayer + " wins!");
                    break;
                } else {
                    System.out.println("Incorrect guess for the full phrase.");
                    switchPlayers();
                }
            }


            boolean phraseSolved = checkPhraseSolved(currentSolution);
            if (phraseSolved) {
                displayGameState();
                System.out.println(currentPlayer + " wins!");
                break;
            }


            switchPlayers();
        }
    }


    private void displayGameState() {
        System.out.println("Current phrase: " + currentSolution);
        System.out.println("Current player: " + currentPlayer);
    }


    private String promptForGuess(Scanner scanner) {
        System.out.print(currentPlayer + ", enter your guess (letter or full phrase): ");
        return scanner.nextLine();
    }


    private boolean checkLetter(char letterGuess) {
        return phrase.contains(String.valueOf(letterGuess));
    }


    private void updateCurrentSolution(char letterGuess) {
        StringBuilder updatedSolution = new StringBuilder(currentSolution);
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == letterGuess) {
                updatedSolution.setCharAt(i, letterGuess);
            }
        }
        currentSolution = updatedSolution.toString();
    }


    private void switchPlayers() {
        if (currentPlayer == Player.PLAYER_1) {
            currentPlayer = Player.PLAYER_2;
        } else {
            currentPlayer = Player.PLAYER_1;
        }
    }


    private boolean checkPhraseSolved(String guess) {
        return phrase.equals(guess);
    }


    private String initializeCurrentSolution(String phrase) {
        StringBuilder initialSolution = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            if (Character.isLetter(phrase.charAt(i))) {
                initialSolution.append('_');
            } else {
                initialSolution.append(phrase.charAt(i));
            }
        }
        return initialSolution.toString();
    }


    public static void main(String[] args) {
        PhraseSolver game = new PhraseSolver("hello world");
        game.playGame();
    }
}


enum Player {
    PLAYER_1, PLAYER_2
}

