package com.pdemuinck;

public class Game {

  private boolean[][] roster;
  private final int rows;
  private final int cols;
  private final int mid;

  public Game(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.mid = cols / 2;
    this.roster = new boolean[rows][cols];
  }

  public void onEvent(Event event){
    if(Event.DOWN == event){

    }
  }

  public void start(int walkPaceMs) {
    while (true) {
      if (roster[rows-1][mid] && roster[rows - 1][mid + 1]) {
        System.out.println("GAME OVER");
        break;
      }
      int r = rows - 1;
      int c = mid;
      roster[r][c] = true;
      roster[r][c + 1] = true;
      roster[r - 1][c] = true;
      roster[r - 1][c + 1] = true;
      while(r-1 > 0 && !roster[r - 2][c]){
        try {
          Thread.sleep(walkPaceMs);
        } catch (InterruptedException e) {
          System.out.println("Thread interrupted!!!");
        }

        roster[r][c] = false;
        roster[r][c + 1] = false;
        roster[r - 1][c] = false;
        roster[r - 1][c + 1] = false;

        r -= 1;
        roster[r][c] = true;
        roster[r][c + 1] = true;
        roster[r - 1][c] = true;
        roster[r - 1][c + 1] = true;
      }
    }
  }

  public boolean[][] getRoster() {
    return roster;
  }

  public int getRows() {
    return rows;
  }

  public int getCols() {
    return cols;
  }
}
