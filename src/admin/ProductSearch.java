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
public final class ProductSearch extends javax.swing.JDialog {

    /**
     * Creates new form ChartSearch
     */
    private Connection conn;
    private int row;

    public ProductSearch(java.awt.Frame parent, boolean modal, Connection conn, String Direction) {
        super(parent, modal);
        this.conn = conn;
        initComponents();
        txtSearch.requestFocusInWindow();
        loadProducts();
        tableSelectionListener();
        setLocationRelativeTo(null);

    }

    private void tableSelectionListener() {
        ListSelectionListener listener2 = (ListSelectionEvent e) -> {
            row = tblProduct.getSelectedRow();
            if (row >= 0) {
                txtPID.setText(tblProduct.getValueAt(row, 0).toString());
                txtPName_INV.setText(tblProduct.getValueAt(row, 1).toString());
            }
        };
        tblProduct.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblProduct.getSelectionModel().addListSelectionListener(listener2);

    }

    public void removeTableData() {
        DefaultTableModel tableModel = (DefaultTableModel) tblProduct.getModel();
        tableModel.setRowCount(0);

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
        tblProduct = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        txtPID = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txtPName_INV = new javax.swing.JTextField();
        lblRefreshProduct_GL = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

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

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProduct);
        if (tblProduct.getColumnModel().getColumnCount() > 0) {
            tblProduct.getColumnModel().getColumn(0).setResizable(false);
            tblProduct.getColumnModel().getColumn(1).setResizable(false);
        }

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

        jLabel5.setFont(new java.awt.Font("Orator Std", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SEARCH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(32, 47, 78));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Register Product", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel64.setFont(new java.awt.Font("Orator Std", 0, 27)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Product ID");

        txtPID.setEditable(false);
        txtPID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPID.setText("AUTOGENERATED");

