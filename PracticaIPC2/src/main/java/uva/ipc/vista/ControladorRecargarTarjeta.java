/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.vista;

import uva.ipc.app.Main;
import uva.ipc.modelo.Modelo;

/**
 * @author Daniel Garcia Solla
 * @author Carolina de las Heras Clavier
 */
public class ControladorRecargarTarjeta {

    private VistaRecargarTarjeta vista;
    private Modelo modelo;
    private double cantidadRecarga;

    public ControladorRecargarTarjeta(VistaRecargarTarjeta vista) {
        this.vista = vista;
        this.modelo = Main.getModelo();
        this.vista.actualizarSaldo(modelo.getSaldo());
    }
    
    /**
     * Permite volver al menu inicial mostrando dicha vista
     */
    public void volverMenu() {
        Main.getGestorVistas().mostrarVistaMenu();
    }
    
    /**
     * Inicia el proceso de pago con tarjeta de credito
     */
    public void tarjetaCreditoStart() {
        modelo.tarjetaCreditoStart(this);
    }
    
    /**
     * Detiene el proceso de pago con tarjeta de credito
     */
    public void tarjetaCreditoStop() {
        modelo.tarjetaCreditoStop();
    }
    
    /**
     * Procesa la aceptacion del pago con tarjeta de credito
     */
    public void aceptarPagoTarjetaCredito() {
        if (modelo.validarPin(vista.getPinTarjeta())) {
            //continuarPaso3();
            modelo.recargarTarjetaCyl(cantidadRecarga);
            Utiles.sonidoAmigable();
            vista.mostrarFelicidadesPanel();
        } else {
            vista.mensajePaso3TarjetaCredito("Su PIN es incorrecto", Utiles.codigoMensaje.ERROR);
        }
    }
    
    /**
     * Regresa a la vista de recarga de tarjeta de credito mostrando dicha vista
     */
    public void volverTarjetaCredito() {
        vista.mostrarRecargaTarjeta();
    }
    
    /**
     * Regresa a la vista de recarga de tarjeta
     */
    public void volverAccesoTarjeta() {
        Main.getGestorVistas().mostrarVistaAccesoTarjeta();
    }

    /**
     * Establece el precio de la recarga en 10$
     */
    public void recargar10() {
        vista.mostrarTarjetaCredito();
        this.cantidadRecarga = 10;
    }
    
    /**
     * Establece el precio de la recarga en 20$
     */
    public void recargar20() {
        vista.mostrarTarjetaCredito();
        this.cantidadRecarga = 20;
    }
    
    /**
     * Establece el precio de la recarga en 50$
     */
    public void recargar50() {
        vista.mostrarTarjetaCredito();
        this.cantidadRecarga = 50;
    }
    
    /**
     * Muestra el panel para que usuario inserte su pin de la tarjeta 
     */
    public void tarjetaCreditoValida() {
        vista.mostrarPinTarjetaPanel();
    }
}//class Controlador
