package Project;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class riwayatLaundry extends baseModel{

    public riwayatLaundry() throws SQLException {
        super();
    }

    public static void getRiwayatLaundry() throws SQLException {
        String query = "SELECT detail_laundry.id_pelanggan, tanggal_laundry, pelanggan.nama_pelanggan, no_telp_pelanggan, detail_laundry.berat_laundry FROM pelanggan JOIN detail_laundry ON pelanggan.id_pelanggan = detail_laundry.id_pelanggan";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("\n+----------------------------------------------------------------------------------------+");
            System.out.println("|                            DAFTAR RIWAYAT DILAUNDRY                            |");
            System.out.println("+----------------------------------------------------------------------------------------+");
            System.out.println("No | ID Pelanggan \t|Pelanggan      \t\t\t|No Telepon \t\t|Berat \t\t |Tanggal");
            System.out.println("==========================================================================================");

            int n = 1;
            while (resultSet.next()) {
                int idPelanggan = resultSet.getInt("id_pelanggan");
                String namaPelanggan = resultSet.getString("nama_pelanggan");
                String noTelpPelanggan = resultSet.getString("no_telp_pelanggan");
                double beratLaundry = resultSet.getDouble("berat_laundry");
                Date date = resultSet.getDate("tanggal_laundry");
                int nomor = n ++;

                System.out.println(String.format("%d  | \t%s \t\t\t|%s \t\t\t\t|%s \t\t|%.2f kg \t |%tD", nomor,idPelanggan, namaPelanggan, noTelpPelanggan, beratLaundry, date));
                System.out.println("-----------------------------------------------------------------------------------------");
            }
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }
    }
}
