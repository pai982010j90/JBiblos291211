/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VistaGPrincipal.java
 *
 * Created on 23-nov-2011, 21:59:24
 */
package Vista.Nivel0;

import Vista.Nivel1.VistaGGestion;
import Vista.Nivel1.ParametrizadorGestion;
import Vista.Nivel2.VistaGFichaUsuario;
import Vista.Nivel1.VistaGListadoUsuarios;
import Vista.Nivel1.VistaGCGeneral;
import Vista.Nivel1.VAcercaDe;
import Vista.Nivel1.VistaGCConcreta;
import Vista.Nivel2.VistaGFichaTitulo;
import Controlador.Controlador;
import Controlador.Evento;
import Controlador.GestorEventos;
import Controlador.TipoEvento;

import java.beans.PropertyChangeEvent;
import javax.swing.JDesktopPane;

// Pruebas para el nuevo MVC
import Vista2.*;
import Controlador2.*;
import HBM.Autor;
import HBM.Dewey;
import HBM.Idioma6391;
import HBM.Titulo;
import Modelo.Catalogo;
import Modelo.GestorUsuarios;
import Modelo.Usuario;
import Vista.Modelos.AutoresTableModel;
import Vista.Modelos.AutoresTableModelGen;
import Vista.Modelos.CatalogoTableModelGen;
import Vista.Nivel2.VistaGFichaAutor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nanohp
 */
public class VistaGPrincipal extends javax.swing.JFrame implements GestorEventos {

    // Pruebas para el nuevo MVC
    private Panel2Modelo panelPrueba;
    MiControlador controladorV2;

    /** Creates new form VistaGPrincipal */
    public VistaGPrincipal() {
        initComponents();

    }

    /*
     * AÑADIDO PARA JBIBLOS
     */
    private GestorEventos padre;
    private Controlador controlador;
    private Usuario usuario;
    private JDesktopPane jdpDesktop;
    private VistaGFichaUsuario vGPerfilUsuario;
    private VistaGCGeneral vGCGeneral;
    private VistaGCConcreta vGCConcreta;
    private VistaGFichaTitulo vGFichaTitulo;
    private VAcercaDe vAcercaDe;
    private List<Dewey> listaCategoriasDewey;
    private List<Idioma6391> listaIdiomas6391;
    private List<Autor> listaAutores;
    //private VistaGListadoUsuarios vistaGListadoUsuarios;
    private VistaGGestion vistaGGestionCatalogo;
    private VistaGGestion vistaGGestionAutores;
    private Catalogo catalogo;
//1

    public VistaGPrincipal(GestorEventos padre, Controlador controlador, Usuario usuario) {//1
        this.padre = padre;
        this.controlador = controlador;
        this.usuario = usuario;
        controlador.procesarEvento(new Evento(TipoEvento.OBTENER_CAT_DEWEY, null, this));
        controlador.procesarEvento(new Evento(TipoEvento.LISTADO_ISO_639_1, null, this));

        initComponents();
        inicializaComponentesPropios();
    }

