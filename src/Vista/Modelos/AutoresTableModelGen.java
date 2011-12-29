/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelos;

import HBM.Autor;
import java.util.Collection;

/**
 *
 * @author nanohp
 */
public class AutoresTableModelGen<E> extends BaseTableModelGen {

    public AutoresTableModelGen(int filas) {
        Object[] encabezadoAutores = {"Id", "Nombre", "Apellido 1", "Apellido 2"};
        initModel(encabezadoAutores, filas);
    }

    @Override
    public void initModel(Collection objAutores) {
        Collection<Autor> autores = (Collection<Autor>) objAutores;
        Object data[][] = new Object[objAutores.size()][encabezado.length];

        int i = 0;
        for (Autor autor : autores) {
            int j = 0;
            // Extraemos los apellidos
            data[i][j++] = autor.getIdAutor();
            data[i][j++] = autor.getNombreAutor();
            data[i][j++] = autor.getApellido1Autor();
            data[i][j++] = autor.getApellido2Autor();

            addElemento(autor);
            i++;
        }
        setDataVector(data, encabezado);
    }
}
