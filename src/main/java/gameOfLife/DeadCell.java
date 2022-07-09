package gameOfLife;

import static gameOfLife.CellState.Dead;

public class DeadCell implements Cell {
    public static final Cell INSTANCE = new DeadCell();

    private DeadCell() {
    }

    public boolean isAlive() {
        CellState cellState=CellState.valueOf(String.valueOf(Dead));
        return cellState.valueOf(Dead);
    }

    public Cell nextGeneration(int liveNeighbours) {
        if (liveNeighbours == 3) {
            return LiveCell.INSTANCE;
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        DeadCell cell = (DeadCell) obj;
        return isAlive() == cell.isAlive();
    }
}