    private void inicializaComponentesPropios() {

        String tipoUsuario = usuario.isAdministrador() ? " (Administrador)" : " (Lector)";
        setTitle("JBiblos - " + usuario.getNombre() + tipoUsuario);
        jdpDesktop = new JDesktopPane();
        setContentPane(jdpDesktop);

        vGPerfilUsuario = new VistaGFichaUsuario(controlador);

        jdpDesktop.add(vGPerfilUsuario);

        /* Version antigua de Vista G General. DEPRECATED
        vGCGeneral = new VistaGCGeneral(controlador, listaCategoriasDewey, jdpDesktop, usuario.isAdministrador());
        jdpDesktop.add(vGCGeneral);
         * 
         */

        vGCConcreta = new VistaGCConcreta(this, controlador, listaCategoriasDewey);
        jdpDesktop.add(vGCConcreta);

        vAcercaDe = new VAcercaDe();
        jdpDesktop.add(vAcercaDe);

        //vistaGListadoUsuarios = new VistaGListadoUsuarios();
        //jdpDesktop.add(vistaGListadoUsuarios);

        /*
         * Nueva gestion de CATALOGO general basada en ventana común
         */

        CatalogoTableModelGen catalogoTableModel = new CatalogoTableModelGen(2);
        catalogoTableModel.setEditable(false);

        ParametrizadorGestion parametrosGestionCatalogo = new ParametrizadorGestion("Gestión de Catálogo", catalogoTableModel, TipoEvento.CONSULTA_CATALOGO_GENERAL);

        vGFichaTitulo = new VistaGFichaTitulo(controlador, listaCategoriasDewey, listaIdiomas6391);
        jdpDesktop.add(vGFichaTitulo);

        vistaGGestionCatalogo = new VistaGGestion(controlador, parametrosGestionCatalogo, vGFichaTitulo, usuario.isAdministrador());
        vGFichaTitulo.setDelegado(vistaGGestionCatalogo);
        jdpDesktop.add(vistaGGestionCatalogo);



        /*
         * Nueva gestion de AUTORES basada en ventana común
         */

        AutoresTableModelGen autoresTableModelGen = new AutoresTableModelGen(2);
        autoresTableModelGen.setEditable(false);

        ParametrizadorGestion parametrosGestionAutores = new ParametrizadorGestion("Gestión Autores", autoresTableModelGen, TipoEvento.CONSULTA_AUTORES_GENERAL);


        VistaGFichaAutor vGFichaAutores = new VistaGFichaAutor(controlador);
        jdpDesktop.add(vGFichaAutores);

        vistaGGestionAutores = new VistaGGestion(controlador, parametrosGestionAutores, vGFichaAutores, usuario.isAdministrador());
        vGFichaAutores.setDelegado(vistaGGestionAutores);
        jdpDesktop.add(vistaGGestionAutores);

    }

