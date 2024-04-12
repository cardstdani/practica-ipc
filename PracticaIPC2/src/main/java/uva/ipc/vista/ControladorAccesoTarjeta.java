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

    public void tarjetaCylStart() {
        modelo.tarjetaCylStart(this);
    }

    public void tarjetaCylStop() {
        modelo.tarjetaCylStart(this);
    }

    public void tarjetaCylValida() {
        vista.tarjetaValida();
    }

    public void volverMenu() {
        Main.getGestorVistas().mostrarVistaMenu();
    }

    public boolean isTarjetaValida() {
        return modelo.isTarjetaCylValida();
    }

    public String getPoliticaPrivacidad() {
        return modelo.getPoliticaPrivacidad();
    }

    public void recargarTarjeta() {
        Main.getGestorVistas().mostrarVistaRecargarTarjeta();
    }

    public void misViajes() {
        Main.getGestorVistas().mostrarVistaMisViajes();
    }
}//class Controlador
