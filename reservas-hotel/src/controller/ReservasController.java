package controller;

import model.Habitacion;
import model.Huesped;
import model.ReservasRepository;
import view.ReservasView;

public class ReservasController {
    private ReservasRepository repositorio;
    private ReservasView vista;

    public ReservasController(ReservasRepository repositorio, ReservasView vista) {
        this.repositorio = repositorio;
        this.vista = vista;
    }

    public void realizarReserva(int numeroHabitacion, String nombreHuesped) {
        Habitacion habitacion = new Habitacion(numeroHabitacion);
        Huesped huesped = new Huesped(nombreHuesped);

        if (repositorio.agregarReserva(habitacion, huesped)) {
            vista.mostrarMensaje("Reserva realizada: Habitación " + numeroHabitacion + " para " + nombreHuesped);
        } else {
            vista.mostrarMensaje("La habitación " + numeroHabitacion + " ya está reservada.");
        }
    }

    public void cancelarReserva(int numeroHabitacion) {
        Habitacion habitacion = new Habitacion(numeroHabitacion);

        if (repositorio.eliminarReserva(habitacion)) {
            vista.mostrarMensaje("Reserva cancelada para la habitación " + numeroHabitacion);
        } else {
            vista.mostrarMensaje("No existe reserva para la habitación " + numeroHabitacion);
        }
    }

    public void mostrarReservas() {
        vista.mostrarReservas(repositorio.obtenerReservas());
    }
}
