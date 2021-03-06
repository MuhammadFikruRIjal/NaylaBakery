/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.UI;

//import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import penjualan.manager.ProdukManajer;
import penjualan.manager.KonsumenManajer;
import penjualan.model.konsumen;
import penjualan.model.produk;
import helper.ConnnectionHelper;
import java.sql.*;
import java.sql.Statement;
import penjualan.model.konsumen;

/**
 *
 * @author L
 */
public class laporanApp extends javax.swing.JFrame {

    private DefaultTableModel model;

    /**
     * Creates new form laporanApp
     */
    public laporanApp() {
        initComponents();
        initTableProduk();
        loadKue();

        model = new DefaultTableModel();
        konsumenTabel.setModel(model);
        model.addColumn("ID");
        model.addColumn("Nama Konsumen");
        model.addColumn("Alamat");
        model.addColumn("No Telp");
        model.addColumn("Email");
        model.addColumn("Password");

        getData();
    }

    public void getData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            String query = "SELECT * FROM konsumen";
            java.sql.Connection conn = ConnnectionHelper.getConnection();
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                Object[] obj = new Object[6];
                obj[0] = rs.getString("id_konsumen");
                obj[1] = rs.getString("Nama_konsumen");
                obj[2] = rs.getString("Alamat_konsumen");
                obj[3] = rs.getString("No_telp");
                obj[4] = rs.getString("Email_konsumen");
                obj[5] = rs.getString("Password_konsumen");

