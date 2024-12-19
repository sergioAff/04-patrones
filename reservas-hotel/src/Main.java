import controller.ReservasController;
import repositories.ReservasRepository;

public class Main {
    public static void main(String[] args) {
        ReservasController controller = new ReservasController();

        controller.realizarReserva(101, "Sher Maestre");
        controller.realizarReserva(102, "Jose Maestre");
        controller.realizarReserva(101, "Asli Maestre");
        controller.realizarReserva(106, "John Doe");

        controller.mostrarReservas();

        controller.cancelarReserva(101);

        controller.mostrarReservas();

    }
}