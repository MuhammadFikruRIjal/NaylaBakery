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

/**
 *
 * @author L
 */
public class KonsumenManajer {

    public static List<konsumen> showAllKonsumen() {
        List<konsumen> konsumenlist = new ArrayList<>();

        try {
            Connection conn = ConnnectionHelper.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("SELECT * FROM konsumen");
            while (rs.next()) {
                konsumen ksn = new konsumen();
                ksn.setId_konsumen(Integer.parseInt(rs.getString("id_konsumen")));
                ksn.setNama_konsumen(rs.getString("Nama_konsumen"));
                ksn.setAlamat_konsumen(rs.getString("Alamat_konsumen"));
                ksn.setNo_telp(Integer.parseInt(rs.getString("No_telp")));
                ksn.setEmail_konsumen(rs.getString("Email_konsumen"));
                ksn.setPassword_konsumen(rs.getString("Password_konsumen"));

                konsumenlist.add(ksn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return konsumenlist;
    }

}
