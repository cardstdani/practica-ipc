/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.vista;

import javax.swing.JFrame;

/**
 *
 * @author mcorrales
 */
public class GestorVistas {

    private JFrame vistaActual;

    public void mostrarVistaComprarBillete() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaCompraBillete();
        vistaActual.setVisible(true);
    }

    public void mostrarVistaMenu() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaMenu();
        vistaActual.setVisible(true);
    }

    public void mostrarVistaAccesoTarjeta() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaAccesoTarjeta();
        vistaActual.setVisible(true);
    }

    public void mostrarVistaRecargarTarjeta() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaRecargarTarjeta();
        vistaActual.setVisible(true);
    }

    public void mostrarVistaMisViajes() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaMisViajes();
        vistaActual.setVisible(true);
    }
}
