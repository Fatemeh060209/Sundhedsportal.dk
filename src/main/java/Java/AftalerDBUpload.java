package Java;

import dataBase.MariaDBComm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class AftalerDBUpload {
    private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    private static MariaDBComm mariaDBComm = new MariaDBComm();
    private static AftalerDTO aftalerDTO = new AftalerDTO();
    private static String cpr;
    private static String Hospital;
    private static String Afdeling;

    public static void main(String[] args) {
IndtastValues();
mariaDBComm.getConnection();
opretaftale();
    }
    public static void IndtastValues () {
        try {
        System.out.println("Indtast cpr");
        cpr = bufferedReader.readLine();
        System.out.println("Indtast Hospital");
        Hospital = bufferedReader.readLine();
        System.out.println("Indtast Afdeling");
        Afdeling = bufferedReader.readLine();
        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());
        aftalerDTO.setCpr(cpr);
        aftalerDTO.setHospital(Hospital);
        aftalerDTO.setAfdeling(Afdeling);
        aftalerDTO.setDato(sqldate);
        aftalerDTO.setTid(sqltime);
    } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void opretaftale() {
        try {
            String sql = "INSERT INTO Gruppe7.Kalender (cpr,Hospital,Afdeling,Dato,Tid) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = mariaDBComm.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,aftalerDTO.getCpr());
            preparedStatement.setString(2,aftalerDTO.getHospital());
            preparedStatement.setString(3,aftalerDTO.getAfdeling());
            preparedStatement.setDate(4, (java.sql.Date) aftalerDTO.getDato());
            preparedStatement.setTimestamp(5, aftalerDTO.getTid());
            preparedStatement.execute();
            System.out.println("Booket Aftale");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
