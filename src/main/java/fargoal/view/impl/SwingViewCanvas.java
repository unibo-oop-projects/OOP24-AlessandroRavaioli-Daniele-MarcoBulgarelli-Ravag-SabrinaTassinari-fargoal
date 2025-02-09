package fargoal.view.impl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fargoal.controller.input.api.KeyboardInputController;

public class SwingViewCanvas extends JPanel implements KeyListener{
    
    private KeyboardInputController input = new KeyboardInputController();
    private List<Consumer<Graphics2D>> list;
    private boolean canDraw;

    SwingViewCanvas() {
        list = new LinkedList<>();
        canDraw = true;
    }

    public void addToList(Consumer<Graphics2D> g2d) {
        SwingUtilities.invokeLater(() -> list.add(g2d));
    }

    @Override
    public void paintComponent(Graphics g) {
        if (this.canDraw) {
            this.canDraw = false;
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;
            this.list.forEach(d -> d.accept(g2d));
            this.list.clear();   
        }
    }

    public void enableDraw(boolean canDraw) {
        this.canDraw = canDraw;
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            case KeyEvent.VK_UP:
                input.notifyMoveUp();
                break;
            
            case KeyEvent.VK_DOWN:
                input.notifyMoveDown();
                break;

            case KeyEvent.VK_LEFT:
                input.notifyMoveLeft();
                break;

            case KeyEvent.VK_RIGHT:
                input.notifyMoveRight();
                break;
        
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { 
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                input.notifyNoMoreMoveUp();
                break;
        
            case KeyEvent.VK_DOWN:
                input.notifyNoMoreMoveDown();
                break;
            
            case KeyEvent.VK_LEFT:
                input.notifyNoMoreMoveLeft();
                break;

            case KeyEvent.VK_RIGHT:
                input.notifyNoMoreMoveRight();
                break;

            default:
                break;
        }
    }
}
