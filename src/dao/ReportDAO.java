
package dao;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ReportDAO {

    public ResultSet getInventoryReport() {

        try {

            Connection conn =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM materials " +
                    "ORDER BY material_name";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            return ps.executeQuery();

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
    
    public ResultSet getLowStockReport() {

    try {

        Connection conn =
                DBConnection.getConnection();

        String sql =
            "SELECT * " +
            "FROM materials " +
            "WHERE quantity <= reorder_level " +
            "ORDER BY material_name";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        return ps.executeQuery();

    } catch (Exception e) {

        e.printStackTrace();

        return null;
    }
}
    
    public ResultSet getIssuanceHistoryReport() {

    try {

        Connection conn =
                DBConnection.getConnection();

        String sql =
            "SELECT " +
            "s.issuance_id, " +
            "c.first_name, " +
            "c.last_name, " +
            "m.material_name, " +
            "s.quantity_issued, " +
            "s.issued_date " +
            "FROM stock_issuance s " +
            "JOIN cleaners c " +
            "ON s.cleaner_id = c.cleaner_id " +
            "JOIN materials m " +
            "ON s.material_id = m.material_id " +
            "ORDER BY s.issued_date DESC";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        return ps.executeQuery();

    } catch (Exception e) {

        e.printStackTrace();

        return null;
    }
}
    
    public ResultSet getMaterialUsageReport() {

    try {

        Connection conn =
                DBConnection.getConnection();

        String sql =
            "SELECT " +
            "m.material_name, " +
            "SUM(s.quantity_issued) AS total_used " +
            "FROM stock_issuance s " +
            "JOIN materials m " +
            "ON s.material_id = m.material_id " +
            "GROUP BY m.material_name " +
            "ORDER BY total_used DESC";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        return ps.executeQuery();

    } catch (Exception e) {

        e.printStackTrace();

        return null;
    }
}
    
    
    public static void main(String args[]) {
      
    }
}
