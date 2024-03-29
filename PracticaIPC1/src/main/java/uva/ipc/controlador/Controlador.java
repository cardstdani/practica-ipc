/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.controlador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import uva.ipc.modelo.Modelo;
import uva.ipc.modelo.Viaje;
import uva.ipc.vista.Utiles;
import uva.ipc.vista.Vista;

/**
 * @author Daniel Garcia Solla
 * @author Carolina de las Heras Clavier
 */
public class Controlador {

    private Vista vista;
    private Modelo modelo;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.modelo = new Modelo(this);
    }

    /**
     * Actualiza los valores de la vista cuando se quiere pasar del paso 1 al
     * siguiente
     */
    public void continuarPaso1() {
        if (vista.getFecha() == null) {
            vista.dialogoError("Seleccione usted bien la fecha");
            return;
        }
        modelo.setFecha(vista.getFecha());
        modelo.setEstacionOrigen(vista.getEstacionOrigen());
        modelo.setEstacionDestino(vista.getEstacionDestino());
        ArrayList<Viaje> viajesDisponibles = modelo.getViajesPaso2();
        if (viajesDisponibles.isEmpty()) {
            vista.dialogoAlerta("No hay viajes disponibles con estos datos.");
            return;
        }
        vista.actualizarViajes(viajesDisponibles);
        vista.activarPaso(2);
    }

    /**
     * Actualiza los valores de la vista cuando se quiere pasar del paso 2 al
     * siguiente
     */
    public void continuarPaso2() {
        if (vista.getSelectedViaje() != null) {
            modelo.setSelectedViaje(vista.getSelectedViaje());
            modelo.setMascota(vista.getMascotaSelection());
            modelo.setBicicleta(vista.getBicicletaSelection());
            vista.activarPaso(3);
        } else {
            vista.dialogoError("Por favor, seleccione usted un viaje");
        }
    }

    /**
     * Actualiza los valores de la vista cuando se quiere pasar del paso 3 al
     * siguiente
     */
    public void continuarPaso3() {
        vista.activarPaso(4);
        vista.sonidoAmigable();
    }

    /**
     * Actualiza los valores de la vista cuando se quiere volver del paso 2 al
     * paso 1
     */
    public void volverPaso2() {
        vista.activarPaso(1);
    }

    /**
     * Actualiza los valores de la vista cuando se quiere volver del paso 3 al
     * paso 2
     */
    public void volverPaso3() {
        vista.activarPaso(2);
    }

    /**
     * Acepta al usuario su pago con la tarejeta de credito
     */
    public void aceptarPagoTarjetaCredito() {
        if (modelo.validarPin(vista.getPinTarjeta())) {
            continuarPaso3();
        } else {
            vista.mensajePaso3TarjetaCredito("Su PIN es incorrecto", Utiles.codigoMensaje.ERROR);
        }
    }

    /**
     * Inicia el tiempo para procesar que el usuario quiere pagar con tarjeta de
     * credito
     */
    public void tarjetaCreditoStart() {
        modelo.tarjetaCreditoStart();
    }

    /**
     * Para el tiempo cuando el usuario deja de seleccionar el metodo de pago
     * con tarjeta de crédito
     */
    public void tarjetaCreditoStop() {
        modelo.tarjetaCreditoStop();
    }

    /**
     * Inicia el tiempo para procesar que el usuario quiere pagar con tarjeta de
     * CYL
     */
    public void tarjetaCylStart() {
        vista.mensajePaso3TarjetaCyl("Mantenga usted la tarjeta 2 segundos", Utiles.codigoMensaje.NORMAL);
        modelo.tarjetaCylStart();
    }

    /**
     * Para el tiempo cuando el usuario deja de seleccionar el metodo de pago
     * con tarjeta de CYL
     */
    public void tarjetaCylStop() {
        modelo.tarjetaCylStop();
    }

    /**
     * Permite al usuario introducir el pin de su tarjeta para pagar
     */
    public void tarjetaCreditoValida() {
        vista.activarPinTarjeta();
        vista.mensajePaso3TarjetaCredito("Inserte usted el pin de su tarjeta", Utiles.codigoMensaje.NORMAL);
    }

    /**
     * Activa el paso 4 de la vitsa una vez el usuario ha pagado con su tarjeta
     * CYL
     */
    public void tarjetaCylValida() {
        if (modelo.validarSaldoCyl()) {
            continuarPaso3();
            modelo.pagarConTarjetaCyl();
        } else {
            vista.mensajePaso3TarjetaCyl("No hay saldo suficiente", Utiles.codigoMensaje.ERROR);
        }
    }

    /**
     * Obtiene viajes de manera aleatoria para que el usuario pueda elegir el
     * origen de su tren
     *
     * @return un listado de viajes
     */
    public Viaje getRandomViaje() {
        return modelo.getRandomViaje();
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
        return modelo.getPosiblesEstacionesDestino(estacionOrigen);
    }

    /**
     * Obtiene el listado de estaciones
     *
     * @return el listado de estaciones
     */
    public ArrayList<String> getEstaciones() {
        return modelo.getEstaciones();
    }
}//class Controlador
