package Project;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static Project.baseModel.connection;

public class Registrasi extends baseRegistrasi {
    Scanner input = new Scanner(System.in);

    public Registrasi() throws SQLException {
    }

    public static int tambahPegawai(String namaPegawai, String username, String password, String email, String noTelp) throws SQLException, SQLException {
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

    @Override
    public void regitrasiPegawai() throws SQLException {
        menuPage menu = new menuPage();
        try {
            System.out.println("Masukkan Nama Pegawai : ");
            String Nama = input.nextLine();
            System.out.println("Masukkan Username : ");
            String user = input.nextLine();
            System.out.println("Masukkan Password: ");
            String pass = input.nextLine();
            System.out.println("Masukkan E-mail : ");
            String email = input.nextLine();
            System.out.println("Masukkan No Telepon : ");
            String telp = input.nextLine();
            if (Nama.isEmpty() || user.isEmpty() || pass.isEmpty() || email.isEmpty() || telp.isEmpty()) {
                System.out.println("Data Tidak Boleh Kosong !");
                menu.kembaliLogin();
            }

            tambahPegawai(Nama, user, pass, email, telp);
            System.out.println("\nMESSAGE: Registrasi Berhasil !");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }
}