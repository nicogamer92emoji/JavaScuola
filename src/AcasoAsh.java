import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AcasoAsh {
    public static class SnakeGame extends JPanel implements ActionListener {
        private final int TILE_SIZE = 20;
        private final int GAME_WIDTH = 400;
        private final int GAME_HEIGHT = 400;
        private final int ALL_TILES = (GAME_WIDTH * GAME_HEIGHT) / (TILE_SIZE * TILE_SIZE);
        private final int DELAY = 150;

        private final int[] x = new int[ALL_TILES];
        private final int[] y = new int[ALL_TILES];

        private int bodyParts = 3;
        private int appleX;
        private int appleY;
        private int score = 0;

        private boolean running = false;
        private char direction = 'R';

        private Timer timer;

        public SnakeGame() {
            setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
            setBackground(Color.BLACK);
            setFocusable(true);
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT -> {
                            if (direction != 'R') direction = 'L';
                        }
                        case KeyEvent.VK_RIGHT -> {
                            if (direction != 'L') direction = 'R';
                        }
                        case KeyEvent.VK_UP -> {
                            if (direction != 'D') direction = 'U';
                        }
                        case KeyEvent.VK_DOWN -> {
                            if (direction != 'U') direction = 'D';
                        }
                    }
                }
            });
            startGame();
        }

        private void startGame() {
            spawnApple();
            running = true;
            timer = new Timer(DELAY, this);
            timer.start();
        }

        private void spawnApple() {
            appleX = (int) (Math.random() * (GAME_WIDTH / TILE_SIZE)) * TILE_SIZE;
            appleY = (int) (Math.random() * (GAME_HEIGHT / TILE_SIZE)) * TILE_SIZE;
        }

        private void move() {
            for (int i = bodyParts; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }

            switch (direction) {
                case 'U' -> y[0] -= TILE_SIZE;
                case 'D' -> y[0] += TILE_SIZE;
                case 'L' -> x[0] -= TILE_SIZE;
                case 'R' -> x[0] += TILE_SIZE;
            }
        }

        private void checkApple() {
            if (x[0] == appleX && y[0] == appleY) {
                bodyParts++;
                score++;
                spawnApple();
            }
        }

        private void checkCollision() {
            for (int i = bodyParts; i > 0; i--) {
                if (x[0] == x[i] && y[0] == y[i]) {
                    running = false;
                }
            }

            if (x[0] < 0 || x[0] >= GAME_WIDTH || y[0] < 0 || y[0] >= GAME_HEIGHT) {
                running = false;
            }

            if (!running) {
                timer.stop();
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (running) {
                move();
                checkApple();
                checkCollision();
            }
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (running) {
                g.setColor(Color.RED);
                g.fillRect(appleX, appleY, TILE_SIZE, TILE_SIZE);

                for (int i = 0; i < bodyParts; i++) {
                    if (i == 0) {
                        g.setColor(Color.GREEN);
                    } else {
                        g.setColor(new Color(45, 180, 0));
                    }
                    g.fillRect(x[i], y[i], TILE_SIZE, TILE_SIZE);
                }

                g.setColor(Color.WHITE);
                g.drawString("Score: " + score, 10, 10);
            } else {
                gameOver(g);
            }
        }

        private void gameOver(Graphics g) {
            String message = "Game Over";
            String scoreMessage = "Score: " + score;

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            FontMetrics metrics = getFontMetrics(g.getFont());

            g.drawString(message, (GAME_WIDTH - metrics.stringWidth(message)) / 2, GAME_HEIGHT / 2 - 20);
            g.drawString(scoreMessage, (GAME_WIDTH - metrics.stringWidth(scoreMessage)) / 2, GAME_HEIGHT / 2 + 20);
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("Snake Game");
            AcasoAsh.SnakeGame game = new AcasoAsh.SnakeGame();

            frame.add(game);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        public int getWIDTH() {
            return WIDTH;
        }

        public int getHEIGHT() {
            return HEIGHT;
        }
    }
}
