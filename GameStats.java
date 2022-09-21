package tictactoe;

import java.io.Serializable;

/**
 *
 * @author Andualem Teshome
 */
public class GameStats implements Serializable {

  private int xwins = 0;
  private int owins = 0;
  private int tie = 0;

  public GameStats() {
  }

  public int getXwins() {
    return xwins;
  }

  public void incXWins() {
    xwins++;
  }

  public void setXwins(int xwins) {
    this.xwins = xwins;
  }

  public int getOwins() {
    return owins;
  }

  public void incOwins() {
    owins++;
  }

  public void setOwins(int owins) {
    this.owins = owins;
  }

  public int getTie() {
    return tie;
  }

  public void incTie() {
    tie++;
  }

  public void setTie(int tie) {
    this.tie = tie;
  }

}
