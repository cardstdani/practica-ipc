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
public class ControladorAccesoTarjeta {

    private VistaAccesoTarjeta vista;
    private Modelo modelo;

    public ControladorAccesoTarjeta(VistaAccesoTarjeta vista) {
        this.vista = vista;
        this.modelo = Main.getModelo();
        this.vista.actualizarSaldo(modelo.getSaldo());
        this.vista.actualizarViajes(modelo.getNumeroViajes());
    }

    /**
    * Inicia el proceso de pago con tarjeta CYL    
    */
    public void tarjetaCylStart() {
        modelo.tarjetaCylStart(this);
    }
    
    /**
    * Detiene el proceso de pago con tarjeta CYL    
    */
    public void tarjetaCylStop() {
        modelo.tarjetaCylStart(this);
    }
    
    /**
     * Establece que la tarjeta CYL ha sido validada
     */
    public void tarjetaCylValida() {
        vista.tarjetaValida();
    }
    
    /**
     * Permite volver a la vista menu inicial
     */
    public void volverMenu() {
        Main.getGestorVistas().mostrarVistaMenu();
    }
    
    /**
    * Verifica si la tarjeta CYL es valida
    * @return true si la tarjeta es válida, false en caso contrario.
    */
    public boolean isTarjetaValida() {
        return modelo.isTarjetaCylValida();
    }
    
    /**
     * Obtiene la politica de privacidad
     * @return la politica de privacidad
     */
    public String getPoliticaPrivacidad() {
        return modelo.getPoliticaPrivacidad();
    }
    
    /**
     * Permite mostrar la vista de Recargar la tarjeta
     */
    public void recargarTarjeta() {
        Main.getGestorVistas().mostrarVistaRecargarTarjeta();
    }

    /**
    * Muestra la vista que lista los viajes realizados por el usuario
    */
    public void misViajes() {
        Main.getGestorVistas().mostrarVistaMisViajes();
    }
}//class Controlador
