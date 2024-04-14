/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.modelo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Timer;
import uva.ipc.vista.ControladorAccesoTarjeta;
import uva.ipc.vista.ControladorCompraBillete;
import uva.ipc.vista.ControladorRecargarTarjeta;

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
    private ControladorRecargarTarjeta controladorRecargaTarjeta = null;
    private double saldoTarjetaCYL = 20;
    private boolean tarjetaCylValida = false;
    private String politicaPrivacidad = "", pinTarjetaValido = "1234";
    private Billete selectedBillete;

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
        Collections.sort(estaciones);

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
            if (this.controladorRecargaTarjeta != null) {
                this.controladorRecargaTarjeta.tarjetaCreditoValida();
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

    public double getSaldo() {
        return saldoTarjetaCYL;
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
        Collections.sort(out);
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
        return pinTarjeta.equals(pinTarjetaValido);
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

    public void tarjetaCreditoStart(ControladorRecargarTarjeta controlador) {
        this.controladorRecargaTarjeta = controlador;
        this.controladorCompraBillete = null;
        timerTarjetaCredito.start();
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
        saldoTarjetaCYL = Math.round(saldoTarjetaCYL * 100.0) / 100.0;
        addBillete();
    }
    
    /**
     * Aumenta el saldo de la tarjeta CYL
     * @param cantidadRecarga cantidad con la que se incrementa el saldo de la tarjeta CYL
     */
    public void recargarTarjetaCyl(double cantidadRecarga) {
        saldoTarjetaCYL += cantidadRecarga;
        saldoTarjetaCYL = Math.round(saldoTarjetaCYL * 100.0) / 100.0;
    }

    /**
    * Agrega un nuevo billete al archivo CSV de billetes
    */
    private void addBillete() {
        String content = String.join(";", fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                viaje.getHorario().toString(), viaje.getIdRuta(), viaje.getEstacionOrigen(),
                viaje.getEstacionDestino(), "" + viaje.getTiempo(), "" + viaje.getPrecio(), "" + bicicleta, "" + mascota);
        try {
            Files.write(Paths.get("src/main/resources/billetes.csv"), Collections.singleton(content),
                    StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    /**
    * Obtiene una lista de tipo Billete a partir de un archivo CSV de billetes
    * @return Una lista de tipo Billete que representa los billetes almacenados en el archivo CSV
    */
    public ArrayList<Billete> getBilletes() {
        ArrayList<Billete> out = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/billetes.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] chunkos = line.split(";");
                out.add(new Billete(chunkos[0], chunkos[1], chunkos[2], chunkos[3], chunkos[4], chunkos[5], chunkos[6], chunkos[7], chunkos[8]));
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        out.sort((p1, p2) -> p1.compareTo(p2));
        return out;
    }
    
    /**
    * Agrega el billete al archivo CSV de billetes.
    */
    public void pagarConTarjetaCredito() {
        addBillete();
    }
    
    /**
    * Devuelve un billete, eliminandolo del registro de billetes almacenado en un archivo CSV
    * @param selectedValue El billete que se va a devolver
    */
    public void devolverBillete(Billete selectedValue) {
        ArrayList<Billete> tmp = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/billetes.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] chunkos = line.split(";");
                Billete billete = new Billete(chunkos[0], chunkos[1], chunkos[2], chunkos[3], chunkos[4], chunkos[5], chunkos[6], chunkos[7], chunkos[8]);
                if (!billete.equals(selectedValue)) {
                    tmp.add(billete);
                }

            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        reescribirDatosBilletes(tmp);
    }
    
    /**
    * Reescribe los datos de los billetes en el archivo CSV de billetes.
    * @param tmp La lista de billetes actualizada que se va a escribir en el archivo CSV.
    */
    
    private void reescribirDatosBilletes(ArrayList<Billete> tmp) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/billetes.csv"))) {
            bw.write("fecha;hora;id;estacionOrigen;estacionDestino;tiempo;precio;bicicleta;mascota");
            bw.newLine();
            for (Billete billete : tmp) {
                bw.write(billete.toStringCSV());
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    /**
    * Obtiene el número total de viajes registrados en el archivo CSV de billetes
    * @return El número total de viajes registrados
    */
    public int getNumeroViajes() {
        try {
            return (int) (Files.lines(Paths.get("src/main/resources/billetes.csv")).count() - 1);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return 0;
    }
    
    /**
    * Establece los valores del billete seleccionado para modificar
    * @param selectedBillete El billete seleccionado para editar.
    */
    public void setSelectedBilleteEdicion(Billete selectedBillete) {
        this.selectedBillete = selectedBillete;
        this.fecha = selectedBillete.getFecha().atTime(LocalTime.NOON);
        this.estacionOrigen = selectedBillete.getEstacionOrigen();
        this.estacionDestino = selectedBillete.getEstacionDestino();
    }

    /**
    * Actualiza un billete con la información proporcionada de un nuevo viaje y guarda los cambios en el archivo CSV de billetes
    * @param newSelectedViaje El nuevo viaje 
    */
    public void actualizarBillete(Viaje newSelectedViaje) {
        ArrayList<Billete> tmp = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/billetes.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] chunkos = line.split(";");
                Billete billete = new Billete(chunkos[0], chunkos[1], chunkos[2], chunkos[3], chunkos[4], chunkos[5], chunkos[6], chunkos[7], chunkos[8]);
                if (!billete.equals(selectedBillete)) {
                    tmp.add(billete);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        reescribirDatosBilletes(tmp);

        //Añadir billete actualizado
        try {
            selectedBillete.setHora(newSelectedViaje.getHorario());
            selectedBillete.setId(newSelectedViaje.getIdRuta());
            selectedBillete.setTiempo(newSelectedViaje.getTiempo());
            selectedBillete.setMascota(mascota);
            selectedBillete.setBicicleta(bicicleta);
            Files.write(Paths.get("src/main/resources/billetes.csv"), Collections.singleton(selectedBillete.toStringCSV()),
                    StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}//class Modelo
