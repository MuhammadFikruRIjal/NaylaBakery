/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author L
 */
public class CheckConnection {

    public static void main(String[] args) {
        isConnected();
        showKue();

    }

    private static boolean isConnected() {
        try {
            ConnnectionHelper.getConnection();
            System.out.println("Database Connected");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed toconnect database");
            return false;

        }
    }

    public static void showKue() {
        try {
            Connection conn = ConnnectionHelper.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("SELECT * FROM produk");

            while (rs.next()) {
                System.out.println("\nID kue    : " + rs.getString("id_kue"));
                System.out.println("Nama kue    : " + rs.getString("Nama_kue"));
                System.out.println("Harga Kue   : " + rs.getString("Harga_kue"));
                System.out.println("Stock kue   : " + rs.getString("Stock_kue"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
