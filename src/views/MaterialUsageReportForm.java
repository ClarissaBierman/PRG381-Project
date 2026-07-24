
package views;
import dao.ReportDAO;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class MaterialUsageReportForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MaterialUsageReportForm.class.getName());
     
    private void applyDarkMode() {
        getContentPane().setBackground(new java.awt.Color(15, 23, 42));
        tblUsage.setBackground(new java.awt.Color(30, 41, 59));
        tblUsage.setForeground(new java.awt.Color(226, 232, 240));
        tblUsage.setGridColor(new java.awt.Color(51, 65, 85));
        tblUsage.setSelectionBackground(new java.awt.Color(51, 65, 85));
        tblUsage.getTableHeader().setBackground(new java.awt.Color(30, 41, 59));
        tblUsage.getTableHeader().setForeground(new java.awt.Color(148, 163, 184));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(15, 23, 42));
        repaint();
    }

    private void applyLightMode() {
        getContentPane().setBackground(new java.awt.Color(248, 250, 252));
        tblUsage.setBackground(java.awt.Color.WHITE);
        tblUsage.setForeground(new java.awt.Color(15, 23, 42));
        tblUsage.setGridColor(new java.awt.Color(226, 232, 240));
        tblUsage.setSelectionBackground(new java.awt.Color(226, 232, 240));
        tblUsage.getTableHeader().setBackground(new java.awt.Color(241, 245, 249));
        tblUsage.getTableHeader().setForeground(new java.awt.Color(100, 116, 139));
        jScrollPane1.getViewport().setBackground(java.awt.Color.WHITE);
        repaint();
    }
    
    public MaterialUsageReportForm() {
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
        setTitle("Material Usage Report");
        
        tblUsage.setDefaultEditor(
        Object.class,
        null);
        
        loadMaterialUsage();
    }

    private void loadMaterialUsage() {

    try {

        DefaultTableModel model =
                (DefaultTableModel)
                tblUsage.getModel();

        model.setRowCount(0);

        ReportDAO dao =
                new ReportDAO();

        ResultSet rs =
                dao.getMaterialUsageReport();

        while (rs.next()) {

            model.addRow(new Object[] {

                rs.getString("material_name"),
                rs.getInt("total_used")
            });
            
            model.setColumnIdentifiers(
            new String[] {

        "Material Name",
        "Total Issued"
    });
        }

    } catch (Exception e) {

        e.printStackTrace();
    }
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsage = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnToggleTheme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblUsage.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUsage);

        btnRefresh.setText("Refresh");

        btnBack.setText("Back to Dashboard");
        btnBack.addActionListener(this::btnBackActionPerformed);

        btnToggleTheme.setText("☀ Light");
        btnToggleTheme.addActionListener(this::btnToggleThemeActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnToggleTheme)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(btnRefresh)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnToggleTheme)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRefresh)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        java.awt.EventQueue.invokeLater(() -> new MaterialUsageReportForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnToggleTheme;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblUsage;
    // End of variables declaration//GEN-END:variables
}
