package Project;

//import Project.Pelanggan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Transaksi extends baseModel{

    public Transaksi() throws SQLException {
        super();
    }

    static Scanner scanner = new Scanner(System.in);

    public static int Transaksi() {
        try {
//            System.out.println("====================================================");
//            Pegawai.getDataPegawai();
//            System.out.println("Pilih Pegawai: ");
//            int pegawai = scanner.nextInt();
            System.out.println("====================================================");
            Pelanggan.addPelanggan();

            System.out.println("Masukkan berat laundry: ");
            float berat = scanner.nextFloat();

            getJenisLaundry();
            System.out.println("Pilihan jenis laundry: ");
            int jenisLaundry = scanner.nextInt();

            Pelanggan.lihatPelanggan();
            System.out.println("Masukkan id pelanggan: ");
            int idPelanggan = scanner.nextInt();

            getPewangi();
            System.out.println("Pilihan Pewangi: ");
            int pilihPewangi = scanner.nextInt();

            System.out.println("Uang Diterima: ");
            Double uangMasuk = scanner.nextDouble();

            String query = "INSERT INTO detail_laundry" +
                    "(berat_laundry, id_jenis, id_pewangi, id_pelanggan) VALUES " +
                    " (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setFloat(1, berat);
            preparedStatement.setInt(2, jenisLaundry);
            preparedStatement.setInt(3, pilihPewangi);
            preparedStatement.setInt(4, idPelanggan);

            String queryJenis = "SELECT * FROM jenis_laundry";
            ResultSet resultSet = preparedStatement.executeQuery(queryJenis);
            String jenis = resultSet.getString("nama_jenis");
            float hargaJenis = resultSet.getFloat("harga_jenis");

            double totalPembayaran = berat * hargaJenis;
            double uangKembali = uangMasuk - totalPembayaran;

            String queryToko = "SELECT * FROM toko";
            ResultSet resultSetToko = preparedStatement.executeQuery(queryToko);
            String namaToko = resultSetToko.getString("nama_toko");
            String noTelpToko = resultSetToko.getString("no_telp_toko");
            String alamatToko = resultSetToko.getString("alamat_toko");
            String desaToko = resultSetToko.getString("desa_toko");
            String kecToko = resultSetToko.getString("kecamatan_toko");
            String kabToko = resultSetToko.getString("kabupaten_toko");
            String slogan = resultSetToko.getString("slogan");

            String queryPelanggan = "SELECT * FROM pelanggan";
            ResultSet resultSetPlgn = preparedStatement.executeQuery(queryPelanggan);
            String namaPlgn = resultSetPlgn.getString("nama_pelanggan");
            String noTelpPlgn = resultSetPlgn.getString("no_telp_pelanggan");

            System.out.println(String.format("\t\t\t%s \n\t%s, %s, kec. %s, kab. %s, Telp. %s \n\t%s", namaToko, alamatToko, desaToko, kecToko, kabToko, noTelpToko, slogan));
            System.out.println("================================================");
            System.out.println(String.format(">> Nama Pelanggan : %s \n>> Nomor Telepon : %s", namaPlgn, noTelpPlgn));
            System.out.println("--------------------------------------------");
            System.out.println(String.format("DETAIL LAUNDRY \n>> Jenis Laundry : %s \n>> Berat : %2.f kg \tx Rp.%2.f", jenis, berat, hargaJenis));
            System.out.println(String.format("\nTOTAL : \t\tRp.%2.f", totalPembayaran));
            System.out.println(String.format("BAYAR : \t\tRp.%2.f", uangMasuk));
            System.out.println(String.format("KEMBALI : \t\tRp.%2.f", uangKembali));
//            System.out.println(String.format(">> Kasir : %s",p));

            return preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return 0;
    }
//            bikin pentotalan biaya laundry
//            bikin perhitungan uang diterima - uang kembali
//            bikin pilihan cetak struk atau tidak
//            bikin format cetak struk
//            dah bismillah ya


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
            exception.printStackTrace();
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
            exception.printStackTrace();
        }
    }

}
