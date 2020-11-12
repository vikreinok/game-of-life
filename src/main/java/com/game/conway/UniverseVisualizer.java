package com.game.conway;

import java.util.List;

/**
 *
 */
public class UniverseVisualizer {
    private Universe universe;

    public UniverseVisualizer(Universe universe) {
        this.universe = universe;
    }

    public void renderGrid() {
        clearSdOut();
        List<Cell> aliveCells = universe.getAliveCells();

        for (int x = -5; x < 5; x++) {
            for (int y = -5; y < 5; y++) {
                String renderedValue = "□";
                if (isMatch(aliveCells, x, y)) {
                    renderedValue = "■";
                }
                System.err.print(renderedValue);
            }
            System.err.println();
        }
    }

    private void clearSdOut() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isMatch(List<Cell> aliveCells, int x, int y) {
        return aliveCells.stream().filter(cell -> cell.x == x && cell.y == y).findFirst().isPresent();
    }


}

