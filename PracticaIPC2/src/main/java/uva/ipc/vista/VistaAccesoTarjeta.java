/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uva.ipc.vista;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import uva.ipc.modelo.Viaje;

/**
 * @author Daniel Garcia Solla
 * @author Carolina de las Heras Clavier
 */
public class VistaAccesoTarjeta extends javax.swing.JFrame {

    private ControladorAccesoTarjeta controlador;
    private DefaultListModel<Viaje> viajesListModel = new DefaultListModel<>();
    private boolean darkTheme = false;

    /**
     * Creates new form MainFrame
     */
    public VistaAccesoTarjeta() {
        FlatLaf.setup(new FlatArcOrangeIJTheme());

        this.setIconImage(new ImageIcon("src/main/resources/Tarjetacyl.png").getImage());
        initComponents();
        this.setLocationRelativeTo(null);//Para que no aparezca a arriba a la izquierda
        this.controlador = new ControladorAccesoTarjeta(this);
        setMinimumSize(new Dimension(650, 700));

        styleButtons();
        Utiles.setObjectIcon(tarjetaCylButton, "src/main/resources/Tarjetacyl.png");
        Utiles.setObjectIcon(tarjetaDecorativa, "src/main/resources/Tarjetacyl.png");
        tarjetaCylButton.addMouseListener(new MouseAdapter() {
            /**
             * Indica que se inicia el contador de tiempo requerido para que el
             * usuario pague con tarjeta CYL
             *
             * @param e El evento del raton (hacer click) que desencadenó la
             * acción.
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                controlador.tarjetaCylStart();
            }

            /**
             * Invocado cuando el puntero del raton sale del área del
             * componente. Indica que se detenga la accion de cntar el numero de
             * segundos para pagar con la tarjeta CYL
             *
             * @param e El evento del mouse que desencadenó la acción.
             */
            @Override
            public void mouseExited(MouseEvent e) {
                controlador.tarjetaCylStop();
            }
        });

        meterTarjetaPanel.setVisible(false);
        tarjetaValidaPanel.setVisible(false);
        if (controlador.isTarjetaValida()) {
            tarjetaValida();
        } else {
            meterTarjetaPanel.setVisible(true);
        }
    }

    /**
     * Aplica un estilo específico a una serie de botones.
     */
    public void styleButtons() {
        styleButton(recargarTarjetaButton);
        styleButton(misViajesButton);
    }

    /**
     * Aplica un estilo personalizado a un botón.
     *
     * @param button El botón al que se le aplicará el estilo.
     */
    public void styleButton(JButton button) {
        button.setBackground(UIManager.getColor("Component.accentColor"));
        if (darkTheme) {
            button.setForeground(UIManager.getColor("Label.foreground"));
        } else {
            button.setForeground(UIManager.getColor("Label.background"));
        }

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

        tarjetaValidaPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        paso1Label3 = new javax.swing.JLabel();
        inicioButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        recargarTarjetaButton = new javax.swing.JButton();
        misViajesButton = new javax.swing.JButton();
        saldoLabel = new javax.swing.JLabel();
        viajesLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tarjetaDecorativa = new org.jdesktop.swingx.JXButton();
        meterTarjetaPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        paso1Label = new javax.swing.JLabel();
        inicioButton1 = new javax.swing.JButton();
        tarjetaCylPanel = new javax.swing.JPanel();
        tarjetaCylButton = new org.jdesktop.swingx.JXButton();
        erroresLabel4 = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tren Castilla y León");
        getContentPane().setLayout(new java.awt.CardLayout());

        tarjetaValidaPanel.setEnabled(false);
        tarjetaValidaPanel.setMaximumSize(new java.awt.Dimension(700, 700));
        tarjetaValidaPanel.setMinimumSize(new java.awt.Dimension(600, 600));
        tarjetaValidaPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        tarjetaValidaPanel.setLayout(new javax.swing.BoxLayout(tarjetaValidaPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        paso1Label3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        paso1Label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paso1Label3.setText("Bienvenido mister marshall!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 23, 55, 96);
        jPanel7.add(paso1Label3, gridBagConstraints);

        inicioButton.setBackground(UIManager.getColor("Component.accentColor"));
        inicioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inicioButton.setText("INICIO");
        inicioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 21, 0, 0);
        jPanel7.add(inicioButton, gridBagConstraints);

        tarjetaValidaPanel.add(jPanel7);

        jPanel8.setLayout(new java.awt.GridBagLayout());

        recargarTarjetaButton.setBackground(UIManager.getColor("Component.accentColor"));
        recargarTarjetaButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        recargarTarjetaButton.setText("Recargar Tarjeta");
        recargarTarjetaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargarTarjetaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 36;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 214, 0, 0);
        jPanel8.add(recargarTarjetaButton, gridBagConstraints);

        misViajesButton.setBackground(UIManager.getColor("Component.accentColor"));
        misViajesButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        misViajesButton.setText("Mis viajes");
        misViajesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                misViajesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 75;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 214, 109, 0);
        jPanel8.add(misViajesButton, gridBagConstraints);

        saldoLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        saldoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldoLabel.setText("Saldo: 78");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(52, 214, 0, 0);
        jPanel8.add(saldoLabel, gridBagConstraints);

        viajesLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        viajesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viajesLabel.setText("Viajes: 78");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 214, 0, 0);
        jPanel8.add(viajesLabel, gridBagConstraints);

