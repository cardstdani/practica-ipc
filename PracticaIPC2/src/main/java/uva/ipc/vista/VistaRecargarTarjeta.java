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
import static uva.ipc.vista.Utiles.codigoMensaje.ERROR;
import static uva.ipc.vista.Utiles.codigoMensaje.NORMAL;

/**
 * @author Daniel Garcia Solla
 * @author Carolina de las Heras Clavier
 */
public class VistaRecargarTarjeta extends javax.swing.JFrame {

    private ControladorRecargarTarjeta controlador;
    private DefaultListModel<Viaje> viajesListModel = new DefaultListModel<>();
    private boolean darkTheme = false;

    /**
     * Creates new form MainFrame
     */
    public VistaRecargarTarjeta() {
        UIManager.put("Panel.background", new Color(249,255,255));
        FlatLaf.setup(new FlatArcOrangeIJTheme());

        this.setIconImage(new ImageIcon("src/main/resources/Tarjetacyl.png").getImage());
        initComponents();
        this.setLocationRelativeTo(null);//Para que no aparezca a arriba a la izquierda
        this.controlador = new ControladorRecargarTarjeta(this);
        setMinimumSize(new Dimension(650, 700));

        styleButtons();

        tarjetaCreditoButton.addMouseListener(new MouseAdapter() {
            /**
             * Invocado cuando el puntero del raton entra en el área del
             * componente. Indica que se inicia el contador de tiempo requerido
             * para que el usuario pague con tarjeta de credito
             *
             * @param e El evento del raton (hacer click) que desencadenó la
             * acción.
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                controlador.tarjetaCreditoStart();
            }

            /**
             * Invocado cuando el puntero del raton sale del área del
             * componente. Indica que se detnega la accion de cntar el numero de
             * segundos para pagar con la tarjeta de credito
             *
             * @param e El evento del mouse que desencadenó la acción.
             */
            @Override
            public void mouseExited(MouseEvent e) {
                controlador.tarjetaCreditoStop();
            }
        });
        Utiles.setObjectIcon(tarjetaCreditoButton, "src/main/resources/Visa.png");
        mostrarRecargaTarjeta();
        pinTarjetaCreditoPanel.setVisible(false);
    }

