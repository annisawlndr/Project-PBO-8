package Project;

import Exception.excepNote;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pelanggan extends baseModel{

    public Pelanggan() throws SQLException {
        super();
    }

    public static int addPelanggan() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Masukkan nama pelanggan: ");
            String namaPelanggan = scanner.next();

            System.out.println("Masukkan nomor telepon pelanggan: ");
            String noTelepon = scanner.next();

            System.out.println("Masukkan alamat pelanggan: ");
            String alamat = scanner.next();

            if (namaPelanggan.isEmpty() || noTelepon.isEmpty() || alamat.isEmpty()) {
                throw new excepNote();
            }

            String queryPelanggan = "INSERT INTO pelanggan" +
                    " (nama_pelanggan, no_telp_pelanggan, alamat_pelanggan)" + "" +
                    " VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(queryPelanggan);
            preparedStatement.setString(1, namaPelanggan);
            preparedStatement.setString(2, noTelepon);
            preparedStatement.setString(3, alamat);

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void lihatPelanggan() throws SQLException{
        String query = "SELECT * FROM pelanggan";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("\n+-----------------------+");
            System.out.println("|     DATA PELANGGAN    |");
            System.out.println("+-----------------------+");

            while (rs.next()) {
                int idPelanggan = rs.getInt("id_pelanggan");
                String nama = rs.getString("nama_pelanggan");
                String noTelp = rs.getString("no_telp_pelanggan");

                System.out.println(String.format("%d. %s   (%s)", idPelanggan, nama, noTelp));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}
