package dao;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ValidationHelper {
    
    public boolean isUsernameTaken(String username) {
        boolean taken = false;
        Connection conn = DBConnection.getConnection();

        try {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                taken = true;
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return taken;
    }

    public boolean isEmailTaken(String email) {
        boolean taken = false;
        Connection conn = DBConnection.getConnection();

        try {
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                taken = true;
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return taken;
    }

    public boolean areFieldsFilled(String... fields) {
        boolean allFilled = true;

        for (int i = 0; i < fields.length; i++) {
            if (fields[i] == null || fields[i].trim().isEmpty()) {
                allFilled = false;
            }
        }

        return allFilled;
    }

    public boolean isNegativeStock(int quantity) {
        if (quantity < 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isIssuingTooMuch(int quantityAvailable, int quantityRequested) {
        if (quantityRequested > quantityAvailable) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasPermission(String requiredRole, String currentUserRole) {
        if (currentUserRole == null) {
            return false;
        }

        if (currentUserRole.equalsIgnoreCase(requiredRole)) {
            return true;
        } else {
            return false;
        }
    }

    public void showError(java.awt.Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
