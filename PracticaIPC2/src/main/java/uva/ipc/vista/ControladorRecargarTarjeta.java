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

    public void volverMenu() {
        Main.getGestorVistas().mostrarVistaMenu();
    }

    public void tarjetaCreditoStart() {
        modelo.tarjetaCreditoStart(this);
    }

    public void tarjetaCreditoStop() {
        modelo.tarjetaCreditoStop();
    }

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

    public void volverTarjetaCredito() {
        vista.mostrarRecargaTarjeta();
    }

    public void volverAccesoTarjeta() {
        Main.getGestorVistas().mostrarVistaAccesoTarjeta();
    }

    public void recargar10() {
        vista.mostrarTarjetaCredito();
        this.cantidadRecarga = 10;
    }

    public void recargar20() {
        vista.mostrarTarjetaCredito();
        this.cantidadRecarga = 20;
    }

    public void recargar50() {
        vista.mostrarTarjetaCredito();
        this.cantidadRecarga = 50;
    }

    public void tarjetaCreditoValida() {
        vista.mostrarPinTarjetaPanel();
    }
}//class Controlador
