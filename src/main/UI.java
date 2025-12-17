package main;


import generator.Generator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI{
    Gamepanel gp;
    Generator gen;

    //Fonts
    Font calibri_40;
    Font calibri_20;
    Font calibri_10;

    // Clicked mouse pos
    public int cursorX;
    public int cursorY;

    public UI(Gamepanel gp, Generator gen) {
        this.gp = gp;
        this.gen = gen;

        calibri_40 = new Font("Calibri", Font.PLAIN, 40);
        calibri_20 = new Font("Calibri", Font.PLAIN, 20);
        calibri_10 = new Font("Calibri", Font.PLAIN, 10);
    }

    public void draw(Graphics2D g2) {
        drawScreen(g2);
        checkAction();
    }
    private void drawScreen(Graphics2D g2) {
        String text;

        //BackGround
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        // score
        text = String.format("%.1f", gen.score);
        this.drawString(g2, text, 400, 150, Color.white, calibri_40);

        // speed
        text = String.format("%.1f", gen.generatorAmount);
        this.drawString(g2, text, 600, 150, Color.white, calibri_20);

        // Generator 1
        this.drawString(g2, "Generator 1", 160, 310, Color.white, calibri_20);

        text = String.valueOf(Integer.valueOf((int) gen.generatorAmount));this.drawString(g2, text, 300, 310, Color.white, calibri_20);
        g2.setColor(Color.GREEN);
        g2.drawRect(900, 300, 100, 20);
        this.drawString(g2, "Upgrade", 920, 310, Color.white, calibri_20);

        // Generator 2
        this.drawString(g2, "Generator 2", 160, 340, Color.white, calibri_20);
        text = String.valueOf(Integer.valueOf((int) gen.generatorAmount2));
        this.drawString(g2, text, 300, 340, Color.white, calibri_20);
        g2.setColor(Color.GREEN);
        g2.drawRect(900, 330, 100, 20);
        this.drawString(g2, "Upgrade", 910, 340, Color.white, calibri_20);

        // version
        String version = "Snapshot 25w01a";
        this.drawString(g2, version,1000, 700, Color.white, calibri_10);
    }

    private void drawString(Graphics2D g2, String text, int x, int y, Color color, Font font) {
        g2.setFont(font);
        g2.setColor(color);
        g2.drawString(text, x, y);
    }

    private void checkAction() {
        if (cursorX >= 900 && cursorX <= 1000 &&
                cursorY >= 300 && cursorY <= 320) {
            gen.generatorAmount++;
            cursorX = -1;
            cursorY = -1;
        }

        if (cursorX >= 900 && cursorX <= 1000 &&
                cursorY >= 330 && cursorY <= 350) {
            gen.generatorAmount2++;
            cursorX = -1;
            cursorY = -1;
        }
    }
}
