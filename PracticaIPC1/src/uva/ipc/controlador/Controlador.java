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
    }

    public void continuarPaso1() {
        if (comprobarErrorPaso1().equals("")) {
            vista.activarPaso(2);
        } else {

        }
    }

    public void continuarPaso2() {
        if (comprobarErrorPaso2().equals("")) {
            vista.activarPaso(3);
        } else {

        }
    }

    public void continuarPaso3() {
        if (comprobarErrorPaso3().equals("")) {
            vista.activarPaso(3);
        } else {

        }
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

    private String comprobarErrorPaso3() {
        return "";
    }
}
