/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.controlador;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uva.ipc.modelo.Modelo;
import uva.ipc.modelo.Viaje;
import uva.ipc.vista.Utiles;
import uva.ipc.vista.Vista;

/**
 *
 * @author danie
 */
public class Controlador {

    private Vista vista;
    private Modelo modelo;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.modelo = new Modelo(this);
    }

    public void continuarPaso1() {
        modelo.setEstacionOrigen(vista.getEstacionOrigen());
        modelo.setEstacionDestino(vista.getEstacionDestino());
        modelo.setFecha(vista.getFecha());
        vista.actualizarViajes(modelo.getViajesPaso2());
        vista.activarPaso(2);
    }

    public void continuarPaso2() {
        if (comprobarErrorPaso2().equals("")) {
            modelo.setSelectedViaje(vista.getSelectedViaje());
            modelo.setMascota(vista.getMascotaSelection());
            modelo.setBicicleta(vista.getBicicletaSelection());
            vista.activarPaso(3);
        } else {

        }
    }

    public void continuarPaso3() {
        vista.activarPaso(4);
    }

    public void volverPaso2() {
        vista.activarPaso(1);
    }

    public void volverPaso3() {
        vista.activarPaso(2);
    }

    private String comprobarErrorPaso2() {
        return "";
    }

    public void aceptarPagoTarjetaCredito() {
        if (modelo.validarPin(vista.getPinTarjeta())) {
            continuarPaso3();
        } else {
            vista.mensajePaso3("Su PIN es incorrecto", Utiles.codigoMensaje.ERROR);
        }
    }

    public void tarjetaCreditoStart() {
        modelo.tarjetaCreditoStart();
    }

    public void tarjetaCreditoStop() {
        modelo.tarjetaCreditoStop();
    }

    public void tarjetaCylStart() {
        modelo.tarjetaCylStart();
    }

    public void tarjetaCylStop() {
        modelo.tarjetaCylStop();
    }

    public void tarjetaCreditoValida() {
        vista.activarPinTarjeta();
        vista.mensajePaso3("Inserte usted el pin de su tarjeta", Utiles.codigoMensaje.NORMAL);
    }

    public void tarjetaCylValida() {
        vista.activarPaso(4);
    }

    public Viaje getRandomViaje() {
        return modelo.getRandomViaje();
    }

    public ArrayList<String> getPosiblesEstacionesDestino(String estacionOrigen) {
        return modelo.getPosiblesEstacionesDestino(estacionOrigen);
    }

    public ArrayList<String> getEstaciones() {
        return modelo.getEstaciones();
    }
}