        tarjetaDecorativa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visa.png"))); // NOI18N
        tarjetaDecorativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaDecorativaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tarjetaDecorativa, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tarjetaDecorativa, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 96, 0, 98);
        jPanel8.add(jPanel1, gridBagConstraints);

        tarjetaValidaPanel.add(jPanel8);

        getContentPane().add(tarjetaValidaPanel, "card2");

        meterTarjetaPanel.setEnabled(false);
        meterTarjetaPanel.setMaximumSize(new java.awt.Dimension(700, 700));
        meterTarjetaPanel.setMinimumSize(new java.awt.Dimension(600, 600));
        meterTarjetaPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        meterTarjetaPanel.setLayout(new javax.swing.BoxLayout(meterTarjetaPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        paso1Label.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        paso1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paso1Label.setText("¿Tarjeta?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 86, 20, 225);
        jPanel2.add(paso1Label, gridBagConstraints);

        inicioButton1.setBackground(UIManager.getColor("Component.accentColor"));
        inicioButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inicioButton1.setText("INICIO");
        inicioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(56, 52, 0, 0);
        jPanel2.add(inicioButton1, gridBagConstraints);

        meterTarjetaPanel.add(jPanel2);

        tarjetaCylButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visa.png"))); // NOI18N
        tarjetaCylButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaCylButtonActionPerformed(evt);
            }
        });

        erroresLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        erroresLabel4.setText("Mantenga usted la tarjeta 2 segundos");
        erroresLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout tarjetaCylPanelLayout = new javax.swing.GroupLayout(tarjetaCylPanel);
        tarjetaCylPanel.setLayout(tarjetaCylPanelLayout);
        tarjetaCylPanelLayout.setHorizontalGroup(
            tarjetaCylPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tarjetaCylPanelLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(erroresLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addGap(114, 114, 114))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tarjetaCylPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tarjetaCylButton, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        tarjetaCylPanelLayout.setVerticalGroup(
            tarjetaCylPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tarjetaCylPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tarjetaCylButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(erroresLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        meterTarjetaPanel.add(tarjetaCylPanel);

        getContentPane().add(meterTarjetaPanel, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recargarTarjetaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarTarjetaButtonActionPerformed
        controlador.recargarTarjeta();
    }//GEN-LAST:event_recargarTarjetaButtonActionPerformed

    private void misViajesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_misViajesButtonActionPerformed
        controlador.misViajes();
    }//GEN-LAST:event_misViajesButtonActionPerformed

    private void tarjetaCylButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaCylButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tarjetaCylButtonActionPerformed

    private void inicioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioButtonActionPerformed
        controlador.volverMenu();
    }//GEN-LAST:event_inicioButtonActionPerformed

    private void inicioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioButton1ActionPerformed
        controlador.volverMenu();
    }//GEN-LAST:event_inicioButton1ActionPerformed

    private void tarjetaDecorativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaDecorativaActionPerformed
        Utiles.dialogoInformativo(controlador.getPoliticaPrivacidad());
    }//GEN-LAST:event_tarjetaDecorativaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel erroresLabel4;
    private javax.swing.JButton inicioButton;
    private javax.swing.JButton inicioButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel meterTarjetaPanel;
    private javax.swing.JButton misViajesButton;
    private javax.swing.JLabel paso1Label;
    private javax.swing.JLabel paso1Label3;
    private javax.swing.JButton recargarTarjetaButton;
    private javax.swing.JLabel saldoLabel;
    private org.jdesktop.swingx.JXButton tarjetaCylButton;
    private javax.swing.JPanel tarjetaCylPanel;
    private org.jdesktop.swingx.JXButton tarjetaDecorativa;
    private javax.swing.JPanel tarjetaValidaPanel;
    private javax.swing.JLabel viajesLabel;
    // End of variables declaration//GEN-END:variables

    public void tarjetaValida() {
        meterTarjetaPanel.setVisible(false);
        tarjetaValidaPanel.setVisible(true);
    }

    public void actualizarSaldo(double saldo) {
        saldoLabel.setText("Saldo: " + saldo + "$");
    }

    public void actualizarViajes(int numeroViajes) {
        viajesLabel.setText("Viajes: " + numeroViajes);
    }
}//class Vista
