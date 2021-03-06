/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import util.Sutil;
import util.Sutil;

/**
 *
 * @author FG
 */
public final class ChartSearch extends javax.swing.JDialog {

    /**
     * Creates new form ChartSearch
     */
    private Connection conn;
    private int row;
    private int chart_id;
    public String Direction;

    public ChartSearch(java.awt.Frame parent, boolean modal, Connection conn, String Direction) {
        super(parent, modal);
        this.conn = conn;
        this.Direction = Direction;
        initComponents();
        txtSearch.requestFocusInWindow();
        loadDatabase();
        comboChartType();
        tableSelectionListener();
        setLocationRelativeTo(null);

    }

    private void tableSelectionListener() {
        ListSelectionListener listener2 = (ListSelectionEvent e) -> {
            row = tblChart.getSelectedRow();
            if (row >= 0) {
                txtChartNo.setText(tblChart.getValueAt(row, 0).toString());
                txtChartNo.setEditable(false);
                txtChartName.setText(tblChart.getValueAt(row, 1).toString());
                cboType.setSelectedItem(tblChart.getValueAt(row, 2).toString());
            }
        };
        tblChart.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblChart.getSelectionModel().addListSelectionListener(listener2);

    }

    public void removeTableData() {
        DefaultTableModel tableModel = (DefaultTableModel) tblChart.getModel();
        tableModel.setRowCount(0);

    }

