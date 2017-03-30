package sample;

import javafx.application.Application;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.SwingUtilities;

public class GameOfLife {

  /*  final int W = 200, H = 100;
    boolean[][] currentMove = new boolean[H][W], nextMove = new boolean[H][W];
    boolean play;
    private Image offScrImg;
    Graphics offScrGraph;


    public GameOfLife() {
        initComponents();
        offScrImg = createImage(jPanel1.getHeight(), jPanel1.getWidth());
        offScrGraph = offScrImg.getGraphics();
        Timer time = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                if (!play) {
                    return;
                }
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        nextMove[i][j] = decide(i, j);
                    }
                }

                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        currentMove[i][j] = nextMove(i, j);
                    }
                }
                repain();
            }

            private boolean nextMove(int i, int j) {
                return false;
            }
        };
        time.scheduleAtFixedRate(task, 0, 100);
        repain();
    }

    private boolean decide(int i, int j) {
        int neighbours = 0;
        if (j <= 0) {
        } else {
            if (!currentMove[i][j - 1]) {
            } else {
                neighbours++;
            }
            if (i <= 0 || !currentMove[i - 1][j - 1]) {
            } else {
                neighbours++;
            }
            if (i >= H - 1 || !currentMove[i + 1][j - 1]) {
            } else {
                neighbours++;
            }
        }

        if (j >= W - 1) {
        } else {
            if (!currentMove[i][j + 1]) {
            } else {
                neighbours++;
            }
            if (i <= 0 || !currentMove[i - 1][j + 1]) {
            } else {
                neighbours++;
            }
            if (i >= H - 1 || !currentMove[i + 1][j + 1]) {
            } else {
                neighbours++;
            }
        }

        if (i > 0 && currentMove[i - 1][j]) {
            neighbours++;
        }
        if (i < H - 1 && currentMove[i + 1][j]) {
            neighbours++;
            return neighbours == 3 || currentMove[i][j] && neighbours == 2;
        } else {
            return neighbours == 3 || currentMove[i][j] && neighbours == 2;
        }
    }

    private void repain() {
        offScrGraph.setColor(Color.gray);
        offScrGraph.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (currentMove[i][j]) {
                    offScrGraph.setColor(Color.black);
                    int y = i * jPanel1.getHeight() / H;
                    int x = j * jPanel1.getWidth() / W;

                    offScrGraph.fillRect(x, y, jPanel1.getWidth(), jPanel1.getHeight());
                }
            }
        }

        for (int i = 1; i < H; i++) {
            int y = i * jPanel1.getHeight() / H;
            offScrGraph.drawLine(0, y, jPanel1.getWidth(), y);
        }
        for (int j = 1; j < W; j++) {
            int x = j * jPanel1.getWidth() / W;
            offScrGraph.drawLine(x, 0, x, jPanel1.getHeight());
        }

        jPanel1.getGraphics().drawImage(offScrImg, 0, 0, jPanel1);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 293, Short.MAX_VALUE)
        );

        jButton1.setText("Play");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap())
        );

        pack();
    }

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {
        offScrImg = createImage(jPanel1.getWidth(), jPanel1.getHeight());
        offScrGraph = offScrImg.getGraphics();
        repain();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        play = !play;
        jButton1.setText(play ? "Stop" : "Play");
        repain();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        currentMove = new boolean[H][W];
        repain();
    }

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {
        int j = W * evt.getX() / jPanel1.getWidth();
        int i = H * evt.getY() / jPanel1.getHeight();
        currentMove[i][j] = SwingUtilities.isLeftMouseButton(evt);
        repain();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new GameOfLife().setVisible(true));
    }

    private javax.swing.JButton jButton1 = new javax.swing.JButton();
    private javax.swing.JButton jButton2 = new javax.swing.JButton();
    private javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
    */
}