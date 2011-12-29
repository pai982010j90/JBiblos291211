/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VistaGCGeneral.java
 *
 * Created on 23-nov-2011, 23:27:34
 */
package Vista.Nivel1;

import Vista.Modelos.BaseTableModelGen;
import Vista.Nivel2.VistaGFichaTitulo;
import Controlador.Controlador;
import Controlador.Evento;
import Controlador.GestorEventos;
import Controlador.TipoEvento;
import HBM.Autor;
import HBM.Dewey;
import HBM.Titulo;
import HBM.TituloId;
import Modelo.Catalogo;
import Vista.Modelos.GestionarModelo;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author nanohp
 */
public class VistaGCGeneral extends javax.swing.JInternalFrame implements GestionarModelo, GestorEventos {

    VistaGFichaTitulo vGFichaTitulo;
    CatalogoTableModel catalogoTableModel;
    List<Dewey> listaCategoriasDewey;
    private JDesktopPane jDesktopPane;
    private Controlador controlador;
    boolean administrador;

    /** Creates new form VistaGCGeneral */
    public VistaGCGeneral(Controlador controlador, List<Dewey> listaCategoriasDewey, JDesktopPane jDesktopPane, boolean administrador) {
        this.listaCategoriasDewey = listaCategoriasDewey;
        this.jDesktopPane = jDesktopPane;
        this.controlador = controlador;
        this.administrador = administrador;

        initComponents();
        inicializaComponentesPropios();
    }

    private void inicializaComponentesPropios() {
        vGFichaTitulo = new VistaGFichaTitulo(controlador, listaCategoriasDewey);
        jDesktopPane.add(vGFichaTitulo);

        /* Controla la visibildad del boton para altas de titulo
         * depediendo de si el usuario es administrador o no
         */
        if (administrador) {
            jButtonNuevoTitulo.setVisible(true);
        } else {
            jButtonNuevoTitulo.setVisible(false);
        }



    }

    @Override
    public void setVisible(boolean visible) {

        super.setVisible(visible);
        ocultaBotonesAccion();
    }

    public void ocultaBotonesAccion() {
        try {

            jButtonMostrarFicha.setVisible(false);
            jButtonModificarTitulo.setVisible(false);
            jButtonBajaTitulo.setVisible(false);
        } catch (NullPointerException e) {
            System.err.println("Error en ocultaBotonesAccion");
        }
    }

    // Implementacion de los metodos de 'GestionarModelo'
    @Override
    public void fijarModelo(Object object) {
        assert (object.getClass().getName().endsWith(".Catalogo")) : "fijarModelo: clase suminastrada invalida";

        catalogoTableModel = new CatalogoTableModel((Catalogo) object);
        jTableCatalogo.setModel(catalogoTableModel);
        jTableCatalogo.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

    }

    @Override
    public CatalogoTableModel obtenerModelo() {
        return catalogoTableModel;
    }

    @Override
    public void limpiarModelo() {
        catalogoTableModel = null;
    }

    @Override
    public void setEditable(boolean esEditable) {
        catalogoTableModel.setEditable(esEditable);
    }

    @Override
    public void setModo(String modo) {
        //this.modo = modo;

        if (modo.equals("mostrar")) {
            //setTitle("Consulta título");
            setEditable(false);
            this.jButtonModificarTitulo.setEnabled(true);
            this.jButtonMostrarFicha.setEnabled(true);
        } else if (modo.equals("modificar")) {
            //setTitle("Consulta título");
            setEditable(false);
            this.jButtonModificarTitulo.setEnabled(true);
            this.jButtonMostrarFicha.setEnabled(true);
        } else if (modo.equals("baja")) {

            setEditable(false);
            this.jButtonBajaTitulo.setEnabled(true);
            this.jButtonModificarTitulo.setEnabled(false);

        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCatalogo = new javax.swing.JTable();
        jButtonAceptar = new javax.swing.JButton();
        jButtonMostrarFicha = new javax.swing.JButton();
        jButtonModificarTitulo = new javax.swing.JButton();
        jButtonBajaTitulo = new javax.swing.JButton();
        jButtonNuevoTitulo = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Catálogo general");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/catalogo_20.png"))); // NOI18N

        jTableCatalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableCatalogo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCatalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCatalogoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCatalogo);

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escuchadorAceptar(evt);
            }
        });

        jButtonMostrarFicha.setText("Mostrar ficha");
        jButtonMostrarFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarFichaActionPerformed(evt);
            }
        });

        jButtonModificarTitulo.setText("Modificar");
        jButtonModificarTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarTituloActionPerformed(evt);
            }
        });

        jButtonBajaTitulo.setText("Baja título");
        jButtonBajaTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBajaTituloActionPerformed(evt);
            }
        });

        jButtonNuevoTitulo.setText("Nuevo");
        jButtonNuevoTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoTituloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jButtonAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonMostrarFicha)
                        .addGap(23, 23, 23)
                        .addComponent(jButtonNuevoTitulo)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModificarTitulo)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBajaTitulo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonMostrarFicha)
                    .addComponent(jButtonBajaTitulo)
                    .addComponent(jButtonModificarTitulo)
                    .addComponent(jButtonNuevoTitulo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void escuchadorAceptar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escuchadorAceptar
        setVisible(false);
    }//GEN-LAST:event_escuchadorAceptar

    private void jTableCatalogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCatalogoMouseClicked
        int pos = jTableCatalogo.getSelectedRow();
        boolean visible = pos > -1 ? true : false;
        jButtonMostrarFicha.setVisible(visible);

        if (administrador) {
            jButtonModificarTitulo.setVisible(visible);
            jButtonBajaTitulo.setVisible(visible);
        }
    }//GEN-LAST:event_jTableCatalogoMouseClicked

    private void jButtonMostrarFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarFichaActionPerformed
        int filaSeleccionada = jTableCatalogo.getSelectedRow();
        System.out.println(filaSeleccionada);
        if (filaSeleccionada > -1) {
            System.out.println("--:" + catalogoTableModel.getTitulo(filaSeleccionada));
            vGFichaTitulo.fijarModelo(catalogoTableModel.getTitulo(filaSeleccionada));
            vGFichaTitulo.setModo("mostrar");
            vGFichaTitulo.setVisible(true);
        }

    }//GEN-LAST:event_jButtonMostrarFichaActionPerformed

    private void jButtonModificarTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarTituloActionPerformed
        int filaSeleccionada = jTableCatalogo.getSelectedRow();
        System.out.println(filaSeleccionada);
        if (filaSeleccionada > -1) {
            System.out.println("--:" + catalogoTableModel.getTitulo(filaSeleccionada));
            vGFichaTitulo.fijarModelo(catalogoTableModel.getTitulo(filaSeleccionada));
            vGFichaTitulo.setModo("modificar");

            vGFichaTitulo.setVisible(true);
        }
    }//GEN-LAST:event_jButtonModificarTituloActionPerformed

