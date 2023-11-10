import java.util.Scanner;

public class Player {
  private String playerName;
  private int points;

  public Player() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter your name: ");
      String playerNameInput = scanner.nextLine();
      this.playerName = playerNameInput;
      this.points = 0;
      System.out.println("Welcome, " + playerName + "!");
  }

  public Player(String inputName, int points) {
      this.playerName = inputName;
      this.points = points;
      System.out.println("Welcome, " + playerName + "!");
  }

  public String getPlayerName() {
      return playerName;
  }

  public int getPoints() {
      return points;
  }

  public void setPlayerName(String playerName) {
      this.playerName = playerName;
  }

  public void setPoints(int points) {
      this.points = points;
  }
}







