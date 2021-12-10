package Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

import static Project.baseModel.connection;

public class loginApp implements Login{
    Scanner input = new Scanner(System.in);

    public loginApp() throws SQLException {
        super();
    }

    public static void Login(String userName, String password) throws SQLException {
        menuPage menu = new menuPage();
        String query = "SELECT * FROM pegawai where username = '" + userName + "' AND password = '" + password + "'";
        ResultSet res;
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            res = stmt.executeQuery();
            if (res.next()) {
                String username = res.getString("username");
                String pword = res.getString("password");
                if (Objects.equals(username, userName) && Objects.equals(pword, password)) {
                    System.out.println("MESSAGE: Login Berhasil");
                    menu.menudiLaundryApp();
                }
            } else {
                System.out.println("MESSAGE: Username Atau Password Salah !");
                menu.kembaliLogin();
            }
        } catch (SQLException e) {
            System.out.println("Terdapat Kesalahan : " + e.getMessage());
        }
    }

    public void loginUser() throws SQLException {
        System.out.println("Masukkan Username : ");
        String username = input.next();
        System.out.println("Masukkan Password : ");
        String password = input.next();

        Login(username, password);
    }
}