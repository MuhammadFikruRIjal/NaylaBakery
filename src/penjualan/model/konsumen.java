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
public class konsumen {
    private int id_konsumen;
    private String Nama_konsumen;
    private String Alamat_konsumen;
    private int No_telp;
    private String Email_konsumen;
    private String Password_konsumen;

    public int getId_konsumen() {
        return id_konsumen;
    }

    public void setId_konsumen(int id_konsumen) {
        this.id_konsumen = id_konsumen;
    }

    public String getNama_konsumen() {
        return Nama_konsumen;
    }

    public void setNama_konsumen(String Nama_konsumen) {
        this.Nama_konsumen = Nama_konsumen;
    }

    public String getAlamat_konsumen() {
        return Alamat_konsumen;
    }

    public void setAlamat_konsumen(String Alamat_konsumen) {
        this.Alamat_konsumen = Alamat_konsumen;
    }

    public int getNo_telp() {
        return No_telp;
    }

    public void setNo_telp(int No_telp) {
        this.No_telp = No_telp;
    }

    public String getEmail_konsumen() {
        return Email_konsumen;
    }

    public void setEmail_konsumen(String Email_konsumen) {
        this.Email_konsumen = Email_konsumen;
    }

    public String getPassword_konsumen() {
        return Password_konsumen;
    }

    public void setPassword_konsumen(String Password_konsumen) {
        this.Password_konsumen = Password_konsumen;
    }
    
}

