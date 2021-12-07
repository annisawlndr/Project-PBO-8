import Project.JenisLaundry;
import Project.Login;
import Project.Pegawai;
import Exception.excepNote;
import Project.Transaksi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Pegawai diLaundry;

    public static void main(String[] args) throws Exception {
        try {
            diLaundry = new Pegawai();
            System.out.println("Berhasil Terhubung!");
            System.out.println("======================================================");
            menudiLaundryApp();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    public static void LogindiLaundry() throws SQLException {
        Login login = new Login();
        Scanner scan = new Scanner(System.in);

        System.out.println("Masukkan username: ");
        String txtUsername = scan.next();

        System.out.println("Masukkan password: ");
        String txtPassword = scan.next();

        login.Login(txtUsername, txtPassword);
    }

    public static void menudiLaundryApp() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("======== SELAMAT DATANG DI APLIKASI DILAUNDRY ========");
        System.out.println("======================================================");
        System.out.print("Menu: \n1. Buat Data Laundry Baru \n2. Lihat Riwayat Data Laundry \n3. Hapus Data Laundry \n0. Keluar \nPILIHAN ANDA>> ");
        Integer menu = scan.nextInt();
        switch (menu) {
            case 0:
                System.exit(0);
                break;
            case 1:
                menuBuatDataLaundry();
                break;
            case 2:
//                menuLihatDataLaundry();
                break;
            case 3:
//                menuHapusDataLaundry();
                break;
            default:
                System.out.println("Pilihan Anda Salah!");
        }


    }

    public static void menuBuatDataLaundry() throws SQLException {
        try {
            Transaksi laundry = new Transaksi();
            laundry.Transaksi();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void menuLihatDataLaundry() throws SQLException {

    }


    public static void menuHapusDataLaundry() throws SQLException {

    }

    public static void menuDaftarPegawai() throws SQLException {
        ResultSet daftarPegawai = diLaundry.getDataPegawai();
        System.out.println("DAFTAR DATA PEGAWAI DILAUNDRY");
        while (daftarPegawai.next()) {
            System.out.print(daftarPegawai.getInt("id_pegawai"));
            System.out.print("       ");
            System.out.print(daftarPegawai.getString("nama_pegawai"));
            System.out.print("       ");
            System.out.print(daftarPegawai.getString("username"));
            System.out.print("       ");
            System.out.print(daftarPegawai.getString("password"));
            System.out.print("       ");
            System.out.print(daftarPegawai.getString("email"));
            System.out.print("       ");
            System.out.print(daftarPegawai.getString("no_telp"));
            System.out.println();
        }
    }


    public static void menuTambahDataPegawai() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Masukkan nama pegawai: ");
            String namaPegawai = scan.nextLine();

            System.out.println("Masukkan username: ");
            String username = scan.nextLine();

            System.out.println("Masukkan password: ");
            String password = scan.nextLine();

            System.out.println("Masukkan e-mail: ");
            String email = scan.nextLine();

            System.out.println("Masukkan nomor telepon: ");
            String noTelp = scan.nextLine();

            if (namaPegawai.isEmpty() || username.isEmpty() || password.isEmpty() || email.isEmpty() || noTelp.isEmpty()) {
                throw new excepNote();
            }

            int hasil = diLaundry.tambahData(namaPegawai, username, password, email, noTelp);
            if (hasil > 0){
                System.out.println("Berhasil Menambahkan" + hasil + " baris!");
            }
        } catch (SQLException exception) {
            System.out.println("Terdapat Kesalahan: " + exception.getMessage());
        } catch (excepNote e){
            System.out.println(e.getMessage());
        }
    }
}
