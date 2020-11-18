package dataBase;

import java.sql.*;


public class MariaDBComm {

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static String url = "jdbc:mariadb://su5.eduhost.dk:3306/Gruppe7";
    private static Connection conn = null;
    private static Statement statement = null;
    //private PreparedStatement prep = null;

    public static void main(String[] args) {
        //Bruges bare til at have en metode som kan k re det hele fra.
        //DBcomm db = new DBcomm();
        try {
            Class.forName(JDBC_DRIVER);
            String user, pass;
            user = "fatemeh";
            pass = "Hassan123";
            // url="jdbc:mysql://localhost:3306/phoenixpoint?serverTimezone=Europe/Amsterdam&amp";

            // Skal man fx. bruge 127.0.0.1 til en remote maskine?
//Connection connection =
// DriverManager.getConnection("jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword");
            //T nk jer om - kan man opn  mariadb forbindelse til en anden maskine uden at  ndre denne her?


            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {

                System.out.println("Im in");
            } else {
                System.out.println("connection not made");
            }

            //find out which columns are in current table:
            findTableKalender();
            findTableLogin();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void findTableKalender() throws SQLException {
        statement = conn.createStatement();
        String sql = "select * from Kalender;";
        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int numberOfColumns = rsMetaData.getColumnCount();

        // get the column names; column indexes start from 1
        for (int i = 1; i < numberOfColumns + 1; i++) {
            String columnName = rsMetaData.getColumnName(i);
            // Get the name of the column's table name
            String tableName = rsMetaData.getTableName(i);
            System.out.println(columnName);
        }
    }

    private static void findTableLogin() throws SQLException {
        statement = conn.createStatement();
        String sql = "select * from Login;";
        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int numberOfColumns = rsMetaData.getColumnCount();

        // get the column names; column indexes start from 1
        for (int i = 1; i < numberOfColumns + 1; i++) {
            String columnName = rsMetaData.getColumnName(i);
            // Get the name of the column's table name
            String tableName = rsMetaData.getTableName(i);
            System.out.println(tableName);
            System.out.println(columnName);
        }
    }


   /* private static String findUser(String Cpr,String Paswword){
        String userCpr = null;
        String sqlFindUser = " select ";

    */
}



