
package views;
import dao.ReportDAO;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class LowStockReportForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LowStockReportForm.class.getName());
    
    private void applyDarkMode() {
        getContentPane().setBackground(new java.awt.Color(15, 23, 42));
        lblStatus.setForeground(new java.awt.Color(226, 232, 240));
        tblLowStock.setBackground(new java.awt.Color(30, 41, 59));
        tblLowStock.setForeground(new java.awt.Color(226, 232, 240));
        tblLowStock.setGridColor(new java.awt.Color(51, 65, 85));
        tblLowStock.setSelectionBackground(new java.awt.Color(51, 65, 85));
        tblLowStock.getTableHeader().setBackground(new java.awt.Color(30, 41, 59));
        tblLowStock.getTableHeader().setForeground(new java.awt.Color(148, 163, 184));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(15, 23, 42));
        repaint();
    }

    private void applyLightMode() {
        getContentPane().setBackground(new java.awt.Color(248, 250, 252));
        lblStatus.setForeground(new java.awt.Color(15, 23, 42));
        tblLowStock.setBackground(java.awt.Color.WHITE);
        tblLowStock.setForeground(new java.awt.Color(15, 23, 42));
        tblLowStock.setGridColor(new java.awt.Color(226, 232, 240));
        tblLowStock.setSelectionBackground(new java.awt.Color(226, 232, 240));
        tblLowStock.getTableHeader().setBackground(new java.awt.Color(241, 245, 249));
        tblLowStock.getTableHeader().setForeground(new java.awt.Color(100, 116, 139));
        jScrollPane1.getViewport().setBackground(java.awt.Color.WHITE);
        repaint();
    }
    
    public LowStockReportForm() {
        initComponents();
        setLocationRelativeTo(null);
        if (util.ThemeManager.isDarkMode) {
            applyDarkMode();
            btnToggleTheme.setText("☀ Light");
        } else {
            applyLightMode();
            btnToggleTheme.setText("🌙 Dark");
        }
        setLocationRelativeTo(null);
        
        setTitle("Low Stock Report");
        tblLowStock.setDefaultEditor(
        Object.class,
        null);
        
        loadLowStockReport();
        
    }
    private void loadLowStockReport() {

    try {

        DefaultTableModel model =
                (DefaultTableModel)
                tblLowStock.getModel();

        model.setRowCount(0);

        ReportDAO dao =
                new ReportDAO();

        ResultSet rs =
                dao.getLowStockReport();

        while (rs.next()) {

            model.addRow(new Object[] {

                rs.getInt("material_id"),
                rs.getString("material_name"),
                rs.getInt("quantity"),
                rs.getInt("reorder_level")
            });
        }

        lblStatus.setText(
                "Low Stock Items: "
                + tblLowStock.getRowCount());

    } catch (Exception e) {

        e.printStackTrace();
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLowStock = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnToggleTheme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblLowStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblLowStock);

        btnRefresh.setText("Refresh");

        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Status:");

        btnBack.setText("Back to Dashboard");
        btnBack.addActionListener(this::btnBackActionPerformed);

        btnToggleTheme.setText("☀ Light");
        btnToggleTheme.addActionListener(this::btnToggleThemeActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnToggleTheme)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnToggleTheme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        DashboardForm dashboardForm = new DashboardForm();
        dashboardForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnToggleThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToggleThemeActionPerformed
        util.ThemeManager.isDarkMode = !util.ThemeManager.isDarkMode;
        if (util.ThemeManager.isDarkMode) {
            applyDarkMode();
            btnToggleTheme.setText("☀ Light");
        } else {
            applyLightMode();
            btnToggleTheme.setText("🌙 Dark");
        }
    }//GEN-LAST:event_btnToggleThemeActionPerformed

    
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new LowStockReportForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnToggleTheme;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblLowStock;
    // End of variables declaration//GEN-END:variables
}
