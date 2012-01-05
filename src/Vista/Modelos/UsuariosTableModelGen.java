/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Modelos;

import Modelo.Usuario;
import java.util.Collection;

/**
 *
 * @author nanohp
 */
public class UsuariosTableModelGen extends BaseTableModelGen {

    public UsuariosTableModelGen(int filas) {
        Object[] encabezadoCatalogo = {"Código", "Nombre", "Idioma", "Autor","Admin"};
        initModel(encabezadoCatalogo, filas);
    }

    @Override
    public void initModel(Collection modelo) {
        Collection<Usuario> elementos = (Collection<Usuario>) modelo;
        data = new Object[modelo.size()][encabezado.length];

        int i = 0;
        for (Usuario elemento : elementos) {
            int j = 0;
            // Extraemos los apellidos
            String dniZeroFill = String.format("%08d", elemento.getDni());

            data[i][j++] = dniZeroFill;
            data[i][j++] = elemento.getApellido1();
            data[i][j++] = elemento.getApellido2() == null ? "" : elemento.getApellido2();
            data[i][j++] = elemento.getNombre();
            data[i][j++] = elemento.isAdministrador() ? Boolean.TRUE : Boolean.FALSE;

            addElemento(elemento);

            i++;
        }
        setDataVector(data, encabezado);
    }
}
