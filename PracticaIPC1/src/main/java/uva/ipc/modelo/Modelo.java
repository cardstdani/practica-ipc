/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.modelo;

import java.io.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Timer;
import uva.ipc.controlador.Controlador;

/**
 *
 * @author danie
 */
public class Modelo {

    private ArrayList<String> estaciones = new ArrayList<>();
    private ArrayList<Viaje> viajes = new ArrayList<>();
    private String estacionOrigen, estacionDestino;
    private LocalDateTime fecha;
    private Viaje viaje;
    private boolean mascota, bicicleta;
    Timer timerTarjetaCredito, timerTarjetaCyl;
    private final Controlador controlador;

    public Modelo(Controlador controlador) {
        this.controlador = controlador;
        String csvFile = "src/main/resources/estaciones.csv";
        String rutasCsvFile = "src/main/resources/rutas.csv";

        //Procesar estaciones
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                estaciones.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        //Procesar rutas
        try (BufferedReader br = new BufferedReader(new FileReader(rutasCsvFile))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] chunks = line.split(";");

                for (String horarioSemana : chunks[5].split(",")) {
                    viajes.add(new Viaje(chunks[0], chunks[1], chunks[2], Integer.parseInt(chunks[3]), Double.parseDouble(chunks[4]), horarioSemana, false));
                }
                for (String horarioFinSemana : chunks[6].split(",")) {
                    viajes.add(new Viaje(chunks[0], chunks[1], chunks[2], Integer.parseInt(chunks[3]), Double.parseDouble(chunks[4]), horarioFinSemana, true));
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        timerTarjetaCredito = new Timer(2000, e -> {
            this.controlador.tarjetaCreditoValida();
        });
        timerTarjetaCyl = new Timer(2000, e -> {
            this.controlador.tarjetaCylValida();
        });
        timerTarjetaCyl.setRepeats(false);
    }

    public ArrayList<String> getEstaciones() {
        return (ArrayList<String>) estaciones.clone();
    }

    public ArrayList<Viaje> getViajesPaso2() {
        ArrayList<Viaje> out = new ArrayList<>();
        for (Viaje viaje : viajes) {
            if (viaje.getEstacionOrigen().equals(estacionOrigen) && viaje.getEstacionDestino().equals(estacionDestino) && (viaje.isFinSemana() == (fecha.getDayOfWeek().getValue() > 5))) {
                out.add(viaje);
            }
        }
        return out;
    }

    public void setEstacionOrigen(String estacionOrigen) {
        this.estacionOrigen = estacionOrigen;
    }

    public void setEstacionDestino(String estacionDestino) {
        this.estacionDestino = estacionDestino;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setSelectedViaje(Viaje selectedViaje) {
        this.viaje = selectedViaje;
    }

    public void setMascota(boolean mascotaSelection) {
        this.mascota = mascotaSelection;
    }

    public void setBicicleta(boolean bicicletaSelection) {
        this.bicicleta = bicicletaSelection;
    }

    public boolean validarPin(String pinTarjeta) {
        return pinTarjeta.equals("1234");
    }

    public void tarjetaCreditoStart() {
        timerTarjetaCredito.start();
    }

    public void tarjetaCreditoStop() {
        timerTarjetaCredito.stop();
    }

    public void tarjetaCylStart() {
        timerTarjetaCyl.start();
    }

    public void tarjetaCylStop() {
        timerTarjetaCyl.stop();
    }

    public Viaje getRandomViaje() {
        return viajes.get(ThreadLocalRandom.current().nextInt(viajes.size()));
    }

    public ArrayList<String> getPosiblesEstacionesDestino(String estacionOrigen) {
        ArrayList<String> out = new ArrayList<>();
        for (Viaje viaje : viajes) {
            if (viaje.getEstacionOrigen().equals(estacionOrigen) && !out.contains(viaje.getEstacionDestino())) {
                out.add(viaje.getEstacionDestino());
            }
        }
        return out;
    }
}