    /**
     * Aplica un estilo específico a una serie de botones.
     */
    public void styleButtons() {
        styleButton(recargar10Button);
        styleButton(recargar20Button);
        styleButton(recargar50Button);
        styleButton(aceptarButton);
        styleButton(menuButton1);
        styleButton(accesoTarjetaButton);
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

        recargarPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        paso1Label3 = new javax.swing.JLabel();
        inicioButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        recargar10Button = new javax.swing.JButton();
        saldoLabel = new javax.swing.JLabel();
        recargar20Button = new javax.swing.JButton();
        recargar50Button = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        volverRecargarButton = new javax.swing.JButton();
        tarjetaPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        paso1Label5 = new javax.swing.JLabel();
        seleccioneEstacionLabel4 = new javax.swing.JLabel();
        inicioButton3 = new javax.swing.JButton();
        tarjetaCreditoPanel = new javax.swing.JPanel();
        pinTarjetaCreditoPanel = new javax.swing.JPanel();
        seleccioneEstacionLabel5 = new javax.swing.JLabel();
        pinTarjetaField = new javax.swing.JPasswordField();
        aceptarButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tarjetaCreditoButton = new org.jdesktop.swingx.JXButton();
        jPanel4 = new javax.swing.JPanel();
        erroresLabel3 = new org.jdesktop.swingx.JXLabel();
        jPanel13 = new javax.swing.JPanel();
        volverTarjetaCreditoButton = new javax.swing.JButton();
        felicidadesPanel = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        paso1Label6 = new javax.swing.JLabel();
        seleccioneEstacionLabel6 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        accesoTarjetaButton = new javax.swing.JButton();
        menuButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tren Castilla y León");
        getContentPane().setLayout(new java.awt.CardLayout());

        recargarPanel.setEnabled(false);
        recargarPanel.setMaximumSize(new java.awt.Dimension(700, 700));
        recargarPanel.setMinimumSize(new java.awt.Dimension(600, 600));
        recargarPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        recargarPanel.setLayout(new javax.swing.BoxLayout(recargarPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        paso1Label3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        paso1Label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paso1Label3.setText("Recargar tarjeta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 85, 1, 150);
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
        gridBagConstraints.insets = new java.awt.Insets(18, 17, 0, 0);
        jPanel7.add(inicioButton, gridBagConstraints);

        recargarPanel.add(jPanel7);

        jPanel8.setLayout(new java.awt.GridBagLayout());

        recargar10Button.setBackground(UIManager.getColor("Component.accentColor"));
        recargar10Button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        recargar10Button.setText("10$");
        recargar10Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargar10ButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 52, 0, 0);
        jPanel8.add(recargar10Button, gridBagConstraints);

        saldoLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        saldoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldoLabel.setText("Saldo: 78");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 3, 0, 0);
        jPanel8.add(saldoLabel, gridBagConstraints);

        recargar20Button.setBackground(UIManager.getColor("Component.accentColor"));
        recargar20Button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        recargar20Button.setText("20$");
        recargar20Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargar20ButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        jPanel8.add(recargar20Button, gridBagConstraints);

        recargar50Button.setBackground(UIManager.getColor("Component.accentColor"));
        recargar50Button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        recargar50Button.setText("50$");
        recargar50Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargar50ButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 4, 0, 166);
        jPanel8.add(recargar50Button, gridBagConstraints);

        label.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Seleccione la cantidad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(61, 52, 0, 0);
        jPanel8.add(label, gridBagConstraints);

        volverRecargarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        volverRecargarButton.setText("Volver");
        volverRecargarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverRecargarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(179, 24, 18, 0);
        jPanel8.add(volverRecargarButton, gridBagConstraints);

        recargarPanel.add(jPanel8);

        getContentPane().add(recargarPanel, "card2");

        tarjetaPanel.setEnabled(false);
        tarjetaPanel.setMaximumSize(new java.awt.Dimension(700, 700));
        tarjetaPanel.setMinimumSize(new java.awt.Dimension(600, 600));
        tarjetaPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        tarjetaPanel.setLayout(new javax.swing.BoxLayout(tarjetaPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel12.setLayout(new java.awt.GridBagLayout());

        paso1Label5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        paso1Label5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paso1Label5.setText("A pagar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 142, 0, 235);
        jPanel12.add(paso1Label5, gridBagConstraints);

        seleccioneEstacionLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        seleccioneEstacionLabel4.setText("Pague usted");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 168, 13, 0);
        jPanel12.add(seleccioneEstacionLabel4, gridBagConstraints);

        inicioButton3.setBackground(UIManager.getColor("Component.accentColor"));
        inicioButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inicioButton3.setText("INICIO");
        inicioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 16, 0, 0);
        jPanel12.add(inicioButton3, gridBagConstraints);

        tarjetaPanel.add(jPanel12);

        tarjetaCreditoPanel.setLayout(new java.awt.GridBagLayout());

        seleccioneEstacionLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        seleccioneEstacionLabel5.setText("PIN:");

        pinTarjetaField.setToolTipText("Introduce el PIN...");

        aceptarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pinTarjetaCreditoPanelLayout = new javax.swing.GroupLayout(pinTarjetaCreditoPanel);
        pinTarjetaCreditoPanel.setLayout(pinTarjetaCreditoPanelLayout);
        pinTarjetaCreditoPanelLayout.setHorizontalGroup(
            pinTarjetaCreditoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pinTarjetaCreditoPanelLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(seleccioneEstacionLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pinTarjetaField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(aceptarButton)
                .addGap(29, 29, 29))
        );
        pinTarjetaCreditoPanelLayout.setVerticalGroup(
            pinTarjetaCreditoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pinTarjetaCreditoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pinTarjetaCreditoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pinTarjetaField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptarButton)
                    .addComponent(seleccioneEstacionLabel5))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 132, 27, 101);
        tarjetaCreditoPanel.add(pinTarjetaCreditoPanel, gridBagConstraints);

        tarjetaCreditoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaCreditoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tarjetaCreditoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tarjetaCreditoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 132, 0, 101);
        tarjetaCreditoPanel.add(jPanel1, gridBagConstraints);

        erroresLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        erroresLabel3.setText("Mantenga usted la tarjeta 2 segundos");
        erroresLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(erroresLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(erroresLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 167, 0, 0);
        tarjetaCreditoPanel.add(jPanel4, gridBagConstraints);

        tarjetaPanel.add(tarjetaCreditoPanel);

        jPanel13.setLayout(new java.awt.GridBagLayout());

        volverTarjetaCreditoButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        volverTarjetaCreditoButton.setText("Volver");
        volverTarjetaCreditoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverTarjetaCreditoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 40, 8, 491);
        jPanel13.add(volverTarjetaCreditoButton, gridBagConstraints);

        tarjetaPanel.add(jPanel13);

        getContentPane().add(tarjetaPanel, "card4");

        felicidadesPanel.setEnabled(false);
        felicidadesPanel.setMaximumSize(new java.awt.Dimension(700, 700));
        felicidadesPanel.setMinimumSize(new java.awt.Dimension(600, 600));
        felicidadesPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        felicidadesPanel.setLayout(new javax.swing.BoxLayout(felicidadesPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel14.setLayout(new java.awt.GridBagLayout());

        paso1Label6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        paso1Label6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paso1Label6.setText("Felicidades!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(73, 257, 0, 0);
        jPanel14.add(paso1Label6, gridBagConstraints);

        seleccioneEstacionLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        seleccioneEstacionLabel6.setText("Su pago ha sido aceptado con éxito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 247, 6, 275);
        jPanel14.add(seleccioneEstacionLabel6, gridBagConstraints);

        felicidadesPanel.add(jPanel14);

        panel.setLayout(new java.awt.GridBagLayout());

        accesoTarjetaButton.setBackground(UIManager.getColor("Component.accentColor"));
        accesoTarjetaButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        accesoTarjetaButton.setText("Acceso tarjeta");
        accesoTarjetaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accesoTarjetaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 227, 224, 245);
        panel.add(accesoTarjetaButton, gridBagConstraints);

        menuButton1.setBackground(UIManager.getColor("Component.accentColor"));
        menuButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuButton1.setText("Ir al menú");
        menuButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 36;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(59, 227, 0, 245);
        panel.add(menuButton1, gridBagConstraints);

        felicidadesPanel.add(panel);

        getContentPane().add(felicidadesPanel, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
    * Maneja el evento de acción cuando se hace clic en el boton de recargar 10$
    * Se incia el proceso de recarga 
    *
    * @param evt El evento de accion que desencadeno este metodo
    */
    private void recargar10ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargar10ButtonActionPerformed
        controlador.recargar10();
    }//GEN-LAST:event_recargar10ButtonActionPerformed
    
    /**
    * Maneja el evento de acción cuando se hace clic en el boton de inicio
    * Permite volver al menu inicial 
    *
    * @param evt El evento de accion que desencadeno este metodo
    */
    private void inicioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioButtonActionPerformed
        controlador.volverMenu();
    }//GEN-LAST:event_inicioButtonActionPerformed
    
    /**
    * Maneja el evento de acción cuando se hace clic en el boton de recargar 20$
    * Se incia el proceso de recarga 
    *
    * @param evt El evento de accion que desencadeno este metodo
    */
    private void recargar20ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargar20ButtonActionPerformed
        controlador.recargar20();
    }//GEN-LAST:event_recargar20ButtonActionPerformed
    
    /**
    * Maneja el evento de acción cuando se hace clic en el boton de recargar 50$
    * Se incia el proceso de recarga 
    *
    * @param evt El evento de accion que desencadeno este metodo
    */
    private void recargar50ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargar50ButtonActionPerformed
        controlador.recargar50();
    }//GEN-LAST:event_recargar50ButtonActionPerformed
    
    /**
    * Maneja el evento de accion cuando se hace clic en el boton de inicio
    * Permite volver al menu inicial 
    *
    * @param evt El evento de accion que desencadeno este metodo
    */
    private void inicioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioButton3ActionPerformed
        controlador.volverMenu();
    }//GEN-LAST:event_inicioButton3ActionPerformed
    
    /**
    * Maneja el evento de acción cuando se hace clic en el boton de aceptar
    * Procesa el pago con tarjeta de credito
    *
    * @param evt El evento de accion que desencadeno este metodo
    */
    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        controlador.aceptarPagoTarjetaCredito();
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void tarjetaCreditoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaCreditoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tarjetaCreditoButtonActionPerformed
    
    /**
    * Maneja el evento de accion cuando se hace clic en el boton de volver para regresar a la vista de tarjeta de credito
    * @param evt El evento de accion que desencadenó este metodo
    */
    private void volverTarjetaCreditoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverTarjetaCreditoButtonActionPerformed
        controlador.volverTarjetaCredito();
    }//GEN-LAST:event_volverTarjetaCreditoButtonActionPerformed
    
    /**
    * Maneja el evento de accion cuando se hace clic en el boton de volver para recargar la tarjeta
    * Vuelve al acceso con tarjeta desde la vista de recarga
    * @param evt El evento de accion que desencadenó este método
    */
    private void volverRecargarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverRecargarButtonActionPerformed
        controlador.volverAccesoTarjeta();
    }//GEN-LAST:event_volverRecargarButtonActionPerformed
    
    /**
    * Maneja el evento de accion cuando se hace clic en el boton de acceso a la tarjeta
    * Vuelve al acceso con tarjeta
    *
    * @param evt El evento de accion que desencadenó este método
    */
    private void accesoTarjetaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accesoTarjetaButtonActionPerformed
        controlador.volverAccesoTarjeta();
    }//GEN-LAST:event_accesoTarjetaButtonActionPerformed
    
    /**
    * Maneja el evento de accion cuando se hace clic en el boton de menu
    * Vuelve al menu inicial 
    *
    * @param evt El evento de acción que desencadenó este método
    */
    private void menuButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButton1ActionPerformed
        controlador.volverMenu();
    }//GEN-LAST:event_menuButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accesoTarjetaButton;
    private javax.swing.JButton aceptarButton;
    private org.jdesktop.swingx.JXLabel erroresLabel3;
    private javax.swing.JPanel felicidadesPanel;
    private javax.swing.JButton inicioButton;
    private javax.swing.JButton inicioButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel label;
    private javax.swing.JButton menuButton1;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel paso1Label3;
    private javax.swing.JLabel paso1Label5;
    private javax.swing.JLabel paso1Label6;
    private javax.swing.JPanel pinTarjetaCreditoPanel;
    private javax.swing.JPasswordField pinTarjetaField;
    private javax.swing.JButton recargar10Button;
    private javax.swing.JButton recargar20Button;
    private javax.swing.JButton recargar50Button;
    private javax.swing.JPanel recargarPanel;
    private javax.swing.JLabel saldoLabel;
    private javax.swing.JLabel seleccioneEstacionLabel4;
    private javax.swing.JLabel seleccioneEstacionLabel5;
    private javax.swing.JLabel seleccioneEstacionLabel6;
    private org.jdesktop.swingx.JXButton tarjetaCreditoButton;
    private javax.swing.JPanel tarjetaCreditoPanel;
    private javax.swing.JPanel tarjetaPanel;
    private javax.swing.JButton volverRecargarButton;
    private javax.swing.JButton volverTarjetaCreditoButton;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Actualiza y muestra el saldo de la tarjeta de credito
     * @param saldo el nuevo saldo de la tarjeta de credito
     */
    public void actualizarSaldo(double saldo) {
        saldoLabel.setText("Saldo: " + saldo + "$");
    }
    
    /**
     * Desactiva los paneles de tarjeta de credito, recarga y felicidades
     */
    private void desactivarPaneles() {
        tarjetaPanel.setVisible(false);
        recargarPanel.setVisible(false);
        felicidadesPanel.setVisible(false);
    }
    
    /**
     * Muestra el panel de recarga de tarjeta de credito
     */
    public void mostrarRecargaTarjeta() {
        desactivarPaneles();
        recargarPanel.setVisible(true);
    }
    
    /**
     * Muestra el panel donde se ve la tarjeta de credito
     */
    public void mostrarTarjetaCredito() {
        desactivarPaneles();
        tarjetaPanel.setVisible(true);
    }
    
    /**
     * Muestra el panel donde se introduce el pin de la tarjeta de credito
     */
    public void mostrarPinTarjetaPanel() {
        pinTarjetaCreditoPanel.setVisible(true);
    }
    
    /**
     * Muestra el panel de felicidades
     */
    public void mostrarFelicidadesPanel() {
        desactivarPaneles();
        felicidadesPanel.setVisible(true);
    }
    /**
     * Obtiene el pin de la tarjeta introducido 
     * @return el pin de la tarjeta introducido 
     */
    public String getPinTarjeta() {
        return pinTarjetaField.getText();
    }
    
    /**
    * Muestra mensaje de error en el paso 3 de comprar un billete
    * Actualiza el texto de la etiqueta de errores y ajusta su color según el tipo de mensaje
    *
    * @param mensaje       el mensaje a mostrar
    * @param codigoMensaje el codigo del mensaje que indica su tipo: normal o de error
    */
    public void mensajePaso3TarjetaCredito(String mensaje, Utiles.codigoMensaje codigoMensaje) {
        erroresLabel3.setText(mensaje);
        switch (codigoMensaje) {
            case ERROR:
                erroresLabel3.setForeground(Color.red);
                Toolkit.getDefaultToolkit().beep();
                break;
            case NORMAL:
                erroresLabel3.setForeground(Color.black);
                break;
        }
    }
}//class Vista
