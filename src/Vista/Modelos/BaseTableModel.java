/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelos;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manu
 */
public abstract class BaseTableModel extends DefaultTableModel {

    protected boolean editable = true;
    

    abstract public void addInfo(Object titulo);

    abstract public Object getInfo(int pos);
    abstract public void borrarInfo(Object elemento);

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    public abstract void initModel(Object modelo);
    
    
}
