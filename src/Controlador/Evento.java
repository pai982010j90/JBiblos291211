/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author nanohp
 */
public class Evento {

    TipoEvento tipoEvento;
    Object info;
    GestorEventos destinoRespueta;
    TipoEvento tipoEventoRespuesta;

    public Evento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Evento(TipoEvento tipoEvento, Object info) {
        this.tipoEvento = tipoEvento;
        this.info = info;
    }

    public Evento(TipoEvento tipoEvento, Object info, GestorEventos destinoRespueta) {
        this.tipoEvento = tipoEvento;
        this.info = info;
        this.destinoRespueta = destinoRespueta;
    }
    
    public Evento(TipoEvento tipoEvento, Object info, GestorEventos destinoRespueta, TipoEvento tipoEventoRespuesta) {
        this.tipoEvento = tipoEvento;
        this.info = info;
        this.destinoRespueta = destinoRespueta;
        this.tipoEventoRespuesta = tipoEventoRespuesta;
    }    

    public Object getInfo() {
        return info;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public GestorEventos getDestinoRespueta() {
        return destinoRespueta;
    }

    public TipoEvento getTipoEventoRespuesta() {
        return tipoEventoRespuesta;
    }

    public void setTipoEventoRespuesta(TipoEvento tipoEventoRespuesta) {
        this.tipoEventoRespuesta = tipoEventoRespuesta;
    }
    
}
