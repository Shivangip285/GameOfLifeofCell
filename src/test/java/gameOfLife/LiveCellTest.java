package gameOfLife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LiveCellTest {
    @Test
    public void liveCellIsAlive() throws Exception {
        assertTrue(LiveCell.INSTANCE.isAlive());
    }

    @Test
    public void aLiveCellWithFewerThanTwoLiveNeighboursDies() throws Exception {
        Cell cell = LiveCell.INSTANCE.nextGeneration(1);
        assertFalse(cell.isAlive());
    }

    @Test
    public void aLiveCellWithMoreThanThreeLiveNeighboursDies() throws Exception {
        Cell cell = LiveCell.INSTANCE.nextGeneration(4);
        assertFalse(cell.isAlive());
    }

    @Test
    public void aLiveCellWithTwoOrThreeLiveNeighboursRemainsLive() throws Exception {
        assertTrue(LiveCell.INSTANCE.nextGeneration(2).isAlive());
        assertTrue(LiveCell.INSTANCE.nextGeneration(3).isAlive());
    }
}