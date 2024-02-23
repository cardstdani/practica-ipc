/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.numberadditionmodelo;

/**
 *
 * @author danie
 */
public class EntradaHistorial {

    private double primerSumando, segundoSumando;

    public EntradaHistorial(double a, double b) {
        primerSumando = a;
        segundoSumando = b;
    }

    public double getPrimerSumando() {
        return primerSumando;
    }

    public double getSegundoSumando() {
        return segundoSumando;
    }

    public String asText() {
        return "" + primerSumando + " + " + segundoSumando + " = " + (primerSumando + segundoSumando);
    }

    public void setPrimerSumando(double d) {
        primerSumando = d;
    }

    public void setSegundoSumando(double d) {
        segundoSumando = d;
    }
}
