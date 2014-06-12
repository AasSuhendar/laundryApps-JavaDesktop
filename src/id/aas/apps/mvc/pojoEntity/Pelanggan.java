/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.aas.apps.mvc.pojoEntity;

/**
 *
 * @author Aas Suhendar
 */
public class Pelanggan {

    private int kd_pelanggan;
    private String nama;
    private String alamat;
    private String tlp;

    public Pelanggan() {
    }

    public Pelanggan(String nama, String alamat, String tlp) {
        this.nama = nama;
        this.alamat = alamat;
        this.tlp = tlp;
    }

    public Pelanggan(int kd_pelanggan, String nama, String alamat, String tlp) {
        this.kd_pelanggan = kd_pelanggan;
        this.nama = nama;
        this.alamat = alamat;
        this.tlp = tlp;
    }
        
    public int getKd_pelanggan() {
        return kd_pelanggan;
    }

    public void setKd_pelanggan(int kd_pelanggan) {
        this.kd_pelanggan = kd_pelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTlp() {
        return tlp;
    }

    public void setTlp(String tlp) {
        this.tlp = tlp;
    }
    
    
}
