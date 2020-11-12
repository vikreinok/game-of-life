package com.game.conway.rule;

import com.game.conway.Cell;
import com.game.conway.Universe;

/**
 * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 */
public class FourthRule implements Rule {

    @Override
    public Outcome process(Universe universe, Cell cell) {
        if (universe.getNeighbors(cell).size() == 3 ) {
           return Outcome.REPRODUCE;
        }
        return null;
    }
}
