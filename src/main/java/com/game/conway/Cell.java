package com.game.conway;

import java.util.Objects;
import java.util.StringJoiner;

public class Cell {
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Cell cell = (Cell) o;
            return this.x == cell.x && this.y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Cell.class.getSimpleName() + "[", "]")
                    .add("x=" + x)
                    .add("y=" + y)
                    .toString();
        }
    }