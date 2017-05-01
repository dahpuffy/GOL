package sample;

import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameBoard extends GameLogic {
    private int bs;
    private TilePane tp = new TilePane(3,3);

    GameBoard(int boardSize, int cellSize, GameLogic board) {
        super();
        bs = boardSize;
        tp.setPrefRows(boardSize);
        tp.setPrefColumns(boardSize);

        Cell[][] g = board.getGrid();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Color c = g[i][j].getState() ? Color.DARKGRAY : Color.WHITE;
                Rectangle r = new Rectangle(cellSize, cellSize, c);
                tp.getChildren().add(r);

                attachListeners(r, g[i][j]);
            }
        }
    }

    @Override
    public void displayBoard(GameLogic board) {
        Cell[][] g = board.getGrid();
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                Rectangle r = (Rectangle) tp.getChildren().get(boardToPaneLoc(i, j));
                r.setFill(g[i][j].getState() ? Color.DARKGRAY : Color.WHITE);
            }
        }
    }

    TilePane getPane() {
        return tp;
    }

    private int boardToPaneLoc(int i, int j) {
        return i * bs + j;
    }

    private void attachListeners(Rectangle r, Cell c) {
        r.setOnMousePressed(e -> r.setFill(Color.GRAY));

        r.setOnMouseClicked(e -> {
            r.setFill(c.getState() ? Color.WHITE : Color.DARKGRAY);
            c.setNewState(!c.getState());
            c.updateState();
        });
    }
}