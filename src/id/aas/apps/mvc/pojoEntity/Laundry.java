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
public class Laundry {
    private int kd_laundry;
    private String jenisLayanaan;
    private String jenisPewangi;
    private double jumBerat;
    private double jumPakaian;
    private String jenisPakaian;
    private double hargaSatuan;
    private double totalTagihan;
    private String keterangan;

    public Laundry() {
    }

    public Laundry(int kd_laundry, String keterangan) {
        this.kd_laundry = kd_laundry;
        this.keterangan = keterangan;
    }
    
    public Laundry(int kd_laundry, String jenisLayanaan, String jenisPewangi, double jumBerat, double jumPakaian, String jenisPakaian, double hargaSatuan, double totalTagihan, String keterangan) {
        this.kd_laundry = kd_laundry;
        this.jenisLayanaan = jenisLayanaan;
        this.jenisPewangi = jenisPewangi;
        this.jumBerat = jumBerat;
        this.jumPakaian = jumPakaian;
        this.jenisPakaian = jenisPakaian;
        this.hargaSatuan = hargaSatuan;
        this.totalTagihan = totalTagihan;
        this.keterangan = keterangan;
    }

    public Laundry(String jenisLayanaan, String jenisPewangi, double jumBerat, double jumPakaian, String jenisPakaian, double hargaSatuan, double totalTagihan, String keterangan) {
        this.jenisLayanaan = jenisLayanaan;
        this.jenisPewangi = jenisPewangi;
        this.jumBerat = jumBerat;
        this.jumPakaian = jumPakaian;
        this.jenisPakaian = jenisPakaian;
        this.hargaSatuan = hargaSatuan;
        this.totalTagihan = totalTagihan;
        this.keterangan = keterangan;
    }
    
    

    public int getKd_laundry() {
        return kd_laundry;
    }

    public void setKd_laundry(int kd_laundry) {
        this.kd_laundry = kd_laundry;
    }

    public String getJenisLayanaan() {
        return jenisLayanaan;
    }

    public void setJenisLayanaan(String jenisLayanaan) {
        this.jenisLayanaan = jenisLayanaan;
    }

    public String getJenisPewangi() {
        return jenisPewangi;
    }

    public void setJenisPewangi(String jenisPewangi) {
        this.jenisPewangi = jenisPewangi;
    }

    public double getJumBerat() {
        return jumBerat;
    }

    public void setJumBerat(double jumBerat) {
        this.jumBerat = jumBerat;
    }

    public double getJumPakaian() {
        return jumPakaian;
    }

    public void setJumPakaian(double jumPakaian) {
        this.jumPakaian = jumPakaian;
    }

    public String getJenisPakaian() {
        return jenisPakaian;
    }

    public void setJenisPakaian(String jenisPakaian) {
        this.jenisPakaian = jenisPakaian;
    }

    public double getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(double hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public double getTotalTagihan() {
        return totalTagihan;
    }

    public void setTotalTagihan(double totalTagihan) {
        this.totalTagihan = totalTagihan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    
    
    
    
}
