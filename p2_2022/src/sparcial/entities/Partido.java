package sparcial.entities;

import TADs.adt.hash.MyHash;
import TADs.adt.hash.MyHashImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Partido {
    private LocalDate fecha;
    private int capacidadHabilitada;
    private int entradasVendidas;
    private Pais equipoPaisA;
    private Pais equipoPaisB;
    private MyHash<String,Entrada> entradas;
    private String nombreEstadio;

    public Partido(LocalDate fecha, int capacidadHabilitada) {
        this.fecha = fecha;
        this.capacidadHabilitada = capacidadHabilitada;
    }

    public Partido(LocalDate fecha, int capacidadHabilitada, Pais equipoPaisA, Pais equipoPaisB) {
        this.fecha = fecha;
        this.capacidadHabilitada = capacidadHabilitada;
        this.equipoPaisA = equipoPaisA;
        this.equipoPaisB = equipoPaisB;
        this.entradas = new MyHashImpl<>();
    }

    public int entradasVendidas() {
        return this.entradasVendidas;
    }


    public int capacidad() {
        return this.capacidadHabilitada;
    }

    public boolean yaVendido(String pasaporteAficionado) {
        if (entradas.values().contains(new Entrada(pasaporteAficionado))){
            return true;
        }
        return false;
    }

    public String verderEntrada(LocalDate partidoFecha, Aficionado aficionado) {
        String fechaStr = partidoFecha.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String pasaporte = aficionado.getPasaporte();
        String retorno = pasaporte+"|"+fechaStr+"|"+this.nombreEstadio;
        Entrada entrada = new Entrada(retorno, aficionado);
        entradas.put(retorno, entrada);
        return retorno;
    }

    public void setEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }
}
