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
public class pembayaran {
    private int id_pembayaran;
    private int Total_bayar;
    private String Tanggal_pembayaran;

    public int getId_pembayaran() {
        return id_pembayaran;
    }

    public void setId_pembayaran(int id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public int getTotal_bayar() {
        return Total_bayar;
    }

    public void setTotal_bayar(int Total_bayar) {
        this.Total_bayar = Total_bayar;
    }

    public String getTanggal_pembayaran() {
        return Tanggal_pembayaran;
    }

    public void setTanggal_pembayaran(String Tanggal_pembayaran) {
        this.Tanggal_pembayaran = Tanggal_pembayaran;
    }
    
}
