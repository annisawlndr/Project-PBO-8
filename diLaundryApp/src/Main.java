import Project.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Berhasil Terhubung!\n");
            menudiLaundryApp();
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }

    }

    public static void kembaliKeMenu() throws SQLException {
        System.out.println("\n--------------------------");
        System.out.println("Tekan Enter Untuk Kembali!");
        try {
            System.in.read();
            menudiLaundryApp();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
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
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("======================================================");
        System.out.println("-------- SELAMAT DATANG DI APLIKASI DILAUNDRY --------");
        System.out.println("======================================================");
        System.out.print("Menu: \n1. Buat Data Laundry Baru \n2. Lihat Riwayat Data Laundry \n3. Hapus Data Laundry \n0. Keluar \nPILIHAN ANDA>> ");
        Integer menu = scan.nextInt();
        switch (menu) {
            case 0:
                System.out.println("------------------");
                System.out.println("Anda telah Keluar!");
                System.out.println("------------------");
                System.exit(0);
                break;
            case 1:
                menuBuatDataLaundry();
                kembaliKeMenu();
            case 2:
                menuLihatDataLaundry();
                kembaliKeMenu();
            case 3:
                menuHapusDataLaundry();
                kembaliKeMenu();
            default:
                System.out.println("Pilihan Anda Salah!");
                kembaliKeMenu();
        }


    }

    public static void menuBuatDataLaundry() throws SQLException {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            Transaksi laundry = new Transaksi();
            laundry.Transaksi();
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
            kembaliKeMenu();
        }
    }

    public static void menuLihatDataLaundry() throws SQLException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            riwayatLaundry daftarLaundry = new riwayatLaundry();
            daftarLaundry.getRiwayatLaundry();
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
            kembaliKeMenu();
        }
    }

    public static void menuHapusDataLaundry() throws SQLException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            deleteLaundry hapusRiwayat = new deleteLaundry();
            hapusRiwayat.hapusRiwayatLaundry();
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
            kembaliKeMenu();
        }

    }

}
