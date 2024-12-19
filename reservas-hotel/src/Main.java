import controller.ReservasController;
import model.ReservasRepository;
import view.ReservasView;

public class Main {
    public static void main(String[] args) {
        // Usamos el singleton
        ReservasRepository repositorio = ReservasRepository.getInstancia();

        // creamos la vista
        ReservasView vista = new ReservasView();

        // creamos el controlador y le pasamos la unica instancia de nuestro repo
        ReservasController controlador = new ReservasController(repositorio, vista);


        controlador.realizarReserva(101, "Juan Pérez");
        controlador.realizarReserva(102, "María García");
        controlador.realizarReserva(101, "Carlos López");
        controlador.mostrarReservas();

        controlador.cancelarReserva(101);

        controlador.mostrarReservas();

    }
}