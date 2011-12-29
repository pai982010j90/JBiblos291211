/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelos;

import HBM.Autor;
import HBM.Titulo;
import Modelo.Catalogo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author manu
 */
public class CatalogoTableModelGen<E> extends BaseTableModelGen {

    public CatalogoTableModelGen(int filas) { 
        Object[] encabezadoCatalogo = {"Código", "Nombre", "Idioma", "Autor"};
        initModel(encabezadoCatalogo, filas);
    }

    @Override
    public void initModel(Collection objTitulos) {
        Collection<Titulo> titulos = (Collection<Titulo>) objTitulos;
        Object data[][] = new Object[objTitulos.size()][encabezado.length];

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

            addElemento(titulo);
            
            i++;
        }
        setDataVector(data, encabezado);
    }
}
