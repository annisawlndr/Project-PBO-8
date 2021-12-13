package Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pegawai extends baseModel{

    public Pegawai() throws SQLException {
        super();
    }

    public static ResultSet getDataPegawai() throws SQLException {
        String query = "SELECT * FROM pegawai";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("\n+---------------------+");
            System.out.println("|     DATA PEGAWAI    |");
            System.out.println("+---------------------+");

            while (rs.next()){
                int idPegawai = rs.getInt("id_pegawai");
                String namaPegawai = rs.getString("nama_pegawai");

                System.out.println(String.format("%d | %s", idPegawai, namaPegawai));
            }

            return preparedStatement.executeQuery();
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }
        return null;
    }
}
