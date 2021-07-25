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
import penjualan.model.pembayaran;
import penjualan.model.produk;

/**
 *
 * @author L
 */
public class PembayaranManajer {

    public static List<pembayaran> showAllPembayaran() {
        List<pembayaran> pembayaranlist = new ArrayList<>();

        try {
            Connection conn = ConnnectionHelper.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("SELECT * FROM produk");
            while (rs.next()) {
                pembayaran pmb = new pembayaran();
                pmb.setId_pembayaran(Integer.parseInt(rs.getString("id_pembayaran")));
                pmb.setTotal_bayar(Integer.parseInt(rs.getString("Total_bayar")));
                pmb.setTanggal_pembayaran(rs.getString("Tanggal_pembayaran"));

                pembayaranlist.add(pmb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pembayaranlist;
    }
}
