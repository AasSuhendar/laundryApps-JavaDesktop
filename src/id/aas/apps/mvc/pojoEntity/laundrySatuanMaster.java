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
public class laundrySatuanMaster {
    private int kd_pakaian;
    private String namaPakaian;
    private double harga;

    public laundrySatuanMaster() {
    }

    public laundrySatuanMaster(String namaPakaian, double harga) {
        this.namaPakaian = namaPakaian;
        this.harga = harga;
    }

    public laundrySatuanMaster(int kd_pakaian, String namaPakaian, double harga) {
        this.kd_pakaian = kd_pakaian;
        this.namaPakaian = namaPakaian;
        this.harga = harga;
    }

    public int getKd_pakaian() {
        return kd_pakaian;
    }

    public void setKd_pakaian(int kd_pakaian) {
        this.kd_pakaian = kd_pakaian;
    }

    public String getNamaPakaian() {
        return namaPakaian;
    }

    public void setNamaPakaian(String namaPakaian) {
        this.namaPakaian = namaPakaian;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    
}
