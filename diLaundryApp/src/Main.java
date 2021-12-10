import java.sql.SQLException;
import java.util.Scanner;
import Project.*;


public class Main {
    static Scanner scan = new Scanner(System.in);
    static menuPage menu = new menuPage();
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("MESSAGE: Berhasil Terhubung ke Database!\n");
            menu.LogindiLaundry();
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }
    }
}