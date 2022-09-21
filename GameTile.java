package tictactoe;

import java.io.Serializable;

public class GameTile implements Serializable {

  private char marker = ' ';
  private boolean winning;
  private int row;
  private int col;

  public GameTile() {
  }

  public GameTile(int row, int col) {
    this.row = row;
    this.col = col;
    this.marker = ' ';
  }

  public char getMarker() {
    return marker;
  }

  public void setMarker(char marker) {
    this.marker = marker;
  }

  public boolean isWinning() {
    return winning;
  }

  public void setWinning(boolean winning) {
    this.winning = winning;
  }

  @Override
  public String toString() {
    return "" + getMarker();
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getCol() {
    return col;
  }

  public void setCol(int col) {
    this.col = col;
  }

}
