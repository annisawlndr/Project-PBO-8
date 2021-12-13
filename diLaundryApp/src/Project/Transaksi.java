package Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Transaksi extends baseModel{

    public Transaksi() throws SQLException {
        super();
    }

    private static Scanner scanner = new Scanner(System.in);

    public static int Transaksi() {
        try {
            System.out.println("\n+--------------------------------------------------+");
            System.out.println("|               BUAT DATA LAUNDRY BARU             |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("====================================================");
            Pegawai.getDataPegawai();
            System.out.println("Pilih Pegawai: ");
            int pegawai = scanner.nextInt();

            System.out.println("----------------------------------------------------");
            LocalDate localDate = LocalDate.now();
            System.out.println("Tanggal Laundry: " + localDate);
            Pelanggan.addPelanggan();

            Pelanggan.lihatPelanggan();
            System.out.println("Masukkan id pelanggan: ");
            int idPelanggan = scanner.nextInt();

            System.out.println("Masukkan berat laundry: ");
            float berat = scanner.nextFloat();

            getJenisLaundry();
            System.out.println("Pilihan jenis laundry: ");
            int jenisLaundry = scanner.nextInt();

            getPewangi();
            System.out.println("Pilihan Pewangi: ");
            int pilihPewangi = scanner.nextInt();

            System.out.println("Uang Diterima: ");
            Double uangMasuk = scanner.nextDouble();
            NumberFormat rupiah = NumberFormat.getNumberInstance(new Locale("in", "ID"));

            String query = "INSERT INTO detail_laundry" +
                    "(tanggal_laundry, berat_laundry, id_jenis, id_pewangi, id_pelanggan, id_pegawai) VALUES " +
                    " (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, localDate);
            preparedStatement.setFloat(2, berat);
            preparedStatement.setInt(3, jenisLaundry);
            preparedStatement.setInt(4, pilihPewangi);
            preparedStatement.setInt(5, idPelanggan);
            preparedStatement.setInt(6, pegawai);

            System.out.println(">> MESSAGE: Laundry Baru Telah Ditambahkan!");
            System.out.println("---------------------------------------------------------\n");

            String queryToko = "SELECT * FROM toko";
            String queryPegawai = "SELECT nama_pegawai FROM pegawai WHERE id_pegawai = ?;";
            String queryJenis = "SELECT * FROM jenis_laundry WHERE id_jenis = ?;";
            String queryPelanggan = "SELECT nama_pelanggan, no_telp_pelanggan FROM pelanggan WHERE id_pelanggan = ?;";

            PreparedStatement preparedStatementPegawai = connection.prepareStatement(queryPegawai);
            preparedStatementPegawai.setInt(1, pegawai);
            ResultSet rsPegawai = preparedStatementPegawai.executeQuery();
            String namaPegawai = null;
            while (rsPegawai.next()) {
                namaPegawai = rsPegawai.getString("nama_pegawai");
            }

            PreparedStatement preparedStatementJenis = connection.prepareStatement(queryJenis);
            preparedStatementJenis.setInt(1, jenisLaundry);
            ResultSet resultSetJenis = preparedStatementJenis.executeQuery();

            double hargaJenis = 0;
            String namaJenis = null;
            double totalPembayaran = 0;
            double uangKembali = 0;

            while (resultSetJenis.next()) {
                hargaJenis = resultSetJenis.getDouble("harga_jenis");
                namaJenis = resultSetJenis.getString("nama_jenis");
                totalPembayaran = berat * hargaJenis;
                uangKembali = uangMasuk - totalPembayaran;
            }

            PreparedStatement preparedStatementPlgn = connection.prepareStatement(queryPelanggan);
            preparedStatementPlgn.setInt(1, idPelanggan);
            ResultSet resultSetPlgn = preparedStatementPlgn.executeQuery();

            String namaPlgn = null;
            String noTelpPlgn = null;

            while (resultSetPlgn.next()) {
                namaPlgn = resultSetPlgn.getString("nama_pelanggan");
                noTelpPlgn = resultSetPlgn.getString("no_telp_pelanggan");
            }

            PreparedStatement preparedStatementToko = connection.prepareStatement(queryToko);
            ResultSet resultSetToko = preparedStatementToko.executeQuery();

            String namaToko = null;
            String alamatToko = null;
            String desaToko = null;
            String kecToko = null;
            String kabToko = null;
            String noTelpToko = null;
            String slogan = null;

            while (resultSetToko.next()) {
                namaToko = resultSetToko.getString("nama_toko");
                noTelpToko = resultSetToko.getString("no_telp_toko");
                alamatToko = resultSetToko.getString("alamat_toko");
                desaToko = resultSetToko.getString("desa_toko");
                kecToko = resultSetToko.getString("kecamatan_toko");
                kabToko = resultSetToko.getString("kabupaten_toko");
                slogan = resultSetToko.getString("slogan");
            }

            System.out.println(String.format("\t\t\t\t\t\t%s \n %s, %s, kec. %s, kab. %s \n\t\t\t\t\tTelp. %s \n\t\t%s", namaToko, alamatToko, desaToko, kecToko, kabToko, noTelpToko, slogan));
            System.out.println("=========================================================");
            System.out.println(String.format(">> Nama Pelanggan : %s \n>> Nomor Telepon  : %s \n>> Tanggal        : %s\n---------------------------------------------------------", namaPlgn, noTelpPlgn, localDate));
            System.out.println("DETAIL LAUNDRY \n>> Jenis Laundry : " + namaJenis + "\n>> Berat  \t\t : " + berat + " kg    \t\t\tx\t\tRp"+ rupiah.format(hargaJenis));
            System.out.println("\nTOTAL    :  \t\t\t\t\t\t\t\t\tRp" + rupiah.format(totalPembayaran) + "\nBAYAR    :  \t\t\t\t\t\t\t\t\tRp" + rupiah.format(uangMasuk) + "\nKEMBALI  :  \t\t\t\t\t\t\t\t\tRp" + rupiah.format(uangKembali));
            System.out.println(String.format(">> Kasir : %s", namaPegawai));
            System.out.println("========================================================= \n\t\t\t\t\t  TERIMAKASIH\n         \t\tSemoga Harimu Menyenangkan!");

            return preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }
        return 0;
    }

    public static void getJenisLaundry() {
        String query = "SELECT * FROM jenis_laundry";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("\n+----------------------+");
            System.out.println("|     JENIS LAUNDRY    |");
            System.out.println("+----------------------+");

            while (rs.next()) {
                int idJenis = rs.getInt("id_jenis");
                String jenis = rs.getString("nama_jenis");
                float harga = rs.getFloat("harga_jenis");

                System.out.println(String.format("%d. %s\n    --> Rp%.2f", idJenis, jenis, harga));
            }
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }
    }

    public static void getPewangi() {
        String query = "SELECT * FROM pewangi";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("\n+--------------------+");
            System.out.println("|    PILIH PEWANGI   |");
            System.out.println("+---------------------");

            while (rs.next()) {
                int idPewangi = rs.getInt("id_pewangi");
                String pewangi = rs.getString("nama_pewangi");

                System.out.println(String.format("%d. %s", idPewangi, pewangi));
            }
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }
    }
}
