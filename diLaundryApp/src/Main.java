import java.sql.SQLException;
import java.util.Scanner;

import static Project.menuPage.LogindiLaundry;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("MESSAGE: Berhasil Terhubung ke Database!\n");
            LogindiLaundry();
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }
    }
}