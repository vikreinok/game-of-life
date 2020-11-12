package com.game.conway.rule;

import com.game.conway.Cell;
import com.game.conway.Universe;

/**
 * Any live cell with fewer than two live neighbours dies, as if by underpopulation.
 */
public class FirstRule implements Rule {

    @Override
    public Outcome process(Universe universe, Cell cell) {
        if (universe.getNeighbors(cell).size() < 2) {
           return Outcome.DIE;
        }
        return null;
    }
}
