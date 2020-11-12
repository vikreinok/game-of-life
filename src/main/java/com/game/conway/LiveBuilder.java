package com.game.conway;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class LiveBuilder {
    public static Collection<? extends Cell> buildLife() {
        List<Cell> cells = buildGlider();
        return cells;
    }

    private static List<Cell> buildGlider() {
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(0, 0));
        cells.add(new Cell(0, 1));
        cells.add(new Cell(0, 2));
        cells.add(new Cell(1, 2));
        cells.add(new Cell(2, 1));
        return cells;
    }
}
