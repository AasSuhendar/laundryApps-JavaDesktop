/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.aas.apps.mvc.pojoEntity;

import java.sql.Date;

/**
 *
 * @author Aas Suhendar
 */
public class Transaksi {
    private int kd_transaksi;
    private int kd_pelanggan;
    private int kd_laundry;
    private Date tgl_terima;
    private Date tgl_selesai;
    private double totalTagihan;
    private String keterangan;

    public Transaksi() {
    }

    public Transaksi(int kd_transaksi, String keterangan) {
        this.kd_transaksi = kd_transaksi;
        this.keterangan = keterangan;
    }
    
    public Transaksi(int kd_transaksi, int kd_pelanggan, int kd_laundry, Date tgl_terima, Date tgl_selesai, double totalTagihan, String keterangan) {
        this.kd_transaksi = kd_transaksi;
        this.kd_pelanggan = kd_pelanggan;
        this.kd_laundry = kd_laundry;
        this.tgl_terima = tgl_terima;
        this.tgl_selesai = tgl_selesai;
        this.totalTagihan = totalTagihan;
        this.keterangan = keterangan;
    }

    public Transaksi(int kd_pelanggan, int kd_laundry, Date tgl_terima, Date tgl_selesai, double totalTagihan, String keterangan) {
        this.kd_pelanggan = kd_pelanggan;
        this.kd_laundry = kd_laundry;
        this.tgl_terima = tgl_terima;
        this.tgl_selesai = tgl_selesai;
        this.totalTagihan = totalTagihan;
        this.keterangan = keterangan;
    }

    
    
    public int getKd_transaksi() {
        return kd_transaksi;
    }

    public void setKd_transaksi(int kd_transaksi) {
        this.kd_transaksi = kd_transaksi;
    }

    public int getKd_pelanggan() {
        return kd_pelanggan;
    }

    public void setKd_pelanggan(int kd_pelanggan) {
        this.kd_pelanggan = kd_pelanggan;
    }

    public int getKd_laundry() {
        return kd_laundry;
    }

    public void setKd_laundry(int kd_laundry) {
        this.kd_laundry = kd_laundry;
    }

    public Date getTgl_terima() {
        return tgl_terima;
    }

    public void setTgl_terima(Date tgl_terima) {
        this.tgl_terima = tgl_terima;
    }

    public Date getTgl_selesai() {
        return tgl_selesai;
    }

    public void setTgl_selesai(Date tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
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
