/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.modelo;

/**
 *
 * @author danie
 */
public class Viaje {

    private String idRuta;
    private String estacionOrigen;
    private String estacionDestino;
    private int tiempo;
    private double precio;
    private String horario;
    private final boolean finSemana;

    public Viaje(String idRuta, String estacionOrigen, String estacionDestino, int tiempo, double precio, String horario, boolean finSemana) {
        this.idRuta = idRuta;
        this.estacionOrigen = estacionOrigen;
        this.estacionDestino = estacionDestino;
        this.tiempo = tiempo;
        this.precio = precio;
        this.horario = horario;
        this.finSemana = finSemana;
    }

    public String getEstacionOrigen() {
        return estacionOrigen;
    }

    public String getEstacionDestino() {
        return estacionDestino;
    }

    public boolean isFinSemana() {
        return finSemana;
    }       

    @Override
    public String toString() {
        return idRuta + " " + tiempo + " " + horario + " " + precio + "$";
    }
}
