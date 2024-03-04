package com.pdemuinck;

import java.util.Scanner;

public class Tris {

  private static final String CLEAR_SCREEN = "\u001b[2J";
  private static final String GOTO_COORD = "\u001b[%d;%dH";
  private static final String HOME = "\u001b[H";
  private static final String HIDE_CURSOR = "\u001b[?25l";
  private static final String SHOW_CURSOR = "\u001b[?25h";

  public static void main(String... args) throws InterruptedException {
    Game game = new Game(15, 8);
    Thread.sleep(4000);
    System.out.println(CLEAR_SCREEN);
    System.out.print(HOME);
    System.out.print(HIDE_CURSOR);
    game.printGrid();
    Thread.sleep(2000);
    while(game.getStatus() != 0){
      game.startWithShape();
      game.printGridUpdate();
      game.goLeft();
      game.printGridUpdate();
      game.dropShape(500);
    }
    System.out.println(CLEAR_SCREEN);
    System.out.print(HOME);
    game.printGrid();
    System.out.print(SHOW_CURSOR);
  }
}
