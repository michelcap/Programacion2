package entities;

import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.hash.MyHash;
import uy.edu.um.adt.hash.MyHashImpl;

public class ControlParentalImpl implements ControlParentalService {
    MySearchBinaryTree<Usuario, Usuario> usuarios;
    MyHash<Aplicaciones, Aplicaciones> aplicaciones;

    public ControlParentalImpl() {
        usuarios = new MySearchBinaryTreeImpl<>();
        aplicaciones = new MyHashImpl<>();
    }

    @Override
    public void registrarUsuario(String mail, String nombre, boolean esMenor, String mailAdulto) throws Exception {
        if (mail == null || mail.equals("") || nombre == null || nombre.equals("")
                || (esMenor && (mailAdulto == null || mailAdulto.equals("")))) {
            throw new Exception("Datos ingresados erroneos !");
        }

        if (esMenor) {
            Adulto adulto = (Adulto) usuarios.find(new Adulto(mailAdulto));

            if (adulto == null) {
                throw new Exception("El adulto No existe !");
            }

            Menor menor = new Menor(mail, nombre);
            adulto.addMenor(menor);
            this.usuarios.add(menor, menor);
        } else {
            Adulto adulto = new Adulto(mail);
            if (this.usuarios.contains(adulto)) {
                throw new Exception("El adulto Ya existe !");
            }

            adulto = new Adulto(mail, nombre);
            this.usuarios.add(adulto, adulto);
        }
    }

    @Override
    public void restringirAcceso(String mailAdulto, String mailMenor, long tiempoPermitido, String aplicacion) throws Exception {
        if (mailAdulto == null || mailAdulto.equals("") || mailMenor == null || mailMenor.equals("")
                || tiempoPermitido < 0) {
            throw new Exception("Datos ingresados erroneos !");
        }

        Adulto adulto;
        Menor menor;

        try {
            adulto = (Adulto) usuarios.find(new Adulto(mailAdulto));
            menor = (Menor) usuarios.find(new Menor(mailMenor));
        } catch (ClassCastException e) {
            throw new Exception("Error en lectura de los usuarios ingresado");
        }

        if (adulto == null || menor == null) {
            throw new Exception("Algunos uuarios ingresados no existen");
        }

        if (!adulto.contains(menor)) {
            throw new Exception("El adulto no esta a cargo del menor");
        }

        Aplicaciones app;
        if (!aplicaciones.contains(new Aplicaciones(aplicacion))) {
            app = new Aplicaciones(aplicacion);
            aplicaciones.put(app, app);
        }
        app = aplicaciones.get(new Aplicaciones(aplicacion));

        menor.addRestriccion(app, tiempoPermitido);
    }

    @Override
    public boolean notificacionAperturaAplicacion(String mail, String aplicacion) throws Exception {
        boolean retorno = false;
        Usuario usuario;
        Aplicaciones app;
        try {
            usuario = usuarios.find(new Usuario(mail));
            app = aplicaciones.get(new Aplicaciones(aplicacion));
        } catch (ClassCastException e) {
            throw new Exception("Error al leer el usuario y/o la aplicación ingresada.");
        }

        if (usuario == null) {
            throw new Exception("El usuario no existe.");
        }

        if (app == null) {
            app = new Aplicaciones(aplicacion);
            aplicaciones.put(app, app);
        }

        retorno = usuario.AperturaApp(app);

        return retorno;
    }

    @Override
    public boolean notificacionCierreAplicacion(String mail, String aplicacion) throws Exception {
        boolean retorno = false;
        Usuario usuario;
        Aplicaciones app;
        try {
            usuario = usuarios.find(new Usuario(mail));
            app = aplicaciones.get(new Aplicaciones(aplicacion));
        } catch (ClassCastException e) {
            throw new Exception("Error al leer el usuario y/o la aplicación ingresada.");
        }

        if (usuario == null) {
            throw new Exception("El usuario no existe.");
        }

        if (app == null) {
            throw new Exception("El aplicacion no existe.");
        }

        retorno = usuario.CierreApp(app);

        return retorno;
    }

    @Override
    public void obtenerRankingAplicaciones(String mail) {

    }

    @Override
    public void obtenerRankingTop5Usuarios() {

    }
}
