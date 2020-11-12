package com.game.conway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
class UniverseTest {

    @Test
    public void thereIsUniverse() {
        Universe universe = new Universe();
    }

    @Test
    public void thereIsAtLeastOneCellInTheUniverse() {
        Universe universe = new Universe();
        assertEquals(true, universe.getAliveCells().size() > 0);
    }

    @Test
    public void getNeighbors() {
        Universe universe = new Universe();
        Cell cell = new Cell(0, 1);

        assertEquals(true, universe.getNeighbors(cell).size() > 0);
    }

    @Test
    public void getNeighbors_notSameCell() {
        Universe universe = new Universe();
        Cell cell = new Cell(22, 12);

        assertEquals(true, universe.getNeighbors(cell).isEmpty());
    }

    @Test
    public void getNeighbors_neighborCell() {
        Universe universe = new Universe();
        Cell cell = new Cell(0, 1);
        Cell neighborCell = new Cell(0, 0);

        assertEquals(true, universe.getNeighbors(cell).contains(neighborCell));
    }

    @Test
    public void getNeighbors_neighborCellDistance2_false() {
        Universe universe = new Universe();
        Cell cell = new Cell(-1, 1);

        assertEquals(false, universe.getNeighbors(cell).contains(new Cell(1, 1)));
    }

}