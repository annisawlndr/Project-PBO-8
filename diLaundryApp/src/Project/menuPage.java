package Project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class menuPage {
    static Scanner scan = new Scanner(System.in);

    public static void LogindiLaundry() throws SQLException {
        Registrasi reg = new Registrasi();
        loginApp log = new loginApp();

        System.out.println("=============================================================");
        System.out.println("-------- SILAHKAN LOGIN/REGISTRASI TERLEBIH DAHULU ! --------");
        System.out.println("=============================================================");
        System.out.print("Menu: \n1. Login \n2. Registrasi \n0. Keluar \nPILIHAN ANDA>> ");
        Integer open = scan.nextInt();
        switch (open) {
            case 0:
                System.out.println("------------------");
                System.out.println("Anda telah Keluar!");
                System.out.println("------------------");
                System.exit(0);
                break;
            case 1:
                log.loginUser();
            case 2:
                reg.regitrasiPegawai();
                menudiLaundryApp();
            default:
                System.out.println("Pilihan Anda Salah!");
                kembaliLogin();
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

    public static void kembaliLogin() throws SQLException {
        System.out.println("\n--------------------------");
        System.out.println("Tekan Enter Untuk Kembali!");
        try {
            System.in.read();
            LogindiLaundry();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }


    public static void menudiLaundryApp() throws SQLException {
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
                kembaliLogin();
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

    public static void menuBuatDataLaundry () throws SQLException {
        try {
            Transaksi laundry = new Transaksi();
            laundry.Transaksi();
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
            kembaliKeMenu();
        }
    }

    public static void menuLihatDataLaundry () throws SQLException {
        try {
            riwayatLaundry daftarLaundry = new riwayatLaundry();
            daftarLaundry.getRiwayatLaundry();
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
            kembaliKeMenu();
        }
    }

    public static void menuHapusDataLaundry () throws SQLException {
        try {
            deleteLaundry hapusRiwayat = new deleteLaundry();
            hapusRiwayat.hapusRiwayatLaundry();
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
            kembaliKeMenu();
        }

    }
}