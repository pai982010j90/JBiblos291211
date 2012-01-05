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


        if (objAutores != null && objAutores.size() > 0) {

            Collection<Autor> autores = (Collection<Autor>) objAutores;

            data = new Object[objAutores.size()][encabezado.length];

            int i = 0;
            for (Autor autor : autores) {
                int j = 0;
                // Extraemos los apellidos
                data[i][j++] = autor.getIdAutor() == null ? "" : autor.getIdAutor();
                data[i][j++] = autor.getNombreAutor() == null ? "" : autor.getNombreAutor();
                data[i][j++] = autor.getApellido1Autor() == null ? "" : autor.getApellido1Autor();
                System.out.println("autor.getApellido2Autor():" + autor.getApellido2Autor());
                data[i][j++] = autor.getApellido2Autor() == null ? "" : autor.getApellido2Autor();

                addElemento(autor);
                i++;
            }
            setDataVector(data, encabezado);
        } else {
            data = new Object[objAutores.size()][encabezado.length];
            int k=0;
            data[0][k++]="";
            data[0][k++]="";
            data[0][k++]="";
            data[0][k++]="";

        }


    }
}
