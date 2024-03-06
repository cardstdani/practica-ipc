/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.modelo;

import java.io.*;
import java.util.*;

/**
 *
 * @author danie
 */
public class Modelo {

    private ArrayList<String> estaciones = new ArrayList<>();

    public Modelo() {
        String csvFile = "src/resources/estaciones.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                estaciones.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        estaciones.remove(0);
    }

    public ArrayList<String> getEstaciones() {
        return (ArrayList<String>) estaciones.clone();
    }
}
