package dataBase;

import com.sun.jdi.connect.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbcon {

    public static void main(String[] args) {

        Connection connection = (Connection) Mysqlforbindelse.getConn();
        try {
            //Scanner scanner = new Scanner(System.in);
            // System.out.println("skriv en temp;");
            //  String Temp = scanner.next();
            Statement statement = connection.createStatement();
            ResultSet show_tables = statement.executeQuery("SELECT * FROM sys.persondata");

            // WILLIAMS   ResultSet show_tables = statement.executeQuery("SELECT * FROM suit1.loginoplysninger");
  /*
            System.out.println("Got a result with nr of columns");
            System.out.println(show_tables.getMetaData().getColumnCount());
            while (show_tables.next()){
                System.out.println("Id: " + show_tables.getString(1));
                System.out.println("CPR: " + show_tables.getString(2));
                System.out.println("Fornavn: " + show_tables.getString(3));
                System.out.println("Efternavn : " + show_tables.getString(4));
                System.out.println("Mail : " + show_tables.getString(5));
                System.out.println("Password : " + show_tables.getString(6));




                System.out.println("Id: " + show_tables.getString(1));
                System.out.println("Mail: " + show_tables.getString(2));
                System.out.println("Password: " + show_tables.getString(3));
                System.out.println("Cpr: " + show_tables.getString(4));
                System.out.println("Køn: " + show_tables.getString(4));

                 */

                System.out.println(" ");

            /*
            String sql = "SELECT * FROM suit1.loginoplysninger WHERE mail like  'daniel%;' ";
            Statement state1 = connection.createStatement();
            ResultSet userCredentials = state1.executeQuery(sql);
            System.out.println("Mail :" + userCredentials.getString(2));
*/
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}



