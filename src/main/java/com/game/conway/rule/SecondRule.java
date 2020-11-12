package com.game.conway.rule;

import com.game.conway.Cell;
import com.game.conway.Universe;

/**
 * Any live cell with two or three live neighbours lives on to the next generation.
 */
public class SecondRule implements Rule {

    @Override
    public Outcome process(Universe universe, Cell cell) {
        if (universe.getNeighbors(cell).size() == 2 || universe.getNeighbors(cell).size() == 3) {
           return Outcome.LIVE;
        }
        return null;
    }
}
