package PlotearArbol;

import TAD.Queue.MyQueue;
import TAD.TreeBinaryCompleto.MyTreeBinaryCompletoImpl;

import javax.swing.*;

public class BinaryTreeVisualizer<K,T> extends JPanel {

    public static void main(String[] args) throws MyQueue.EmptyQueueException {
        // Creamos un árbol binario de ejemplo
        MyTreeBinaryCompletoImpl<Integer, String> arbol = new MyTreeBinaryCompletoImpl<>();
        arbol.insert(10, "a");
        arbol.insert(4, "b");
        arbol.insert(15, "c");
        arbol.insert(5, "d");
        arbol.insert(30, "e");
        arbol.insert(6, "f");
        arbol.insert(1, "g");
        arbol.insert(3, "h");
        arbol.insert(25, "i");
        arbol.insert(12, "j");
        arbol.insert(0, "k");
        arbol.insert(20, "l");
        arbol.delete(10);
        arbol.delete(20);
        arbol.delete(0);
        arbol.delete(15);
        arbol.delete(4);


        // Creamos un panel para mostrar el árbol binario
        BinaryTreePanel<Integer, String> panel = new BinaryTreePanel<>(arbol.getRaiz());
        panel.setRadius(30);
        panel.setvGap(80);
        panel.sethGap(60);

        // Creamos una ventana para mostrar el panel
        JFrame frame = new JFrame("Árbol binario");
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}