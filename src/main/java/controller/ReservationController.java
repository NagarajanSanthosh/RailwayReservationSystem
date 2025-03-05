package controller;

import model.ReservationModel;
import view.ReservationView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationController {
    private ReservationModel model;
    private ReservationView view;

    public ReservationController(ReservationModel model, ReservationView view) {
        this.model = model;
        this.view = view;
    }

    public void addReservation() {
        String passengerName = view.getPassengerName();
        String trainNumber = view.getTrainNumber();
        String date = view.getDate();
        if (model.addReservation(passengerName, trainNumber, date)) {
            view.showMessage("Reservation added successfully.");
        } else {
            view.showMessage("Failed to add reservation.");
        }
    }

    public void showReservations() {
        ResultSet resultSet = model.getReservations();
        try {
            while (resultSet != null && resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Passenger Name: " + resultSet.getString("passenger_name") +
                        ", Train Number: " + resultSet.getString("train_number") +
                        ", Date: " + resultSet.getString("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}