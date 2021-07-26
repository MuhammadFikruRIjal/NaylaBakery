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
public class pemesanan {

    private int id_pemesanan;
    private int id_konsumen;
    private int id_kue;
    private String Nama_konsumen;
    private int Total_harga;
    private String Tanggal_pemesanan;

    public int getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(int id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public int getId_konsumen() {
        return id_konsumen;
    }

    public void setId_konsumen(int id_konsumen) {
        this.id_konsumen = id_konsumen;
    }

    public int getId_kue() {
        return id_kue;
    }

    public void setId_kue(int id_kue) {
        this.id_kue = id_kue;
    }

    public String getNama_konsumen() {
        return Nama_konsumen;
    }

    public void setNama_konsumen(String Nama_konsumen) {
        this.Nama_konsumen = Nama_konsumen;
    }

    public int getTotal_harga() {
        return Total_harga;
    }

    public void setTotal_harga(int Total_harga) {
        this.Total_harga = Total_harga;
    }

    public String getTanggal_pemesanan() {
        return Tanggal_pemesanan;
    }

    public void setTanggal_pemesanan(String Tanggal_pemesanan) {
        this.Tanggal_pemesanan = Tanggal_pemesanan;
    }

}
