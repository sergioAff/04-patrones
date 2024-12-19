package view;

import model.Huesped;

import java.util.Map;

public class ReservasView {
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarReservas(Map<Integer, Huesped> reservas) {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas en este momento.");
        } else {
            System.out.println("Reservas actuales:");
            reservas.forEach((numero, huesped) ->
                    System.out.println("Habitación " + numero + ": " + huesped.getNombre()));
        }
    }
}
