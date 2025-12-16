package main;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI{
    Gamepanel gp;
    Graphics2D g2;

    //Fonts
    Font gothic_40;
    Font gothic_20;
    Font serif_bold_70;
    Font serif_bold_50;
    Font serif_bold_30;
    Font serif_bold_20;
    Font serif_15;
    Font serif_20;

    public UI(Gamepanel gp) {
        this.gp = gp;

        gothic_40 = new Font("MS Pゴシック",Font.PLAIN, 40);
        gothic_20 = new Font("MS Pゴシック",Font.PLAIN, 20);
        serif_bold_70 = new Font("Serif", Font.BOLD, 70);
        serif_bold_50 = new Font("Serif", Font.BOLD, 50);
        serif_bold_30 = new Font("Serif", Font.BOLD, 30);
        serif_bold_20 = new Font("Serif", Font.BOLD, 20);
        serif_15 = new Font("Serif", Font.PLAIN, 15);
        serif_20 = new Font("Serif", Font.PLAIN, 20);

    }

    public void draw(Graphics2D g2) {
        String version = "Snapshot 23w02a";

        //Play state
        if (gp.gamestate == gp.PlayState) {
            drawScreen(g2);
        }
    }
    private void drawScreen(Graphics2D g2) {
        //BackGround
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        //score
        g2.setFont(serif_bold_50);
        String text = String.valueOf(gp.score);
        int x = 400;
        int y = 150;

        g2.setColor(Color.white);
        g2.drawString(text, x, y);
    }
}
