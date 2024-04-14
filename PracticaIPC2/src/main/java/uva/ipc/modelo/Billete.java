/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.modelo;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author Daniel Garcia Solla
 * @author Carolina de las Heras Clavier
 */
public class Billete implements Comparable<Billete> {

    private LocalDate fecha;
    private LocalTime hora;
    private String id;
    private String estacionDestino;
    private String estacionOrigen;
    private int tiempo;
    private double precio;
    private boolean bicicleta, mascota;

    public Billete(String fecha, String hora, String id, String estacionOrigen, String estacionDestino, String tiempo, String precio, String bicicleta, String mascota) {
        this.fecha = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.hora = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
        this.estacionDestino = estacionDestino;
        this.estacionOrigen = estacionOrigen;
        this.id = id;
        this.tiempo = Integer.parseInt(tiempo);
        this.precio = Double.parseDouble(precio);
        this.bicicleta = Boolean.parseBoolean(bicicleta);
        this.mascota = Boolean.parseBoolean(mascota);
    }

    /**
     * Establece la hora del viaje que el usuario ha elegido
     * @param hora que el usuario ha elegido para viajar
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    /***
     * Establece el identificador del billete
     * @param id identificador del billete
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Establece el tiempo del viaje
     * @param tiempo duracion del viaje
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
     /**
     * Establece si el usuario ha elegido llevar una mascota en su viaje
     * @param mascotaSelection True o False dependiendo de si el usuario ha elegido llevar mascota
     */
    public void setMascota(boolean mascota) {
        this.mascota = mascota;
    }
    
    /**
     * Establece si el usuario ha elegido llevar una bicicleta en su viaje
     *
     * @param bicicletaSelection True o False dependiendo de si el usuario ha
     * elegido llevar bicicleta
     */
    public void setBicicleta(boolean bicicleta) {
        this.bicicleta = bicicleta;
    }
    
    /**
     * Obtiene la estacion de origen del billete
     * @return la estacion origen 
     */
    public String getEstacionOrigen() {
        return estacionOrigen;
    }
    
    /**
     * Obtiene la estacion de destino del billete
     * @return la estacion destino 
     */
    public String getEstacionDestino() {
        return estacionDestino;
    }
    
    /**
     * Obtiene la hora del viaje
     * @return la hora del viaje
     */
    public LocalTime getHora() {
        return hora;
    }
    
    /**
     * Obtiene la fecha del viaje
     * @return la fecha del viaje
     */
    public LocalDate getFecha() {
        return fecha;
    }
    
    /**
     * Obtiene si el usuario ha elegido llevar o no mascota
     * @return True o False dependiendo de si el usuario ha decidido llevar o no mascota
     */
    public boolean getMascota() {
        return mascota;
    }

    /**
     * Obtiene si el usuario ha elegido llevar o no bicicleta
     * @return True o False dependiendo de si el usuario ha decidido llevar o no bicicleta
     */
    public boolean getBicicleta() {
        return bicicleta;
    }

    /**
     * Sobrescribe el método toString por defecto
     */
    @Override
    public String toString() {
        String bicicletaString = bicicleta ? "Bicicleta" : "";
        String mascotaString = mascota ? "Mascota" : "";
        return fecha + " " + hora + " " + id + " " + estacionOrigen + " " + estacionDestino + " " + tiempo + "m " + precio + "€ " + bicicletaString + " " + mascotaString;
    }
    
    /**
     * Establece una cadena de texto en formato CSV
     * @return Una cadena de caracteres que representa el objeto en formato CSV.
     */
    public String toStringCSV() {
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";" + hora.format(DateTimeFormatter.ofPattern("HH:mm")) + ";" + id + ";" + estacionOrigen + ";" + estacionDestino + ";" + tiempo + ";" + precio + ";" + bicicleta + ";" + mascota;
    }
    
    /**
    * Compara este billete con otro billete basado en la fecha y la hora.
    * @param otroBillete El billete a comparar con este.
    * @return Un valor entero negativo si este billete es anterior al otro billete, 
    *         cero si son iguales, o un valor entero positivo si este billete es posterior al otro billete.
    */
    
    @Override
    public int compareTo(Billete otroBillete) {
        return fecha.equals(otroBillete.fecha) ? hora.compareTo(otroBillete.hora) : fecha.compareTo(otroBillete.fecha);
    }
    
    /**
    * Compara este billete con otro objeto para determinar si son iguales.
    * @param obj El objeto a comparar con este billete.
    * @return true si los objetos son iguales, false en caso contrario.
    */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Billete billete = (Billete) obj;
        return tiempo == billete.tiempo
                && billete.precio == precio
                && bicicleta == billete.bicicleta
                && mascota == billete.mascota
                && fecha.equals(billete.fecha)
                && hora.equals(billete.hora)
                && id.equals(billete.id)
                && estacionDestino.equals(billete.estacionDestino)
                && estacionOrigen.equals(billete.estacionOrigen);
    }
}//class Billete
