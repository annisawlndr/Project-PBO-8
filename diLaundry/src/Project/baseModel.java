package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class baseModel {
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    public static Connection connection;

    public baseModel() throws SQLException{
        dbUrl = "jdbc:postgresql://localhost/diLaundry";
        dbUser = "postgres";
        dbPassword = "WULan1745_";

        connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }
}
