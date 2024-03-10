/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.controlador;

import uva.ipc.modelo.Modelo;
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
        this.modelo = new Modelo();
        vista.inicializarEstaciones(modelo.getEstaciones());
    }

    public void continuarPaso1() {
        if (comprobarErrorPaso1().equals("")) {
            modelo.setEstacionOrigen(vista.getEstacionOrigen());
            modelo.setEstacionDestino(vista.getEstacionDestino());
            modelo.setFecha(vista.getFecha());
            vista.actualizarViajes(modelo.getViajes());
            vista.activarPaso(2);
        } else {

        }
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

    private String comprobarErrorPaso1() {
        return "";
    }

    private String comprobarErrorPaso2() {
        return "";
    }

    public void aceptarPagoTarjetaCredito() {
        if (modelo.validarPin(vista.getPinTarjeta())) {
            continuarPaso3();
        }
    }
}
