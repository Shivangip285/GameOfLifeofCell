package gameOfLife;

public interface Cell {
    boolean isAlive();

    Cell nextGeneration(int liveNeighbours);
}