/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Nivel1;

import Controlador.TipoEvento;
import Vista.Modelos.BORRAR.BaseTableModel;
import Vista.Modelos.BaseTableModelGen;

/**
 *
 * @author manu
 */
public class ParametrizadorGestion {

    private String titulo;
    private BaseTableModelGen modeloTablaGen;
    private TipoEvento consultaGeneral;

    public ParametrizadorGestion(String titulo, BaseTableModelGen modeloTabla, TipoEvento consultaGeneral) {
        this.titulo = titulo;
        this.modeloTablaGen = modeloTabla;
        this.consultaGeneral = consultaGeneral;
    }

    public BaseTableModelGen getBaseTableModelGen() {
        return modeloTablaGen;
    }

    public String getTitulo() {
        return titulo;
    }

    public TipoEvento getConsultaGeneral() {
        return consultaGeneral;
    }
}
