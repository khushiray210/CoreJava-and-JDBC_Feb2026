package payroll;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3308/payroll_db",
                    "root",
                    "root"     // <-- change to your mysql password
            );

        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }
}
