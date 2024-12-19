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


        controlador.realizarReserva(101, "Sher Maestre");
        controlador.realizarReserva(102, "Jose Maestre");
        controlador.realizarReserva(101, "Asli Maestre");
        controlador.realizarReserva(106, "John Doe");
        controlador.mostrarReservas();

        controlador.cancelarReserva(101);

        controlador.mostrarReservas();

    }
}