    public VistaGCGeneral getvGCGeneral() {
        return vGCGeneral;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBarPrincipal = new javax.swing.JMenuBar();
        jMenuPrincipal = new javax.swing.JMenu();
        jMenuItemLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemGestionCatalogo = new javax.swing.JMenuItem();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuItemAutores = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAcercaDe = new javax.swing.JMenuItem();
        jMenuLector = new javax.swing.JMenu();
        jMenuCatalogo = new javax.swing.JMenu();
        jMenuItemLectorCConcreta = new javax.swing.JMenuItem();
        jMenuItemAltaTitulo = new javax.swing.JMenuItem();
        jMenuItemBajaTitulo = new javax.swing.JMenuItem();
        jMenuItemModificarTitulo = new javax.swing.JMenuItem();
        jMenuItemMostrarPerfil = new javax.swing.JMenuItem();
        jMenuUsuarios = new javax.swing.JMenu();
        jMenuItemListadoUsuarios = new javax.swing.JMenuItem();
        jMenuItemUsuariosAlta = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItemUsuariosModificar = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JBiblos - ");

        jMenuPrincipal.setText("Principal");

        jMenuItemLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_logout_20.png"))); // NOI18N
        jMenuItemLogout.setText("Logout");
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoutActionPerformed(evt);
            }
        });
        jMenuPrincipal.add(jMenuItemLogout);
        jMenuPrincipal.add(jSeparator1);

        jMenuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/desconexion-de-salida-icono-7025-20.png"))); // NOI18N
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuPrincipal.add(jMenuItemSalir);

        jMenuBarPrincipal.add(jMenuPrincipal);

        jMenu4.setText("Operaciones");

        jMenuItemGestionCatalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/catalogo_20.png"))); // NOI18N
        jMenuItemGestionCatalogo.setText("Catálogo");
        jMenuItemGestionCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionCatalogoActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemGestionCatalogo);

        jMenuItemUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User_group_20.png"))); // NOI18N
        jMenuItemUsuarios.setText("Usuarios");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemUsuarios);

        jMenuItemAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tinteros-20.png"))); // NOI18N
        jMenuItemAutores.setText("Autores");
        jMenuItemAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAutoresActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemAutores);

        jMenuBarPrincipal.add(jMenu4);

        jMenuAyuda.setText("Ayuda");

        jMenuItemAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/interrogante_20.png"))); // NOI18N
        jMenuItemAcercaDe.setText("A cerca de");
        jMenuItemAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAcercaDeActionPerformed(evt);
            }
        });
        jMenuAyuda.add(jMenuItemAcercaDe);

        jMenuBarPrincipal.add(jMenuAyuda);

        jMenuLector.setText("PROVISIONAL");

        jMenuCatalogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/catalogo_20.png"))); // NOI18N
        jMenuCatalogo.setText("Catálogo");
        jMenuCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCatalogoActionPerformed(evt);
            }
        });

        jMenuItemLectorCConcreta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/120px-Libro_y_lupa_20.png"))); // NOI18N
        jMenuItemLectorCConcreta.setText("Consulta concreta");
        jMenuItemLectorCConcreta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLectorCConcretaActionPerformed(evt);
            }
        });
        jMenuCatalogo.add(jMenuItemLectorCConcreta);

        jMenuItemAltaTitulo.setText("Alta");
        jMenuItemAltaTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAltaTituloActionPerformed(evt);
            }
        });
        jMenuCatalogo.add(jMenuItemAltaTitulo);

        jMenuItemBajaTitulo.setText("Baja");
        jMenuItemBajaTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBajaTituloActionPerformed(evt);
            }
        });
        jMenuCatalogo.add(jMenuItemBajaTitulo);

        jMenuItemModificarTitulo.setText("Modificación");
        jMenuItemModificarTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarTituloActionPerformed(evt);
            }
        });
        jMenuCatalogo.add(jMenuItemModificarTitulo);

        jMenuLector.add(jMenuCatalogo);

        jMenuItemMostrarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User_info_16.png"))); // NOI18N
        jMenuItemMostrarPerfil.setText("Mostrar Perfil");
        jMenuItemMostrarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMostrarPerfilActionPerformed(evt);
            }
        });
        jMenuLector.add(jMenuItemMostrarPerfil);

        jMenuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User_group_20.png"))); // NOI18N
        jMenuUsuarios.setText("Usuarios");
        jMenuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuariosActionPerformed(evt);
            }
        });

        jMenuItemListadoUsuarios.setText("Listado");
        jMenuItemListadoUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoUsuariosActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItemListadoUsuarios);

        jMenuItemUsuariosAlta.setText("Alta");
        jMenuItemUsuariosAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosAltaActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItemUsuariosAlta);

        jMenuItem4.setText("Baja");
        jMenuUsuarios.add(jMenuItem4);

        jMenuItemUsuariosModificar.setText("Modificar");
        jMenuItemUsuariosModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosModificarActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItemUsuariosModificar);

        jMenuLector.add(jMenuUsuarios);

        jMenuItem3.setText("Gestion2");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuLector.add(jMenuItem3);

        jMenuBarPrincipal.add(jMenuLector);

        setJMenuBar(jMenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemMostrarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMostrarPerfilActionPerformed
        vGPerfilUsuario.setModo("mostrar");
        vGPerfilUsuario.fijarModelo(usuario);
        vGPerfilUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItemMostrarPerfilActionPerformed

    private void jMenuItemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAcercaDeActionPerformed
        vAcercaDe.setVisible(true);
    }//GEN-LAST:event_jMenuItemAcercaDeActionPerformed

    private void jMenuItemLectorCConcretaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLectorCConcretaActionPerformed
        vGCConcreta.setVisible(true);
    }//GEN-LAST:event_jMenuItemLectorCConcretaActionPerformed

    private void jMenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoutActionPerformed
        controlador.procesarEvento(new Evento(TipoEvento.LOGOUT, null, this));
    }//GEN-LAST:event_jMenuItemLogoutActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        procesarEvento(new Evento(TipoEvento.SALIR));
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemUsuariosAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosAltaActionPerformed
        vGPerfilUsuario.setModo("alta");
        vGPerfilUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItemUsuariosAltaActionPerformed

    private void jMenuItemUsuariosModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosModificarActionPerformed
        vGPerfilUsuario.fijarModelo(usuario);
        vGPerfilUsuario.setModo("modificar");
        vGPerfilUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItemUsuariosModificarActionPerformed

    private void jMenuItemListadoUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoUsuariosActionPerformed
        Evento evListadoUsuarios = new Evento(TipoEvento.LISTADO_USUARIOS, null, this);
        controlador.procesarEvento(evListadoUsuarios);
        //listadoUsuarios.setVisible(true);

    }//GEN-LAST:event_jMenuItemListadoUsuariosActionPerformed

    private void jMenuItemAltaTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAltaTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemAltaTituloActionPerformed

    private void jMenuItemModificarTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarTituloActionPerformed
        //this.vGCGeneral.setModo("modificar");
        controlador.procesarEvento(new Evento(TipoEvento.CONSULTA_CATALOGO_GENERAL, "modificar", this));

    }//GEN-LAST:event_jMenuItemModificarTituloActionPerformed