                model.addRow(obj);
            }

        } catch (Exception e) {

        }
    }
    public static DefaultTableModel tableModel;
    public static List<produk> KueList;

    private void initTableProduk() {
        String[] bookColumns = new String[]{"ID", "Nama Kue", "Harga Kue", "Stock Kue"};
        //total lebar 650
        int[] columnWidth = {
            70, 190, 210, 90
        };

        tableModel = new DefaultTableModel(bookColumns, 0);
        produkTabel.setModel(tableModel);
        produkTabel.setRowHeight(20);

        int i = 0;
        for (int width : columnWidth) {
            TableColumn column = produkTabel.getColumnModel().getColumn(i++);
            column.setMaxWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
        }
    }

    public static void loadKue() {
        KueList = new ArrayList<>();
        KueList = ProdukManajer.showAllKue();
        tableModel.setRowCount(0);
        KueList.forEach(produk -> {
            tableModel.addRow(new Object[]{
                produk.getId_kue(),
                produk.getNama_kue(),
                produk.getHarga_kue(),
                produk.getStock_kue(),});
        });
    }

    public void showMessage(String message, int type) {
        if (type == 1) {
            JOptionPane.showMessageDialog(this, message, "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
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

        bodyPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        btnDataKue = new javax.swing.JButton();
        btnDataKonsumen = new javax.swing.JButton();
        btnDataTransaksi = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        kuePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        produkTabel = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKue = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        konsumenPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        konsumenTabel = new javax.swing.JTable();
        transaksiPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bodyPanel.setBackground(new java.awt.Color(255, 204, 204));

        menuPanel.setBackground(new java.awt.Color(255, 204, 204));
        menuPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        btnDataKue.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnDataKue.setText("Data Kue");
        btnDataKue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataKueActionPerformed(evt);
            }
        });

        btnDataKonsumen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnDataKonsumen.setText("Data Konsumen");
        btnDataKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataKonsumenActionPerformed(evt);
            }
        });

        btnDataTransaksi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnDataTransaksi.setText("Data Transaksi");
        btnDataTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataTransaksiActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\Mata Kuliah\\Sem 2\\5. Pemrograman berbasis dekstop\\Logo\\logo (1)\\logo\\logo.jpg")); // NOI18N

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDataKue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDataKonsumen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(btnDataTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addComponent(btnDataKue, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDataKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDataTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(255, 204, 204));
        mainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        mainPanel.setLayout(new java.awt.CardLayout());

        kuePanel.setBackground(new java.awt.Color(255, 204, 204));

        produkTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(produkTabel);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Nama Kue");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Harga Kue");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Stock Kue");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon("E:\\Mata Kuliah\\Sem 2\\5. Pemrograman berbasis dekstop\\Logo\\Menu\\logo\\logo.jpg")); // NOI18N

        javax.swing.GroupLayout kuePanelLayout = new javax.swing.GroupLayout(kuePanel);
        kuePanel.setLayout(kuePanelLayout);
        kuePanelLayout.setHorizontalGroup(
            kuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kuePanelLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(kuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kuePanelLayout.createSequentialGroup()
                        .addGroup(kuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnTambah)
                                .addGroup(kuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(kuePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtHarga))
                                    .addGroup(kuePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtKue))
                                    .addGroup(kuePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kuePanelLayout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kuePanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(128, 128, 128))))
        );
        kuePanelLayout.setVerticalGroup(
            kuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kuePanelLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTambah)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(kuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnRefresh))
                .addGap(36, 36, 36))
        );

        mainPanel.add(kuePanel, "card2");

        konsumenPanel.setBackground(new java.awt.Color(255, 204, 204));

        konsumenTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(konsumenTabel);

        javax.swing.GroupLayout konsumenPanelLayout = new javax.swing.GroupLayout(konsumenPanel);
        konsumenPanel.setLayout(konsumenPanelLayout);
        konsumenPanelLayout.setHorizontalGroup(
            konsumenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(konsumenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );
        konsumenPanelLayout.setVerticalGroup(
            konsumenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, konsumenPanelLayout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        mainPanel.add(konsumenPanel, "card3");

        transaksiPanel.setBackground(new java.awt.Color(255, 204, 204));

        jLabel7.setIcon(new javax.swing.ImageIcon("E:\\Mata Kuliah\\Sem 2\\5. Pemrograman berbasis dekstop\\Logo\\Payment\\logo\\logo.jpg")); // NOI18N

        javax.swing.GroupLayout transaksiPanelLayout = new javax.swing.GroupLayout(transaksiPanel);
        transaksiPanel.setLayout(transaksiPanelLayout);
        transaksiPanelLayout.setHorizontalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiPanelLayout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        transaksiPanelLayout.setVerticalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        mainPanel.add(transaksiPanel, "card4");

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDataKueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataKueActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        // add panel selanjutnya
        mainPanel.add(kuePanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnDataKueActionPerformed

    private void btnDataKonsumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataKonsumenActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        // add panel selanjutnya
        mainPanel.add(konsumenPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnDataKonsumenActionPerformed

    private void btnDataTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataTransaksiActionPerformed
        // TODO add your handling code here:
        TransaksiForm du = new TransaksiForm();
        du.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDataTransaksiActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = produkTabel.getSelectedRow();
        if (selectedRow == -1) {
            showMessage("Pilih Baris", 2);
        } else {
            int option = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus baris ini?", "Hapus Data",
                    JOptionPane.WARNING_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    java.sql.Connection conn = ConnnectionHelper.getConnection();
                    Statement stmn = conn.createStatement();
                    produk kue = KueList.get(selectedRow);
                    stmn.executeUpdate("DELETE FROM produk WHERE id_kue = " + kue.getId_kue());
                    loadKue();
                } catch (Exception e) {
                    System.out.println("Error:" + e.getMessage());
                }
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        loadKue();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        try {
            java.sql.Connection conn = ConnnectionHelper.getConnection();
            Statement stmn = conn.createStatement();

            String query = "INSERT INTO produk (`Nama_kue`, `Harga_kue`, `Stock_kue`) "
                    + "VALUES ('" + txtKue.getText() + "', '" + txtHarga.getText() + "', "
                    + "'" + txtStock.getText() + "')";

            stmn.executeUpdate(query);
            

            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            txtHarga.setText("");
            txtKue.setText("");
            txtStock.setText("");
            

        } catch (Exception e) {
            if (txtKue.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Kue Tidak Boleh Kosong");
        } else if (txtHarga.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Harga Tidak Boleh Kosong");
        } else if (txtStock.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Stock Tidak Boleh Kosong");
        }
            System.out.println("Error" + e.getMessage());
        }
    
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int dialogBtn = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Apakah Anda Yakin?", "PERINGATAN", dialogBtn);

        if (dialogResult == 0) {
            // pasang true kondisi
            System.exit(0);
        } else {
            // false kondisi
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(laporanApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporanApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporanApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporanApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporanApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton btnDataKonsumen;
    private javax.swing.JButton btnDataKue;
    private javax.swing.JButton btnDataTransaksi;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel konsumenPanel;
    private javax.swing.JTable konsumenTabel;
    private javax.swing.JPanel kuePanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JTable produkTabel;
    private javax.swing.JPanel transaksiPanel;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtKue;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
