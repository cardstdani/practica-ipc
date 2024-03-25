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
import uva.ipc.vista.ControladorAccesoTarjeta;
import uva.ipc.vista.ControladorCompraBillete;

/**
 * @author Daniel Garcia Solla
 * @author Carolina de las Heras Clavier
 */
public class Modelo {

    private ArrayList<String> estaciones = new ArrayList<>();
    private ArrayList<Viaje> viajes = new ArrayList<>();//Ruta + Horario
    private String estacionOrigen, estacionDestino;
    private LocalDateTime fecha;
    private Viaje viaje;
    private boolean mascota, bicicleta;
    Timer timerTarjetaCredito, timerTarjetaCyl;
    private ControladorCompraBillete controladorCompraBillete = null;
    private ControladorAccesoTarjeta controladorTarjeta = null;
    private double saldoTarjetaCYL = 20;
    private boolean tarjetaCylValida = false;
    private String politicaPrivacidad = "";

    public Modelo() {
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
        //idRuta;estacionOrigen;estacionDestino;tiempo;precio;horariosSemana;horariosFinDeSemana
        //CYL5;Ponferrada - León;   Astorga - León;  25;  4.7;   08:00,10:00,12:00,14:00,16:00,18:00,22:00;  07:00,11:00,15:00,19:00
        try (BufferedReader br = new BufferedReader(new FileReader(rutasCsvFile))) {//nombre
            String line = br.readLine();//Coger siguiente linea de estaciones. Ej: Aguilar de Campoo - Palencia
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

        //Política privacidad
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/PoliticaPrivacidad.txt"))) {//nombre
            String line = null;//Coger siguiente linea de estaciones. Ej: Aguilar de Campoo - Palencia
            while ((line = br.readLine()) != null) {
                politicaPrivacidad += line;
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        timerTarjetaCredito = new Timer(2000, e -> {
            if (this.controladorCompraBillete != null) {
                this.controladorCompraBillete.tarjetaCreditoValida();
            }
        });
        timerTarjetaCyl = new Timer(2000, e -> {
            if (this.controladorCompraBillete != null) {
                this.controladorCompraBillete.comprarBilleteTarjetaCyl();
            }
            if (this.controladorTarjeta != null) {
                this.controladorTarjeta.tarjetaCylValida();
            }
            tarjetaCylValida = true;
        });
        timerTarjetaCyl.setRepeats(false);
    }

    public boolean isTarjetaCylValida() {
        return tarjetaCylValida;
    }

    public String getPoliticaPrivacidad() {
        return politicaPrivacidad;
    }

    /**
     * Obtiene el listado de estaciones
     *
     * @return el listado de estaciones
     */
    public ArrayList<String> getEstaciones() {
        return (ArrayList<String>) estaciones.clone();
    }

    /**
     * Obtiene el listado de viajes que se muestran en el paso 2 y que el
     * usuario puede elegir segun sus datos introducidos
     *
     * @return el listado de viajes que se deben de mostar en el paso 2
     */
    public ArrayList<Viaje> getViajesPaso2() {
        ArrayList<Viaje> out = new ArrayList<>();
        for (Viaje viaje : viajes) {
            if (viaje.getEstacionOrigen().equals(estacionOrigen) && viaje.getEstacionDestino().equals(estacionDestino) && (viaje.isFinSemana() == (fecha.getDayOfWeek().getValue() > 5))) {
                if (fecha.toLocalDate().equals(LocalDateTime.now().toLocalDate()) && viaje.getHorario().isBefore(LocalTime.now())) {//Validar hora del viaje
                    continue;
                }
                out.add(viaje);
            }
        }
        return out;
    }
    //Seleccion del usuario

    /**
     * Establece la estacion de origen que el usuario elije
     *
     * @param estacionOrigen la estacion de origen establecida por el usuario
     */
    public void setEstacionOrigen(String estacionOrigen) {
        this.estacionOrigen = estacionOrigen;
    }

    /**
     * Establece la estacion de destino que el usuario elije
     *
     * @param estacionDestino la estacion de destino establecida por el usuario
     */
    public void setEstacionDestino(String estacionDestino) {
        this.estacionDestino = estacionDestino;
    }

    /**
     * Establece la fecha del viaje que el usuario ha elegido
     *
     * @param fecha que el usuario ha elegido para viajar
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Establece el viaje que el usuario ha elegido
     *
     * @param selectedViaje el viaje que el usuario ha elegido
     */
    public void setSelectedViaje(Viaje selectedViaje) {
        this.viaje = selectedViaje;
    }

    /**
     * Establece si el usuario ha elegido llevar una mascota en su viaje
     *
     * @param mascotaSelection True o False dependiendo de si el usuario ha
     * elegido llevar mascota
     */
    public void setMascota(boolean mascotaSelection) {
        this.mascota = mascotaSelection;
    }

    /**
     * Establece si el usuario ha elegido llevar una bicicleta en su viaje
     *
     * @param bicicletaSelection True o False dependiendo de si el usuario ha
     * elegido llevar bicicleta
     */
    public void setBicicleta(boolean bicicletaSelection) {
        this.bicicleta = bicicletaSelection;
    }

    /**
     * Indica si el pin introducido por el usuario es valido
     *
     * @param pinTarjeta El pin de la tarjeta introducido por el usuario
     * @return True o False si el pin es valido o no
     */
    public boolean validarPin(String pinTarjeta) {
        return pinTarjeta.equals("1234");
    }

    /**
     * Inicia el tiempo para procesar que el usuario quiere pagar con tarjeta de
     * credito
     */
    public void tarjetaCreditoStart(ControladorCompraBillete controlador) {
        this.controladorCompraBillete = controlador;
        timerTarjetaCredito.start();
    }

    /**
     * Para el tiempo cuando el usuario deja de seleccionar el metodo de pago
     * con tarjeta de crédito
     */
    public void tarjetaCreditoStop() {
        timerTarjetaCredito.stop();
    }

    /**
     * Inicia el tiempo para procesar que el usuario quiere pagar con tarjeta de
     * CYL
     */
    public void tarjetaCylStart(ControladorCompraBillete controlador) {
        this.controladorCompraBillete = controlador;
        this.controladorTarjeta = null;
        timerTarjetaCyl.start();
    }

    /**
     * Para el tiempo cuando el usuario deja de seleccionar el metodo de pago
     * con tarjeta de CYL
     */
    public void tarjetaCylStop() {
        timerTarjetaCyl.stop();
    }

    /**
     * Inicia el tiempo para procesar que el usuario quiere pagar con tarjeta de
     * CYL
     */
    public void tarjetaCylStart(ControladorAccesoTarjeta controlador) {
        this.controladorTarjeta = controlador;
        this.controladorCompraBillete = null;
        timerTarjetaCyl.start();
    }

    /**
     * Obtiene viajes de manera aleatoria para que el usuario pueda elegir el
     * origen de su tren
     *
     * @return un listado de viajes
     */
    public Viaje getRandomViaje() {
        return viajes.get(ThreadLocalRandom.current().nextInt(viajes.size()));
    }

    /**
     * Obtiene el listado de las posibles estaciones de destino dada la estacion
     * de origen
     *
     * @param estacionOrigen Estacion de origen que el usuario ha elegido
     * @return el listado de las posibles estaciones de destino que el usuario
     * podra elegir
     */
    public ArrayList<String> getPosiblesEstacionesDestino(String estacionOrigen) {
        ArrayList<String> out = new ArrayList<>();
        for (Viaje viaje : viajes) {
            if (viaje.getEstacionOrigen().equals(estacionOrigen) && !out.contains(viaje.getEstacionDestino())) {
                out.add(viaje.getEstacionDestino());
            }
        }
        return out;
    }

    /**
     * Valida que el sueldo restante en la tarjeta Cyl es superior al precio del
     * viaje
     *
     * @return True si hay mas saldo en la tarjeta que el precio del viaje.
     * False en caso contrario
     */
    public boolean validarSaldoCyl() {
        return saldoTarjetaCYL >= viaje.getPrecio();
    }

    /**
     * Resta el coste del viaje al saldo de la tarjeta CYL
     */
    public void pagarConTarjetaCyl() {
        saldoTarjetaCYL -= viaje.getPrecio();
    }
}//class Modelo
