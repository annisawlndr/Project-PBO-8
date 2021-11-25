import Project.baseModel;
import Project.diLaundry;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            baseModel model = new baseModel();
            System.out.println("Berhasil Terhubung!");

            diLaundry.tambahData("Wardah Permatasari", "wardah245_", "permata123", "wardahpermatasari1@gmail.com", "085234775601");
            System.out.println("Data Pegawai Berhasil Ditambahkan!");
        } catch (SQLException exception) {
            System.out.println("Terdapat Kesalahan: " + exception.getMessage());
        }
    }
}
