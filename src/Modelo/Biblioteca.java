package Modelo;

import Utils.HibernateUtil;
import java.util.List;
import java.util.Observable;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import HBM.*;

public class Biblioteca extends Observable {

    private Usuario usuarioActivo;
    private Catalogo alberga;
    private GestorUsuarios gestorUsuarios;

    public Biblioteca() {
        alberga = new Catalogo();
        gestorUsuarios = new GestorUsuarios();
    }

    public Usuario login(String dni, String clave) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            //List usuarios = BD.executeHQLQuery("from Usuario u where u.dni=" + dni + " and u.clave='" + clave + "'");
            usuarioActivo = (Usuario) session.load(Usuario.class, Integer.parseInt(dni));
            System.out.println("BD:" + usuarioActivo.getClave() + ", clave:" + clave);
            if (usuarioActivo.getClave().equals(clave) == false) {
                System.out.println("Fallo en clave");
                throw new Exception("Usuario " + dni + " clave no válido");
            }
            session.getTransaction().commit();
            session.close();
            setChanged();
            notifyObservers();

        } catch (ObjectNotFoundException ex) {
            System.err.println("Login (" + dni + " / " + clave + ") clave no valida");
            throw new Exception("Usuario " + dni + " no válido");
        }
        return usuarioActivo;


    }

    public Catalogo getAlberga() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            alberga.init(session.createQuery("from Titulo").list());

            session.getTransaction().commit();
            //session.close();
            setChanged();
            notifyObservers();

        } catch (ObjectNotFoundException ex) {
            System.err.println("ObjectNotFoundException");
        }
        return alberga;
    }

    public GestorUsuarios getUsuarios() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {

            gestorUsuarios.init(session.createQuery("from Usuario").list());

            session.getTransaction().commit();
            //session.close();


        } catch (ObjectNotFoundException ex) {
            System.err.println("ObjectNotFoundException");
            throw ex;
        }
        return gestorUsuarios;
    }

    public List<Dewey> getCategoriasDewey() {
        List<Dewey> listaCategoriasDewey = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            listaCategoriasDewey = session.createQuery("from Dewey").list();

            session.getTransaction().commit();
            //session.close();

        } catch (ObjectNotFoundException ex) {
            System.err.println("ObjectNotFoundException");
        }
        return listaCategoriasDewey;
    }

    public void altaUsuario(Usuario usuario) {


        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {

            session.save(usuario);
            session.flush();
            session.getTransaction().commit();


        } catch (ObjectNotFoundException ex) {
            System.err.println("ObjectNotFoundException");
            throw ex;
        }

    }

    public void modificacionTitulo(Titulo titulo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {

            Titulo tituloAux = (Titulo) session.load(Titulo.class, titulo.getId());

            tituloAux.setEdicion(titulo.getEdicion());
            tituloAux.setSinopsis(titulo.getSinopsis());
            tituloAux.setNumPaginas(titulo.getNumPaginas());
            tituloAux.setFechaAdquisicion(titulo.getFechaAdquisicion());
            tituloAux.setIdioma6391(titulo.getIdioma6391());


            session.update(tituloAux);
            session.flush();
            session.getTransaction().commit();


        } catch (Exception ex) {
            System.err.println("ObjectNotFoundException " + ex);
        }
    }

    public void bajaTitulo(TituloId tituloId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Titulo titulo = (Titulo) session.load(Titulo.class, tituloId);
            session.delete(titulo);
            session.flush();
            session.getTransaction().commit();
        } catch (ObjectNotFoundException ex) {
            System.err.println("ObjectNotFoundException");
            throw ex;
        }
    }

    public List<Idioma6391> getISO6391() {
        List<Idioma6391> listaIdioma6391 = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            listaIdioma6391 = session.createQuery("from Idioma6391").list();

            session.getTransaction().commit();
            //session.close();

        } catch (ObjectNotFoundException ex) {
            System.err.println("ObjectNotFoundException");
        }
        return listaIdioma6391;
    }

    public List<Autor> getAutores() {
        List<Autor> autores = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            autores = session.createQuery("from Autor").list();

            session.getTransaction().commit();
            //session.close();

        } catch (ObjectNotFoundException ex) {
            System.err.println("ObjectNotFoundException");
        }
        return autores;
    }
}
