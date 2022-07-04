package gameOfLife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {
    @Test
    public void initializeGridWithSize() throws Exception {
        Grid grid = aGrid(12);
        assertEquals(grid.size(), 12);
    }

    @Test
    public void populateGridWithLiveAndDeadCells() throws Exception {
        Grid grid = aGrid(10);
        grid.put(LiveCell.INSTANCE, 0, 0);
        grid.put(LiveCell.INSTANCE, 0, 1);
        grid.put(LiveCell.INSTANCE, 0, 2);
        grid.put(DeadCell.INSTANCE, 0, 3);
        assertEquals(grid.liveCellsSize(), 3);
    }

    @Test
    public void evaluateGridWithDeadCells() throws Exception {
        Grid grid = aGrid(3);
        Grid newGrid = grid.nextGeneration();
        Grid expectedGrid = aGrid(3);
        assertEquals(newGrid, expectedGrid);
    }

    @Test
    public void evaluateGridWithOneLiveCells() throws Exception {
        Grid grid = aGrid(3);
        grid.put(LiveCell.INSTANCE, 0, 0);
        Grid newGrid = grid.nextGeneration();
        Grid expectedGrid = aGrid(3);
        assertEquals(expectedGrid, newGrid);
    }

    @Test
    public void evaluateBlockGrid() throws Exception {
        Grid grid = aGrid(10);
        grid.put(LiveCell.INSTANCE, 1, 1);
        grid.put(LiveCell.INSTANCE, 1, 2);
        grid.put(LiveCell.INSTANCE, 2, 1);
        grid.put(LiveCell.INSTANCE, 2, 2);

        Grid newGrid = grid.nextGeneration();
        Grid expectedGrid = aGrid(10);
        expectedGrid.put(LiveCell.INSTANCE, 1, 1);
        expectedGrid.put(LiveCell.INSTANCE, 1, 2);
        expectedGrid.put(LiveCell.INSTANCE, 2, 1);
        expectedGrid.put(LiveCell.INSTANCE, 2, 2);
        assertEquals(expectedGrid, newGrid);

        Grid startingPosition = newGrid.nextGeneration();
        assertEquals(grid, startingPosition);
    }
    @Test
    public void evaluateBoatGrid() throws Exception {
        Grid grid = aGrid(10);
        grid.put(LiveCell.INSTANCE, 0, 1);
        grid.put(LiveCell.INSTANCE, 1, 0);
        grid.put(LiveCell.INSTANCE, 2, 1);
        grid.put(LiveCell.INSTANCE, 0, 2);
        grid.put(LiveCell.INSTANCE, 1, 2);

        Grid newGrid = grid.nextGeneration();
        Grid expectedGrid = aGrid(10);
        expectedGrid.put(LiveCell.INSTANCE, 0, 1);
        expectedGrid.put(LiveCell.INSTANCE, 1, 0);
        expectedGrid.put(LiveCell.INSTANCE, 2, 1);
        expectedGrid.put(LiveCell.INSTANCE, 0, 2);
        expectedGrid.put(LiveCell.INSTANCE, 1, 2);
        assertEquals(expectedGrid, newGrid);

        Grid startingPosition = newGrid.nextGeneration();
        assertEquals(grid, startingPosition);
    }
    @Test
    public void evaluateBlinkerGrid() throws Exception {
        Grid grid = aGrid(10);
        grid.put(LiveCell.INSTANCE, 1, 1);
        grid.put(LiveCell.INSTANCE, 1, 0);
        grid.put(LiveCell.INSTANCE, 1, 2);

        Grid newGrid = grid.nextGeneration();
        Grid expectedGrid = aGrid(10);
        expectedGrid.put(LiveCell.INSTANCE, 1, 1);
        expectedGrid.put(LiveCell.INSTANCE, 0, 1);
        expectedGrid.put(LiveCell.INSTANCE, 2, 1);
        assertEquals(expectedGrid, newGrid);

        Grid startingPosition = newGrid.nextGeneration();
        assertEquals(grid, startingPosition);
    }
    @Test
    public void evaluateToadGrid() throws Exception {
        Grid grid = aGrid(12);
        grid.put(LiveCell.INSTANCE, 1, 1);
        grid.put(LiveCell.INSTANCE, 1, 2);
        grid.put(LiveCell.INSTANCE, 1, 3);
        grid.put(LiveCell.INSTANCE, 2, 2);
        grid.put(LiveCell.INSTANCE, 2, 3);
        grid.put(LiveCell.INSTANCE, 2, 4);

        Grid newGrid = grid.nextGeneration();
        Grid expectedGrid = aGrid(12);
        expectedGrid.put(LiveCell.INSTANCE, 0, 2);
        expectedGrid.put(LiveCell.INSTANCE, 1, 1);
        expectedGrid.put(LiveCell.INSTANCE, 1, 4);
        expectedGrid.put(LiveCell.INSTANCE, 2, 1);
        expectedGrid.put(LiveCell.INSTANCE, 3, 3);
        expectedGrid.put(LiveCell.INSTANCE, 2, 4);
        assertEquals(expectedGrid, newGrid);

        Grid startingPosition = newGrid.nextGeneration();
        assertEquals(grid, startingPosition);

    }


    private Grid aGrid(int size) {
        return new Grid(size);
    }
}