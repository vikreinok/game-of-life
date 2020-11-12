package com.game.conway;

import com.game.conway.rule.FirstRule;
import com.game.conway.rule.FourthRule;
import com.game.conway.rule.Rule;
import com.game.conway.rule.SecondRule;
import com.game.conway.rule.ThirdRule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Universe {
    List<Cell> aliveCells = new ArrayList();
    List<Rule> rules = new ArrayList();

    public Universe() {
        aliveCells.addAll(LiveBuilder.buildLife());
        rules.add(new FirstRule());
        rules.add(new SecondRule());
        rules.add(new ThirdRule());
        rules.add(new FourthRule());
    }

    public void tick() {
        List<Cell> deadCells = new ArrayList<>();
        List<Cell> newBornCells = new ArrayList<>();
        for (Iterator<Cell> iterator = aliveCells.iterator(); iterator.hasNext(); ) {
            Cell aliveCell = iterator.next();

            for (Rule rule : rules) {
                Rule.Outcome outcome = rule.process(this, aliveCell);
                if (outcome == Rule.Outcome.DIE) {
                    deadCells.add(aliveCell);
                    break;
                } else if(outcome == Rule.Outcome.REPRODUCE) {
                    newBornCells.add(this.getFirstNearByFreeCell(aliveCell));
                }
            }
        }

        deadCells.forEach(deadCell -> aliveCells.remove(deadCell));
        newBornCells.forEach(newBornCell -> aliveCells.add(newBornCell));
    }


    public List<Cell> getNeighbors(Cell cell) {

        List<Cell> matchingCells = getSurroundingCells(cell).stream()
                .filter(c -> this.getAliveCells().contains(c))
                .collect(Collectors.toList());


        return matchingCells;
    }

    public Cell getFirstNearByFreeCell(Cell cell) {
        Cell newCell = getSurroundingCells(cell).stream()
                .filter(c -> !this.getAliveCells().contains(c))
                .findFirst().get();

        return newCell;
    }

    private List<Cell> getSurroundingCells(Cell cell) {
        List<Cell> surroundingCells = new ArrayList<>();
        surroundingCells.add(new Cell(cell.x + 1, cell.y));
        surroundingCells.add(new Cell(cell.x - 1, cell.y));
        surroundingCells.add(new Cell(cell.x + 1, cell.y + 1));
        surroundingCells.add(new Cell(cell.x - 1, cell.y + 1));
        surroundingCells.add(new Cell(cell.x + 1, cell.y - 1));
        surroundingCells.add(new Cell(cell.x - 1, cell.y - 1));
        surroundingCells.add(new Cell(cell.x, cell.y - 1));
        surroundingCells.add(new Cell(cell.x, cell.y - 1));
        return surroundingCells;
    }


    List<Cell> getAliveCells() {
        return aliveCells;
    }

    public boolean lifePresent() {
        return !aliveCells.isEmpty();
    }
}
