/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uva.ipc.vista;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import raven.toast.Notifications;
import uva.ipc.modelo.*;

/**
 * @author Daniel Garcia Solla
 * @author Carolina de las Heras Clavier
 */
public class VistaMisViajes extends javax.swing.JFrame {

    private ControladorMisViajes controlador;
    private DefaultListModel<Billete> billetesListModel = new DefaultListModel<>();
    private DefaultListModel<Viaje> viajesListModel = new DefaultListModel<>();

    /**
     * Creates new form MainFrame
     */
    public VistaMisViajes() {
        UIManager.put("Panel.background", new Color(249, 255, 255));
        FlatLaf.setup(new FlatArcOrangeIJTheme());

        this.setIconImage(new ImageIcon("src/main/resources/Tarjetacyl.png").getImage());
        initComponents();
        this.setLocationRelativeTo(null);//Para que no aparezca a arriba a la izquierda
        this.controlador = new ControladorMisViajes(this);
        setMinimumSize(new Dimension(650, 700));

        styleButtons();
        Notifications.getInstance().setJFrame(this);
        rutasList.setModel(viajesListModel);
        rutasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        billetesList.setModel(billetesListModel);
        billetesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        actualizarBilletes();
        activarVistaMisBilletes();
    }

    /**
     * Aplica un estilo específico a una serie de botones.
     */
    public void styleButtons() {
        styleButton(devolverButton);
        styleButton(editarButton);
        styleButton(confirmarButton);
        styleButton(inicioButton);
        styleButton(inicioButton1);
        Utiles.setObjectIcon(imagenBiciLabel, "src/main/resources/Bicicleta.png");
        Utiles.setObjectIcon(imagenMascotaLabel, "src/main/resources/Mascota.png");
    }

    /**
     * Aplica un estilo personalizado a un botón.
     *
     * @param button El botón al que se le aplicará el estilo.
     */
    public void styleButton(JButton button) {
        button.setBackground(UIManager.getColor("Component.accentColor"));
        button.setForeground(UIManager.getColor("Label.background"));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        misBilletesPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        paso1Label = new javax.swing.JLabel();
        inicioButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        volverButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        billetesList = new org.jdesktop.swingx.JXList();
        devolverButton = new javax.swing.JButton();
        editarButton = new javax.swing.JButton();
        editarBilletePanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        seleccioneEstacionLabel1 = new javax.swing.JLabel();
        inicioButton1 = new javax.swing.JButton();
        paso1Label1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rutasList = new org.jdesktop.swingx.JXList();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        bicicletaCheckBox = new javax.swing.JCheckBox();
        mascotaCheckBox = new javax.swing.JCheckBox();
        imagenMascotaLabel = new javax.swing.JLabel();
        imagenBiciLabel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        cancelarButton = new javax.swing.JButton();
        confirmarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tren Castilla y León");
        getContentPane().setLayout(new java.awt.CardLayout());

        misBilletesPanel.setEnabled(false);
        misBilletesPanel.setMaximumSize(new java.awt.Dimension(700, 700));
        misBilletesPanel.setMinimumSize(new java.awt.Dimension(600, 600));
        misBilletesPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        misBilletesPanel.setLayout(new javax.swing.BoxLayout(misBilletesPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        paso1Label.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        paso1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paso1Label.setText("Mis viajes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 141, 64, 259);
        jPanel2.add(paso1Label, gridBagConstraints);

        inicioButton.setBackground(UIManager.getColor("Component.accentColor"));
        inicioButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inicioButton.setText("Menu");
        inicioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 41, 0, 0);
        jPanel2.add(inicioButton, gridBagConstraints);

        misBilletesPanel.add(jPanel2);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        volverButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(105, 14, 23, 0);
        jPanel5.add(volverButton, gridBagConstraints);

        billetesList.setMinimumSize(new java.awt.Dimension(300, 100));
        jScrollPane3.setViewportView(billetesList);

        devolverButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        devolverButton.setText("Devolver");
        devolverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverButtonActionPerformed(evt);
            }
        });

        editarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editarButton.setText("Editar");
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(devolverButton)
                        .addGap(32, 32, 32)
                        .addComponent(editarButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(devolverButton)
                    .addComponent(editarButton))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 58, 0, 54);
        jPanel5.add(jPanel1, gridBagConstraints);

        misBilletesPanel.add(jPanel5);

        getContentPane().add(misBilletesPanel, "card2");

        editarBilletePanel.setEnabled(false);
        editarBilletePanel.setMaximumSize(new java.awt.Dimension(700, 700));
        editarBilletePanel.setMinimumSize(new java.awt.Dimension(600, 600));
        editarBilletePanel.setPreferredSize(new java.awt.Dimension(600, 600));
        editarBilletePanel.setLayout(new java.awt.GridLayout(4, 1));

        jPanel6.setLayout(new java.awt.GridBagLayout());

        seleccioneEstacionLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        seleccioneEstacionLabel1.setText("Ahora usté modifica su billete");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 116, 24, 0);
        jPanel6.add(seleccioneEstacionLabel1, gridBagConstraints);

        inicioButton1.setBackground(UIManager.getColor("Component.accentColor"));
        inicioButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inicioButton1.setText("Menu");
        inicioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 17, 0, 0);
        jPanel6.add(inicioButton1, gridBagConstraints);

        paso1Label1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        paso1Label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paso1Label1.setText("Editar billete");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 110, 0, 193);
        jPanel6.add(paso1Label1, gridBagConstraints);

        editarBilletePanel.add(jPanel6);

        rutasList.setMinimumSize(new java.awt.Dimension(300, 100));
        DefaultListModel<String> listModel = new DefaultListModel<>();
        rutasList.setModel(listModel);
        jScrollPane2.setViewportView(rutasList);

        jPanel7.add(jScrollPane2);

        editarBilletePanel.add(jPanel7);

        jPanel8.setLayout(new java.awt.GridBagLayout());

        bicicletaCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bicicletaCheckBox.setText("Bicicleta");
        bicicletaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bicicletaCheckBoxActionPerformed(evt);
            }
        });

        mascotaCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mascotaCheckBox.setText("Mascota");
        mascotaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mascotaCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(bicicletaCheckBox)
                        .addGap(12, 12, 12)
                        .addComponent(imagenBiciLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(mascotaCheckBox)
                        .addGap(6, 6, 6)
                        .addComponent(imagenMascotaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bicicletaCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagenBiciLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(mascotaCheckBox))
                    .addComponent(imagenMascotaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 256, 29, 220);
        jPanel8.add(jPanel13, gridBagConstraints);

        editarBilletePanel.add(jPanel8);

        jPanel9.setLayout(new java.awt.GridBagLayout());

        cancelarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(77, 48, 47, 0);
        jPanel9.add(cancelarButton, gridBagConstraints);

        confirmarButton.setBackground(UIManager.getColor("Component.accentColor"));
        confirmarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        confirmarButton.setText("Confirmar");
        confirmarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(77, 363, 47, 31);
        jPanel9.add(confirmarButton, gridBagConstraints);

        editarBilletePanel.add(jPanel9);

        getContentPane().add(editarBilletePanel, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de accion cuando se hace clic en el boton de inicio
     * Permite volver al menu incial
     *
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void inicioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioButtonActionPerformed
        controlador.volverMenu();
    }//GEN-LAST:event_inicioButtonActionPerformed

    /**
     * Maneja el evento de accion cuando se hace clic en el boton de volver
     * Permite volver a la vista anterior
     *
     * @param evt El evento de acción que desencadenó este método
     */
    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        controlador.volver();
    }//GEN-LAST:event_volverButtonActionPerformed

    /**
     * Maneja el evento de accion cuando se hace clic en el boton de inicio
     * Permite volver al menu inicial
     *
     * @param evt El evento de acción que desencadenó este método
     */
    private void inicioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioButton1ActionPerformed
        controlador.volverMenu();
    }//GEN-LAST:event_inicioButton1ActionPerformed

    private void bicicletaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bicicletaCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bicicletaCheckBoxActionPerformed

    private void mascotaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mascotaCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mascotaCheckBoxActionPerformed

    /**
     * Maneja el evento de accion cuando se hace clic en el boton de devolucion
     * Devuelve el billete seleccionado
     *
     * @param evt El evento de acción que desencadeno este metodo
     */
    private void devolverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverButtonActionPerformed
        controlador.devolverBillete();
    }//GEN-LAST:event_devolverButtonActionPerformed

    /**
     * Maneja el evento de accion cuando se hace clic en el boton de edicion
     * Edita el billete seleccionado
     *
     * @param evt El evento de acción que desencadenó este método
     */
    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
        controlador.editarBillete();
    }//GEN-LAST:event_editarButtonActionPerformed

    /**
     * Maneja el evento de accion cuando se hace clic en el boton de cancelacion
     * Cancela la edicion actual
     *
     * @param evt El evento de acción que desencadenó este método
     */
    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        controlador.cancelarEdicion();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    /**
     * Maneja el evento de accion cuando se hace clic en el boton de
     * confirmacion
     *
     * @param evt el evento de accion que desencadeno este método
     */
    private void confirmarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarButtonActionPerformed
        controlador.confirmarEdicion();
    }//GEN-LAST:event_confirmarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox bicicletaCheckBox;
    private org.jdesktop.swingx.JXList billetesList;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton confirmarButton;
    private javax.swing.JButton devolverButton;
    private javax.swing.JPanel editarBilletePanel;
    private javax.swing.JButton editarButton;
    private javax.swing.JLabel imagenBiciLabel;
    private javax.swing.JLabel imagenMascotaLabel;
    private javax.swing.JButton inicioButton;
    private javax.swing.JButton inicioButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JCheckBox mascotaCheckBox;
    private javax.swing.JPanel misBilletesPanel;
    private javax.swing.JLabel paso1Label;
    private javax.swing.JLabel paso1Label1;
    private org.jdesktop.swingx.JXList rutasList;
    private javax.swing.JLabel seleccioneEstacionLabel1;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables

    /**
     * Actualiza la lista de billetes en la vista
     */
    public void actualizarBilletes() {
        billetesListModel.clear();
        billetesListModel.addAll(controlador.getBilletes());
    }

    /**
     * Devuelve una notificacion al usuario de que su billete ha sido devuelto
     * con exito
     */
    public void notificarBilleteDevuelto() {
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Billete devuelto con éxito!");
    }

    /**
     * Devuelve una notificacion al usuario de que su billete ha sido editado
     * con exito
     */
    public void notificarBilleteEditado() {
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Billete editado con éxito!");
    }

    /**
     * Obtiene el billete seleccionado actualmente en la lista de billetes
     *
     * @return El objeto Billete seleccionado en la lista de billetes
     */
    public Billete getSelectedBillete() {
        return (Billete) billetesList.getSelectedValue();
    }

    /**
     * Hace visible la vista de editar el billete que el usuario ha seleccionado
     */
    public void activarVistaEditarBillete() {
        misBilletesPanel.setVisible(false);
        editarBilletePanel.setVisible(true);
    }

    /**
     * Hace visible la vista de los billetes que tiene el usuario
     */
    public void activarVistaMisBilletes() {
        misBilletesPanel.setVisible(true);
        editarBilletePanel.setVisible(false);
    }

    /**
     * Actualiza la vista de edicion de billetes con la informacion
     * proporcionada
     *
     * @param viajes La lista de viajes disponibles para editar el billete
     */
    public void actualizarVistaEditarBillete(ArrayList<Viaje> viajes, Billete billeteSeleccionado) {
        viajesListModel.clear();
        for (Viaje viaje : viajes) {
            viajesListModel.addElement(viaje);
            if (rutasList.getSelectedValue() == null && viaje.getHorario().equals(billeteSeleccionado.getHora())) {
                rutasList.setSelectedValue(viaje, true);
            }
        }
        mascotaCheckBox.setSelected(billeteSeleccionado.getMascota());
        bicicletaCheckBox.setSelected(billeteSeleccionado.getBicicleta());
    }

    /**
     * Obtiene el viaje seleccionado actualmente en la lista de rutas
     *
     * @return el objeto Viaje seleccionado en la lista de rutas
     */
    public Viaje getNewSelectedViaje() {
        return (Viaje) rutasList.getSelectedValue();
    }

    /**
     * Obtiene el estado de la casilla de si el usuario ha elegido bicicleta
     *
     * @return true si la casilla de verificación de bicicleta está
     * seleccionada, false en el caso contrario
     */
    public boolean getBicicleta() {
        return bicicletaCheckBox.isSelected();
    }

    /**
     * Obtiene el estado de la casilla de si el usuario ha elegido mascota
     *
     * @return true si la casilla de verificacion de mascota esta seleccionada,
     * false en el caso contrario
     */
    public boolean getMascota() {
        return mascotaCheckBox.isSelected();
    }
}//class Vista
