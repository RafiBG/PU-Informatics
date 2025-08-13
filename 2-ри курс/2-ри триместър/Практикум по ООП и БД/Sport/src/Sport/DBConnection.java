package Sport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static Connection conn = null;

    static Connection getConnection() {

        try {
            Class.forName("org.h2.Driver");
            try {
                conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/C:\\Users\\Rafi\\Desktop\\Sport\\src\\dbSport", "sa", "1234");
                System.out.println("Connected to the database!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to connect to the database!");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database!");
        }
        return conn;
    }
}