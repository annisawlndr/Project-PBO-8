package Project;

import java.sql.SQLException;

public abstract class baseRegistrasi extends baseModel{
    baseRegistrasi() throws SQLException {
        super();
    }

    public abstract void regitrasiPegawai() throws SQLException;
}