private void jMenuItemBajaTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBajaTituloActionPerformed
    controlador.procesarEvento(new Evento(TipoEvento.CONSULTA_CATALOGO_GENERAL, "baja", this));
}//GEN-LAST:event_jMenuItemBajaTituloActionPerformed

private void jMenuCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCatalogoActionPerformed
    controlador.procesarEvento(new Evento(TipoEvento.CONSULTA_CATALOGO_GENERAL, null, this));
}//GEN-LAST:event_jMenuCatalogoActionPerformed

private void jMenuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuariosActionPerformed
}//GEN-LAST:event_jMenuUsuariosActionPerformed

private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
    Evento evListadoUsuarios = new Evento(TipoEvento.LISTADO_USUARIOS, null, this);
    controlador.procesarEvento(evListadoUsuarios);
}//GEN-LAST:event_jMenuItemUsuariosActionPerformed

private void jMenuItemGestionCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionCatalogoActionPerformed
    //controlador.procesarEvento(new Evento(TipoEvento.CONSULTA_CATALOGO_GENERAL, null, this));
    vistaGGestionCatalogo.setVisible(true);
}//GEN-LAST:event_jMenuItemGestionCatalogoActionPerformed

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    System.out.println("jMenuItem3ActionPerformed");
}//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItemAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAutoresActionPerformed
        //controlador.procesarEvento(new Evento(TipoEvento.CONSULTA_AUTORES_GENERAL, null, this));
        vistaGGestionAutores.setVisible(true);
    }//GEN-LAST:event_jMenuItemAutoresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaGPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VistaGPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenu jMenuCatalogo;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemAcercaDe;
    private javax.swing.JMenuItem jMenuItemAltaTitulo;
    private javax.swing.JMenuItem jMenuItemAutores;
    private javax.swing.JMenuItem jMenuItemBajaTitulo;
    private javax.swing.JMenuItem jMenuItemGestionCatalogo;
    private javax.swing.JMenuItem jMenuItemLectorCConcreta;
    private javax.swing.JMenuItem jMenuItemListadoUsuarios;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JMenuItem jMenuItemModificarTitulo;
    private javax.swing.JMenuItem jMenuItemMostrarPerfil;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JMenuItem jMenuItemUsuariosAlta;
    private javax.swing.JMenuItem jMenuItemUsuariosModificar;
    private javax.swing.JMenu jMenuLector;
    private javax.swing.JMenu jMenuPrincipal;
    private javax.swing.JMenu jMenuUsuarios;
    private javax.swing.JPopupMenu.Separator jSeparator1;
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

        switch (evento.getTipoEvento()) {
            case SALIR:
                mensaje = "¿Desea salir realmente?";
                tituloStr = "Salir de JBiblos";
                int respuetaInt;

                // display the JOptionPane showConfirmDialog
                respuetaInt = JOptionPane.showConfirmDialog(null, mensaje, tituloStr, JOptionPane.YES_NO_OPTION);
                if (respuetaInt == JOptionPane.YES_OPTION) {
                    System.out.println("Saliendo");
                    System.exit(0);
                }


                break;
            case LOGOUT:
                mensaje = "¿Desea cerrar la sesión realmente?";
                tituloStr = "Cerra sesión (" + usuario.getDni() + ")";
                // display the JOptionPane showConfirmDialog
                respuetaInt = JOptionPane.showConfirmDialog(null, mensaje, tituloStr, JOptionPane.YES_NO_OPTION);
                if (respuetaInt == JOptionPane.YES_OPTION) {
                    padre.procesarEvento(new Evento(TipoEvento.LOGOUT));
                }

                break;

            case OBTENER_CAT_DEWEY:
                listaCategoriasDewey = (List<Dewey>) evento.getInfo();
                break;

            case LISTADO_ISO_639_1:
                listaIdiomas6391 = (List<Idioma6391>) evento.getInfo();
                break;

            case CONSULTA_AUTORES_GENERAL:
                listaAutores = (List<Autor>) evento.getInfo();
                //vistaGGestionAutores.fijarModelo(listaAutores);
                break;

            case CONSULTA_CATALOGO_GENERAL:


                System.out.println("VistaGPrincipal.procesadorEventos()->CONSULTA_CATALOGO_GENERAL");
                try {
                    catalogo = (Catalogo) evento.getInfo();
                    //vistaGGestionCatalogo.fijarModelo(catalogo.getCatalogo().values());
                } catch (NullPointerException ex) {
                    //Logger.getLogger(VistaGPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println("ERROR: Catalogo vacio: evento:" + ex);
                    //eventoAux = new Evento(TipoEvento.ERROR);
                    ex.printStackTrace();

                } catch (Exception ex) {
                    Logger.getLogger(VistaGPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    //System.err.println("ERROR");
                    //eventoAux = new Evento(TipoEvento.ERROR);
                }
                break;

            case CONSULTA_CATALOGO_CONCRETA:

                System.out.println("CONSULTA_CATALOGO_CONCRETA");
                try {

                    Titulo titulo = (Titulo) evento.getInfo();
                    if (titulo == null) {
                        JOptionPane.showMessageDialog(this,
                                "Fallo en la consulta de un titulo",
                                "Error de consulta",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        vGFichaTitulo.fijarModelo(titulo);
                        vGCConcreta.setVisible(false);
                        vGFichaTitulo.setEditable(false);
                        vGFichaTitulo.setVisible(true);
                    }


                } catch (NullPointerException ex) {
                    //Logger.getLogger(VistaGPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println("ERROR: Catalogo vacio: evento:" + ex);
                    //eventoAux = new Evento(TipoEvento.ERROR);
                    ex.printStackTrace();

                } catch (Exception ex) {
                    Logger.getLogger(VistaGPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    //System.err.println("ERROR");
                    //eventoAux = new Evento(TipoEvento.ERROR);
                }
                break;
            case LISTADO_USUARIOS:
                System.out.println("LISTADO_USUARIOS");
                try {

                    GestorUsuarios gestorUsuarios = (GestorUsuarios) evento.getInfo();
                    // vistaGListadoUsuarios.fijarModelo(gestorUsuarios);
                    // vistaGListadoUsuarios.setEditable(false);
                    // vistaGListadoUsuarios.setVisible(true);

                } catch (NullPointerException ex) {
                    //Logger.getLogger(VistaGPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println("ERROR: Listado de Usuario: evento:" + ex);
                    //eventoAux = new Evento(TipoEvento.ERROR);
                    ex.printStackTrace();

                } catch (Exception ex) {
                    Logger.getLogger(VistaGPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    //System.err.println("ERROR");
                    //eventoAux = new Evento(TipoEvento.ERROR);
                }
                break;

            case LISTADO_USUARIOS_ERROR:
                JOptionPane.showMessageDialog(this,
                        "Error en la peticion de lista de usuarios",
                        "Error en listado usuarios",
                        JOptionPane.ERROR_MESSAGE);
                break;


        }
    }

    @Override
    public void setDelegado(GestorEventos gestorEventosDelegado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
