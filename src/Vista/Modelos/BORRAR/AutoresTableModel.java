package Vista.Modelos.BORRAR;

import HBM.Autor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author manu
 */
public class AutoresTableModel extends BaseTableModel {

    Object[] encabezado = {"Id", "Nombre", "Apellido 1", "Apellido 2"};
    //private Collection<Titulo> titulos;
    //REVISARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
    private ArrayList<Autor> listaAutores = new ArrayList<Autor>();
    private Map<Autor, Integer> autoresId2NumFila = new HashMap<Autor, Integer>();

    public AutoresTableModel(int filas) {
        super();

        Object data[][] = new Object[filas][encabezado.length];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < encabezado.length; j++) {
                data[i][j] = null;
            }
        }

        setDataVector(data, encabezado);
    }

    public AutoresTableModel(Collection<Autor> autores) {
        super();
        Object data[][] = new Object[autores.size()][encabezado.length];

        int i = 0;
        for (Autor autor : autores) {
            int j = 0;
            // Extraemos los apellidos
            data[i][j++] = autor.getIdAutor();
            data[i][j++] = autor.getNombreAutor();
            data[i][j++] = autor.getApellido1Autor();
            data[i][j++] = autor.getApellido2Autor();

            listaAutores.add(autor);
            // Asocio con el mapa tituloId - numero de fila en la que se encuentra en la tabla
            autoresId2NumFila.put(autor, i);
            i++;
        }
        setDataVector(data, encabezado);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (!editable) {
            return false;
        } else {
            return super.isCellEditable(rowIndex, columnIndex);
        }
    }

    @Override
    public void addInfo(Object autor) {
        listaAutores.add((Autor) autor);
    }

    @Override
    public Object getInfo(int pos) {
        return listaAutores.get(pos);
    }

    @Override
    public void borrarInfo(Object autor) {
        removeRow(
                autoresId2NumFila.get((Autor) autor));
    }

    @Override
    public void initModel(Object autores) {
        Collection<Autor> coleccionAutores = (Collection) autores;
        Object data[][] = new Object[coleccionAutores.size()][encabezado.length];

        int i = 0;
        for (Autor autor : coleccionAutores) {
            int j = 0;
            // Extraemos los apellidos
            data[i][j++] = autor.getIdAutor();
            data[i][j++] = autor.getNombreAutor();
            data[i][j++] = autor.getApellido1Autor();
            data[i][j++] = autor.getApellido2Autor();


            listaAutores.add(autor);
            // Asocio con el mapa tituloId - numero de fila en la que se encuentra en la tabla
            autoresId2NumFila.put(autor, i);
            i++;
        }
        setDataVector(data, encabezado);
    }
}
