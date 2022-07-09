package gameOfLife;

public enum CellState {
    Alive(true),
    Dead(false);


    private final boolean status;

    CellState(boolean status) {
        this.status=status;
    }


    public boolean valueOf(CellState alive) {
        return status;
    }
}
