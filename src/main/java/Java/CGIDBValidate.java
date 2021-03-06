package Java;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.StringTokenizer;

public class CGIDBValidate {
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
   // static String url = "jdbc:mariadb://192.168.239.25:3306/Gruppe7";
    static String url = "jdbc:mariadb://[2001:878:200:4102:207:e9ff:fe62:c2d]:3306/Gruppe7";
    static String username = "fatemeh";
    static String kodeord = "Hassan123";
    private static Connection conn = null;
    private static Statement statement = null;
    private PreparedStatement prep = null;

    static String inputfraCGI = null;

// here we use DBComm as a classname, if you use this method, make sure to change it to whatever class you use the
    // logger from


    public static void main(String[] args) {
        showHead();


        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String[] data = { in.readLine() };

            inputfraCGI= data[0];
            System.out.println(data[0]);
            // showBody(new StringTokenizer(data[0],"&\n\r"));
        } catch(IOException ioe) {
            System.out.println("<P>IOException reading POST data: "+ioe+"</P>");
        }


        //Bruges bare til at have en metode som kan k re det hele fra.
        //DBcomm db = new DBcomm();


        try {
            Class.forName("org.mariadb.jdbc.Driver");

            //mysql skal  ndres senere til MariaDB, localhost til en IPaddresse -
            String Cpr, pass;
            Cpr = "1212121212";
            pass = "hejhej";

            conn = DriverManager.getConnection(url,username,kodeord);
            if (conn != null) {

                System.out.println("Im in");
            } else {
                System.out.println("connection not made");
            }

            //find out which columns are in current table:
            statement = conn.createStatement();
            String sql = "select * from Gruppe7.Login;";
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int numberOfColumns = rsMetaData.getColumnCount();

            // get the column names; column indexes start from 1
            for (int i = 1; i < numberOfColumns + 1; i++) {
                String columnName = rsMetaData.getColumnName(i);
                // Get the name of the column's table name
                String tableName = rsMetaData.getTableName(i);
                System.out.println("<p> column name:=" + columnName +"<7p>");
            }

            //
            String finduser = findUser("2506913535", "goddavs");


//            showHead();
            //          showBody();
            //db.getHomeData();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }



        showTail();



    }

    private static void showHead() {
        System.out.println("Content-Type: text/html");
        System.out.println();
        System.out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 3.2//EN\">");
        System.out.println("<HTML>");
        System.out.println("<HEAD>");
        System.out.println("<TITLE>Loginvalidation application</TITLE>");
        System.out.println("<META http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
        System.out.println("<META http-equiv=\"Pragma\" content=\"no-cache\">");
        System.out.println("<META http-equiv=\"expires\" content=\"0\">");
        System.out.println("</HEAD>");
        System.out.println("<BODY>");

    }
    private static void showBody(StringTokenizer stringTokenizer){

    }

    private static void showTail(){
        System.out.println("</BODY>\n</HTML>");
    }

    private static String findUser(String cpr,String pass){
        String userCPR =null;

        String sqlFindUser = "select cpr,pass from Login where cpr ='" +cpr+ "'and pass ='"+ pass +"';";
        try {
            ResultSet rs = statement.executeQuery(sqlFindUser);
            rs.next();
             cpr = rs.getString("cpr");
            pass = rs.getString("pass");
           // String email = rs.getString(3);
            System.out.println("cpr:"+cpr);
            System.out.println("pass:"+pass);
            //System.out.println("mail:"+email);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userCPR;
    }
}
