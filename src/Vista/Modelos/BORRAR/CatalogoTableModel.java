/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelos.BORRAR;

import Vista.Modelos.BORRAR.BaseTableModel;
import HBM.Autor;
import HBM.Titulo;
import HBM.TituloId;
import Modelo.Catalogo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author manu
 */
public class CatalogoTableModel extends BaseTableModel {

    Catalogo catalogo;
    Object[] encabezado = {"Código", "Nombre", "Idioma", "Autor"};
    //private Collection<Titulo> titulos;
    private ArrayList<Titulo> listaTitulos = new ArrayList<Titulo>();
    private Map<TituloId, Integer> tituloId2NumFila = new HashMap<TituloId, Integer>();

    public CatalogoTableModel(int filas) {
        super();

        Object data[][] = new Object[filas][encabezado.length];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < encabezado.length; j++) {
                data[i][j] = null;
            }
        }

        setDataVector(data, encabezado);
    }

    public CatalogoTableModel(Catalogo catalogo) {
        super();
        this.catalogo = catalogo;
        Collection<Titulo> titulos = catalogo.getCatalogo().values();
        Object data[][] = new Object[titulos.size()][encabezado.length];

        int i = 0;
        for (Titulo titulo : titulos) {
            int j = 0;
            // Extraemos los apellidos
            data[i][j++] = titulo.getId().getDeweyCategoriaDewey() + "-" + titulo.getId().getIdApellido() + "-" + titulo.getId().getIdTitulo();
            data[i][j++] = titulo.getNombreTitulo();
            data[i][j++] = WordUtils.capitalizeFully(titulo.getIdioma6391().getIdioma6391());
            Set<Autor> autores = titulo.getAutors();
            Iterator<Autor> it = autores.iterator();
            int numAutores = autores.size();
            String autoresStr = "";
            if (numAutores > 0) {
                Autor autor = it.next();
                autoresStr = autor.getApellido1Autor() + ", " + autor.getNombreAutor();
                if (numAutores > 1) {
                    autoresStr += " ...";
                }
            } else {
                autoresStr = "Sin autor";
            }

            data[i][j++] = autoresStr;

            listaTitulos.add(titulo);
            // Asocio con el mapa tituloId - numero de fila en la que se encuentra en la tabla
            tituloId2NumFila.put(titulo.getId(), i);
            i++;
        }
        setDataVector(data, encabezado);
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (!editable) {
            return false;
        } else {
            return super.isCellEditable(rowIndex, columnIndex);
        }
    }

    public void addInfo(Object titulo) {
        //titulos.add(titulo);
        listaTitulos.add((Titulo) titulo);
    }

    public Object getInfo(int pos) {
        return listaTitulos.get(pos);
    }

    @Override
    public void borrarInfo(Object titulo) {
        TituloId tituloId = ((Titulo) titulo).getId();

        removeRow(tituloId2NumFila.get(tituloId));
    }

    @Override
    public void initModel(Object catalogo) {
        Collection<Titulo> titulos = ((Catalogo) catalogo).getCatalogo().values();
        Object data[][] = new Object[titulos.size()][encabezado.length];

        int i = 0;
        for (Titulo titulo : titulos) {
            int j = 0;
            // Extraemos los apellidos
            data[i][j++] = titulo.getId().getDeweyCategoriaDewey() + "-" + titulo.getId().getIdApellido() + "-" + titulo.getId().getIdTitulo();
            data[i][j++] = titulo.getNombreTitulo();
            data[i][j++] = WordUtils.capitalizeFully(titulo.getIdioma6391().getIdioma6391());
            Set<Autor> autores = titulo.getAutors();
            Iterator<Autor> it = autores.iterator();
            int numAutores = autores.size();
            String autoresStr = "";
            if (numAutores > 0) {
                Autor autor = it.next();
                autoresStr = autor.getApellido1Autor() + ", " + autor.getNombreAutor();
                if (numAutores > 1) {
                    autoresStr += " ...";
                }
            } else {
                autoresStr = "Sin autor";
            }

            data[i][j++] = autoresStr;

            listaTitulos.add(titulo);
            // Asocio con el mapa tituloId - numero de fila en la que se encuentra en la tabla
            tituloId2NumFila.put(titulo.getId(), i);
            i++;
        }
        setDataVector(data, encabezado);
    }
}
