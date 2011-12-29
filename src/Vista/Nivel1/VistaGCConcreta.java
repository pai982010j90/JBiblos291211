/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VistaGCConcreta.java
 *
 * Created on 28-nov-2011, 13:26:44
 */
package Vista.Nivel1;

import Controlador.Controlador;
import Controlador.Evento;
import Controlador.GestorEventos;
import Controlador.TipoEvento;
import HBM.Dewey;
import HBM.TituloId;
import Modelo.CategoriaDewey;
import Modelo.CodDewey;
import Vista.Modelos.BaseTableModelGen;
import Vista.Modelos.GestionarModelo;
import java.util.Collection;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.text.PlainDocument;

/**
 *
 * @author tutto
 */
public class VistaGCConcreta extends javax.swing.JInternalFrame implements GestionarModelo {

    private TituloId tituloId;
    private Controlador controlador;
    private GestorEventos observadorPadre;
    List<Dewey> listaCategoriasDewey;

    /** Creates new form VistaGCConcreta */
    public VistaGCConcreta(GestorEventos padre, Controlador controlador, List<Dewey> listaCategoriasDewey) {
        this.observadorPadre = padre;
        this.controlador = controlador;
        this.listaCategoriasDewey = listaCategoriasDewey;
        initComponents();
        inicializaComponentesPropios();
    }

    private void inicializaComponentesPropios() {
        jComboBoxCategoriasDewey.addItem(new String("Seleccione Categoría"));
        for (Dewey dewey : listaCategoriasDewey) {
            //jComboBoxCategoriasDewey.addItem(dewey.getCategoriaDewey() + " - " + dewey.getNombreCategoriaDewey());
            jComboBoxCategoriasDewey.addItem(dewey);
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

        jLabel1 = new javax.swing.JLabel();
        jComboBoxCategoriasDewey = new javax.swing.JComboBox();
        jTextFieldCodApellido = new javax.swing.JTextField();
        jTextFieldCodTitulo = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        javax.swing.JButton jButtonCancelar = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Buscar título");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/120px-Libro_y_lupa_20.png"))); // NOI18N

        jLabel1.setText("Dewey");

        jComboBoxCategoriasDewey.setModel(new javax.swing.DefaultComboBoxModel());

        jTextFieldCodApellido.setColumns(3);

        jTextFieldCodTitulo.setColumns(3);

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCategoriasDewey, 0, 181, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCodApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCodTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonBuscar)
                        .addGap(33, 33, 33)
                        .addComponent(jButtonCancelar)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonReset)
                        .addGap(57, 57, 57))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxCategoriasDewey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonReset)
                    .addComponent(jButtonBuscar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        jComboBoxCategoriasDewey.setSelectedIndex(0);
        jTextFieldCodApellido.setText("");
        jTextFieldCodTitulo.setText("");
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        // El boton SOLO tiene efecto si TODOS los campos del código dewey están completos
        if (jComboBoxCategoriasDewey.getSelectedIndex() > 0
                && !jTextFieldCodApellido.getText().equals("")
                && !jTextFieldCodTitulo.getText().equals("")) {
            Dewey dewey = (Dewey) jComboBoxCategoriasDewey.getSelectedItem();

            tituloId = new TituloId(dewey.getCategoriaDewey(),
                    jTextFieldCodApellido.getText(), jTextFieldCodTitulo.getText());
            controlador.procesarEvento(new Evento(TipoEvento.CONSULTA_CATALOGO_CONCRETA, tituloId, observadorPadre));
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JComboBox jComboBoxCategoriasDewey;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldCodApellido;
    private javax.swing.JTextField jTextFieldCodTitulo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void fijarModelo(Object tituloId) {
        this.tituloId = (TituloId) tituloId;
    }

    @Override
    public Object obtenerModelo() {
        Dewey dewey = (Dewey) jComboBoxCategoriasDewey.getSelectedItem();
        return new TituloId(dewey.getCategoriaDewey(),
                jTextFieldCodApellido.getText(), jTextFieldCodTitulo.getText());
    }

    @Override
    public void limpiarModelo() {
        jComboBoxCategoriasDewey.setSelectedIndex(0);
        jTextFieldCodApellido.setText("");
        jTextFieldCodTitulo.setText("");
        tituloId = null;
    }

    @Override
    public void setEditable(boolean esEditable) {
        jComboBoxCategoriasDewey.setEnabled(esEditable);
        jTextFieldCodApellido.setEditable(esEditable);
        jTextFieldCodTitulo.setEditable(esEditable);
    }

    @Override
    public void setModo(String modo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fijarModelo(Collection object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BaseTableModelGen obtenerModeloGen() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
