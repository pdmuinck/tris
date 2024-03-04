package com.pdemuinck;

public class Game {

  private static final String GOTO_COORD = "\u001b[%d;%dH";

  private boolean[][] grid;
  private final int rows;
  private final int cols;
  private final int mid;
  private int status;
  private int currentC;
  private int currentR;

  public Game(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.mid = cols / 2;
    this.grid = new boolean[rows][cols];
    this.status = 1;
    this.currentC = mid;
    this.currentR = this.rows - 1;
  }

  public void onEvent(Event event) {
    if (Event.DOWN == event) {

    }
  }

  public void goLeft(){
    this.currentC--;
  }

  public void startWithShape(){
    if (grid[rows - 1][mid] && grid[rows - 1][mid + 1]) {
      this.status = 0;
    }
    int r = rows - 1;
    int c = mid;
    this.currentC = mid;
    this.currentR = rows - 1;
    grid[r][c] = true;
    grid[r][c + 1] = true;
    grid[r - 1][c] = true;
    grid[r - 1][c + 1] = true;
  }

  public void dropShape(int walkPaceMs) {
    int r = this.currentR;
    int c = this.currentC;
    while (r - 1 > 0 && !grid[r - 2][c]) {
      try {
        Thread.sleep(walkPaceMs);
      } catch (InterruptedException e) {
        System.out.println("Thread interrupted!!!");
      }

      grid[r][c] = false;
      grid[r][c + 1] = false;
      grid[r - 1][c] = false;
      grid[r - 1][c + 1] = false;

      r -= 1;
      grid[r][c] = true;
      grid[r][c + 1] = true;
      grid[r - 1][c] = true;
      grid[r - 1][c + 1] = true;
      printGridUpdate();
    }
  }

  public boolean[][] getGrid() {
    return grid;
  }

  public int getRows() {
    return rows;
  }

  public int getCols() {
    return cols;
  }

  public int getStatus() {
    return status;
  }

  public void printGrid(){
    StringBuilder sb = new StringBuilder();
    int r = this.rows - 1;
    for( ; r >= 0; r--){
      sb.append("\u2502");
      for(int c = 0; c < this.cols; c++){
        if(this.grid[r][c]){
          sb.append("\u25A0");
        } else {
          sb.append(" ");
        }
      }
      sb.append("\u2502");
      sb.append("\n");
    }
    System.out.print(sb);
  }

  public void printGridUpdate(){
    for(int r = 0; r < this.rows - 1; r++){
      for(int c = 0; c < this.cols; c++){
        if(grid[r][c]){
          System.out.print(String.format(GOTO_COORD, this.rows - r, c + 2));
          System.out.print("\u25A0");

        } else {
          System.out.print(String.format(GOTO_COORD, this.rows - r, c + 2));
          System.out.print(" ");
        }
      }
    }
  }
}
