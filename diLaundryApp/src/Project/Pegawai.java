package Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pegawai extends baseModel{

    public Pegawai() throws SQLException {
        super();
    }

    public static int tambahData(String namaPegawai, String username, String password, String email, String noTelp) throws SQLException {
        String query = "INSERT INTO pegawai" +
                "(nama_pegawai, username, password, email, no_telp)" +
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, namaPegawai);
        preparedStatement.setString(2, username);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, noTelp);
        
        return preparedStatement.executeUpdate();
    }

    public static ResultSet getDataPegawai() throws SQLException {
        String query = "SELECT * FROM pegawai";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("\n+-------------------+");
            System.out.println("|     DATA PEGAWAI    |");
            System.out.println("+---------------------+");

            while (rs.next()){
                int idPegawai = rs.getInt("id_pegawai");
                String namaPegawai = rs.getString("nama_pegawai");

                System.out.println(String.format("%d. %s", idPegawai, namaPegawai));
            }

            return preparedStatement.executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
