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

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setMascota(boolean mascota) {
        this.mascota = mascota;
    }

    public void setBicicleta(boolean bicicleta) {
        this.bicicleta = bicicleta;
    }

    public String getEstacionOrigen() {
        return estacionOrigen;
    }

    public String getEstacionDestino() {
        return estacionDestino;
    }

    public LocalTime getHora() {
        return hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean getMascota() {
        return mascota;
    }

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

    public String toStringCSV() {
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";" + hora.format(DateTimeFormatter.ofPattern("HH:mm")) + ";" + id + ";" + estacionOrigen + ";" + estacionDestino + ";" + tiempo + ";" + precio + ";" + bicicleta + ";" + mascota;
    }

    @Override
    public int compareTo(Billete otroBillete) {
        return fecha.equals(otroBillete.fecha) ? hora.compareTo(otroBillete.hora) : fecha.compareTo(otroBillete.fecha);
    }

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
}
