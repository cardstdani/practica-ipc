/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.modelo;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.util.*;
import joinery.DataFrame;

/**
 *
 * @author danie
 */
public class Modelo {

    private ArrayList<String> estaciones = new ArrayList<>();
    private ArrayList<Viaje> viajes = new ArrayList<>();
    private String estacionOrigen, estacionDestino;
    private LocalDateTime fecha;

    public Modelo() {
        String csvFile = "src/resources/estaciones.csv";
        String rutasCsvFile = "src/resources/rutas.csv";

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
    }

    public ArrayList<String> getEstaciones() {
        return (ArrayList<String>) estaciones.clone();
    }

    public ArrayList<Viaje> getViajes() {
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
}