    public void loadDatabase() {

        try {

            String sql = "SELECT chart_no,chart_name,chart_type FROM akuntansi.chartlist order by chart_no;";
            PreparedStatement pstatement = conn.prepareStatement(sql);

            ResultSet rs = pstatement.executeQuery();
            if (rs.isBeforeFirst()) { // check is resultset not empty
                DefaultTableModel model = (DefaultTableModel) tblChart.getModel();
                while (rs.next()) {
                    Object data[] = {
                        rs.getString("chart_no"),
                        rs.getString("chart_name"),
                        rs.getString("chart_type"),};
                    model.addRow(data);
                }
            } else {

            }
            rs.close();
            pstatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChart = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtChartNo = new javax.swing.JTextField();
        txtChartName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblRefresh = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboType = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AMA | v.1");
        setBackground(new java.awt.Color(32, 47, 78));

        jPanel1.setBackground(new java.awt.Color(32, 47, 78));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        tblChart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chart No", "Chart Name", "Chart Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblChart);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/Search Engine.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/Button OK.gif"))); // NOI18N
        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Orator Std", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SEARCH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSearch)
                                .addGap(4, 4, 4))))
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(32, 47, 78));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtChartNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChartNoActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/+ Icon.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/UPDATE ICON.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/47-512.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/arrow_refresh.png"))); // NOI18N
        lblRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefreshMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Orator Std", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Customize Chart");

        jLabel7.setFont(new java.awt.Font("Orator Std", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TYPE");

        jLabel8.setFont(new java.awt.Font("Orator Std", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CHART NO");
        jLabel8.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jLabel8ComponentMoved(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Orator Std", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CHART NAME");

        cboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Type.." }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtChartNo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChartName, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRefresh)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtChartNo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtChartName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int counter;

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if ((!txtChartNo.getText().trim().isEmpty()) && (!txtChartName.getText().trim().isEmpty())) {
            try {
                String countsql = "SELECT count(chart_no)as counter FROM akuntansi.chartlist where chart_no=?";
                PreparedStatement pstatement1 = conn.prepareStatement(countsql);
                pstatement1.setString(1, txtChartNo.getText().trim());
                ResultSet rs = pstatement1.executeQuery();
                if (rs.isBeforeFirst()) { // check is resultset not empty
                    while (rs.next()) {
                        counter = rs.getInt("counter");

                    }
                } else {
                }

                if (counter == 0) {
                    executeAdd();
                    removeTableData();
                    loadDatabase();
                    txtChartName.setText("");
                    txtChartNo.setText("");
                    Sutil.msg(this, "Chart added.");
                } else {
                    removeTableData();
                    loadDatabase();
                    txtChartName.setText("");
                    txtChartNo.setText("");
                    Sutil.msg(this, "Chart Number exists.");
                }

            } catch (SQLException ex) {
                Logger.getLogger(ChartSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Sutil.msg(this, "Some field is still empty.");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private Boolean changeable;

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if ((!txtChartNo.getText().trim().isEmpty()) && (!txtChartName.getText().trim().isEmpty())) {

            try {

                String getAccess = "SELECT changeable FROM akuntansi.chartlist where chart_no=?";
                PreparedStatement pstatement1 = conn.prepareStatement(getAccess);
                pstatement1.setString(1, txtChartNo.getText().trim());
                ResultSet rs = pstatement1.executeQuery();
                if (rs.isBeforeFirst()) { // check is resultset not empty
                    while (rs.next()) {
                        changeable = rs.getBoolean("changeable");

                    }
                } else {
                }

                if (changeable == true) {
                    executeUpdate();
                    removeTableData();
                    loadDatabase();
                    txtChartName.setText("");
                    txtChartNo.setText("");

                } else {
                    Sutil.msg(this, "You can't change basic chart!");

                    txtChartName.setText("");
                    txtChartNo.setText("");
                    removeTableData();
                    loadDatabase();
                }

            } catch (SQLException ex) {
                Logger.getLogger(ChartSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Sutil.msg(this, "Some field is still empty.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        try {

            String getAccess = "SELECT changeable FROM akuntansi.chartlist where chart_no=?";
            PreparedStatement pstatement1 = conn.prepareStatement(getAccess);
            pstatement1.setString(1, txtChartNo.getText().trim());
            ResultSet rs = pstatement1.executeQuery();
            if (rs.isBeforeFirst()) { // check is resultset not empty
                while (rs.next()) {
                    changeable = rs.getBoolean("changeable");
                   
                }
                System.out.println(changeable);
                 if (changeable == true) {
                        executeDelete();

                        removeTableData();
                        loadDatabase();
                        txtChartName.setText("");
                        txtChartNo.setText("");

                    } else if (changeable == false) {
                        Sutil.msg(this, "You can't delete basic chart!");

                        txtChartName.setText("");
                        txtChartNo.setText("");
                        removeTableData();
                        loadDatabase();
                    }
            } else {
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChartSearch.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (Direction.equals("A")) {

            int row = tblChart.getSelectedRow();
            if (row >= 0) {
                FrmAdmin.txtChartNumber_Journal.setText(tblChart.getValueAt(row, 0).toString());
                FrmAdmin.txtChartName_Journal.setText(tblChart.getValueAt(row, 1).toString());

                dispose();
            }

        } else if (Direction.equals("JV")) {
            int row = tblChart.getSelectedRow();
            if (row >= 0) {
                FrmJournalViewer.txtChartNumber_Journal.setText(tblChart.getValueAt(row, 0).toString());
                FrmJournalViewer.txtChartName_Journal.setText(tblChart.getValueAt(row, 1).toString());

                dispose();
            }

        }

    }//GEN-LAST:event_btnOkActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        executeSearch();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        executeSearch();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtChartNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChartNoActionPerformed
        txtChartName.requestFocusInWindow();
    }//GEN-LAST:event_txtChartNoActionPerformed

    private void lblRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseClicked
        removeTableData();
        txtChartNo.setText("");
        txtChartName.setText("");
        txtChartNo.setEditable(true);
        txtChartName.setEditable(true);
        loadDatabase();
    }//GEN-LAST:event_lblRefreshMouseClicked

    private void jLabel8ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel8ComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8ComponentMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblRefresh;
    private javax.swing.JTable tblChart;
    private javax.swing.JTextField txtChartName;
    private javax.swing.JTextField txtChartNo;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void executeAdd() throws SQLException {
        DefaultTableModel tableModel = (DefaultTableModel) tblChart.getModel();

        String insertSql = "insert into akuntansi.chartlist values (?,?,?,?)";
        PreparedStatement pstatement = conn.prepareStatement(insertSql);
        pstatement.setInt(1, Integer.valueOf(txtChartNo.getText()));
        pstatement.setString(2, txtChartName.getText());
        pstatement.setString(3, cboType.getSelectedItem().toString());
        pstatement.setBoolean(4, true);
        pstatement.executeUpdate();

        tableModel.setRowCount(0);
        loadDatabase();
        pstatement.close();
    }

    private void executeUpdate() throws SQLException {

        String editSql = "update akuntansi.chartlist set "
                + "chart_name=?, chart_type=?"
                + "where chart_no=?";
        PreparedStatement pstatement2 = conn.prepareStatement(editSql);
        pstatement2.setString(1, txtChartName.getText().trim());
        pstatement2.setString(2, cboType.getSelectedItem().toString());
        pstatement2.setInt(3, Integer.valueOf(txtChartNo.getText()));
        pstatement2.executeUpdate();
        pstatement2.close();
        Sutil.msg(this, "Chart has been updated.");
    }

    private void executeDelete() throws SQLException {
        if (Sutil.msq(this, "Are you sure?") == 0) {

            DefaultTableModel tableModel = (DefaultTableModel) tblChart.getModel();
            tableModel.setRowCount(0);
            String deleteSql = "DELETE FROM akuntansi.chartlist where chart_no = ?";
            PreparedStatement pstatement = conn.prepareStatement(deleteSql);
            pstatement.setInt(1, Integer.valueOf(txtChartNo.getText()));
            pstatement.executeUpdate();
            pstatement.close();
        }
    }

    private void executeSearch() {

        try {
            removeTableData();
            String sql = "SELECT * FROM akuntansi.chartlist WHERE chart_name LIKE ?";

            PreparedStatement pstatement = conn.prepareStatement(sql);
            pstatement.setString(1, "%" + txtSearch.getText().trim() + "%");

            ResultSet rs = pstatement.executeQuery();
            if (rs.isBeforeFirst()) { // check is resultset not empty
                DefaultTableModel tableModel = (DefaultTableModel) tblChart.getModel();
                while (rs.next()) {
                    Object data[] = {
                        rs.getInt("chart_no"),
                        rs.getString("chart_name"),
                        rs.getString("chart_type")

                    };
                    tableModel.addRow(data);
                }
            }

            rs.close();
            pstatement.close();
        } catch (SQLException ex) {
            System.out.println("Error:\n" + ex.getLocalizedMessage());
        }

    }

    private void comboChartType() {
        try {

            String sql = "SELECT distinct chart_type FROM akuntansi.chartlist;";
            PreparedStatement pstatement = conn.prepareStatement(sql);

            ResultSet rs = pstatement.executeQuery();
            if (rs.isBeforeFirst()) { // check is resultset not empty
                DefaultComboBoxModel combotype = new DefaultComboBoxModel();
                while (rs.next()) {
                    String chart_type = rs.getString("chart_type");
                    combotype.addElement(chart_type);
                }

                cboType.setModel(combotype);
            } else {

            }
            rs.close();
            pstatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
