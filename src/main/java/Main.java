import controller.ReservationController;
import model.ReservationModel;
import view.ReservationView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReservationModel model = new ReservationModel();
        ReservationView view = new ReservationView();
        ReservationController controller = new ReservationController(model, view);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Reservation");
            System.out.println("2. Show Reservations");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    controller.addReservation();
                    break;
                case 2:
                    controller.showReservations();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}