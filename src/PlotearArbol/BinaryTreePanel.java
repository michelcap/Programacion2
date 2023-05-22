package PlotearArbol;

import TAD.Tree.NodoTree;

import javax.swing.*;
import java.awt.*;

class BinaryTreePanel<K,T> extends JPanel {
    private NodoTree<K,T> root;
    private int radius = 20;
    private int vGap = 50;
    private int hGap = 30;

    public BinaryTreePanel(NodoTree<K,T> root) {
        this.root = root;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            displayTree(g, root, getWidth() / 2, 30, getWidth() / 4);
        }
    }

    private void displayTree(Graphics g, NodoTree<K,T> node, int x, int y, int hGap) {
        g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        g.drawString(node.getKey() + "-" +node.getData(), x - 8, y + 4);

        if (node.getLeftChild() != null) {
            connectLeftChild(g, x - hGap, y + vGap, x, y);
            displayTree(g, node.getLeftChild(), x - hGap, y + vGap, hGap / 2);
        }

        if (node.getRightChild() != null) {
            connectRightChild(g, x + hGap, y + vGap, x, y);
            displayTree(g, node.getRightChild(), x + hGap, y + vGap, hGap / 2);
        }
    }

    private void connectLeftChild(Graphics g, int x1, int y1, int x2, int y2) {
        double d = Math.sqrt(vGap * vGap + (x2 - x1) * (x2 - x1));
        int x11 = (int) (x1 + radius * (x2 - x1) / d);
        int y11 = (int) (y1 - radius * vGap / d);
        int x21 = (int) (x2 - radius * (x2 - x1) / d);
        int y21 = (int) (y2 + radius * vGap / d);
        g.drawLine(x11, y11, x21, y21);
    }

    private void connectRightChild(Graphics g, int x1, int y1, int x2, int y2) {
        double d = Math.sqrt(vGap * vGap + (x2 - x1) * (x2 - x1));
        int x11 = (int) (x1 - radius * (x1 - x2) / d);
        int y11 = (int) (y1 - radius * vGap / d);
        int x21 = (int) (x2 + radius * (x1 - x2) / d);
        int y21 = (int) (y2 + radius * vGap / d);
        g.drawLine(x11, y11, x21, y21);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setvGap(int vGap) {
        this.vGap = vGap;
    }

    public void sethGap(int hGap) {
        this.hGap = hGap;
    }
}