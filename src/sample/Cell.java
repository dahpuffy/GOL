package sample;

public class Cell {

    private boolean state = false;
    private boolean newState;

    public Cell() {

    }

    public Cell(boolean state) {
        this.state = state;
    }

    void setNewState(boolean state) {
        newState = state;
    }

    void updateState() {
        state = newState;
    }

    boolean getState() {
        return state;
    }
}
