package sample;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Atika on 22.02.2017.
 */
public class GameBoard {

    private byte[][] board;
    private int columnsize;
    private int rowsize;
    private GraphicsContext gc;
    private Canvas canvas;

    public GameBoard(int columnsize, int rowsize, GraphicsContext gc,Canvas canvas){

        this.columnsize=columnsize;
        this.rowsize=rowsize;
        this.gc=gc;
        this.canvas=canvas;
        gc.setFill(Color.WHITE);
        gc.fillRect(30, 30, 100, 100);

    }

    public static class draw extends JPanel {

        public  draw(){


            setSize(960,960);
            setVisible(true);

        }

        public void paint(Graphics g){
            g.setColor(java.awt.Color.green);
            g.drawRect(480, 480, 200, 200);
            g.setColor(java.awt.Color.green);
            g.fillRect(240, 240, 200, 100);
        }
    public static void main(String[] args)
    {
            draw d =new draw();
            d.paint(null);
    }
    }
}
