/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.numberadditionmodelo;

import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class ModeloNA {

    private ArrayList<EntradaHistorial> historial = new ArrayList<>();
    private double resultado;

    public ModeloNA() {
        this.historial = new ArrayList<>();
    }

    public void addEntrada(EntradaHistorial entrada) {
        historial.add(entrada);
    }

    public ArrayList<EntradaHistorial> getHistorial() {
        return (ArrayList<EntradaHistorial>) historial.clone();
    }

    public double getResultado() {
        return resultado;
    }

    public void sumar(EntradaHistorial entrada) {
        resultado = entrada.getPrimerSumando() + entrada.getSegundoSumando();
    }
}
