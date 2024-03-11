package org.example.models;

import java.sql.*;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;


    public class ConnectDB {

        private Connection connection;


        public ConnectDB() {

            String url = "jdbc:sqlite:Futsal.db";

            try {

                connection = DriverManager.getConnection(url);

                System.out.println("Connection Successful");

            } catch (SQLException e) {

                System.out.println("Error, Can't connect");

                e.printStackTrace();

            }

        }


        public Connection getConnection() {

            return connection;

        }


        public void closeConnection() {

            try {

                if (connection != null) {

                    System.out.println("Connection Closed");

                    connection.close();

                }

            } catch (SQLException e) {

                e.printStackTrace();

            }

        }

    }
