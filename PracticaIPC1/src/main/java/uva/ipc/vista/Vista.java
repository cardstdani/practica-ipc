/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uva.ipc.vista;

import java.util.*;
import java.text.SimpleDateFormat;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.time.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import uva.ipc.controlador.Controlador;
import uva.ipc.modelo.Viaje;

/**
 * @author Daniel Garcia Solla
 * @author Carolina de las Heras Clavier
 */
public class Vista extends javax.swing.JFrame {

    private Controlador controlador;
    private DefaultListModel<Viaje> viajesListModel = new DefaultListModel<>();
    private boolean darkTheme = false;

    /**
     * Creates new form MainFrame
     */
    public Vista() {
        FlatLaf.setup(new FlatArcOrangeIJTheme());
        this.setIconImage(new ImageIcon("src/main/resources/Tarjetacyl.png").getImage());
        initComponents();
        this.setLocationRelativeTo(null);//Para que no aparezca a arriba a la izquierda
        this.controlador = new Controlador(this);
        rutasList.setModel(viajesListModel);
        setMinimumSize(new Dimension(650, 700));
        desactivarPinTarjeta();
        inicializarIconos();
        limpiar();

        tarjetaCreditoButton.addMouseListener(new MouseAdapter() {
            /**
             * Invocado cuando el puntero del raton entra en el área del componente.
             * Indica que se inicia el contador de tiempo requerido para que el usuario pague con tarjeta de credito
             * @param e El evento del raton (hacer click) que desencadenó la acción.
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                controlador.tarjetaCreditoStart();
            }
            /**
             * Invocado cuando el puntero del raton sale del área del componente.
             * Indica que se detnega la accion de cntar el numero de segundos para pagar con la tarjeta de credito
             * @param e El evento del mouse que desencadenó la acción.
             */
            @Override
            public void mouseExited(MouseEvent e) {
                controlador.tarjetaCreditoStop();
            }
        });

        tarjetaCylButton.addMouseListener(new MouseAdapter() {            
            /**
             * Indica que se inicia el contador de tiempo requerido para que el usuario pague con tarjeta CYL
             * @param e El evento del raton (hacer click) que desencadenó la acción.
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                controlador.tarjetaCylStart();
            }
            /**
             * Invocado cuando el puntero del raton sale del área del componente.
             * Indica que se detenga la accion de cntar el numero de segundos para pagar con la tarjeta CYL
             * @param e El evento del mouse que desencadenó la acción.
             */
            @Override
            public void mouseExited(MouseEvent e) {
                controlador.tarjetaCylStop();
            }
        });
        styleButtons();
        inicializarJueguecito();
    }
    /**
     * Inicializa el juego que le aparece al usuario una vez ha comprado cargando una página web 
     */
    public void inicializarJueguecito() {
        final JFXPanel jfxPanel = new JFXPanel();

        Platform.runLater(() -> {
            WebView webView = new WebView();
            webView.getEngine().load("https://dinorunner.com/"); //https://offline-dino-game.firebaseapp.com/
            Scene scene = new Scene(webView);
            jfxPanel.setScene(scene);
            webView.requestFocus();
        });
        //Se actualiza el panel
        dinoPanel.setLayout(new BorderLayout());
        dinoPanel.add(jfxPanel, BorderLayout.CENTER);
        dinoPanel.revalidate();
        dinoPanel.repaint();
    }
    /**
     * Aplica un estilo específico a una serie de botones.
     */
    public void styleButtons() {
        styleButton(continuarPaso1Button);
        styleButton(continuarPaso2Button);
        styleButton(comprarOtroBillete);
        styleButton(aceptarButton);
    }
    
