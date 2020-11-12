package com.game.conway.rule;

import com.game.conway.Cell;
import com.game.conway.Universe;

/**
 * Any live cell with fewer than two live neighbours dies, as if by underpopulation.
 * Any live cell with two or three live neighbours lives on to the next generation.
 * Any live cell with more than three live neighbours dies, as if by overpopulation.
 * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 *
 */
public interface Rule {

     enum Outcome {
        LIVE,
        DIE,
        REPRODUCE,
    }

    Outcome process(Universe universe, Cell cell);
}
