package sample;

abstract class GameLogic {

    private Cell[][] grid;
    private int height = 3;
    private int width = 3;

    GameLogic(int height, int width, double p) {
        this.height = height;
        this.width = width;
        grid = new Cell[height][width];

        for (int h = 0; h < grid.length; h++) {
            for (int w = 0; w < grid[h].length; w++) {
                grid[h][w] = new Cell();
                if (Math.random() <= p) {
                    grid[h][w].setNewState(true);
                    grid[h][w].updateState();
                }
            }
        }
    }

    GameLogic() {

    }

    Cell[][] getGrid() {
        return grid;
    }

    int getSize() {
        return width;
    }

    private int neighbourCount(int row, int col) {
        int sum = 0;
        if (row != 0 && col != 0){          //1
            if(isAlive(row-1,col-1)) {
                sum++;
            }
        }

        if (row != 0){
            if(isAlive(row-1,col)) {   //2
                sum++;
            }
        }

        if (row != 0 && col != width-1) {   //3
            if(isAlive(row-1,col+1)) {
                sum++;
            }
        }

        if (col != 0){
            if(isAlive(row,col-1)) {    //4
                sum++;
            }
        }

        if (col != width-1){
            if(isAlive(row,col+1)) {    //5
                sum++;
            }
        }

        if (row != height-1 && col != 0){
            if(isAlive(row+1,col-1)) { //6
                sum++;
            }
        }

        if (row != height-1){
            if(isAlive(row+1,col)) { //7
                sum++;
            }
        }

        if (row != height-1 && col != width-1) {
            if(isAlive(row+1,col+1)) { //8
                sum++;
            }
        }

        return sum;
    }

    private boolean isAlive(int row, int col) {
        return grid[row][col].getState();
    }

    void update() {
        prepare();
        commit();
    }

    private void prepare() {
        for (int h = 0; h < grid.length; h++) {
            for (int w = 0; w < grid[h].length; w++) {
                int nr = neighbourCount(h,w);
                if (nr < 2) { grid[h][w].setNewState(false);}  //Any live cell with fewer than two neighbours dies, as if caused by underpopulation.
                else if (nr > 3) { grid[h][w].setNewState(false);} //Any live cell with two or three neighbours lives on to the next generation.
                else if (nr == 3) { grid[h][w].setNewState(true);} //Any live cell with more than three live neighbours dies, as if by overpopulation.
                else if (nr == 2) { grid[h][w].setNewState(grid[h][w].getState());} //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
            }
        }
    }

    private void commit() {
        for (Cell[] aGrid : grid) {
            for (Cell anAGrid : aGrid) {
                anAGrid.updateState();
            }
        }
    }

    public abstract void gameBoard(GameLogic board);
}
