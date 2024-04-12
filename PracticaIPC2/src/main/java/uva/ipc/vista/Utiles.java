/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

/**
 * @author Daniel Garcia Solla
 * @author Carolina de las Heras Clavier
 */
public class Utiles {

    public enum codigoMensaje {
        ERROR, NORMAL
    }

    /**
     * Establece un icono en un JButton utilizando una imagen La imagen se
     * ajusta al tamaño del botón proporcionado.
     *
     * @param button El botón al que se le establecerá el icono.
     * @param path La ruta de archivo de la imagen que se utilizará como icono.
     */
    public static void setObjectIcon(JButton button, String path) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_AREA_AVERAGING);
        ImageIcon ic = new ImageIcon(img);
        button.setIcon(ic);
    }

    /**
     * Establece un icono en un JLabel utilizando una imagen La imagen se ajusta
     * al tamaño del label proporcionado.
     *
     * @param button El label al que se le establecerá el icono.
     * @param path La ruta de archivo de la imagen que se utilizará como icono.
     */
    public static void setObjectIcon(JLabel button, String path) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_AREA_AVERAGING);
        ImageIcon ic = new ImageIcon(img);
        button.setIcon(ic);
    }

    /**
     * Muestra un diálogo de error con el mensaje proporcionado
     *
     * @param mensaje El mensaje de error a mostrar en el diálogo
     */
    public static void dialogoError(String mensaje) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, mensaje, "¡ERROR!", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un diálogo de alerta con el mensaje proporcionado.
     *
     * @param mensaje El mensaje de advertencia a mostrar en el diálogo
     */
    public static void dialogoAlerta(String mensaje) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, mensaje, "¡WARNING!", JOptionPane.WARNING_MESSAGE);
    }

    public static void dialogoInformativo(String mensaje) {
        Toolkit.getDefaultToolkit().beep();
        JTextArea textArea = new JTextArea(mensaje);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(500, 250));
        JOptionPane.showMessageDialog(null, scrollPane, "Bienvenido mister marshall", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Reproduce un sonido
     */
    public static void sonidoAmigable() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("src/main/resources/SonidoAmigable.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}//class Utiles
