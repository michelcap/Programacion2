package Practico_0;

public class Ejercicio5 {
    private double[] remuneraciones;
    private boolean conConyugeACargo;
    private int hijosACargo;
    private double franjaRemuneracion;
    private double costoPromedioEquivalente;

    public Ejercicio5() {
        System.out.println("ckeck Class Practico 0 Ejercicio 5 ok !");
    }

    public double[] getRemuneraciones() {
        return remuneraciones;
    }

    public void setRemuneraciones(double[] remuneraciones) {
        this.remuneraciones = remuneraciones;
    }

    public boolean isConConyugeACargo() {
        return conConyugeACargo;
    }

    public void setConConyugeACargo(boolean conConyugeACargo) {
        this.conConyugeACargo = conConyugeACargo;
    }

    public int getHijosACargo() {
        return hijosACargo;
    }

    public void setHijosACargo(int hijosACargo) {
        this.hijosACargo = hijosACargo;
    }

    public double getFranjaRemuneracion() {
        return franjaRemuneracion;
    }

    public void setFranjaRemuneracion(double franjaRemuneracion) {
        this.franjaRemuneracion = franjaRemuneracion;
    }

    public double getCostoPromedioEquivalente() {
        return costoPromedioEquivalente;
    }

    public void setCostoPromedioEquivalente(double costoPromedioEquivalente) {
        this.costoPromedioEquivalente = costoPromedioEquivalente;
    }

    public double calcularDevolucion(double[] remuneraciones, boolean conyugeACargo, int hijosACargo) {
        double devolucion = 0.0;
        boolean isConhijos = hijosACargo > 0;
        Double aporteMensual = 0.0;
        Double topeMensual = 0.0;
        int meses = 12;

        if (!conyugeACargo) {
            topeMensual = this.getCostoPromedioEquivalente() * (1 + hijosACargo);
        } else {
            topeMensual = this.getCostoPromedioEquivalente() * (2 + hijosACargo);
        }

        for (double sueldo : remuneraciones) {
            if (sueldo <= this.getFranjaRemuneracion()) {
                if (!conyugeACargo) {
                    aporteMensual = aporteMensual + sueldo * 0.03;
                } else {
                    aporteMensual = aporteMensual + sueldo * 0.05;
                }
            } else {
                if (!conyugeACargo) {
                    if (!isConhijos) {
                        aporteMensual = aporteMensual + sueldo * 0.045;
                    } else {
                        aporteMensual = aporteMensual + sueldo * 0.06;
                    }
                } else {
                    if (!isConhijos) {
                        aporteMensual = aporteMensual + sueldo * 0.065;
                    } else {
                        aporteMensual = aporteMensual + sueldo * 0.08;
                    }
                }
            }
        }

        int resultado = aporteMensual.compareTo(topeMensual * meses);

        if (resultado > 0) {
            devolucion = (aporteMensual  - topeMensual * 12);
        }

        return devolucion;
    }
}
