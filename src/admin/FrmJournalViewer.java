/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import static admin.FrmAdmin.convertUtilDateToSql;
import static admin.FrmAdmin.txtChartName_Journal;
import static admin.FrmAdmin.txtChartNumber_Journal;
import static java.awt.Color.black;
import static java.awt.Color.red;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import util.Sutil;

/**
 *
 * @author FG
 */
public class FrmJournalViewer extends javax.swing.JFrame {

    /**
     * Creates new form FrmJournalViewer
     */
    public static String direction;
    private Connection conn;
    private String month_java, year_java;
    private int month_sql = 0;
    private String year_sql;
    private String JID_Journal;
    private int jno;
    private int counter;

    public FrmJournalViewer(Connection conn) {
        this.conn = conn;
        initComponents();
        lblError.setVisible(false);
        ComboBox();
        tableSelectionListener();
        setLocationRelativeTo(null);
    }

    public void ComboBox() {
        try {
            if (conn != null) {
                String sql = "select  distinct month(tgl) as month, year(tgl) as year from journal_detail;";
                PreparedStatement pstatement = conn.prepareStatement(sql);
                DefaultComboBoxModel cbo_model = new DefaultComboBoxModel();
                DefaultTableModel model = (DefaultTableModel) tblJournalViewer.getModel();
                ResultSet rs = pstatement.executeQuery();
                while (rs.next()) {
                    Object data[] = {
                        month_sql = Integer.valueOf(rs.getString("month")),
                        year_sql = rs.getString("year"),};

                    switch (month_sql) {
                        case 1:
                            cbo_model.addElement("January " + year_sql);
                            break;
                        case 2:
                            cbo_model.addElement("February " + year_sql);
                            break;
                        case 3:
                            cbo_model.addElement("March " + year_sql);
                            break;
                        case 4:
                            cbo_model.addElement("April " + year_sql);
                            break;
                        case 5:
                            cbo_model.addElement("May " + year_sql);
                            break;
                        case 6:
                            cbo_model.addElement("June " + year_sql);
                            break;
                        case 7:
                            cbo_model.addElement("July " + year_sql);
                            break;
                        case 8:
                            cbo_model.addElement("August " + year_sql);
                            break;
                        case 9:
                            cbo_model.addElement("September " + year_sql);
                            break;
                        case 10:
                            cbo_model.addElement("October " + year_sql);
                            break;
                        case 11:
                            cbo_model.addElement("November " + year_sql);
                            break;
                        case 12:
                            cbo_model.addElement("December " + year_sql);
                            break;
                        default:
                            break;
                    }

                }
                cboSorter_JV.setModel(cbo_model);

            }

        } catch (SQLException ex) {
            System.out.println("Error:\n" + ex.getLocalizedMessage());
        }
    }

    private void removeTableData() {
        DefaultTableModel tableModel = (DefaultTableModel) tblJournalViewer.getModel();
        tableModel.setRowCount(0);
    }

