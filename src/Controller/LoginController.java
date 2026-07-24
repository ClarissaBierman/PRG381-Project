/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.SQLException;
import javax.swing.JFrame;
import views.RegistrationForm;
import dao.UserDAO;
/**
 *
 * @author Paul
 */
public class LoginController {
 
    private final UserDAO userDAO = new UserDAO();

    public String login(String email, String password) {
        if (email == null || email.trim().isEmpty() || password == null || password.isEmpty()) {
            return "Please enter both email and password.";
        }
 
        try {
            boolean authenticated = userDAO.authenticateUser(email.trim(), password);
            if (!authenticated) {
                return "Invalid email or password.";
            }
            util.CurrentUser.email = email.trim();
            util.CurrentUser.role = userDAO.getRole(email.trim());
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return "A database error occurred. Please try again.";
        }
    }

    public void goToRegistration(JFrame currentFrame) {
        currentFrame.dispose();
        new RegistrationForm().setVisible(true);
    }
}

