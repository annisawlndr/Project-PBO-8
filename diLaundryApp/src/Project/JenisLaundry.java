package Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JenisLaundry extends baseModel{

    public JenisLaundry() throws SQLException {
        super();
    }

    public static int tambahJenisLaundry(String namaJenis, Float hargaJenis) throws SQLException {
        String query = "insert into jenis_laundry" +
                "(nama_jenis, harga_jenis)" +
                "values(?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,namaJenis);
        preparedStatement.setFloat(2, hargaJenis);

        return preparedStatement.executeUpdate();
    }

    public ResultSet getJenisLaundry() throws SQLException {
        String query = "SELECT * FROM jenis_laundry";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }
}
