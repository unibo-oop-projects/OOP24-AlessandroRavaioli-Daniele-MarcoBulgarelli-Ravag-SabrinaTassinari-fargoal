package fargoal.view.impl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SwingViewCanvas extends JPanel {
    
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
}