    /**
    * Aplica un estilo personalizado a un botón.  
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
     * Inicializa los iconos de los botones especificados con las imagenes introducidas
     */
    public void inicializarIconos() {
        setObjectIcon(intercambiarEstacionesButton, "src/main/resources/Swap.png");
        setObjectIcon(tarjetaCreditoButton, "src/main/resources/Visa.png");
        setObjectIcon(tarjetaCylButton, "src/main/resources/Tarjetacyl.png");

    }
    /**
    * Establece un icono en un JButton utilizando una imagen
    * La imagen se ajusta al tamaño del botón proporcionado. 
    * @param button El botón al que se le establecerá el icono.
    * @param path La ruta de archivo de la imagen que se utilizará como icono.
    */
    public void setObjectIcon(JButton button, String path) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_AREA_AVERAGING);
        ImageIcon ic = new ImageIcon(img);
        button.setIcon(ic);
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

        paso1Panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        paso1Label = new javax.swing.JLabel();
        seleccioneEstacionLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        estacionOrigenSelector = new javax.swing.JComboBox<>();
        intercambiarEstacionesButton = new javax.swing.JButton();
        estacionDestinoSelector = new javax.swing.JComboBox<>();
        fechaDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jPanel5 = new javax.swing.JPanel();
        continuarPaso1Button = new javax.swing.JButton();
        cambiarTemaButton = new javax.swing.JButton();
        paso2Panel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        paso1Label1 = new javax.swing.JLabel();
        seleccioneEstacionLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rutasList = new org.jdesktop.swingx.JXList();
        jPanel8 = new javax.swing.JPanel();
        bicicletaCheckBox = new javax.swing.JCheckBox();
        mascotaCheckBox = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        volver2Button = new javax.swing.JButton();
        continuarPaso2Button = new javax.swing.JButton();
        paso4Panel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        paso1Label3 = new javax.swing.JLabel();
        comprarOtroBillete = new javax.swing.JButton();
        dinoPanel = new org.jdesktop.swingx.JXPanel();
        paso3Panel = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        paso1Label2 = new javax.swing.JLabel();
        seleccioneEstacionLabel2 = new javax.swing.JLabel();
        tarjetaCylRadioButton = new javax.swing.JRadioButton();
        tarjetaCreditoRadioButton = new javax.swing.JRadioButton();
        opcionesPanel = new javax.swing.JPanel();
        tarjetaCreditoPanel = new javax.swing.JPanel();
        pinTarjetaCreditoPanel = new javax.swing.JPanel();
        seleccioneEstacionLabel3 = new javax.swing.JLabel();
        pinTarjetaField = new javax.swing.JPasswordField();
        aceptarButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tarjetaCreditoButton = new org.jdesktop.swingx.JXButton();
        jPanel4 = new javax.swing.JPanel();
        erroresLabel3 = new org.jdesktop.swingx.JXLabel();
        tarjetaCylPanel = new javax.swing.JPanel();
        tarjetaCylButton = new org.jdesktop.swingx.JXButton();
        erroresLabel4 = new org.jdesktop.swingx.JXLabel();
        jPanel11 = new javax.swing.JPanel();
        volver3Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tren Castilla y León");
        getContentPane().setLayout(new java.awt.CardLayout());

        paso1Panel.setEnabled(false);
        paso1Panel.setMaximumSize(new java.awt.Dimension(700, 700));
        paso1Panel.setMinimumSize(new java.awt.Dimension(600, 600));
        paso1Panel.setPreferredSize(new java.awt.Dimension(600, 600));
        paso1Panel.setLayout(new javax.swing.BoxLayout(paso1Panel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        paso1Label.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        paso1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paso1Label.setText("Paso 1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(66, 247, 0, 0);
        jPanel2.add(paso1Label, gridBagConstraints);

        seleccioneEstacionLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        seleccioneEstacionLabel.setText("Seleccione las estaciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 227, 35, 212);
        jPanel2.add(seleccioneEstacionLabel, gridBagConstraints);

        paso1Panel.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        estacionOrigenSelector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        estacionOrigenSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estacionOrigenSelectorActionPerformed(evt);
            }
        });
        estacionOrigenSelector.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                estacionOrigenSelectorPropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 166, 0, 0);
        jPanel3.add(estacionOrigenSelector, gridBagConstraints);

        intercambiarEstacionesButton.setBackground(new java.awt.Color(0, 0, 0, 0));
        intercambiarEstacionesButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        intercambiarEstacionesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Swap.png"))); // NOI18N
        intercambiarEstacionesButton.setBorder(null);
        intercambiarEstacionesButton.setMaximumSize(new java.awt.Dimension(300, 300));
        intercambiarEstacionesButton.setMinimumSize(new java.awt.Dimension(200, 200));
        intercambiarEstacionesButton.setPreferredSize(new java.awt.Dimension(300, 300));
        intercambiarEstacionesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intercambiarEstacionesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -270;
        gridBagConstraints.ipady = -267;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 6, 0, 0);
        jPanel3.add(intercambiarEstacionesButton, gridBagConstraints);

        estacionDestinoSelector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 166, 0, 0);
        jPanel3.add(estacionDestinoSelector, gridBagConstraints);

        fechaDatePicker.setDate(new java.util.Date());
        fechaDatePicker.setDoubleBuffered(true);
        fechaDatePicker.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fechaDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaDatePickerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 52;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 166, 33, 203);
        jPanel3.add(fechaDatePicker, gridBagConstraints);
        fechaDatePicker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
        fechaDatePicker.getMonthView().setFirstDayOfWeek(Calendar.MONDAY);
        fechaDatePicker.getMonthView().setLowerBound(java.util.Calendar.getInstance().getTime());

        paso1Panel.add(jPanel3);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        continuarPaso1Button.setBackground(UIManager.getColor("Component.accentColor"));
        continuarPaso1Button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        continuarPaso1Button.setText("Continuar");
        continuarPaso1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarPaso1ButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(132, 371, 0, 19);
        jPanel5.add(continuarPaso1Button, gridBagConstraints);

        cambiarTemaButton.setText("Tema Oscuro");
        cambiarTemaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarTemaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 43;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(114, 21, 17, 0);
        jPanel5.add(cambiarTemaButton, gridBagConstraints);

        paso1Panel.add(jPanel5);

        getContentPane().add(paso1Panel, "card2");

        paso2Panel.setEnabled(false);
        paso2Panel.setMaximumSize(new java.awt.Dimension(700, 700));
        paso2Panel.setMinimumSize(new java.awt.Dimension(600, 600));
        paso2Panel.setPreferredSize(new java.awt.Dimension(600, 600));
        paso2Panel.setLayout(new java.awt.GridLayout(4, 1));

        jPanel6.setLayout(new java.awt.GridBagLayout());

        paso1Label1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        paso1Label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paso1Label1.setText("Paso 2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(49, 243, 0, 241);
        jPanel6.add(paso1Label1, gridBagConstraints);

        seleccioneEstacionLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        seleccioneEstacionLabel1.setText("Selecciona tu tren");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 243, 36, 0);
        jPanel6.add(seleccioneEstacionLabel1, gridBagConstraints);

        paso2Panel.add(jPanel6);

        rutasList.setMinimumSize(new java.awt.Dimension(300, 100));
        DefaultListModel<String> listModel = new DefaultListModel<>();
        rutasList.setModel(listModel);
        jScrollPane2.setViewportView(rutasList);

        jPanel7.add(jScrollPane2);

        paso2Panel.add(jPanel7);

        jPanel8.setLayout(new java.awt.GridBagLayout());

        bicicletaCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bicicletaCheckBox.setText("Bicicleta");
        bicicletaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bicicletaCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(51, 268, 0, 0);
        jPanel8.add(bicicletaCheckBox, gridBagConstraints);

        mascotaCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mascotaCheckBox.setText("Mascota");
        mascotaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mascotaCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 268, 40, 259);
        jPanel8.add(mascotaCheckBox, gridBagConstraints);

        paso2Panel.add(jPanel8);

        jPanel9.setLayout(new java.awt.GridBagLayout());

        volver2Button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        volver2Button.setText("Volver");
        volver2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volver2ButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(77, 48, 47, 0);
        jPanel9.add(volver2Button, gridBagConstraints);

        continuarPaso2Button.setBackground(UIManager.getColor("Component.accentColor"));
        continuarPaso2Button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        continuarPaso2Button.setText("Continuar");
        continuarPaso2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarPaso2ButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(77, 363, 47, 31);
        jPanel9.add(continuarPaso2Button, gridBagConstraints);

        paso2Panel.add(jPanel9);

        getContentPane().add(paso2Panel, "card3");

        paso4Panel.setEnabled(false);
        paso4Panel.setMaximumSize(new java.awt.Dimension(700, 700));
        paso4Panel.setMinimumSize(new java.awt.Dimension(600, 600));
        paso4Panel.setPreferredSize(new java.awt.Dimension(600, 600));
        paso4Panel.setLayout(new java.awt.GridBagLayout());

        jPanel12.setLayout(new java.awt.GridBagLayout());

        paso1Label3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        paso1Label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paso1Label3.setText("Pago confirmado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(99, 179, 0, 0);
        jPanel12.add(paso1Label3, gridBagConstraints);

        comprarOtroBillete.setBackground(UIManager.getColor("Component.accentColor"));
        comprarOtroBillete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comprarOtroBillete.setText("Comprar otro billete");
        comprarOtroBillete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarOtroBilleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 238, 0, 0);
        jPanel12.add(comprarOtroBillete, gridBagConstraints);

        dinoPanel.setDoubleBuffered(false);

        javax.swing.GroupLayout dinoPanelLayout = new javax.swing.GroupLayout(dinoPanel);
        dinoPanel.setLayout(dinoPanelLayout);
        dinoPanelLayout.setHorizontalGroup(
            dinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );
        dinoPanelLayout.setVerticalGroup(
            dinoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 379;
        gridBagConstraints.ipady = 295;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 136, 57, 85);
        jPanel12.add(dinoPanel, gridBagConstraints);

        paso4Panel.add(jPanel12, new java.awt.GridBagConstraints());

        getContentPane().add(paso4Panel, "card4");

        paso3Panel.setEnabled(false);
        paso3Panel.setMaximumSize(new java.awt.Dimension(700, 700));
        paso3Panel.setMinimumSize(new java.awt.Dimension(600, 600));
        paso3Panel.setPreferredSize(new java.awt.Dimension(600, 600));
        paso3Panel.setLayout(new javax.swing.BoxLayout(paso3Panel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel10.setLayout(new java.awt.GridBagLayout());

        paso1Label2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        paso1Label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paso1Label2.setText("Paso 3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 227, 0, 0);
        jPanel10.add(paso1Label2, gridBagConstraints);

        seleccioneEstacionLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        seleccioneEstacionLabel2.setText("Selecciona el método de pago");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 188, 0, 221);
        jPanel10.add(seleccioneEstacionLabel2, gridBagConstraints);

        tarjetaCylRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tarjetaCylRadioButton.setText("Tarjeta Usuario TCyL");
        tarjetaCylRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaCylRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 220, 12, 0);
        jPanel10.add(tarjetaCylRadioButton, gridBagConstraints);

        tarjetaCreditoRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tarjetaCreditoRadioButton.setSelected(true);
        tarjetaCreditoRadioButton.setText("Tarjeta de crédito");
        tarjetaCreditoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaCreditoRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 220, 0, 0);
        jPanel10.add(tarjetaCreditoRadioButton, gridBagConstraints);

        paso3Panel.add(jPanel10);

        opcionesPanel.setLayout(new java.awt.CardLayout());

        tarjetaCreditoPanel.setLayout(new java.awt.GridBagLayout());

        seleccioneEstacionLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        seleccioneEstacionLabel3.setText("PIN:");

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
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(seleccioneEstacionLabel3)
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
                    .addComponent(seleccioneEstacionLabel3))
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

        opcionesPanel.add(tarjetaCreditoPanel, "card2");

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
                .addComponent(erroresLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(114, 114, 114))
            .addGroup(tarjetaCylPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tarjetaCylPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tarjetaCylButton, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        tarjetaCylPanelLayout.setVerticalGroup(
            tarjetaCylPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tarjetaCylPanelLayout.createSequentialGroup()
                .addContainerGap(289, Short.MAX_VALUE)
                .addComponent(erroresLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(tarjetaCylPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tarjetaCylPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tarjetaCylButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        opcionesPanel.add(tarjetaCylPanel, "card2");

        paso3Panel.add(opcionesPanel);

        jPanel11.setLayout(new java.awt.GridBagLayout());

        volver3Button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        volver3Button.setText("Volver");
        volver3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volver3ButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 40, 8, 491);
        jPanel11.add(volver3Button, gridBagConstraints);

        paso3Panel.add(jPanel11);

        getContentPane().add(paso3Panel, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Maneja el evento de acción del botón para pasar del paso 1 al 2
     * @param evt 
     */
    private void continuarPaso1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarPaso1ButtonActionPerformed
        controlador.continuarPaso1();
    }//GEN-LAST:event_continuarPaso1ButtonActionPerformed
    
    /**
     *  Maneja el evento de accion del selector de estacion de origen.
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void estacionOrigenSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estacionOrigenSelectorActionPerformed
        actualizarSeleccionEstacionDestino();
    }//GEN-LAST:event_estacionOrigenSelectorActionPerformed
    
    /**
     * Maneja el evento de accion del boton "Volver" en el paso 3
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void volver3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver3ButtonActionPerformed
        controlador.volverPaso3();
    }//GEN-LAST:event_volver3ButtonActionPerformed
    
    /**
     * Maneja el evento de acción del boton para continuar del paso al siguiente 
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void continuarPaso2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarPaso2ButtonActionPerformed
        controlador.continuarPaso2();
    }//GEN-LAST:event_continuarPaso2ButtonActionPerformed
    
    /**
     * Maneja el evento de accion del boton de radio para seleccionar la tarjeta de credito.
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void tarjetaCreditoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaCreditoRadioButtonActionPerformed
        desactivarSelectoresTarjeta();
        tarjetaCreditoRadioButton.setSelected(true);
        desactivarPanelesTarjeta();
        tarjetaCreditoPanel.setVisible(true);
    }//GEN-LAST:event_tarjetaCreditoRadioButtonActionPerformed
    
    /**
     * Maneja el evento de acción del botón "Volver" en el paso 2
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void volver2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver2ButtonActionPerformed
        controlador.volverPaso2();
    }//GEN-LAST:event_volver2ButtonActionPerformed
    
    /**
     * Maneja el evento de acción del botón para cambiar el tema de la interfaz
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void cambiarTemaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarTemaButtonActionPerformed
        try {
            if (darkTheme) {
                FlatArcOrangeIJTheme.setup();
                cambiarTemaButton.setText("Tema Oscuro");
            } else {
                FlatArcDarkOrangeIJTheme.setup();
                cambiarTemaButton.setText("Tema Claro");
            }
            SwingUtilities.updateComponentTreeUI(this);
            this.pack();
            darkTheme = !darkTheme;
            styleButtons();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cambiarTemaButtonActionPerformed
    /**
     * Maneja el evento de acción del checkbox relacionado con la opción de bicicleta
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void bicicletaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bicicletaCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bicicletaCheckBoxActionPerformed
    
    /**
     * Maneja el evento de accion del checkbox relacionado con la opcion de mascota
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void mascotaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mascotaCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mascotaCheckBoxActionPerformed
    
    /**
     * Maneja el evento de acción del botón de radio para seleccionar la tarjeta CYL
     * Desactiva los selectores y paneles relacionados con la tarjeta de credito, activa los relacionados con la tarjeta CYL
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void tarjetaCylRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaCylRadioButtonActionPerformed
        desactivarSelectoresTarjeta();
        tarjetaCylRadioButton.setSelected(true);
        desactivarPanelesTarjeta();
        tarjetaCylPanel.setVisible(true);
    }//GEN-LAST:event_tarjetaCylRadioButtonActionPerformed

    /**
     * Maneja el evento de acción del botón para intercambiar estaciones
     * Intercambia la selección de estaciones de origen y destino en los selectores correspondientes
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void intercambiarEstacionesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intercambiarEstacionesButtonActionPerformed
        String origen = (String) estacionOrigenSelector.getSelectedItem();
        String destino = (String) estacionDestinoSelector.getSelectedItem();
        estacionOrigenSelector.setSelectedItem(destino);
        estacionDestinoSelector.setSelectedItem(origen);
    }//GEN-LAST:event_intercambiarEstacionesButtonActionPerformed

    /**
     * Maneja el evento de acción del boton "Aceptar" para aceptar el pago con tarjeta de crédito 
     * @param evt El evento de acción que desencadeno este metodo
     */
    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        controlador.aceptarPagoTarjetaCredito();
    }//GEN-LAST:event_aceptarButtonActionPerformed
    
    /**
     * Maneja el evento de acción del botón para comprar otro billete
     * Limpia los campos y restablece el estado de la interfaz del usuario al paso 1
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void comprarOtroBilleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarOtroBilleteActionPerformed
        limpiar();
        activarPaso(1);
    }//GEN-LAST:event_comprarOtroBilleteActionPerformed

    /**
     * Maneja el evento de acción del botón relacionado con la tarjeta de credito
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void tarjetaCreditoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaCreditoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tarjetaCreditoButtonActionPerformed
    
    /**
     * Maneja el evento de acción del botón relacionado con la tarjeta CYL
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void tarjetaCylButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaCylButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tarjetaCylButtonActionPerformed
    
    /**
     * Establece el cambio de propiedad del selector de estación de origen
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void estacionOrigenSelectorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_estacionOrigenSelectorPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_estacionOrigenSelectorPropertyChange
    
    /**
     * Maneja el evento de acción del selector de fecha
     * @param evt El evento de accion que desencadeno este metodo
     */
    private void fechaDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaDatePickerActionPerformed
        if (getFecha() == null) {
            fechaDatePicker.setDate(new Date());
        }
    }//GEN-LAST:event_fechaDatePickerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            //UIManager.setLookAndFeel(new FlatIntelliJLaf()); //La mejor interfaz
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }//main

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JCheckBox bicicletaCheckBox;
    private javax.swing.JButton cambiarTemaButton;
    private javax.swing.JButton comprarOtroBillete;
    private javax.swing.JButton continuarPaso1Button;
    private javax.swing.JButton continuarPaso2Button;
    private org.jdesktop.swingx.JXPanel dinoPanel;
    private org.jdesktop.swingx.JXLabel erroresLabel3;
    private org.jdesktop.swingx.JXLabel erroresLabel4;
    private javax.swing.JComboBox<String> estacionDestinoSelector;
    private javax.swing.JComboBox<String> estacionOrigenSelector;
    private org.jdesktop.swingx.JXDatePicker fechaDatePicker;
    private javax.swing.JButton intercambiarEstacionesButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox mascotaCheckBox;
    private javax.swing.JPanel opcionesPanel;
    private javax.swing.JLabel paso1Label;
    private javax.swing.JLabel paso1Label1;
    private javax.swing.JLabel paso1Label2;
    private javax.swing.JLabel paso1Label3;
    private javax.swing.JPanel paso1Panel;
    private javax.swing.JPanel paso2Panel;
    private javax.swing.JPanel paso3Panel;
    private javax.swing.JPanel paso4Panel;
    private javax.swing.JPanel pinTarjetaCreditoPanel;
    private javax.swing.JPasswordField pinTarjetaField;
    private org.jdesktop.swingx.JXList rutasList;
    private javax.swing.JLabel seleccioneEstacionLabel;
    private javax.swing.JLabel seleccioneEstacionLabel1;
    private javax.swing.JLabel seleccioneEstacionLabel2;
    private javax.swing.JLabel seleccioneEstacionLabel3;
    private org.jdesktop.swingx.JXButton tarjetaCreditoButton;
    private javax.swing.JPanel tarjetaCreditoPanel;
    private javax.swing.JRadioButton tarjetaCreditoRadioButton;
    private org.jdesktop.swingx.JXButton tarjetaCylButton;
    private javax.swing.JPanel tarjetaCylPanel;
    private javax.swing.JRadioButton tarjetaCylRadioButton;
    private javax.swing.JButton volver2Button;
    private javax.swing.JButton volver3Button;
    // End of variables declaration//GEN-END:variables

    
    /**
     * Establece la visibilidad del paso para que el usuario lo vea
     * @param i paso del que se quiere activar la visibilidad 
     */
    public void activarPaso(int i) {
        desactivarPasos();
        switch (i) {
            case 1:
                paso1Panel.setVisible(true);
                break;
            case 2:
                paso2Panel.setVisible(true);
                break;
            case 3:
                paso3Panel.setVisible(true);
                break;
            case 4:
                paso4Panel.setVisible(true);
                break;
        }
    }
    /**
     * Muestra el error producido
     * @param paso paso en el que se produjo un error
     */
    public void escribirError(int paso) {
        switch (paso) {
            case 1:
                paso1Panel.setVisible(true);
                break;
            case 2:
                paso2Panel.setVisible(true);
                break;
            case 3:
                paso3Panel.setVisible(true);
                break;
        }
    }
    /**
     * Desactiva la visibilidad de los pasos
     */
    private void desactivarPasos() {
        paso1Panel.setVisible(false);
        paso2Panel.setVisible(false);
        paso3Panel.setVisible(false);
        paso4Panel.setVisible(false);
    }
    /**
     * Inicializa el selector de estaciones con la lista proporcionada.
     * @param estaciones La lista de nombres de estaciones a mostrar en el selector
     */
    public void inicializarEstaciones(ArrayList<String> estaciones) {
        estacionOrigenSelector.removeAllItems();
        for (String estacion : estaciones) {
            estacionOrigenSelector.addItem(estacion);
        }

        Viaje v = controlador.getRandomViaje();
        estacionOrigenSelector.setSelectedItem(v.getEstacionOrigen());
        actualizarSeleccionEstacionDestino();
        estacionOrigenSelector.setSelectedItem(v.getEstacionDestino());
    }

    /**
     * Actualiza el modelo de la lista de viajes con la lista proporcionada de viajes.
     * @param viajes La lista de viajes a utilizar para actualizar la lista
     */
    public void actualizarViajes(ArrayList<Viaje> viajes) {
        viajesListModel.removeAllElements();
        for (Viaje viaje : viajes) {
            viajesListModel.addElement(viaje);
        }
    }

    /**
     * Obtiene la fecha actual
     * @return devuelve la fecha actual
     */
    public LocalDateTime getFecha() {
        try {
            return fechaDatePicker.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Devuelve el viaje seleccionado en la lista de rutas
     * @return El viaje seleccionado en la lista de rutas
     */
    public Viaje getSelectedViaje() {
        return (Viaje) rutasList.getSelectedValue();
    }
    
    /**
     * Devuelve el estado de selección del checkbox de bicicleta
     * @return True si el checkbox de bicicleta está seleccionado.False en caso contrario
     */
    public boolean getBicicletaSelection() {
        return bicicletaCheckBox.isSelected();
    }
    
    /**
     * Devuelve el estado de selección del checkbox de la mascota
     * @return True si el checkbox de mascota está seleccionado.False en caso contrario
     */
    public boolean getMascotaSelection() {
        return mascotaCheckBox.isSelected();
    }

    /**
    * Devuelve la estación seleccionada como estación de origen en el selector de estaciones
    * @return El nombre de la estación seleccionada como estación de origen
    */
    public String getEstacionOrigen() {
        return (String) estacionOrigenSelector.getSelectedItem();
    }
    /**
     * Devuelve la estación seleccionada como estación de destino en el selector de estaciones.
     * @return El nombre de la estación seleccionada como estación de destino
     */
    public String getEstacionDestino() {
        return (String) estacionDestinoSelector.getSelectedItem();
    }
    
    /**
     * Desactiva los selectores de tarjeta de crédito y tarjeta CYL
     */
    private void desactivarSelectoresTarjeta() {
        tarjetaCreditoRadioButton.setSelected(false);
        tarjetaCylRadioButton.setSelected(false);
    }
    
    /**
     * Desactiva los paneles relacionados con las tarjetas CYL y de crédito.
     */
    private void desactivarPanelesTarjeta() {
        tarjetaCylPanel.setVisible(false);
        tarjetaCreditoPanel.setVisible(false);
    }
    
    /**
     * Obtiene el PIN introducido en el campo de texto correspondiente al PIN de la tarjeta
     * @return El pin que el usuario introdujo
     */
    public String getPinTarjeta() {
        return pinTarjetaField.getText();
    }

    /**
     * Activa el panel relacionado con el ingreso del PIN de la tarjeta de crédito.
     */
    public void activarPinTarjeta() {
        pinTarjetaCreditoPanel.setVisible(true);
    }

    /**
     * Desactiva el panel relacionado con el ingreso del PIN de la tarjeta de crédito
     */
    public void desactivarPinTarjeta() {
        pinTarjetaCreditoPanel.setVisible(false);
    }

    /**
     * Muestra un mensaje de error en el paso 3 al procesar la tarjeta de crédito
     * @param mensaje El mensaje a mostrar
     * @param codigoMensaje El código que indica el tipo de mensaje (ERROR o NORMAL)
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
    
    /**
     * Muestra un mensaje de error en el paso 3 al procesar la tarjeta de CYL
     * @param mensaje El mensaje a mostrar
     * @param codigoMensaje El código que indica el tipo de mensaje (ERROR o NORMAL)
     */
    public void mensajePaso3TarjetaCyl(String mensaje, Utiles.codigoMensaje codigoMensaje) {
        erroresLabel4.setText(mensaje);
        switch (codigoMensaje) {
            case ERROR:
                erroresLabel4.setForeground(Color.red);
                Toolkit.getDefaultToolkit().beep();
                break;
            case NORMAL:
                erroresLabel4.setForeground(Color.black);
                break;
        }
    }
    
    /**
     * Limpia y restaura el estado de los componentes de la interfaz de usuario
     */
    private void limpiar() { 
        mensajePaso3TarjetaCredito("Mantenga usted la tarjeta 2 segundos", Utiles.codigoMensaje.NORMAL);
        mensajePaso3TarjetaCyl("Mantenga usted la tarjeta 2 segundos", Utiles.codigoMensaje.NORMAL);
        bicicletaCheckBox.setSelected(false);
        mascotaCheckBox.setSelected(false);
        fechaDatePicker.setDate(new Date());
        inicializarEstaciones(controlador.getEstaciones());
        desactivarSelectoresTarjeta();
        desactivarPanelesTarjeta();
        pinTarjetaField.setText("");
        desactivarPinTarjeta();
        tarjetaCreditoRadioButton.setSelected(true);
        tarjetaCreditoPanel.setVisible(true);
    }
    
    /**
     * Actualiza las opciones del selector de estaciones de destino
     */
    private void actualizarSeleccionEstacionDestino() {
        estacionDestinoSelector.removeAllItems();
        ArrayList<String> estacionesDestinoPosibles = controlador.getPosiblesEstacionesDestino(getEstacionOrigen());
        for (String estacion : estacionesDestinoPosibles) {
            estacionDestinoSelector.addItem(estacion);
        }
    }
    
    /**
     * Muestra un diálogo de error con el mensaje proporcionado
     * @param mensaje El mensaje de error a mostrar en el diálogo
     */
    public void dialogoError(String mensaje) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, mensaje, "¡ERROR!", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Muestra un diálogo de alerta con el mensaje proporcionado.
     * @param mensaje El mensaje de advertencia a mostrar en el diálogo
     */
    public void dialogoAlerta(String mensaje) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, mensaje, "¡WARNING!", JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * Reproduce un sonido
     */
    public void sonidoAmigable() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("src/main/resources/SonidoAmigable.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}//class Vista
