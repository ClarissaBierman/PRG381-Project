package Controller;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import dao.UserDAO;
import models.User;
import views.LoginForm;

/**
 *
 * @author Paul
 */
public class RegistrationController {
 
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z\\s'-]+$");
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$");
 
    private final UserDAO userDAO = new UserDAO();
 
    public String register(String firstName, String lastName, String email,
                            String password, String confirmPassword, String role) {
 
        if (isBlank(firstName) || isBlank(lastName) || isBlank(email)
                || isBlank(password) || isBlank(confirmPassword)) {
            return "Please fill in all fields.";
        }
 
        if (!NAME_PATTERN.matcher(firstName.trim()).matches()) {
            return "First name cannot contain numbers or symbols.";
        }
 
        if (!NAME_PATTERN.matcher(lastName.trim()).matches()) {
            return "Last name cannot contain numbers or symbols.";
        }
 
        if (!EMAIL_PATTERN.matcher(email.trim()).matches()) {
            return "Please enter a valid email address.";
        }
 
        if (!password.equals(confirmPassword)) {
            return "Password and Confirm Password do not match.";
        }
 
        try {
            if (userDAO.isEmailRegistered(email.trim())) {
                return "An account with this email already exists.";
            }
 
            User newUser = new User(firstName.trim(), lastName.trim(), email.trim(), password, role);
            boolean success = userDAO.registerUser(newUser);
            return success ? null : "Registration failed. Please try again.";
 
        } catch (SQLException e) {
            e.printStackTrace();
            return "A database error occurred. Please try again.";
        }
    }
 
    public void goToLogin(JFrame currentFrame) {
        currentFrame.dispose();
        new LoginForm().setVisible(true);
    }
 
    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}

