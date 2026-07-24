
package views;
import dao.ReportDAO;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class InventoryReportForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InventoryReportForm.class.getName());
    
    private void applyDarkMode() {
        getContentPane().setBackground(new java.awt.Color(15, 23, 42));
        lblStatus.setForeground(new java.awt.Color(226, 232, 240));
        StaticStatus.setForeground(new java.awt.Color(226, 232, 240));
        tblInventory.setBackground(new java.awt.Color(30, 41, 59));
        tblInventory.setForeground(new java.awt.Color(226, 232, 240));
        tblInventory.setGridColor(new java.awt.Color(51, 65, 85));
        tblInventory.setSelectionBackground(new java.awt.Color(51, 65, 85));
        tblInventory.getTableHeader().setBackground(new java.awt.Color(30, 41, 59));
        tblInventory.getTableHeader().setForeground(new java.awt.Color(148, 163, 184));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(15, 23, 42));
        repaint();
    }

    private void applyLightMode() {
        getContentPane().setBackground(new java.awt.Color(248, 250, 252));
        lblStatus.setForeground(new java.awt.Color(15, 23, 42));
        StaticStatus.setForeground(new java.awt.Color(15, 23, 42));
        tblInventory.setBackground(java.awt.Color.WHITE);
        tblInventory.setForeground(new java.awt.Color(15, 23, 42));
        tblInventory.setGridColor(new java.awt.Color(226, 232, 240));
        tblInventory.setSelectionBackground(new java.awt.Color(226, 232, 240));
        tblInventory.getTableHeader().setBackground(new java.awt.Color(241, 245, 249));
        tblInventory.getTableHeader().setForeground(new java.awt.Color(100, 116, 139));
        jScrollPane1.getViewport().setBackground(java.awt.Color.WHITE);
        repaint();
    }

    private void loadInventoryReport() {

    try {

        DefaultTableModel model =
                (DefaultTableModel)
                tblInventory.getModel();

        model.setRowCount(0);

        ReportDAO dao =
                new ReportDAO();

        ResultSet rs =
                dao.getInventoryReport();

        while (rs.next()) {

            model.addRow(
                    new Object[] {

                        rs.getInt("material_id"),
                        rs.getString("material_name"),
                        rs.getInt("quantity"),
                        rs.getInt("reorder_level")
                    });
        }

    } catch (Exception e) {

        e.printStackTrace();
    }
}
    
    
    public InventoryReportForm() {
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
        setTitle("Inventory Report");
        
        tblInventory.setDefaultEditor(
        Object.class,
        null);
        
        DefaultTableModel model =
            (DefaultTableModel)
            tblInventory.getModel();

    model.setColumnIdentifiers(
            new String[] {

                "Material ID",
                "Material Name",
                "Quantity",
                "Reorder Level"
            });
        
        loadInventoryReport();
        
        tblInventory.setAutoResizeMode(
        javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        lblStatus.setText(
        "Materials Found: "
        + tblInventory.getRowCount());
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventory = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        btnRefresh = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        StaticStatus = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnToggleTheme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblInventory.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblInventory);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);

        lblStatus.setText("Ready");

        StaticStatus.setText("Status:");

        btnBack.setText("Back to Dashboard");
        btnBack.addActionListener(this::btnBackActionPerformed);

        btnToggleTheme.setText("☀ Light");
        btnToggleTheme.addActionListener(this::btnToggleThemeActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(StaticStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack))
                    .addComponent(btnToggleTheme)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnToggleTheme)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(StaticStatus)
                    .addComponent(btnRefresh)
                    .addComponent(btnBack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
       
        lblStatus.setText("Loading...");

        loadInventoryReport();

        lblStatus.setText(
        "Materials Found: "
        + tblInventory.getRowCount());
    }//GEN-LAST:event_btnRefreshActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new InventoryReportForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StaticStatus;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnToggleTheme;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblInventory;
    // End of variables declaration//GEN-END:variables
}
