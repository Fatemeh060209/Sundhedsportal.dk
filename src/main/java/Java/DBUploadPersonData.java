package Java;
import dataBase.MariaDBComm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUploadPersonData {
    private static UIPersonData ui;
    private static String CPR;
    private static String Fornavn;
    private static String Efternavn;
    private static String mail;
    private static Connection connection;
    public static void main(String[] args) {
        try {
           connection = MariaDBComm.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // System.out.println("Im Gone");
        //getHomeData();
        {
            try {
                ui = new UIPersonData();
                CPR = ui.askForCPR();
                System.out.println("Brugeren tastede: " + CPR);
                Fornavn = ui.askForFornavn();
                System.out.println("Brugeren indtastede: " + Fornavn);
                Efternavn = ui.askForEfternavn();
                System.out.println("Brugeren indtastede: " + Efternavn);
                mail = ui.askFormail();
                System.out.println("Brugeren indtastede: " + mail);
                // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?serverTimezone=Europe/Amsterdam&amp", "root", "Johari");
                String query = " insert into Gruppe7.opretbruger (CPR, Fornavn, Efternavn, mail)"
                        + " values (?, ?, ?, ?)";
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, CPR);
                preparedStmt.setString(2, Fornavn);
                preparedStmt.setString(3, Efternavn);
                preparedStmt.setString(4, mail);
                // execute the preparedstatement
                preparedStmt.execute();
                connection.close();
            } catch (Exception e) {
                System.err.println("Got an exception!" + e);
                e.printStackTrace();
                // System.err.println(e.getMessage());
            }
        }
    }
}