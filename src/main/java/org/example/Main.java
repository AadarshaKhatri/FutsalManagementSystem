package org.example;

import org.example.models.Futsal;
import org.example.models.Futsal_rent;
import org.example.models.Customer;

import org.example.models.ConnectDB;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {

        Futsal futsal1 = new Futsal(001, "Jorpati Futsal", "Jorpati", 1000, true);
        Futsal futsal2 = new Futsal(002, "Boudha Futsal", "Boduha", 1200, true);
        Futsal futsal3 = new Futsal(003, "Dhanyantari Futsal", "Dhumbarai", 1700, true);
        Futsal futsal4 = new Futsal(004, "Velocity Futsal", "Raato Pul", 1500, true);
        Futsal futsal5 = new Futsal(005, "Sherpa Futsal", "Boudha", 2500, true);


        List<Futsal> futsals = new ArrayList<>();
        futsals.add(futsal1);
        futsals.add(futsal2);
        futsals.add(futsal3);
        futsals.add(futsal4);
        futsals.add(futsal5);

        ConnectDB db = new ConnectDB();
        Statement statement = null;
        try (Connection connection = db.getConnection()) {

            statement = connection.createStatement();


            String createTableQuery = "CREATE TABLE IF NOT EXISTS Booking (" +
                    "Booking_Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Customer_name VARCHAR(255), " +
                    "Contact_no VARCHAR(20), " +
                    "futsal_id INT, " +
                    "futsal_name VARCHAR(255), " +
                    "booking_hrs INT)";
            statement.executeUpdate(createTableQuery);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }

        Futsal_rent renting = new Futsal_rent(futsals);

        renting.menu();


        //CRUD OPERATIONS

        statement.executeUpdate("DELETE FROM Futsal WHERE booking_hours = 3");  //del
        statement.executeUpdate("UPDATE Futsal SET customer_name = 'Sita' WHERE customer_name = 'Ram'"); //update



    }

    }