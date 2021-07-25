/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan.model;

/**
 *
 * @author L
 */
public class produk {
    private int id_kue;
    private String Nama_kue;
    private int Harga_kue;
    private int Stock_kue;

    public int getId_kue() {
        return id_kue;
    }

    public void setId_kue(int id_kue) {
        this.id_kue = id_kue;
    }

    public String getNama_kue() {
        return Nama_kue;
    }

    public void setNama_kue(String Nama_kue) {
        this.Nama_kue = Nama_kue;
    }

    public int getHarga_kue() {
        return Harga_kue;
    }

    public void setHarga_kue(int Harga_kue) {
        this.Harga_kue = Harga_kue;
    }

    public int getStock_kue() {
        return Stock_kue;
    }

    public void setStock_kue(int Stock_kue) {
        this.Stock_kue = Stock_kue;
    }
   
    
}
