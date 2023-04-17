package Supermercado;

import TAD.Queue.MyQueue;

import java.util.Timer;
import java.util.TimerTask;

public class Super<T extends Number> {
    static int interval;
    static Timer timer;

    static Caja<Integer> caja1 = new Caja<>();
    static Caja<Integer> caja2 = new Caja<>();
    static Caja<Integer> caja3 = new Caja<>();

    public static void main(String[] args) {



        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = 90;

        caja1.addCliente(1, 1);
        caja1.addCliente(2, 2);
        caja1.addCliente(3, 3);
        caja2.addCliente(1, 5);
        caja2.addCliente(1, 1);
        caja2.addCliente(2, 5);
        caja3.addCliente(1, 1);
        caja3.addCliente(2, 1);
        caja3.addCliente(1, 1);

        // Imprime la primera línea fija con nombres de columnas
        System.out.println("         | Caja1 | Caja2 | Caja3 |");

        timer.scheduleAtFixedRate(new TimerTask() {
            int valor11 = 0;
            int valor21 = 0;
            int valor31 = 0;
            int valor12 = 0;
            int valor22 = 0;
            int valor32 = 0;

            private void setInterval(int valor4, int valor5, int valor6) {
                System.out.printf("Clientes: | %4d | %4d | %4d |\n", valor4, valor5, valor6);
            }

            public void run() {
                try {
                    if (caja1.getCantClientes() != 0) {
                        valor11 = 5 * caja1.getDemora();
                        valor12 = caja1.getCantClientes();
                    }
                    if (caja2.getCantClientes() != 0) {
                        valor21 = 5 * caja2.getDemora();
                        valor22 = caja2.getCantClientes();
                    }
                    if (caja3.getCantClientes() != 0) {
                        valor31 = 5 * caja3.getDemora();
                        valor32 = caja3.getCantClientes();
                    }

//                    setInterval(valor12, valor22, valor32);
//                    System.out.printf("Clientes: | %4d | %4d | %4d |\n", valor4, valor5, valor6);
                    System.out.printf("\rDemora:  |  %4d |  %4d |  %4d |", valor11, valor21, valor31);
                    System.out.flush();

                    if (caja1.getDemora() >= 1) {
                        caja1.removeProducto();
                    }
                    if (caja2.getDemora() >= 1) {
                        caja2.removeProducto();
                    }
                    if (caja3.getDemora() >= 1) {
                        caja3.removeProducto();
                    }

                } catch (MyQueue.EmptyQueueException e) {
                    throw new RuntimeException(e);
                }
            }
        }, delay, period);
    }
}
