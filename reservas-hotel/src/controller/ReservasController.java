package controller;

import model.Habitacion;
import model.Huesped;
import repositories.ReservasRepository;
import services.GestorReservasService;

import java.util.Map;

public class ReservasController {

    private GestorReservasService gestorReservasService;

    public ReservasController() {
        this.gestorReservasService = new GestorReservasService();
    }

    public void realizarReserva(int numeroHabitacion, String nombreHuesped) {
        if (gestorReservasService.realizarReserva(numeroHabitacion, nombreHuesped)) {
            System.out.println("Reserva realizada: Habitación " + numeroHabitacion + " para " + nombreHuesped);
        } else {
            System.out.println("La habitación " + numeroHabitacion + " ya está reservada.");
        }
    }

    public void cancelarReserva(int numeroHabitacion) {
        if (gestorReservasService.cancelarReserva(numeroHabitacion)) {
            System.out.println("Reserva cancelada para la habitación " + numeroHabitacion);
        } else {
            System.out.println("No existe reserva para la habitación " + numeroHabitacion);
        }
    }

    public void mostrarReservas() {
        Map<Integer, Huesped> reservas = gestorReservasService.obtenerReservas();
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas en este momento.");
        } else {
            System.out.println("Reservas actuales:");
            reservas.forEach((numero, huesped) ->
                    System.out.println("Habitación " + numero + ": " + huesped.getNombre()));
        }
    }
}
