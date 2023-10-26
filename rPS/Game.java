package rPS;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
  enum Color {
    RESET("\u001B[0m"),
    YELLOW("\u001B[33m"),
    RED("\u001B[31m"),
    BLUE("\u001B[34m");

    public final String value;

    private Color(String value) {
      this.value = value;
    }
  }

  private String addColor(String text, Color color) {
    return color.value + text + Color.RESET.value;
  }

  private class Score {
    int playerScore = 0;
    int computerScore = 0;
  }

  private enum Move {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSOR("Scissor");

    public final String value;

    private Move(String value) {
      this.value = value;
    }
  }

  private enum Result {
    WIN, LOSE, TIE
  }

  private Move getPlayerMove(Scanner sc) {
    while (true) {
      System.out.print("Enter Move: ");
      String playerMove = sc.next().toLowerCase();
      if (playerMove.equals("rock")) {
        return Move.ROCK;
      } else if (playerMove.equals("paper")) {
        return Move.PAPER;
      } else if (playerMove.equals("scissor")) {
        return Move.SCISSOR;
      } else {
        System.out.println("Invalid Input!");
      }
    }
  }

  private Move getComputerMove() {
    int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
    if (randomNum < 33) {
      return Move.ROCK;
    } else if (randomNum > 66) {
      return Move.PAPER;
    } else {
      return Move.SCISSOR;
    }
  }

  private Result playRound(Move playerMove, Move computerMove) {
    if ((playerMove == Move.ROCK && computerMove == Move.SCISSOR) ||
        (playerMove == Move.PAPER && computerMove == Move.ROCK) ||
        (playerMove == Move.SCISSOR && computerMove == Move.PAPER)) {
      return Result.WIN;
    } else if ((playerMove == Move.ROCK && computerMove == Move.PAPER) ||
        (playerMove == Move.PAPER && computerMove == Move.SCISSOR) ||
        (playerMove == Move.SCISSOR && computerMove == Move.ROCK)) {
      return Result.LOSE;
    } else {
      return Result.TIE;
    }
  }

  private void printResult(Result result, Score score, Move playerMove,
      Move computerMove) {

    switch (result) {
      case WIN:
        score.playerScore++;
        System.out.println("Computer Move: " + computerMove);
        System.out.printf("You Win! %s beats %s%n", playerMove.value,
            computerMove.value);
        System.out.printf("Player: %d | Computer: %d%n", score.playerScore,
            score.computerScore);
        break;
      case LOSE:
        score.computerScore++;
        System.out.println("Computer Move: " + computerMove);
        System.out.printf("You Lose! %s beats %s%n", computerMove.value,
            playerMove.value);
        System.out.printf("Player: %d | Computer: %d%n", score.playerScore,
            score.computerScore);
        break;
      case TIE:
        System.out.println("Computer Move: " + computerMove);
        System.out.printf("It's a Tie!%n");
        System.out.printf("Player: %d | Computer: %d%n", score.playerScore,
            score.computerScore);
        break;
    }
  }

  public void playGame() {
    System.out.println(addColor("ROCK", Color.RED) + " " +
        addColor("PAPER", Color.YELLOW) + " " +
        addColor("SCISSOR", Color.BLUE));
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Turns: ");
    int turns = sc.nextInt();
    Score score = new Score();
    for (int i = 0; i < turns; i++) {
      System.out.println();
      Move playerMove = getPlayerMove(sc);
      Move computerMove = getComputerMove();
      Result result = playRound(playerMove, computerMove);
      printResult(result, score, playerMove, computerMove);
    }
    System.out.println();
    System.out.println("Final Result: ");
    if (score.playerScore > score.computerScore) {
      System.out.print("You Win!");
      System.out.printf("Player: %d | Computer: %d%n", score.playerScore,
          score.computerScore);
    } else if (score.playerScore < score.computerScore) {
      System.out.println("You Lose!");
      System.out.printf("Player: %d | Computer: %d%n", score.playerScore,
          score.computerScore);
    } else {
      System.out.println("It's a Tie!");
      System.out.printf("Player: %d | Computer: %d%n", score.playerScore,
          score.computerScore);
    }
  }
}
