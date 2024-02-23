/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.numberadditionvista;

import uva.ipc.numberadditionmodelo.EntradaHistorial;
import uva.ipc.numberadditionmodelo.ModeloNA;

/**
 *
 * @author danie
 */
public class ControladorNA {
    
    private final VistaNA miVista;
    private final ModeloNA miModelo;
    
    public ControladorNA(VistaNA vista) {
        this.miVista = vista;
        this.miModelo = new ModeloNA();
    }
    
    void salir() {
        System.exit(0);
    }
    
    void limpiar() {
        miVista.limpiar();
        miVista.limpiarError();
    }
    
    void eventoSumar() {
        double a, b;
        try {
            a = Double.parseDouble(miVista.getPrimerNumeroText());
        } catch (NumberFormatException e) {
            miVista.escribirError(e.getMessage());
            return;
        }
        try {
            b = Double.parseDouble(miVista.getSegundoNumeroText());
        } catch (NumberFormatException e) {
            miVista.escribirError(e.getMessage());
            return;
        }
        String res = Double.toString(a + b);
        miVista.setResultadoText(res);
        miModelo.addEntrada(new EntradaHistorial(a, b));
        String newHistorial = "";
        for (EntradaHistorial entrada : miModelo.getHistorial()) {
            newHistorial += entrada.asText() + "\n";
        }
        miVista.setHistorialText(newHistorial);
        miVista.escribirError("");
    }
}
