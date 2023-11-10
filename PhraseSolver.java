/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver {
  private String phraseToSolve;
  private StringBuilder guessedLetters;
  private boolean gameSolved;

  public PhraseSolver(String phraseToSolve) {
      this.phraseToSolve = phraseToSolve;
      this.guessedLetters = new StringBuilder();
      this.gameSolved = false;

      Player player1 = new Player();
      Player player2 = new Player();

      Board board = new Board();
  }

  public String getPhraseToSolve() {
      return phraseToSolve;
  }

  public void setPhraseToSolve(String phraseToSolve) {
      this.phraseToSolve = phraseToSolve;
  }

  public boolean isLetterCorrect(char guessedLetter) {
      boolean correct = phraseToSolve.contains(String.valueOf(guessedLetter));

      if (correct) {
          guessedLetters.append(guessedLetter);
      }

      return correct;
  }

  public void displayCurrentState() {
      for (char letter : phraseToSolve.toCharArray()) {
          if (guessedLetters.toString().contains(String.valueOf(letter))) {
              System.out.print(letter + " ");
          } else {
              System.out.print("_ ");
          }
      }
      System.out.println();
  }

  public void play() {
      while (!gameSolved) {
          displayCurrentState();
          System.out.print("Enter a letter: ");
          char guessedLetter = new Scanner(System.in).next().charAt(0);
          boolean correct = isLetterCorrect(guessedLetter);

          if (correct) {
              System.out.println("Letter is correct!");
              gameSolved = !displayCurrentState().contains("_");
          } else {
              System.out.println("Letter is incorrect. Try again!");
          }
      }

      displayCurrentState();
      System.out.println("Congratulations! You solved the phrase!");
  }
}
