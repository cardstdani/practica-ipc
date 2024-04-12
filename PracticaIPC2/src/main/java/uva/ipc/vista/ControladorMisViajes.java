/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.vista;

import java.util.*;
import uva.ipc.app.Main;
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

    public void volverMenu() {
        Main.getGestorVistas().mostrarVistaMenu();
    }

    public void volver() {
        Main.getGestorVistas().mostrarVistaAccesoTarjeta();
    }

    public ArrayList<String> getBilletes() {
        return Main.getModelo().getBilletes();
    }

}//class Controlador
