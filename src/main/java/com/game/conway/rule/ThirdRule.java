package com.game.conway.rule;

import com.game.conway.Cell;
import com.game.conway.Universe;

/**
 * Any live cell with more than three live neighbours dies, as if by overpopulation.
 */
public class ThirdRule implements Rule {

    @Override
    public Outcome process(Universe universe, Cell cell) {
        if (universe.getNeighbors(cell).size() > 3 ) {
           return Outcome.DIE;
        }
        return null;
    }
}
