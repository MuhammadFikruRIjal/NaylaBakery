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
import penjualan.model.produk;

/**
 *
 * @author L
 */
public class ProdukManajer {

    public static List<produk> showAllKue() {
        List<produk> kuelist = new ArrayList<>();

        try {
            Connection conn = ConnnectionHelper.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("SELECT * FROM produk");
            while (rs.next()) {
                produk kue = new produk();
                kue.setId_kue(Integer.parseInt(rs.getString("id_kue")));
                kue.setNama_kue(rs.getString("Nama_kue"));
                kue.setHarga_kue(Integer.parseInt(rs.getString("Harga_kue")));
                kue.setStock_kue(Integer.parseInt(rs.getString("Stock_kue")));

                kuelist.add(kue);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kuelist;
    }

}