private void jButtonBajaTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBajaTituloActionPerformed
    int filaSeleccionada = jTableCatalogo.getSelectedRow();

    Titulo titulo = catalogoTableModel.getTitulo(filaSeleccionada);
    String mensaje = "¿Desea borrar el título?";
    TituloId tituloId = titulo.getId();
    String tituloStr = "Borrado de título: " + tituloId.getDeweyCategoriaDewey() + "-" + tituloId.getIdApellido() + "-" + tituloId.getIdTitulo();

    int respuetaInt = JOptionPane.showConfirmDialog(null, mensaje, tituloStr, JOptionPane.YES_NO_OPTION);
    if (respuetaInt == JOptionPane.YES_OPTION) {
        Evento evento = new Evento(TipoEvento.BAJA_TITULO, titulo.getId(), this);
        controlador.procesarEvento(evento);
    }
}//GEN-LAST:event_jButtonBajaTituloActionPerformed

private void jButtonNuevoTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoTituloActionPerformed
    System.out.println("Nuevo Titulo");
}//GEN-LAST:event_jButtonNuevoTituloActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonBajaTitulo;
    private javax.swing.JButton jButtonModificarTitulo;
    private javax.swing.JButton jButtonMostrarFicha;
    private javax.swing.JButton jButtonNuevoTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCatalogo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void procesarEvento(Evento evento) {
        Evento eventoAux = null;
        String mensaje;
        String tituloStr;
        TipoEvento tipoEvento = evento.getTipoEvento();
        TituloId tituloId = null;

        switch (tipoEvento) {

            case BAJA_TITULO_OK:
                tituloId = (TituloId) evento.getInfo();
                JOptionPane.showMessageDialog(this,
                        "Baja de título correcta",
                        "Baja de titulo: " + tituloId.getDeweyCategoriaDewey() + "-" + tituloId.getIdApellido() + "-" + tituloId.getIdTitulo(),
                        JOptionPane.INFORMATION_MESSAGE);
                catalogoTableModel.borrarTitulo(tituloId);
                break;
            case BAJA_TITULO_ERROR:
                tituloId = (TituloId) evento.getInfo();
                JOptionPane.showMessageDialog(this,
                        "Error en baja de título",
                        "Baja de titulo: " + tituloId.getDeweyCategoriaDewey() + "-" + tituloId.getIdApellido() + "-" + tituloId.getIdTitulo(),
                        JOptionPane.ERROR_MESSAGE);
                break;
            default:
                throw new AssertionError(tipoEvento + ": Evento no controlado");
        }
    }

    @Override
    public void fijarModelo(Collection object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BaseTableModelGen obtenerModeloGen() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    class CatalogoTableModel extends DefaultTableModel {

        Catalogo catalogo;
        boolean editable = true;
        Object[] encabezado = {"Código", "Nombre", "Idioma", "Autor"};
        //private Collection<Titulo> titulos;
        private ArrayList<Titulo> listaTitulos = new ArrayList<Titulo>();
        private Map<TituloId, Integer> tituloId2NumFila = new HashMap<TituloId, Integer>();

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

        public void addTitulo(Titulo titulo) {
            //titulos.add(titulo);
            listaTitulos.add(titulo);
        }

        public Titulo getTitulo(int pos) {
            return listaTitulos.get(pos);
        }

        public boolean isEditable() {
            return editable;
        }

        public void setEditable(boolean editable) {
            System.out.println("editable:" + editable);
            this.editable = editable;
        }

        private void borrarTitulo(TituloId tituloId) {
            //System.out.println(tituloId+" - borrador en la lista");
            removeRow(tituloId2NumFila.get(tituloId));
        }
    }

}