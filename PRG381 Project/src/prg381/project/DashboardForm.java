package prg381.project;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class DashboardForm extends javax.swing.JFrame {

    /**
     * Creates new form DashboardForm
     */
    public DashboardForm() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(15, 23, 42));
    }
    
    private void loadDashboardData() {
        loadTotalMaterials();
        loadLowStockCount();
        loadTotalCleaners();
        loadRecentIssuances();
    }
    
    private void loadTotalMaterials() {
    Connection conn = DBConnection.getConnection();

        try {
            String sql = "SELECT COUNT(*) AS total FROM materials";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                int total = rs.getInt("total");
                lblTotalMaterials.setText(String.valueOf(total));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadLowStockCount() {
        Connection conn = DBConnection.getConnection();

        try {
            String sql = "SELECT COUNT(*) AS total FROM materials WHERE quantity <= reorder_level";
            PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();
             
            if (rs.next()) {
                int total = rs.getInt("total");
                lblLowStock.setText(String.valueOf(total));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadTotalCleaners() {
        Connection conn = DBConnection.getConnection();

        try {
            String sql = "SELECT COUNT(*) AS total FROM cleaners";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int total = rs.getInt("total");
                lblTotalCleaners.setText(String.valueOf(total));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadRecentIssuances() {
        Connection conn = DBConnection.getConnection();
        DefaultTableModel model = (DefaultTableModel) tblRecentIssuances.getModel();
        model.setRowCount(0);
        int count = 0;

        try {
            String sql = "SELECT material_id, cleaner_id, quantity_issued, issue_date "
                    + "FROM stock_issuances ORDER BY issue_date DESC LIMIT 10";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int materialId = rs.getInt("material_id");
                int cleanerId = rs.getInt("cleaner_id");
                int quantityIssued = rs.getInt("quantity_issued");
                String issueDate = rs.getString("issue_date");

                model.addRow(new Object[]{materialId, cleanerId, quantityIssued, issueDate});
                count++;
            }

            lblRecentCount.setText(String.valueOf(count));

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private boolean isDarkMode = true;
    
    private void applyDarkMode() {
        getContentPane().setBackground(new java.awt.Color(15, 23, 42));

        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblSubtitle.setForeground(new java.awt.Color(148, 163, 187));
        lblRecentStockIssuances.setForeground(new java.awt.Color(255, 255, 255));

        pnlTotalMaterials.setBackground(new java.awt.Color(30, 41, 59));
        pnlLowStock.setBackground(new java.awt.Color(30, 41, 59));
        pnlTotalCleaners.setBackground(new java.awt.Color(30, 41, 59));
        pnlRecentCount.setBackground(new java.awt.Color(30, 41, 59));

        lblTotalMaterialsLabel.setForeground(new java.awt.Color(148, 163, 187));
        lblLowStockLabel.setForeground(new java.awt.Color(148, 163, 187));
        lblTotalCleanersLabel.setForeground(new java.awt.Color(148, 163, 187));
        lblRecentCountLabel.setForeground(new java.awt.Color(148, 163, 187));

        lblTotalMaterials.setForeground(new java.awt.Color(255, 255, 255));
        lblLowStock.setForeground(new java.awt.Color(248, 113, 113));
        lblTotalCleaners.setForeground(new java.awt.Color(96, 165, 250));
        lblRecentCount.setForeground(new java.awt.Color(52, 211, 153));

        tblRecentIssuances.setBackground(new java.awt.Color(30, 41, 59));
        tblRecentIssuances.setForeground(new java.awt.Color(226, 232, 240));
        tblRecentIssuances.setGridColor(new java.awt.Color(51, 65, 85));
        tblRecentIssuances.setSelectionBackground(new java.awt.Color(51, 65, 85));
        tblRecentIssuances.getTableHeader().setBackground(new java.awt.Color(30, 41, 59));
        tblRecentIssuances.getTableHeader().setForeground(new java.awt.Color(148, 163, 184));

        jScrollPane1.getViewport().setBackground(new java.awt.Color(15, 23, 42));

        repaint();
    }

    private void applyLightMode() {
        getContentPane().setBackground(new java.awt.Color(248, 250, 252));

        lblTitle.setForeground(new java.awt.Color(15, 23, 42));
        lblSubtitle.setForeground(new java.awt.Color(100, 116, 139));
        lblRecentStockIssuances.setForeground(new java.awt.Color(15, 23, 42));

        pnlTotalMaterials.setBackground(new java.awt.Color(241, 245, 249));
        pnlLowStock.setBackground(new java.awt.Color(241, 245, 249));
        pnlTotalCleaners.setBackground(new java.awt.Color(241, 245, 249));
        pnlRecentCount.setBackground(new java.awt.Color(241, 245, 249));

        lblTotalMaterialsLabel.setForeground(new java.awt.Color(100, 116, 139));
        lblLowStockLabel.setForeground(new java.awt.Color(100, 116, 139));
        lblTotalCleanersLabel.setForeground(new java.awt.Color(100, 116, 139));
        lblRecentCountLabel.setForeground(new java.awt.Color(100, 116, 139));

        lblTotalMaterials.setForeground(new java.awt.Color(15, 23, 42));
        lblLowStock.setForeground(new java.awt.Color(220, 38, 38));
        lblTotalCleaners.setForeground(new java.awt.Color(37, 99, 235));
        lblRecentCount.setForeground(new java.awt.Color(5, 150, 105));

        tblRecentIssuances.setBackground(new java.awt.Color(255, 255, 255));
        tblRecentIssuances.setForeground(new java.awt.Color(15, 23, 42));
        tblRecentIssuances.setGridColor(new java.awt.Color(226, 232, 240));
        tblRecentIssuances.setSelectionBackground(new java.awt.Color(226, 232, 240));
        tblRecentIssuances.getTableHeader().setBackground(new java.awt.Color(241, 245, 249));
        tblRecentIssuances.getTableHeader().setForeground(new java.awt.Color(100, 116, 139));

        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));

        repaint();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        pnlTotalMaterials = new javax.swing.JPanel();
        lblTotalMaterialsLabel = new javax.swing.JLabel();
        lblTotalMaterials = new javax.swing.JLabel();
        pnlLowStock = new javax.swing.JPanel();
        lblLowStockLabel = new javax.swing.JLabel();
        lblLowStock = new javax.swing.JLabel();
        pnlTotalCleaners = new javax.swing.JPanel();
        lblTotalCleanersLabel = new javax.swing.JLabel();
        lblTotalCleaners = new javax.swing.JLabel();
        pnlRecentCount = new javax.swing.JPanel();
        lblRecentCountLabel = new javax.swing.JLabel();
        lblRecentCount = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecentIssuances = new javax.swing.JTable();
        lblRecentStockIssuances = new javax.swing.JLabel();
        btnToggleTheme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("University Cleaning Inventory System");
        setBackground(new java.awt.Color(0, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Dashboard");

        lblSubtitle.setForeground(new java.awt.Color(148, 163, 187));
        lblSubtitle.setText("University Cleaning Inventory System");

        pnlTotalMaterials.setBackground(new java.awt.Color(30, 41, 59));
        pnlTotalMaterials.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        pnlTotalMaterials.setPreferredSize(new java.awt.Dimension(200, 110));

        lblTotalMaterialsLabel.setForeground(new java.awt.Color(148, 163, 187));
        lblTotalMaterialsLabel.setText("TOTAL MATERIALS");

        lblTotalMaterials.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblTotalMaterials.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalMaterials.setText("0");

        javax.swing.GroupLayout pnlTotalMaterialsLayout = new javax.swing.GroupLayout(pnlTotalMaterials);
        pnlTotalMaterials.setLayout(pnlTotalMaterialsLayout);
        pnlTotalMaterialsLayout.setHorizontalGroup(
            pnlTotalMaterialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalMaterialsLayout.createSequentialGroup()
                .addGroup(pnlTotalMaterialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalMaterialsLabel)
                    .addComponent(lblTotalMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 45, Short.MAX_VALUE))
        );
        pnlTotalMaterialsLayout.setVerticalGroup(
            pnlTotalMaterialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalMaterialsLayout.createSequentialGroup()
                .addComponent(lblTotalMaterialsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalMaterials, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlLowStock.setBackground(new java.awt.Color(30, 41, 59));
        pnlLowStock.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        pnlLowStock.setPreferredSize(new java.awt.Dimension(200, 110));

        lblLowStockLabel.setForeground(new java.awt.Color(148, 163, 187));
        lblLowStockLabel.setText("LOW STOCK");

        lblLowStock.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblLowStock.setForeground(new java.awt.Color(248, 113, 113));
        lblLowStock.setText("0");

        javax.swing.GroupLayout pnlLowStockLayout = new javax.swing.GroupLayout(pnlLowStock);
        pnlLowStock.setLayout(pnlLowStockLayout);
        pnlLowStockLayout.setHorizontalGroup(
            pnlLowStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLowStockLayout.createSequentialGroup()
                .addGroup(pnlLowStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLowStockLabel)
                    .addComponent(lblLowStock, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 43, Short.MAX_VALUE))
        );
        pnlLowStockLayout.setVerticalGroup(
            pnlLowStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLowStockLayout.createSequentialGroup()
                .addComponent(lblLowStockLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLowStock, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlTotalCleaners.setBackground(new java.awt.Color(30, 41, 59));
        pnlTotalCleaners.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        pnlTotalCleaners.setPreferredSize(new java.awt.Dimension(200, 110));

        lblTotalCleanersLabel.setForeground(new java.awt.Color(148, 163, 187));
        lblTotalCleanersLabel.setText("TOTAL CLEANERS");

        lblTotalCleaners.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblTotalCleaners.setForeground(new java.awt.Color(96, 165, 250));
        lblTotalCleaners.setText("0");

        javax.swing.GroupLayout pnlTotalCleanersLayout = new javax.swing.GroupLayout(pnlTotalCleaners);
        pnlTotalCleaners.setLayout(pnlTotalCleanersLayout);
        pnlTotalCleanersLayout.setHorizontalGroup(
            pnlTotalCleanersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalCleanersLayout.createSequentialGroup()
                .addGroup(pnlTotalCleanersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalCleanersLabel)
                    .addComponent(lblTotalCleaners, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 43, Short.MAX_VALUE))
        );
        pnlTotalCleanersLayout.setVerticalGroup(
            pnlTotalCleanersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalCleanersLayout.createSequentialGroup()
                .addComponent(lblTotalCleanersLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalCleaners, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlRecentCount.setBackground(new java.awt.Color(30, 41, 59));
        pnlRecentCount.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        pnlRecentCount.setPreferredSize(new java.awt.Dimension(200, 110));

        lblRecentCountLabel.setForeground(new java.awt.Color(148, 163, 187));
        lblRecentCountLabel.setText("RECENT COUNT");

        lblRecentCount.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblRecentCount.setForeground(new java.awt.Color(52, 211, 153));
        lblRecentCount.setText("0");

        javax.swing.GroupLayout pnlRecentCountLayout = new javax.swing.GroupLayout(pnlRecentCount);
        pnlRecentCount.setLayout(pnlRecentCountLayout);
        pnlRecentCountLayout.setHorizontalGroup(
            pnlRecentCountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecentCountLayout.createSequentialGroup()
                .addGroup(pnlRecentCountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecentCountLabel)
                    .addComponent(lblRecentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlRecentCountLayout.setVerticalGroup(
            pnlRecentCountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecentCountLayout.createSequentialGroup()
                .addComponent(lblRecentCountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecentCount, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(15, 23, 42));

        tblRecentIssuances.setBackground(new java.awt.Color(30, 41, 59));
        tblRecentIssuances.setForeground(new java.awt.Color(226, 232, 240));
        tblRecentIssuances.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Material ID", "Cleaner ID", "Quantity", "Date"
            }
        ));
        tblRecentIssuances.setGridColor(new java.awt.Color(51, 65, 85));
        tblRecentIssuances.setSelectionBackground(new java.awt.Color(51, 65, 85));
        jScrollPane1.setViewportView(tblRecentIssuances);

        lblRecentStockIssuances.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRecentStockIssuances.setForeground(new java.awt.Color(255, 255, 255));
        lblRecentStockIssuances.setText("Recent Stock Issuances");

        btnToggleTheme.setText("Toggle Theme");
        btnToggleTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToggleThemeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlLowStock, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnlTotalCleaners, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnlTotalMaterials, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(pnlRecentCount, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btnToggleTheme))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(lblRecentStockIssuances))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lblSubtitle)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnToggleTheme)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lblSubtitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTotalMaterials, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlLowStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlRecentCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(pnlTotalCleaners, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRecentStockIssuances)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadDashboardData();
        tblRecentIssuances.setRowHeight(28);
        applyDarkMode();
        btnToggleTheme.setText("☀ Light");
    }//GEN-LAST:event_formWindowOpened

    private void btnToggleThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToggleThemeActionPerformed
        isDarkMode = !isDarkMode;

        if (isDarkMode) {
            applyDarkMode();
            btnToggleTheme.setText("☀ Light");
        } else {
            applyLightMode();
            btnToggleTheme.setText("🌙 Dark");
        }
    }//GEN-LAST:event_btnToggleThemeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnToggleTheme;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLowStock;
    private javax.swing.JLabel lblLowStockLabel;
    private javax.swing.JLabel lblRecentCount;
    private javax.swing.JLabel lblRecentCountLabel;
    private javax.swing.JLabel lblRecentStockIssuances;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalCleaners;
    private javax.swing.JLabel lblTotalCleanersLabel;
    private javax.swing.JLabel lblTotalMaterials;
    private javax.swing.JLabel lblTotalMaterialsLabel;
    private javax.swing.JPanel pnlLowStock;
    private javax.swing.JPanel pnlRecentCount;
    private javax.swing.JPanel pnlTotalCleaners;
    private javax.swing.JPanel pnlTotalMaterials;
    private javax.swing.JTable tblRecentIssuances;
    // End of variables declaration//GEN-END:variables
}
