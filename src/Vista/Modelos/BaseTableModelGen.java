/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelos;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manu
 */
public abstract class BaseTableModelGen<E> extends DefaultTableModel {

    protected boolean editable = true;
    protected ArrayList<E> listaObjetos = new ArrayList<E>();
    protected Object[] encabezado;

    public BaseTableModelGen() {
        super();
    }

    public void addElemento(E elemento) {
        listaObjetos.add(elemento);
    }

    public E getElemento(int pos) {
        return listaObjetos.get(pos);
    }

    public int getPos(E elemento) {
        return listaObjetos.indexOf(elemento);
    }

    public void borrarElemento(E elemento) {
        removeRow(listaObjetos.indexOf(elemento));
    }

    public void modifyElemento(E elemento) {
        int pos = listaObjetos.indexOf(elemento);
        listaObjetos.set(pos, elemento);
        TableModelEvent evento = new TableModelEvent(this, pos);
        //this.newDataAvailable(evento);
        fireTableChanged(evento);
        
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (!editable) {
            return false;
        } else {
            return super.isCellEditable(rowIndex, columnIndex);
        }
    }

    /*
     * Rellenar modelo de la tabla SOLO con encabezdo
     */
    public void initModel(Object[] encabezado, int numFilasVacias) {
        this.encabezado = encabezado;

        Object data[][] = new Object[numFilasVacias][encabezado.length];

        for (int i = 0; i < numFilasVacias; i++) {
            for (int j = 0; j < encabezado.length; j++) {
                data[i][j] = null;
            }
        }
        setDataVector(data, encabezado);
    }

    /*
     * Rellenar modelo de la tabla con encabezdo y datos
     */
    public abstract void initModel(Collection modelo);

    public Object[] getEncabezado() {
        return encabezado;
    }
}
