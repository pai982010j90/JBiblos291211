/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelos;

import java.util.Collection;

/**
 *
 * @author nanohp
 */
public interface GestionarModelo {

    public void fijarModelo(Object object);
    public void fijarModelo(Collection object);

    public Object obtenerModelo();
    public BaseTableModelGen obtenerModeloGen();

    public void limpiarModelo();

    public void setEditable(boolean setEditable);

    public void setModo(String modo);
}
