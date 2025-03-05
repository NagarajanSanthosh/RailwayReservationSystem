package view;

import java.util.Scanner;

public class ReservationView {
    private Scanner scanner = new Scanner(System.in);

    public String getPassengerName() {
        System.out.print("Enter passenger name: ");
        return scanner.nextLine();
    }

    public String getTrainNumber() {
        System.out.print("Enter train number: ");
        return scanner.nextLine();
    }

    public String getDate() {
        System.out.print("Enter date (YYYY-MM-DD): ");
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}