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

    public ControladorRecargarTarjeta(VistaRecargarTarjeta vista) {
        this.vista = vista;
        this.modelo = Main.getModelo();
        this.vista.actualizarSaldo(modelo.getSaldo());
    }

    public void volverMenu() {
        Main.getGestorVistas().mostrarVistaMenu();
    }

    void tarjetaCreditoStart() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void tarjetaCreditoStop() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void aceptarPagoTarjetaCredito() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void volverTarjetaCredito() {
        vista.mostrarRecargaTarjeta();
    }

    public void volverAccesoTarjeta() {
        Main.getGestorVistas().mostrarVistaAccesoTarjeta();
    }

    public void recargar10() {
        vista.mostrarTarjetaCredito();
    }
}//class Controlador
