/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.modelo;

import java.time.LocalTime;

/**
 * @author Daniel Garcia Solla
 * @author Carolina de las Heras Clavier
 */
public class Viaje implements Comparable<Viaje> {

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

    public String getIdRuta() {
        return idRuta;
    }

    /**
     * Obtiene la estacion de origen que el usuario ha elegido
     *
     * @return la estacion de origen que el usuario ha elegido
     */
    public String getEstacionOrigen() {
        return estacionOrigen;
    }

    public int getTiempo() {
        return tiempo;
    }

    /**
     * Obtiene la estacion de destino que el usuario ha elegido
     *
     * @return la estacion de destino que el usuario ha elegido
     */
    public String getEstacionDestino() {
        return estacionDestino;
    }

    /**
     * Obtiene si es fin de semana
     *
     * @return True o False si es fin de semana
     */
    public boolean isFinSemana() {
        return finSemana;
    }

    /**
     * Obtiene el horario del viaje que el usuario quiere hacer
     *
     * @return el horario del viaje
     */
    public LocalTime getHorario() {
        String[] chunks = horario.split(":");
        return LocalTime.of(Integer.parseInt(chunks[0]), Integer.parseInt(chunks[1]));
    }

    /**
     * Sobrescribe el método toString por defecto
     *
     * @return una cadena que contiene el ID de la ruta, el tiempo, el horario y
     * el precio de la ruta.
     */
    @Override
    public String toString() {
        return idRuta + " " + tiempo + "m " + horario + " " + precio + "€";
    }

    /**
     * Obtiene el precio del viaje
     *
     * @return el precio del viaje
     */
    public double getPrecio() {
        return precio;
    }

    /**
    * Compara un viaje con otro 
    * @param otroViaje El viaje con el que se quiere comparar
    * @return Un valor entero negativo si este viaje es anterior al otro viaje, 
    *  cero si son iguales, o un valor entero positivo si este viaje es posterior al otro viaje
    */
    @Override
    public int compareTo(Viaje otroViaje) {
        return this.getHorario().compareTo(otroViaje.getHorario());
    }
}//class Viaje