        jLabel65.setFont(new java.awt.Font("Orator Std", 0, 27)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("PRODUCT NAME");

        lblRefreshProduct_GL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/arrow_refresh.png"))); // NOI18N
        lblRefreshProduct_GL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefreshProduct_GLMouseClicked(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblRefreshProduct_GL))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPID)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 172, Short.MAX_VALUE))
                    .addComponent(txtPName_INV)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(lblRefreshProduct_GL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPName_INV, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int counter;

    private Boolean changeable;

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        executeSearch();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        executeSearch();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void lblRefreshProduct_GLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshProduct_GLMouseClicked
        refreshForm();
    }//GEN-LAST:event_lblRefreshProduct_GLMouseClicked
    private int productcount;
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!txtPName_INV.getText().isEmpty()) {
            checkDataProduct();
            if (productcount > 0) {
                Sutil.msg(this, "Data exists.");
            } else {
                executeAddProduct();
                refreshForm();
                removeTableDataProducts();
                loadProducts();
            }
        } else {
            Sutil.msg(this, "Some field is still empty.");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (!txtPName_INV.getText().trim().isEmpty()) {
            executeUpdate();
            refreshForm();
            removeTableDataProducts();
            loadProducts();
        } else {
            Sutil.msg(this, "Some field is still empty.");
        }


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        if (!txtPID.getText().trim().isEmpty()) {
            executeDelete();
            removeTableDataProducts();
            loadProducts();
            refreshForm();

        } else {
            Sutil.msg(this, "No data selected.");

        }

    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblRefreshProduct_GL;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtPID;
    private javax.swing.JTextField txtPName_INV;
    public static javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void executeUpdate() {

        try {
            String editSql = "update akuntansi.productlist set "
                    + "product_name=?"
                    + "where pid=?";
            PreparedStatement pstatement2 = conn.prepareStatement(editSql);
            pstatement2.setString(1, txtPName_INV.getText().trim());
            pstatement2.setString(2, txtPID.getText());
            pstatement2.executeUpdate();
            pstatement2.close();
            Sutil.msg(this, "Product has been updated.");
        } catch (SQLException ex) {
            Logger.getLogger(ProductSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void executeDelete() {
        if (Sutil.msq(this, "Are you sure?") == 0) {

            try {
                String deleteSql = "DELETE FROM productlist where pid = ?";
                PreparedStatement deletepstatement = conn.prepareStatement(deleteSql);
                deletepstatement.setString(1, txtPID.getText().trim());
                deletepstatement.executeUpdate();
                deletepstatement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
            Sutil.msg(this, "Product deleted.");
        }
    }

    private void executeSearch() {

        try {
            removeTableData();
            String sql = "SELECT * FROM akuntansi.productlist WHERE product_name LIKE ? order by pno";

            PreparedStatement pstatement = conn.prepareStatement(sql);
            pstatement.setString(1, "%" + txtSearch.getText().trim() + "%");

            ResultSet rs = pstatement.executeQuery();
            if (rs.isBeforeFirst()) { // check is resultset not empty
                DefaultTableModel tableModel = (DefaultTableModel) tblProduct.getModel();
                while (rs.next()) {
                    Object data[] = {
                        rs.getString("pid"),
                        rs.getString("product_name")

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

    private void removeTableDataProducts() {
        DefaultTableModel tableModel = (DefaultTableModel) tblProduct.getModel();
        tableModel.setRowCount(0);
    }

    private int counterpid, pno;
    private String pid, pname;

    private void executeAddProduct() {
        try {
            String countpidSql = "select count(pno)as counter,max(pno) as max_pno from productlist;";
            PreparedStatement pstatement_countpid = conn.prepareStatement(countpidSql);
            ResultSet rs = pstatement_countpid.executeQuery();
            if (rs.isBeforeFirst()) { // check is resultset not empty
                while (rs.next()) {
                    counterpid = rs.getInt("counter");
                    pno = rs.getInt("max_pno");

                }
            }

            rs.close();
            pstatement_countpid.close();

            if (counterpid == 0) {
                pno = 1;
                pid = "P-00" + pno;
            } else {
                pid = "P-00" + (pno + 1);

            }
            txtPID.setText(pid);

            executeSaveProduct();

        } catch (SQLException ex) {
            Logger.getLogger(FrmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void executeSaveProduct() {
        try {
            String insertProductSql = "insert into akuntansi.productlist values (?,?,?)";
            PreparedStatement pstatement_insertproduct = conn.prepareStatement(insertProductSql);
            pstatement_insertproduct.setString(1, txtPID.getText());
            pstatement_insertproduct.setInt(2, pno + 1);
            pstatement_insertproduct.setString(3, txtPName_INV.getText());
            pstatement_insertproduct.executeUpdate();

            pstatement_insertproduct.close();
            Sutil.msg(this, "Product " + pid + " has been added.");
        } catch (SQLException ex) {
            Logger.getLogger(FrmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String product_INV, pid_sql, pname_sql;

    private void loadProducts() {
        try {
            removeTableDataProducts();
            if (conn != null) {
                String sql = "select  pid, product_name from productlist order by pno;";
                PreparedStatement pstatement = conn.prepareStatement(sql);
                DefaultTableModel product = (DefaultTableModel) tblProduct.getModel();
                ResultSet rs = pstatement.executeQuery();
                while (rs.next()) {
                    Object data[] = {
                        rs.getString("pid"),
                        rs.getString("product_name"),};
                    product.addRow(data);
                }

            }

        } catch (SQLException ex) {
            System.out.println("Error:\n" + ex.getLocalizedMessage());
        }
    }

    private void checkDataProduct() {
        try {
            String sql = "select  count(pid) as counter from productlist where product_name=?;";
            PreparedStatement pstatement = conn.prepareStatement(sql);
            pstatement.setString(1, txtPName_INV.getText());
            ResultSet rs = pstatement.executeQuery();
            while (rs.next()) {
                Object data[] = {
                    productcount = rs.getInt("counter"),};

            }

        } catch (SQLException ex) {
            Logger.getLogger(FrmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshForm() {
        txtPID.setText("AUTOGENERATED");
        txtPName_INV.setText("");
        btnAdd.setEnabled(true);
    }

}
