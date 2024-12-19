package services;

import model.Habitacion;
import model.Huesped;
import repositories.ReservasRepository;

import java.util.Map;

public class GestorReservasService {

    private ReservasRepository repositorio;

    public GestorReservasService() {
        this.repositorio = ReservasRepository.getInstancia();
    }

    public boolean realizarReserva(int numeroHabitacion, String nombreHuesped) {
        Habitacion habitacion = new Habitacion(numeroHabitacion);
        Huesped huesped = new Huesped(nombreHuesped);
        return repositorio.agregarReserva(habitacion, huesped);
    }

    public boolean cancelarReserva(int numeroHabitacion) {
        Habitacion habitacion = new Habitacion(numeroHabitacion);
        return repositorio.eliminarReserva(habitacion);
    }

    public Map<Integer, Huesped> obtenerReservas() {
        return repositorio.obtenerReservas();
    }
}
