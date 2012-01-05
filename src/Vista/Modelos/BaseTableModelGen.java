/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelos;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manu
 */
public abstract class BaseTableModelGen<E> extends DefaultTableModel {

    private boolean DEBUG = true;
    protected boolean editable = true;
    protected ArrayList<E> listaObjetos = new ArrayList<E>();
    protected Object[] encabezado;
    protected Object[][] data;

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

    /*
    public void modifyElemento(E elemento) {
    int pos = listaObjetos.indexOf(elemento);
    listaObjetos.set(pos, elemento);
    TableModelEvent evento = new TableModelEvent(this, pos);
    //this.newDataAvailable(evento);
    fireTableChanged(evento);
    
    }*/
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    /*
     * Don't need to implement this method unless your table's
     * editable.
     */

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

        data = new Object[numFilasVacias][encabezado.length];

        for (int i = 0; i < numFilasVacias; i++) {
            for (int j = 0; j < encabezado.length; j++) {
                data[i][j] = null;
            }
        }
        setDataVector(data, encabezado);
    }
    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */

    @Override
    public Class getColumnClass(int c) {
        Class clase = null;
        System.err.println("getColumnClass:" + c);
        if (getValueAt(0, c) != null) {
            clase = getValueAt(0, c).getClass();
        }
        return clase;
    }
    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (DEBUG) {
            System.out.println("Setting value at " + row + "," + col
                    + " to " + value
                    + " (an instance of "
                    + value.getClass() + ")");
        }

        data[row][col] = value;
        fireTableCellUpdated(row, col);

        if (DEBUG) {
            System.out.println("New value of data:");
            printDebugData();
        }
    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();

        for (int i = 0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j = 0; j < numCols; j++) {
                System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /*
     * Rellenar modelo de la tabla con encabezdo y datos
     */
    public abstract void initModel(Collection modelo);

    public Object[] getEncabezado() {
        return encabezado;
    }
}
