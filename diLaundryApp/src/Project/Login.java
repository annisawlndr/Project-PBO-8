package Project;

import java.sql.SQLException;

public interface Login {
    static void Login(String username, String password) throws SQLException {
    }
    void loginUser() throws SQLException;

}