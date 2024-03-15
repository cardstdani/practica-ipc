/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.modelo;

/**
 * @author Daniel Garcia Solla
 * @author Carolina de las Heras Clavier 
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
    
    /**
     * Obtiene la estacion de origen que el usuario ha elegido
     * @return la estacion de origen que el usuario ha elegido
     */
    public String getEstacionOrigen() {
        return estacionOrigen;
    }
    /**
     * Obtiene la estacion de destino que el usuario ha elegido
     * @return la estacion de destino que el usuario ha elegido
     */
    public String getEstacionDestino() {
        return estacionDestino;
    }
    
    /**
     * Obtiene si es fin de semana
     * @return True o False si es fin de semana
     */
    public boolean isFinSemana() {
        return finSemana;
    }       

    
    
    
    
    
    @Override
    public String toString() {
        return idRuta + " " + tiempo + " " + horario + " " + precio + "$";
    }
}
