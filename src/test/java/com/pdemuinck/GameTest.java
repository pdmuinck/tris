package com.pdemuinck;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GameTest {

  @Test
  public void all_roster_values_are_false_by_default(){
    int rows = 4;
    int cols = 4;
    Game game = new Game(4, 4);
    assertThat(game.getGrid()).hasNumberOfRows(4);
    for(int r = 0; r < rows; r++){
      for(int j = 0; j < cols; j++){
        assertThat(game.getGrid()[r][j]).isFalse();
      }
    }
  }

  @Test
  public void without_user_input_shapes_will_stack_until_upper_bound(){
    int rows = 15;
    int cols = 6;
    Game game = new Game(rows, cols);
    while(game.getStatus() > 0){
      game.startWithShape();
      game.dropShape(1);
    }
    for(int r = 0 ; r < rows; r++){
      assertThat(game.getGrid()[r]).contains(true);
    }
  }

  @Test
  public void shape_walks_one_row_at_the_time(){


  }
}
