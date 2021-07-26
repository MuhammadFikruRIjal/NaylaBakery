/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.manager;

import helper.CheckConnection;
import helper.ConnnectionHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import penjualan.model.konsumen;
import penjualan.model.pemesanan;

/**
 *
 * @author L
 */
public class PemesananManajer {

    public static List<pemesanan> showAllPemesanan() {
        List<pemesanan> pemesananlist = new ArrayList<>();

        try {
            Connection conn = ConnnectionHelper.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("SELECT * FROM pemesanan");
            while (rs.next()) {
                pemesanan pmsn = new pemesanan();
                pmsn.setId_pemesanan(Integer.parseInt(rs.getString("id_pemesanan")));
                pmsn.setId_kue(Integer.parseInt(rs.getString("id_kue")));
                pmsn.setNama_konsumen(rs.getString("Nama_konsumen"));
                pmsn.setTotal_harga(Integer.parseInt(rs.getString("Total_harga")));
                pmsn.setTanggal_pemesanan(rs.getString("Tanggal_pemesanan"));
                pmsn.setId_konsumen(Integer.parseInt(rs.getString("id_konsumen")));

                pemesananlist.add(pmsn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pemesananlist;
    }
}
