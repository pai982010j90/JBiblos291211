/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Nivel2;

import Controlador.GestorEventos;
import Vista.Modelos.GestionarModelo;

/**
 *
 * @author manu
 */
public abstract class FichaGBase extends javax.swing.JInternalFrame implements GestionarModelo, GestorEventos{
    private GestorEventos delegado;

    public GestorEventos getDelegado() {
        return delegado;
    }

    @Override
    public void setDelegado(GestorEventos delegado) {
        this.delegado = delegado;
    }
    
}
