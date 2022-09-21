package tictactoe;

import java.io.Serializable;

/**
 *
 * @author Andualem Teshome
 */
public class GameBoard implements Serializable {

  private final GameTile[][] board;
  private char player = 'O';
  private int moves = 0;
  private boolean gameOver = false;
  private String message;
  private final GameStats stats;

  public GameBoard() {
    board = new GameTile[][]{
      {new GameTile(0, 0), new GameTile(0, 1), new GameTile(0, 2)},
      {new GameTile(1, 0), new GameTile(1, 1), new GameTile(1, 2)},
      {new GameTile(2, 0), new GameTile(2, 1), new GameTile(2, 2)},};
    stats = new GameStats();
    message = "Player " + player + "\'s turn.";
  }

  public boolean move(int r, int c) {

    message = "";

    if (gameOver) {
      message = "Game is over. Ckick New Game button.";
      return false;
    }

    if (board[r][c].getMarker() != ' ') {
      message = "Tile is already taken! Try again.";
      return false;
    }

    board[r][c].setMarker(player);
    moves++;

    if (moves == 9) {
      message = "It's a tie!";
      stats.incTie();
      gameOver = true;
      return true;
    }

    if (isWinning()) {
      message = "Player " + player + " wins!";
      if (player == 'X') {
        stats.incXWins();
      }
      if (player == 'O') {
        stats.incOwins();
      }
      gameOver = true;
      return true;
    }

    rotatePlayer();
    message = "Player " + player + "\'s turn.";
    return true;
  }

  public GameTile[][] getBoard() {
    return board;
  }

  public GameStats getSats() {
    return stats;
  }

  public String getMessage() {
    return message;
  }

  private char rotatePlayer() {
    return player = player == 'O' ? 'X' : 'O';
  }

  private boolean isWinning() {

    for (int i = 0; i < 3; i++) {
      if (checkWinningRow(i)) {
        for (int j = 0; j < 3; j++) {
          board[i][j].setWinning(true);
        }
        return true;
      }
    }

    for (int i = 0; i < 3; i++) {
      if (checkWinningCol(i)) {
        for (int j = 0; j < 3; j++) {
          board[j][i].setWinning(true);
        }
        return true;
      }
    }

    if (board[0][0].getMarker() != ' '
            && board[0][0].getMarker() == board[1][1].getMarker()
            && board[1][1].getMarker() == board[2][2].getMarker()) {
      board[0][0].setWinning(true);
      board[1][1].setWinning(true);
      board[2][2].setWinning(true);
      return true;
    }

    if (board[2][0].getMarker() != ' '
            && board[2][0].getMarker() == board[1][1].getMarker()
            && board[1][1].getMarker() == board[0][2].getMarker()) {
      board[2][0].setWinning(true);
      board[1][1].setWinning(true);
      board[0][2].setWinning(true);
      return true;
    }

    return false;
  }

  private boolean checkWinningRow(int r) {
    return board[r][0].getMarker() != ' '
            && board[r][0].getMarker() == board[r][1].getMarker()
            && board[r][1].getMarker() == board[r][2].getMarker();
  }

  private boolean checkWinningCol(int c) {
    return board[0][c].getMarker() != ' '
            && board[0][c].getMarker() == board[1][c].getMarker()
            && board[1][c].getMarker() == board[2][c].getMarker();
  }

  public void reset() {
    gameOver = false;
    message = "Player " + player + "\'s turn.";
    moves = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j].setMarker(' ');
        board[i][j].setWinning(false);
      }
    }
  }
}
