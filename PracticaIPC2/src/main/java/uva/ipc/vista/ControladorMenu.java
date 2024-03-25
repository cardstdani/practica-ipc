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
public class ControladorMenu {

    private VistaMenu vista;
    private Modelo modelo;

    public ControladorMenu(VistaMenu vista) {
        this.vista = vista;
        this.modelo = Main.getModelo();
    }

    public void comprarBillete() {
        Main.getGestorVistas().mostrarVistaComprarBillete();
    }

    public void accesoTarjeta() {
        Main.getGestorVistas().mostrarVistaAccesoTarjeta();
    }
}//class Controlador
