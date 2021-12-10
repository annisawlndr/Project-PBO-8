package Exception;

import Project.menuPage;

import java.sql.SQLException;

public class excepNote extends Exception{
    public excepNote() throws SQLException {
        super("Data Tidak Boleh Kosong!");
        System.out.println("\nData Tidak Boleh Kosong !");
        menuPage menu = new menuPage();
        menu.kembaliKeMenu();
    }
}