    public void loadJournal_Detail() throws SQLException {

        String date = String.valueOf(cboSorter_JV.getSelectedItem());
        String[] parts = date.split(" ");
        month_java = parts[0];
        year_java = parts[1];
        if (month_java.equals("January")) {
            month_sql = 1;
        } else if (month_java.equals("February")) {
            month_sql = 2;
        } else if (month_java.equals("March")) {
            month_sql = 3;
        } else if (month_java.equals("April")) {
            month_sql = 4;
        } else if (month_java.equals("May")) {
            month_sql = 5;
        } else if (month_java.equals("June")) {
            month_sql = 6;
        } else if (month_java.equals("July")) {
            month_sql = 7;
        } else if (month_java.equals("August")) {
            month_sql = 8;
        } else if (month_java.equals("September")) {
            month_sql = 9;
        } else if (month_java.equals("October")) {
            month_sql = 10;
        } else if (month_java.equals("November")) {
            month_sql = 11;
        } else if (month_java.equals("December")) {
            month_sql = 12;
        }

        try {
            if (conn != null) {
                String sql = "select * from journal_detail where month(tgl) = ? and year(tgl)=?order by jid;";
                PreparedStatement pstatement = conn.prepareStatement(sql);
                DefaultTableModel model = (DefaultTableModel) tblJournalViewer.getModel();
                pstatement.setString(1, String.valueOf(month_sql));
                pstatement.setString(2, year_java);
                ResultSet rs = pstatement.executeQuery();
                while (rs.next()) {
                    Object data[] = {
                        rs.getDate("tgl"),
                        rs.getString("jid"),
                        rs.getString("chart_no"),
                        rs.getString("chart_name"),
                        rs.getDouble("debit"),
                        rs.getDouble("credit"),
                        rs.getString("description"),};
                    model.addRow(data);

                };
            }

        } catch (SQLException ex) {
            System.out.println("Error:\n" + ex.getLocalizedMessage());

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

        jPanel20 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtChartName_Journal = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtChartNumber_Journal = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtDesc_Journal = new javax.swing.JTextArea();
        btnSearch_Journal = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        txtCredit_Journal = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtDebit_Journal = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtJID_Journal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblJournalViewer = new javax.swing.JTable();
        btnUpdate_Journal = new javax.swing.JButton();
        btnDelete_Journal = new javax.swing.JButton();
        cboSorter_JV = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        btnSearch_GL = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel20.setBackground(new java.awt.Color(32, 47, 78));
        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Orator Std", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Chart Number");
        jPanel20.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 150, 30));

        jLabel35.setFont(new java.awt.Font("Orator Std", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("DATE");
        jPanel20.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 30));
        jPanel20.add(txtChartName_Journal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 240, 30));

        jLabel39.setFont(new java.awt.Font("Orator Std", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Description");
        jPanel20.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        txtChartNumber_Journal.setFont(new java.awt.Font("Orator Std", 0, 18)); // NOI18N
        jPanel20.add(txtChartNumber_Journal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 170, 30));

        txtDesc_Journal.setColumns(20);
        txtDesc_Journal.setRows(5);
        jScrollPane9.setViewportView(txtDesc_Journal);

        jPanel20.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 326, 240, 120));

        btnSearch_Journal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/mini searching.png"))); // NOI18N
        btnSearch_Journal.setMaximumSize(new java.awt.Dimension(25, 12));
        btnSearch_Journal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch_JournalActionPerformed(evt);
            }
        });
        jPanel20.add(btnSearch_Journal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 50, 30));

        dateChooser.setDateFormatString("yyyy-MM-dd");
        jPanel20.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 240, 30));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        txtCredit_Journal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCredit_JournalKeyReleased(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Orator Std", 0, 18)); // NOI18N
        jLabel38.setText("CREDIT");

        jLabel37.setFont(new java.awt.Font("Orator Std", 0, 18)); // NOI18N
        jLabel37.setText("DEBIT");

        txtDebit_Journal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDebit_JournalKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDebit_Journal, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCredit_Journal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCredit_Journal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDebit_Journal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 460, 50));

        jLabel47.setFont(new java.awt.Font("Orator Std", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Chart Name");
        jPanel20.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 30));

        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel20.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, -1, -1));

        txtJID_Journal.setEditable(false);
        txtJID_Journal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtJID_Journal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJID_Journal.setText("JID");
        jPanel20.add(txtJID_Journal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 230, 40));

        tblJournalViewer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "JID", "Chart No", "Chart Name", "Debit", "Credit", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblJournalViewer);

        jPanel20.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 830, -1));

        btnUpdate_Journal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/AMA - UPDATE 1.png"))); // NOI18N
        btnUpdate_Journal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate_JournalActionPerformed(evt);
            }
        });
        jPanel20.add(btnUpdate_Journal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 220, 70));

        btnDelete_Journal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/delete-button.gif"))); // NOI18N
        btnDelete_Journal.setContentAreaFilled(false);
        btnDelete_Journal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete_JournalActionPerformed(evt);
            }
        });
        jPanel20.add(btnDelete_Journal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 530, 180, 70));

        cboSorter_JV.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        cboSorter_JV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Bank", "Acc. Receivable", "Inventory" }));
        cboSorter_JV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSorter_JVActionPerformed(evt);
            }
        });
        jPanel20.add(cboSorter_JV, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 200, 40));

        jLabel32.setFont(new java.awt.Font("Orator Std", 0, 36)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Sort by");
        jPanel20.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 170, 40));

        btnSearch_GL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/OK2.png"))); // NOI18N
        btnSearch_GL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch_GLActionPerformed(evt);
            }
        });
        jPanel20.add(btnSearch_GL, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 70, 40));

        lblError.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 51, 51));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setText("Error Text appears here.");
        jPanel20.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 230, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/arrow_refresh.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel20.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1335, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearch_JournalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch_JournalActionPerformed

        ChartSearch cs1 = new ChartSearch(this, true, conn, "JV");
        cs1.setVisible(true);
    }//GEN-LAST:event_btnSearch_JournalActionPerformed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked

    }//GEN-LAST:event_jLabel24MouseClicked

    private Double debit_journal;
    private Double credit_journal;
    private int datestatus = 0;


    private void btnUpdate_JournalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate_JournalActionPerformed
        try {
            if (tblJournalViewer.getSelectedRow() == -1) {
                Sutil.msg(this, "No data is selected.");
            } else {
                executeUpdate();
                removeTableData();
                loadJournal_Detail();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmJournalViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdate_JournalActionPerformed

    private void btnDelete_JournalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete_JournalActionPerformed
        executeDelete();
        removeTableData();
        try {
            loadJournal_Detail();
        } catch (SQLException ex) {
            Logger.getLogger(FrmJournalViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDelete_JournalActionPerformed

    private void cboSorter_JVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSorter_JVActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cboSorter_JVActionPerformed

    private void btnSearch_GLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch_GLActionPerformed
        removeTableData();
        try {
            loadJournal_Detail();
        } catch (SQLException ex) {
            Logger.getLogger(FrmJournalViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearch_GLActionPerformed

    private void txtDebit_JournalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDebit_JournalKeyReleased

        if ((txtDebit_Journal.getText().trim().matches(".*[a-zA-Z]+.*")) == true) {
            lblError.setVisible(true);
            lblError.setText("Please input with number only.");
            txtDebit_Journal.setForeground(red);
        } else {

            if ((!txtDebit_Journal.getText().isEmpty()) && Double.valueOf(txtDebit_Journal.getText().trim()) > 0) {

                txtCredit_Journal.setEnabled(false);
                lblError.setVisible(false);
                txtDebit_Journal.setForeground(black);

            } else {
                lblError.setVisible(false);
                txtCredit_Journal.setEnabled(true);
                txtDebit_Journal.setForeground(black);
            }
        }
    }//GEN-LAST:event_txtDebit_JournalKeyReleased

    private void txtCredit_JournalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCredit_JournalKeyReleased
        if ((txtCredit_Journal.getText().trim().matches(".*[a-zA-Z]+.*")) == true) {
            lblError.setVisible(true);
            lblError.setText("Please input with number only.");
            txtCredit_Journal.setForeground(red);
        } else {

            if ((!txtCredit_Journal.getText().isEmpty()) && Double.valueOf(txtCredit_Journal.getText().trim()) > 0) {
                txtDebit_Journal.setEnabled(false);

                lblError.setVisible(false);
                txtCredit_Journal.setForeground(black);

            } else {
                lblError.setVisible(false);
                txtDebit_Journal.setEnabled(true);
                txtCredit_Journal.setForeground(black);
            }
        }
    }//GEN-LAST:event_txtCredit_JournalKeyReleased

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        removeTableData();
        try {
            executeRefresh();
        } catch (SQLException ex) {
            Logger.getLogger(FrmJournalViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private Object getDateChooser() throws ParseException {
        String dateStr;
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        dateStr = f.format(dateChooser.getDate());

        return dateStr;
    }

    private void tableSelectionListener() {
        ListSelectionListener listener;
        listener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int row = tblJournalViewer.getSelectedRow();

                if (row >= 0) {

                    dateChooser.setDate((Date) tblJournalViewer.getValueAt(row, 0));
                    txtJID_Journal.setText(tblJournalViewer.getValueAt(row, 1).toString());
                    txtChartNumber_Journal.setText(tblJournalViewer.getValueAt(row, 2).toString());
                    txtChartName_Journal.setText(tblJournalViewer.getValueAt(row, 3).toString());
                    txtDebit_Journal.setText(String.valueOf(tblJournalViewer.getValueAt(row, 4)));
                    txtCredit_Journal.setText(String.valueOf(tblJournalViewer.getValueAt(row, 5)));
                    txtDesc_Journal.setText(String.valueOf(tblJournalViewer.getValueAt(row, 6)));
                }
            }
        };
        tblJournalViewer.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblJournalViewer.getSelectionModel().addListSelectionListener(listener);
    }

    private void executeDelete() {
        try {
            String updateSql = "DELETE FROM akuntansi.journal_detail WHERE jid = ? and chart_no=? and debit=? and credit=? and description=?";
            PreparedStatement pstatement = conn.prepareStatement(updateSql);
            pstatement.setString(1, txtJID_Journal.getText().trim());
            pstatement.setString(2, txtChartNumber_Journal.getText().trim());
            pstatement.setString(3, txtDebit_Journal.getText().trim());
            pstatement.setString(4, txtCredit_Journal.getText().trim());
            pstatement.setString(5, txtDesc_Journal.getText().trim());
            pstatement.executeUpdate();
            pstatement.close();
            executeNew();
            Sutil.msg(this, "Delete successful.");
        } catch (SQLException ex) {
            Logger.getLogger(FrmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void executeNew() {
        txtChartNumber_Journal.setText("");
        txtChartName_Journal.setText("");
        txtDebit_Journal.setText("");
        txtCredit_Journal.setText("");
        txtDesc_Journal.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete_Journal;
    private javax.swing.JButton btnSearch_GL;
    private javax.swing.JButton btnSearch_Journal;
    private javax.swing.JButton btnUpdate_Journal;
    private javax.swing.JComboBox<String> cboSorter_JV;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblError;
    private javax.swing.JTable tblJournalViewer;
    public static javax.swing.JTextField txtChartName_Journal;
    public static javax.swing.JTextField txtChartNumber_Journal;
    private javax.swing.JTextField txtCredit_Journal;
    private javax.swing.JTextField txtDebit_Journal;
    private javax.swing.JTextArea txtDesc_Journal;
    private javax.swing.JTextField txtJID_Journal;
    // End of variables declaration//GEN-END:variables

    private void executeUpdate() {
        try {
            int row = tblJournalViewer.getSelectedRow();
            String chart_no_temporary = String.valueOf(tblJournalViewer.getValueAt(row, 2));
            String debit_temporary = String.valueOf(tblJournalViewer.getValueAt(row, 4));
            String credit_temporary = String.valueOf(tblJournalViewer.getValueAt(row, 5));
            String updateSql = "UPDATE akuntansi.journal_detail SET "
                    + " tgl=?,chart_no=?,chart_name=?,debit=?,credit=?,description=? WHERE jid=? and chart_no=? and debit=? and credit=?";
            PreparedStatement pstatement = conn.prepareStatement(updateSql);
            pstatement.setObject(1, convertUtilDateToSql(dateChooser.getDate()));
            pstatement.setString(2, txtChartNumber_Journal.getText().trim());
            pstatement.setString(3, txtChartName_Journal.getText().trim());
            pstatement.setDouble(4, Double.valueOf(txtDebit_Journal.getText()));
            pstatement.setDouble(5, Double.valueOf(txtCredit_Journal.getText()));
            pstatement.setString(6, txtDesc_Journal.getText());
            pstatement.setString(7, txtJID_Journal.getText());
            pstatement.setString(8, chart_no_temporary);
            pstatement.setString(9, debit_temporary);
            pstatement.setString(10, credit_temporary);

            pstatement.executeUpdate();
            pstatement.close();
            executeNew();
            Sutil.msg(this, "Update successful.");
        } catch (SQLException ex) {
            Logger.getLogger(FrmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void executeRefresh() throws SQLException {
         executeNew();
        loadJournal_Detail();
        txtChartNumber_Journal.requestFocusInWindow();
    }
}
