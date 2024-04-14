/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.vista;

import javax.swing.JFrame;

/**
 * @author Daniel Garcia Solla
 * @author Carolina de las Heras Clavier
 */
public class GestorVistas {

    private JFrame vistaActual;

    /**
     * Muesta la vista para comprar un billete y gestiona la vista que hay actualemente
     */
    public void mostrarVistaComprarBillete() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaCompraBillete();
        vistaActual.setVisible(true);
    }
    
    /**
     * Muesta la vista del menu inicial y gestiona la vista que hay actualemente
     */
    public void mostrarVistaMenu() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaMenu();
        vistaActual.setVisible(true);
    }
    
    /**
     * Muesta la vista de acceso con tarjeta y gestiona la vista que hay actualemente
     */
    public void mostrarVistaAccesoTarjeta() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaAccesoTarjeta();
        vistaActual.setVisible(true);
    }
    
    /**
     * Muesta la vista de recargar con tarjeta y gestiona la vista que hay actualemente
     */
    public void mostrarVistaRecargarTarjeta() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaRecargarTarjeta();
        vistaActual.setVisible(true);
    }
    
    /**
     * Muesta la vista donde el usuario puede ver los viajes que tiene y gestiona la vista que hay actualemente
     */
    public void mostrarVistaMisViajes() {
        if (vistaActual != null) {
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaMisViajes();
        vistaActual.setVisible(true);
    }
}// class GestorVistas
