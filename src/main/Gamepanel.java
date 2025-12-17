package main;

import generator.Generator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Gamepanel extends JPanel implements Runnable{

    public final int screenWidth = 1280;
    public final int screenHeight = 720;

    Thread gameThread;
    public Generator generator = new Generator(this);
    public UI ui = new UI(this, generator);
    MouseHandler moH = new MouseHandler(this, ui);

    //game state
    public int gamestate;
    public final int PlayState = 1;

    //FPS
    public final int ticksPerSecond = 30; // 30 ticks per second

    public Gamepanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addMouseListener(moH);
    }

    public void setupGame() {
        gamestate = PlayState;
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    //Displaying FPS
    long timer = 0;
    int drawcount = 0;
    public int currentFPS;

    @Override
    public void run() {

        double delta = 0;
        long currentTime;
        long lastTime = System.nanoTime();

        while (gameThread != null) {
            double drawInterval = (double) 1000000000 / ticksPerSecond;

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawcount++;
            }

            if(timer >= 1000000000) {
                timer = 0;
                currentFPS = drawcount;
                drawcount = 0;
            }
        }
    }

    public void update() {
        generator.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        ui.draw(g2);

    }
}

