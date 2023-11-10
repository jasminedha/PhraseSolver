/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class Board {
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue;

  public Board() {
      solvedPhrase = "";
      phrase = loadPhrase();
      setLetterValue();
  }

  public String getSolvedPhrase() {
      return solvedPhrase;
  }

  public String getPhrase() {
      return phrase;
  }

  public int getCurrentLetterValue() {
      return currentLetterValue;
  }

  public void setSolvedPhrase(String solvedPhrase) {
      this.solvedPhrase = solvedPhrase;
  }

  public void setPhrase(String phrase) {
      this.phrase = phrase;
  }

  public void setCurrentLetterValue(int currentLetterValue) {
      this.currentLetterValue = currentLetterValue;
  }

  public void setLetterValue() {
      int randomInt = (int) ((Math.random() * 10) + 1) * 100;
      currentLetterValue = randomInt;
  }

  private String loadPhrase() {
      String tempPhrase = "";

      int numOfLines = 0;
      try {
          Scanner sc = new Scanner(new File("phrases.txt"));
          while (sc.hasNextLine()) {
              tempPhrase = sc.nextLine().trim();
              numOfLines++;
          }
      } catch (Exception e) {
          System.out.println("Error reading or parsing phrases.txt");
      }

      int randomInt = (int) ((Math.random() * numOfLines) + 1);

      try {
          int count = 0;
          Scanner sc = new Scanner(new File("phrases.txt"));
          while (sc.hasNextLine()) {
              count++;
              String temp = sc.nextLine().trim();
              if (count == randomInt) {
                  tempPhrase = temp;
              }
          }
      } catch (Exception e) {
          System.out.println("Error reading or parsing phrases.txt");
      }

      for (int i = 0; i < tempPhrase.length(); i++) {
          if (tempPhrase.substring(i, i + 1).equals(" ")) {
              solvedPhrase += "  ";
          } else {
              solvedPhrase += "_ ";
          }
      }

      return tempPhrase;
  }
}
