package repositories;

import model.Habitacion;
import model.Huesped;

import java.util.HashMap;
import java.util.Map;


public class ReservasRepository {

    // instancia unica del Singleton
    private static ReservasRepository instancia;

    // almaceno las reservas en un Map
    private Map<Integer, Huesped> reservas;

    // modifico el acceso de mi constructor a privado
    private ReservasRepository() {
        this.reservas = new HashMap<>();
    }

    // genero un metodo static para acceder a mi unica instancia
    public static synchronized ReservasRepository getInstancia() {
        if (instancia == null) {
            instancia = new ReservasRepository();
        }
        return instancia;
    }

    //logica de negocio
    public boolean agregarReserva(Habitacion habitacion, Huesped huesped) {
        if (!reservas.containsKey(habitacion.getNumero())) {
            reservas.put(habitacion.getNumero(), huesped);
            return true;
        }
        return false;
    }

    public boolean eliminarReserva(Habitacion habitacion) {
        return reservas.remove(habitacion.getNumero()) != null;
    }

    public Map<Integer, Huesped> obtenerReservas() {
        return reservas;
    }
}
