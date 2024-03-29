/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import HBM.Titulo;
import HBM.TituloId;
import Modelo.Biblioteca;
import Modelo.Catalogo;
import Modelo.GestorUsuarios;
import Modelo.Login;
import Modelo.Usuario;
import java.beans.PropertyChangeEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nanohp
 */
public class Controlador extends AbstractController implements GestorEventos {

    private Biblioteca biblioteca;

    public Controlador(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void procesarEvento(Evento evento) {
        Evento eventoRespuesta = null;



        switch (evento.getTipoEvento()) {
            case SALIR:
                System.out.println("Saliendo");
                System.exit(1);
                break;
            case LOGIN:
                if (!evento.getInfo().getClass().getName().equals("Modelo.Login")) {
                    assert false : evento.getInfo().getClass().getName() + " clase invalida";
                } else {
                    Login login = (Login) evento.getInfo();
                    System.out.println("Intento acceso para: " + login.toString());
                    Usuario usuario;
                    try {
                        usuario = biblioteca.login(login.getNombre(), login.getClave());
                        ((Usuario) usuario).setLookAndFeel(login.getLookAndFeel());
                        //System.out.println("---"+usuario.getClass().getSimpleName()+"-");
                        eventoRespuesta = new Evento(TipoEvento.LOGIN_OK, usuario);
                    } catch (Exception ex) {
                        //Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                        System.err.println("ERROR");
                        eventoRespuesta = new Evento(TipoEvento.LOGIN_FALLO);
                    }
                    evento.getDestinoRespueta().procesarEvento(eventoRespuesta);
                }

                break;
            case LOGOUT:
                evento.getDestinoRespueta().procesarEvento(new Evento(TipoEvento.LOGOUT));
                break;
            case OBTENER_CAT_DEWEY:
                evento.getDestinoRespueta().procesarEvento(new Evento(TipoEvento.OBTENER_CAT_DEWEY, biblioteca.getCategoriasDewey()));
                break;
            case CONSULTA_GENERAL_ISO_639_1:
                evento.getDestinoRespueta().procesarEvento(new Evento(TipoEvento.CONSULTA_GENERAL_ISO_639_1, biblioteca.getISO6391()));
                break;

            case CONSULTA_CATALOGO_GENERAL:
                System.out.println("Controlador.procesarEvento()->CONSULTA_CATALOGO_GENERAL");
                try {

                    Catalogo catalogo = biblioteca.getAlberga();
                    if (evento.getTipoEventoRespuesta() == null) {
                        eventoRespuesta = new Evento(TipoEvento.CONSULTA_CATALOGO_GENERAL, catalogo.getCatalogo().values());
                    } else {
                        eventoRespuesta = new Evento(evento.getTipoEventoRespuesta(), catalogo.getCatalogo().values());
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println("CONSULTA_CATALOGO_GENERAL: ERROR");
                    eventoRespuesta = new Evento(TipoEvento.ERROR);
                }
                evento.getDestinoRespueta().procesarEvento(eventoRespuesta);
                break;


            case CONSULTA_CATALOGO_CONCRETA:
                System.out.println("CONSULTA_CATALOGO_CONCRETA" + evento.getInfo().getClass().getName());
                if (!evento.getInfo().getClass().getName().startsWith("HBM.TituloId")) {
                    assert false : evento.getInfo().getClass().getName() + " clase invalida";
                }

                try {
                    TituloId tituloId = (TituloId) evento.getInfo();

                    Titulo titulo = biblioteca.getAlberga().getCatalogo().get(tituloId);
                    eventoRespuesta = new Evento(TipoEvento.CONSULTA_CATALOGO_CONCRETA, titulo);

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println("CONSULTA_CATALOGO_CONCRETA: ERROR");
                    eventoRespuesta = new Evento(TipoEvento.ERROR);
                }
                evento.getDestinoRespueta().procesarEvento(eventoRespuesta);
                break;

            case CONSULTA_GENERAL_AUTORES:
                if (evento.getTipoEventoRespuesta() == null) {
                    evento.getDestinoRespueta().procesarEvento(new Evento(TipoEvento.CONSULTA_GENERAL_AUTORES, biblioteca.getAutores()));
                } else {
                    evento.getDestinoRespueta().procesarEvento(new Evento(evento.getTipoEventoRespuesta(), biblioteca.getAutores()));
                }

                break;

            case CONSULTA_GENERAL_EDITORIALES:
                if (evento.getTipoEventoRespuesta() == null) {
                    evento.getDestinoRespueta().procesarEvento(new Evento(TipoEvento.CONSULTA_GENERAL_EDITORIALES, biblioteca.getEditoriales()));
                } else {
                    evento.getDestinoRespueta().procesarEvento(new Evento(evento.getTipoEventoRespuesta(), biblioteca.getAutores()));
                }

                break;

            case CONSULTA_GENERAL_USUARIOS:



                System.out.println("Listado de usuarios");
                try {
                    /*
                    GestorUsuarios gestorUsuarios = biblioteca.getUsuarios();
                    eventoRespuesta = new Evento(TipoEvento.LISTADO_USUARIOS, gestorUsuarios);*/
                    if (evento.getTipoEventoRespuesta() == null) {
                        evento.getDestinoRespueta().procesarEvento(new Evento(TipoEvento.CONSULTA_GENERAL_USUARIOS, biblioteca.getUsuarios().getListaUsuarios().values()));
                    } else {
                        evento.getDestinoRespueta().procesarEvento(new Evento(evento.getTipoEventoRespuesta(), biblioteca.getUsuarios().getListaUsuarios().values()));
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println("LISTADO_USUARIOS: ERROR");
                    eventoRespuesta = new Evento(TipoEvento.CONSULTA_GENERAL_USUARIOS_ERROR);
                }
                //evento.getDestinoRespueta().procesarEvento(eventoRespuesta);
                break;
            case ALTA_USUARIO:
                Usuario usuario = (Usuario) evento.getInfo();
                try {
                    biblioteca.altaUsuario(usuario);
                    eventoRespuesta = new Evento(TipoEvento.ALTA_USUARIO_OK, usuario);

                } catch (Exception ex) {
                    eventoRespuesta = new Evento(TipoEvento.ALTA_USUARIO_ERROR, usuario);
                }
                evento.getDestinoRespueta().procesarEvento(eventoRespuesta);
                break;

            case ALTA_TITULO:
                Titulo titulo = (Titulo) evento.getInfo();
                try {
                    biblioteca.altaTitulo(titulo);
                    eventoRespuesta = new Evento(TipoEvento.ALTA_TITULO_OK, titulo);

                } catch (Exception ex) {
                    eventoRespuesta = new Evento(TipoEvento.ALTA_TITULO_ERROR, titulo);
                }
                evento.getDestinoRespueta().procesarEvento(eventoRespuesta);
                break;
            case MODIFICACION_TITULO:
                try {
                    biblioteca.modificacionTitulo((Titulo) evento.getInfo());
                    eventoRespuesta = new Evento(TipoEvento.MODIFICACION_TITULO_OK, (Titulo) evento.getInfo());

                } catch (Exception ex) {
                    eventoRespuesta = new Evento(TipoEvento.MODIFICACION_TITULO_ERROR, (Titulo) evento.getInfo());
                    System.out.println("Error en modificacion de título");
                }
                evento.getDestinoRespueta().procesarEvento(eventoRespuesta);

                break;
            case BAJA_TITULO:

                System.out.println("Controlador BAJA_TITULO");

                try {
                    biblioteca.bajaTitulo(((Titulo) evento.getInfo()).getId());
                    eventoRespuesta = new Evento(TipoEvento.BAJA_TITULO_OK, (Titulo) evento.getInfo());
                } catch (Exception ex) {
                    eventoRespuesta = new Evento(TipoEvento.BAJA_TITULO_ERROR, (Titulo) evento.getInfo());
                }
                evento.getDestinoRespueta().procesarEvento(eventoRespuesta);
        }


    }
    public static final String ELEMENT_TEXT_PROPERTY = "Texto";

    public void changeElementText(String newText) {
        setModelProperty(ELEMENT_TEXT_PROPERTY, newText);
    }

    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setDelegado(GestorEventos gestorEventosDelegado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
