package PlotearArbol;

import TAD.Tree.MyTree;
import TAD.Tree.MyTreeImpl;

import javax.swing.*;

public class BinaryTreeVisualizer<K,T> extends JPanel {

    public static void main(String[] args) {
        // Creamos un árbol binario de ejemplo
        MyTree<Integer, String> arbol = new MyTreeImpl<>();
        arbol.insert(1, "a");
        arbol.insert(4, "b");
        arbol.insert(3, "c");
        arbol.insert(5, "d");
        arbol.insert(2, "e");
        arbol.insert(6, "f");
        arbol.insert(10, "g");
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