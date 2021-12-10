package Project;

import java.sql.SQLException;

abstract class baseRegistrasi extends baseModel{
    baseRegistrasi() throws SQLException {
        super();
        System.out.println("Silahkan Melakukan Registrasi");
    }

    public abstract void regitrasiPegawai() throws SQLException;
}