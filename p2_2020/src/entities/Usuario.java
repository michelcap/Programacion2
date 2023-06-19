package entities;

import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;

public class Usuario implements Comparable<Usuario> {
    MyList<RegistroAcceso> registroAccesoAPPs;
    private String mailUsuario;
    private String nombreUsuario;

    public Usuario(String mail, String nombre) {
        this.mailUsuario = mail;
        this.nombreUsuario = nombre;
        this.registroAccesoAPPs = new MyLinkedListImpl<>();
    }

    public Usuario(String mail) {
        this.mailUsuario = mail;
    }


    public MyList<RegistroAcceso> getRegistroAccesoAPPs() {
        return registroAccesoAPPs;
    }

    public void setRegistroAccesoAPPs(RegistroAcceso newAcceso) {
        this.registroAccesoAPPs.add(newAcceso);
    }

    @Override
    public int compareTo(Usuario o) {
        return 0;
    }

    public boolean AperturaApp(Aplicaciones app) {
        boolean retorno = false;
        RegistroAcceso newAcceso;
        if (!this.registroAccesoAPPs.contains(new RegistroAcceso(app))) {
            newAcceso = new RegistroAcceso(app);
            newAcceso.iniciar();
            newAcceso.setRunning(true);
            setRegistroAccesoAPPs(newAcceso);
        } else {
            RegistroAcceso registro;
            for (int i = 0; i < getRegistroAccesoAPPs().size(); i++) {
                registro = getRegistroAccesoAPPs().get(i);
                if (registro.equals(app)) {
                    if (!registro.isRunning()) {
                        registro.iniciar();
                        registro.setRunning(true);
                    }
                }
            }
        }
        return false;
    }

    public boolean CierreApp(Aplicaciones app) {
        boolean retorno = false;
        RegistroAcceso registro;
        for (int i = 0; i < getRegistroAccesoAPPs().size(); i++) {
            registro = getRegistroAccesoAPPs().get(i);
            if (registro.equals(app)) {
                if (registro.isRunning()) {
                    registro.finalizar();
                    registro.setRunning(false);
                }
            }
        }
        return false;
    }

    protected Long calcularTiempo(Aplicaciones app) {
        Long tiempo = 0L;
        RegistroAcceso registro;
        for (int i = 0; i < registroAccesoAPPs.size(); i++) {
            registro = registroAccesoAPPs.get(i);
            if (registro.equals(app) && registro.esDeHoy()) {
                tiempo += registro.calcularTiempo();
            }
        }
        return tiempo;
    }
}
