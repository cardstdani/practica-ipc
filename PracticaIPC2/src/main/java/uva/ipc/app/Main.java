/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.app;
import uva.ipc.modelo.Modelo;
import uva.ipc.vista.GestorVistas;

/**
 *
 * @author danie
 */
public class Main {

    private static GestorVistas gestor;
    private static Modelo modelo;

    public static void main(String[] args) {
        gestor = new GestorVistas();
        modelo = new Modelo();
        gestor.mostrarVistaMenu();
    }

    public static GestorVistas getGestorVistas() {
        return gestor;
    }

    public static Modelo getModelo() {
        return modelo;
    }
}
