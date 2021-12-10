package Project;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteLaundry extends baseModel{
    public deleteLaundry() throws SQLException {
        super();
    }

    public static void hapusRiwayatLaundry() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            riwayatLaundry lihatRiwayat = new riwayatLaundry();
            lihatRiwayat.getRiwayatLaundry();

            System.out.println("PILIH ID PELANGGAN UNTUK HAPUS >> ");
            int idHapus = scanner.nextInt();

            String queryLaundry = "DELETE FROM detail_laundry USING pelanggan WHERE detail_laundry.id_pelanggan = pelanggan.id_pelanggan AND pelanggan.id_pelanggan = ? ;";
            String queryPelanggan = "DELETE FROM pelanggan WHERE id_pelanggan = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(queryLaundry);
            preparedStatement.setInt(1, idHapus);

            PreparedStatement preparedStatement1 = connection.prepareStatement(queryPelanggan);
            preparedStatement1.setInt(1, idHapus);

            int hasil = preparedStatement.executeUpdate();
            preparedStatement1.executeUpdate();
            System.out.println("--------------------------------------------------");
            System.out.println(">> MESSAGE: Berhasil Menghapus " + hasil + " Riwayat Laundry!");
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }
    }
}
