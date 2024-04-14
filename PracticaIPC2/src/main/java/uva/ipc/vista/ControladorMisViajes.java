/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.vista;

import java.util.*;
import uva.ipc.app.Main;
import uva.ipc.modelo.Billete;
import uva.ipc.modelo.Modelo;

/**
 * @author Daniel Garcia Solla
 * @author Carolina de las Heras Clavier
 */
public class ControladorMisViajes {

    private VistaMisViajes vista;
    private Modelo modelo;

    public ControladorMisViajes(VistaMisViajes vista) {
        this.vista = vista;
        this.modelo = Main.getModelo();
    }
    
    /**
     * Permite volver a la vista del menu inicial
     */
    public void volverMenu() {
        Main.getGestorVistas().mostrarVistaMenu();
    }
    
    /**
     * Permite volver a la vista de acceso con tarjeta
     */
    public void volver() {
        Main.getGestorVistas().mostrarVistaAccesoTarjeta();
    }
    
    /**
    * Obtiene una lista de billetes almacenados en el sistema
    * @return lista con los billetes almacenados en el sistema.
    */
    public ArrayList<Billete> getBilletes() {
        return Main.getModelo().getBilletes();
    }
    
    /**
     * Permite devolver un billete
     */
    public void devolverBillete() {
        if (vista.getSelectedBillete() == null) {
            Utiles.dialogoError("Por favor, seleccione usted un billete");
        } else {
            Main.getModelo().devolverBillete(vista.getSelectedBillete());
            vista.actualizarBilletes();
            vista.notificarBilleteDevuelto();
        }
    }
    
    /**
     * Permite editar un billete
     */
    public void editarBillete() {
        if (vista.getSelectedBillete() == null) {
            Utiles.dialogoError("Por favor, seleccione usted un billete");
        } else {
            Main.getModelo().setSelectedBilleteEdicion(vista.getSelectedBillete());
            vista.actualizarVistaEditarBillete(Main.getModelo().getViajesPaso2());
            vista.activarVistaEditarBillete();
        }
    }
    
    /**
     * Muestra la vista de Billetes del usuario cuando se decide cancelar la edicion de un billete
     */
    public void cancelarEdicion() {
        vista.activarVistaMisBilletes();
    }
    
    /**
     * Confirma la realizacion de la edicion de un billete
     */
    public void confirmarEdicion() {
        if (vista.getNewSelectedViaje() == null) {
            Utiles.dialogoError("Por favor, seleccione usted un viaje");
        } else {
            Main.getModelo().setBicicleta(vista.getBicicleta());
            Main.getModelo().setMascota(vista.getMascota());
            Main.getModelo().actualizarBillete(vista.getNewSelectedViaje());
            vista.actualizarBilletes();
            vista.activarVistaMisBilletes();
            vista.notificarBilleteEditado();
        }
    }
}//class Controlador
