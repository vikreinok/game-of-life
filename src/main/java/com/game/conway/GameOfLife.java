package com.game.conway;

/**
 *
 */
public class GameOfLife {

    public void run() {

        Universe universe = new Universe();
        UniverseVisualizer visualizer = new UniverseVisualizer(universe);

        do {
            visualizer.renderGrid();
            universe.tick();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (universe.lifePresent());
    }
}
