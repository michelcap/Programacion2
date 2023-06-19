package sparcial.entities;

import TADs.adt.hash.MyHash;
import TADs.adt.hash.MyHashImpl;
import TADs.adt.linkedlist.MyLinkedListImpl;
import TADs.adt.linkedlist.MyList;

import java.time.LocalDate;

public class Estadio {
    private int capacidadHabilitada;
    private String nombreEstadio;
    MyHash<LocalDate, Partido> partidos;

    public Estadio(String nombreEstadio){
        this.nombreEstadio = nombreEstadio;
    }

    public Estadio(String nombreEstadio, int capacidadHabilitada){
        this.nombreEstadio = nombreEstadio;
        this.capacidadHabilitada = capacidadHabilitada;
        partidos = new MyHashImpl<>();
    }

    public boolean contienePartido(LocalDate fecha) {
        boolean retorno = false;
        if(partidos != null && partidos.contains(fecha)) {
            retorno = true;
        }
        return retorno;
    }

    public void nuevoPartido(LocalDate fecha, Partido partido) {
        partidos.put(fecha, partido);
    }

    public boolean hayLugar(LocalDate partidoFecha) {
        Partido partido = partidos.get(partidoFecha);
        if (partido.entradasVendidas() < partido.capacidad()){
            return true;
        }
        return false;
    }

    public boolean yaComproParaHoy(LocalDate partidoFecha, String pasaporteAficionado) {
        Partido partido = partidos.get(partidoFecha);
        if (partido.yaVendido(pasaporteAficionado)) {
            return true;
        }
        return false;
    }

    public Partido getPartido(LocalDate partidoFecha) {
        return partidos.get(partidoFecha);
    }
}
