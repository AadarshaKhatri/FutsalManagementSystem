package org.example.models;

import org.example.models.Futsal;
import org.example.models.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.example.models.Customer;

public class Futsal_rent {
    List<Futsal> futsals;
    Scanner sc = new Scanner(System.in);

    public Futsal_rent(List<Futsal> futsals) {
        this.futsals = futsals;
    }

    public void menu() {
        Futsal selectedFutsal = null;
        System.out.println("========== FUTSAL RENTAL SYSTEM ==========");
        System.out.println("Available Futsals:");
        for (Futsal futsal : futsals) {
            futsal.futprint();
        }
        System.out.println("Enter the futsal ID: ");
        int booking_id = sc.nextInt();
        sc.nextLine();
        for (Futsal futsal : futsals) {
            if (booking_id == futsal.getFutsal_id()) {
                selectedFutsal = futsal;
                break;
            }
        }
        System.out.println("Enter your name:");
        String customername = sc.nextLine();
        System.out.println("Enter your number:");
        int customerphonenumber = sc.nextInt();
        System.out.println("For how many hours do you want to book:");
        int hrs = sc.nextInt();
        sc.nextLine();

        System.out.print("\nConfirm rental (Y/N): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {

            double total = selectedFutsal.getFutsal_price() * hrs;
            double vat = (13.0 / 100) * total; // Use 13.0 to force floating-point division
            double dis = (10.0 / 100) * total; // Use 10.0 to force floating-point division
            double grand = total - dis + vat;


            System.out.println("\nCar rented successfully. Here's your slip");
            System.out.println("********************************************");
            System.out.println("========== RENTAL INFORMATION ==========");
            selectedFutsal.futsal_detailprint();
            System.out.println("========== BOOKED BY ==========");
            System.out.println("Name: " + customername);
            System.out.println("Phone Number: " + customerphonenumber);
            System.out.println("========== BOOKING DETAILS ==========");
            System.out.println("Futsal Name: " + selectedFutsal.getFutsal_name());
            System.out.println("Futsal ID: " + selectedFutsal.getFutsal_id());
            System.out.println("Booking Hours: " + hrs);
            System.out.println("========== PAYMENT ==========");
            System.out.println("VAT AMOUNT: " + vat);
            System.out.println("DISCOUNT AMOUNT: " + dis);
            System.out.println("***** GRAND TOTAL *****: " + grand);


            storeBooking(customername, customerphonenumber, selectedFutsal.getFutsal_id(), selectedFutsal.getFutsal_name(), hrs);
        } else {
            System.out.println("\nRental canceled.");
        }
    }


    private void storeBooking(String customerName, int phoneNumber, int futsalId, String futsalName, int hours) {
        ConnectDB db = new ConnectDB();
        try (Connection con = db.getConnection();
             PreparedStatement pat = con.prepareStatement("INSERT INTO Booking (customer_name, phone_number, futsal_id, futsal_name, booking_hours) VALUES (?, ?, ?, ?, ?)")) {
            pat.setString(1, customerName);
            pat.setInt(2, phoneNumber);
            pat.setInt(3, futsalId);
            pat.setString(4, futsalName);
            pat.setInt(5, hours);
            pat.executeUpdate();
            System.out.println("Booking information stored successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
