package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Scanner;


public class Login extends baseModel {
    private String txtUsername;
    private String txtPassword;
    private Component rootPane;
    private DatabaseMetaData koneksi;
    private Object usersession;

    public Login() throws SQLException {
        super();
    }

    public void Login(String txtUsername, String txtPassword){
        try {
            Statement st = connection.createStatement();
            String sql = "select * from admin where username_admin = '" + txtUsername + "' and password_admin = '" + txtPassword + "'";
            ResultSet rsLogin = st.executeQuery(sql);

//            rsLogin.next();
//            rsLogin.last();
//            if (rsLogin.next()){
//                usersession.set_nama(rsLogin.getString("username_admin"));
//
//            } else {
//                System.out.println("Sorry! Username atau Password Salah!");
//            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
