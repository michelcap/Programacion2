package sparcial;

import TADs.adt.hash.MyHash;
import TADs.adt.hash.MyHashImpl;
import exceptions.InformacionInvalida;
import sparcial.entities.Aficionado;
import sparcial.entities.Estadio;
import sparcial.entities.Pais;
import sparcial.entities.Partido;
import sparcial.exceptions.CompraRechazada;
import sparcial.exceptions.EntidadNoExiste;

import java.time.LocalDate;

public class ControladorMundial {
    MyHash<String, Pais> paises;
    MyHash<String, Aficionado> aficionados;
    MyHash<String, Estadio> estadios;

    public ControladorMundial() {
        paises = new MyHashImpl<>();
        aficionados = new MyHashImpl<>();
        estadios = new MyHashImpl<>();
    }

    void registrarPartido(LocalDate fecha, String nombreEstadio, int capacidadHabilitada, String equipoPaisA, String equipoPaisB) throws InformacionInvalida {
        if ((fecha == null || fecha.equals("")) || (nombreEstadio == null || nombreEstadio.equals(""))
                || (40000 > capacidadHabilitada || capacidadHabilitada > 94500) || (equipoPaisA == null || equipoPaisA.equals("")) || (equipoPaisB == null || equipoPaisB.equals(""))) {
            throw new InformacionInvalida("Datos ingresados Invalidos");
        }

        if (!estadios.contains(nombreEstadio)) {
            Estadio newEstadio = new Estadio(nombreEstadio, capacidadHabilitada);
            estadios.put(nombreEstadio, newEstadio);
        }
        Estadio estadio = estadios.get(nombreEstadio);
        if (estadio != null) {
            if (estadio.contienePartido(fecha)) {
                throw new InformacionInvalida("Ya existe un partido para la fecha " + fecha);
            }
            if (!paises.contains(equipoPaisA)) {
                Pais newPaisA = new Pais(equipoPaisA);
                paises.put(equipoPaisA, newPaisA);
            }
            if (!paises.contains(equipoPaisB)) {
                Pais newPaisB = new Pais(equipoPaisB);
                paises.put(equipoPaisB, newPaisB);
            }
            Pais a = paises.get(equipoPaisA);
            Pais b = paises.get(equipoPaisB);
            Partido newPartido = new Partido(fecha, capacidadHabilitada, a, b);
            newPartido.setEstadio(nombreEstadio);
            estadio.nuevoPartido(fecha, newPartido);
            estadios.put(nombreEstadio, estadio);
        }
    }

    String venderEntrada(String pasaporteAficionado, String paisOrigen, LocalDate partidoFecha, String nombreEstadio) throws InformacionInvalida, EntidadNoExiste, CompraRechazada {
        if ((pasaporteAficionado == null || pasaporteAficionado.equals(""))
                || (paisOrigen == null || paisOrigen.equals(""))
                || (partidoFecha == null || partidoFecha.equals(""))
                || (nombreEstadio == null || nombreEstadio.equals(""))) {
            throw new InformacionInvalida("Datos ingresados Invalidos");
        }
        Estadio estadio = estadios.get(nombreEstadio);
        if(estadio==null) {
            throw new InformacionInvalida("El nombre del estadio es incorrecto");
        }
        if(!estadio.contienePartido(partidoFecha)) {
            throw new EntidadNoExiste("No existe partido para la fecha indicada");
        }
        if(!estadio.hayLugar(partidoFecha)){
            throw new CompraRechazada("Compra Rechazada No Hay Lugar");
        }
        if(!estadio.yaComproParaHoy(partidoFecha,pasaporteAficionado)) {
            throw new CompraRechazada("Compra Rechazada Ya Compro Hoy");
        }

        Aficionado aficionado;
        if(!aficionados.contains(pasaporteAficionado)) {
            aficionado = new Aficionado(pasaporteAficionado, paisOrigen);
            aficionados.put(pasaporteAficionado, aficionado);
        }
        aficionado = aficionados.get(pasaporteAficionado);
        Partido partido = estadio.getPartido(partidoFecha);
        String retorno = partido.verderEntrada(partidoFecha, aficionado);
        return retorno;
    }
}
