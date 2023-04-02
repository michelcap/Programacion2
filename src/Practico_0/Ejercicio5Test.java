package Practico_0;

import Practico_0.Ejercicio5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ejercicio5Test {

    @Test
    void test_1() {
        Ejercicio5 test1 = new Practico_0.Ejercicio5();
        test1.setCostoPromedioEquivalente(3246.25);
        test1.setFranjaRemuneracion(25520.5);

        double[] remuneraciones = {110000, 110000, 110000, 110000, 110000, 110000,
                110000, 110000, 110000, 110000, 110000, 110000};
        boolean conyugeACargo = false;
        int hijosACargo = 1;

        double devolucion = test1.calcularDevolucion(remuneraciones, conyugeACargo, hijosACargo);
        assertEquals(1290.0, devolucion);
    }

    @Test
    void test_2() {
        Ejercicio5 test2 = new Ejercicio5();
        test2.setCostoPromedioEquivalente(3246.25);
        test2.setFranjaRemuneracion(25520.5);

        double[] remuneraciones = {110000, 110000, 110000, 110000, 110000, 110000,
                110000, 110000, 110000, 110000, 110000, 110000};
        boolean conyugeACargo = true;
        int hijosACargo = 1;

        double devolucion = test2.calcularDevolucion(remuneraciones, conyugeACargo, hijosACargo);
        assertEquals(0.0, devolucion);
    }

    @Test
    void test_3() {
        Ejercicio5 test3 = new Ejercicio5();
        test3.setCostoPromedioEquivalente(3246.25);
        test3.setFranjaRemuneracion(25520.5);

        double[] remuneraciones = {150000, 150000, 150000, 150000, 150000, 150000,
                150000, 150000, 150000, 150000, 150000, 150000};
        boolean conyugeACargo = true;
        int hijosACargo = 0;

        double devolucion = test3.calcularDevolucion(remuneraciones, conyugeACargo, hijosACargo);
        assertEquals(39090.0, devolucion);
    }

    @Test
    void test_4() {
        Ejercicio5 test4 = new Ejercicio5();
        test4.setCostoPromedioEquivalente(3246.25);
        test4.setFranjaRemuneracion(25520.5);

        double[] remuneraciones = {20000, 30000, 25000, 23000, 35000, 24500,
                20000, 26000, 22500, 2500000, 60000, 21000};
        boolean conyugeACargo = false;
        int hijosACargo = 0;

        double devolucion = test4.calcularDevolucion(remuneraciones, conyugeACargo, hijosACargo);
        assertEquals(85020.0, devolucion);
    }
}