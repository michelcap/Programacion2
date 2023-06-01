package PlotearArbol;

import TAD.Heap.MyHeap;
import TAD.Heap.MyHeapImpl;
import TAD.Queue.MyQueue;
import TAD.TreeBinaryCompleto.MyTreeBinaryCompletoImpl;

import javax.swing.*;

public class BinaryTreeVisualizer<K,T> extends JPanel {

    public static void main(String[] args) throws Exception {
        // Creamos un árbol binario de ejemplo
//        MyTreeBinaryCompletoImpl<Integer, String> arbol = new MyTreeBinaryCompletoImpl<>();
//        arbol.insert(10, "a");
//        arbol.insert(4, "b");
//        arbol.insert(15, "c");
//        arbol.insert(5, "d");
//        arbol.insert(30, "e");
//        arbol.insert(6, "f");
//        arbol.insert(1, "g");
//        arbol.insert(3, "h");
//        arbol.insert(25, "i");
//        arbol.insert(12, "j");
//        arbol.insert(0, "k");
//        arbol.insert(20, "l");

        MyHeapImpl<Integer,String> monticulo = new MyHeapImpl<>("minimo");
        monticulo.insert(10, "a");
        monticulo.insert(4, "b");
        monticulo.insert(15, "c");
        monticulo.insert(5, "d");
        monticulo.insert(30, "e");
        monticulo.insert(6, "f");
        monticulo.insert(1, "g");
        monticulo.insert(3, "h");
        monticulo.insert(25, "i");
        monticulo.insert(12, "j");
        monticulo.insert(0, "k");
        monticulo.insert(20, "l");

        // Creamos un panel para mostrar el árbol binario
        BinaryTreePanel<Integer, String> panel = new BinaryTreePanel<>(monticulo.getRaiz());
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