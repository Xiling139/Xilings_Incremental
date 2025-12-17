package main;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

public class MouseHandler implements MouseInputListener{

    Gamepanel gp;
    UI ui;

    public MouseHandler(Gamepanel gp, UI ui) {
        this.gp = gp;
        this.ui = ui;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int code = e.getButton();

        if (code == MouseEvent.BUTTON1) {
            ui.cursorX = e.getX();
            ui.cursorY = e.getY();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
