package Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class diLaundry extends baseModel{

    public diLaundry() throws SQLException {
        super();
    }

    public static void tambahData(String namaPegawai, String username, String password, String email, String noTelp) throws SQLException {
        String query = "INSERT INTO pegawai" +
                "(nama_pegawai, username, password, email, no_telp)" +
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, namaPegawai);
        preparedStatement.setString(2, username);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, noTelp);
        
        preparedStatement.executeUpdate();
    }
}
