package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.FlowPane;
import javafx.util.Duration;

public class Controller implements Initializable {

    private final int    DEFAULT_SIZE = 30;

    public FlowPane base;
    public Label countLabel;
    public Slider countSlider;
    public Button runButton, stopButton, randomizeButton, clearButton;

    private GameLogic board;

    private GameBoard display;

    private Timeline loop = null;

    private int cellSize;

    {
        cellSize = 15;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        double DEFAULT_PROB = 0.3;
        createBoard(DEFAULT_SIZE, DEFAULT_PROB);


    }

    public void onRun() {
        toggleButtons(false);

        loop = new Timeline(new KeyFrame(Duration.millis(300), e -> {
            board.update();
            display.gameBoard(board);
        }));

        loop.setCycleCount(100);
        loop.play();
    }

    public void onStop() {
        toggleButtons(true);
        loop.stop();
    }

    public void onClear() {
        createBoard(DEFAULT_SIZE, 0);
    }

    public void onRandomize() {
        createBoard(DEFAULT_SIZE, countSlider.getValue() /100);
    }

    public void onSlide() {
        countSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            countLabel.setText(newValue.intValue()+"%");
            createBoard(DEFAULT_SIZE, (double) newValue.intValue()/100);
        });
    }

    private void toggleButtons(boolean enable) {
        countSlider.setDisable(!enable);
        runButton.setDisable(!enable);
        clearButton.setDisable(!enable);
        randomizeButton.setDisable(!enable);

        stopButton.setDisable(enable);
    }

    private void createBoard(int size, double p) {
        board = new GameLogic(size, size, p) {
            @Override
            public void gameBoard(GameLogic board) {

            }
        };
        createDisplay();
    }

    private void createDisplay() {
        display = new GameBoard(board.getSize(), cellSize, board);

        base.getChildren().clear();
        base.getChildren().add(new Group(display.getPane()));
    }



}
