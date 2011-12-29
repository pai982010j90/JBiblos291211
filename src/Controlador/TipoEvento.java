/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author nanohp
 */
//2 lista de valores posibles.
public enum TipoEvento {

    FIJAR_LYL("Fijar Look And Feel"),
    OBTENER_CAT_DEWEY("Obtener lista categorias Dewey"),
    SALIR("Salir"),
    LOGIN("Login"),
    LOGIN_OK("Login OK"),
    LOGIN_FALLO("Login Fallo"),
    ERROR("Mensaje de Error"),
    LOGOUT("Logout"),
    CONSULTA_GENERAL("Consulta general"),
    CONSULTA_CATALOGO_GENERAL("Consulta catálogo general"),
    CONSULTA_CATALOGO_CONCRETA("Consulta catálogo concreta"),
    /*2 */ LISTADO_USUARIOS("Listado de usuarios"),
    LISTADO_USUARIOS_ERROR("Listado de usuarios"),
    ALTA_USUARIO("Alta de Usuario"),
    ALTA_USUARIO_OK("Alta de Usuari ok"),
    ALTA_USUARIO_ERROR("Alta de Usuario error"),
    BAJA_USUARIO("Baja de Usuario"),
    BAJA_USUARIO_OK("Baja de Usuari ok"),
    BAJA_USUARIO_ERROR("Baja de Usuario error"),
    MODIFICACION_USUARIO("Modificacion de Usuario"),
    MODIFICACION_USUARIO_OK("Modificacion de Usuari ok"),
    MODIFICACION_USUARIO_ERROR("Modificacion de Usuario error"),
    ALTA_TITULO("Alta de título"),
    ALTA_TITULO_OK("Alta de título correcta"),
    ALTA_TITULO_ERROR("Alta de título, ERROR"),
    MODIFICACION_TITULO("Modificación de título"),
    MODIFICACION_TITULO_OK("Modificación de título correcto"),
    MODIFICACION_TITULO_ERROR("Modificación de título, ERROR"),
    BAJA_TITULO("Baja de título"),
    BAJA_TITULO_OK("Baja título, Ok"),
    BAJA_TITULO_ERROR("Error en Baja de título"),
    CONSULTA_AUTORES_GENERAL("Consulta catálogo general"),
    ALTA_AUTOR("Alta de autor"),
    ALTA_AUTOR_OK("Alta de autor correcta"),
    ALTA_AUTOR_ERROR("Alta de autor, ERROR"),
    MODIFICACION_AUTOR("Modificación de autor"),
    MODIFICACION_AUTOR_OK("Modificación de autor correcto"),
    MODIFICACION_AUTOR_ERROR("Modificación de autor, ERROR"),
    BAJA_AUTOR("Baja de autor"),
    BAJA_AUTOR_OK("Baja autor, Ok"),
    BAJA_AUTOR_ERROR("Error en Baja de autor"),
    LISTADO_ISO_639_1("Consulta listado ISO 639_1"),
    ALTA_ELEMENTO_OK("Alta genérica correcta"),
    BAJA_ELEMENTO_OK("Baja genérica correcta"),
    MODIFICACION_ELEMENTO_OK("Modificación genérica correcta");
    private String tipoEvento;

    private TipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }
}
