package gameOfLife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

    public class DeadCellTest {
        @Test
        public void deadCellIsNotAlive() throws Exception {
            assertFalse(DeadCell.INSTANCE.isAlive());
        }

        @Test
        public void aDeadCellWithThreeLiveNeighboursBecomesAlive() throws Exception {
            Cell cell = DeadCell.INSTANCE.nextGeneration(3);
            assertTrue(cell.isAlive());
        }

        @Test
        public void aDeadCellRemainsDead() throws Exception {
            assertFalse(DeadCell.INSTANCE.nextGeneration(0).isAlive());
            assertFalse(DeadCell.INSTANCE.nextGeneration(2).isAlive());
            assertFalse(DeadCell.INSTANCE.nextGeneration(4).isAlive());
        }
    }