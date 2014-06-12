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
public class laundryKiloanMaster {
    private String kd_kiloan;
    private double hargaPerKilo;
    private String status;

    public laundryKiloanMaster() {
    }

    public laundryKiloanMaster(String kd_kiloan, double hargaPerKilo, String status) {
        this.kd_kiloan = kd_kiloan;
        this.hargaPerKilo = hargaPerKilo;
        this.status = status;
    }

    public String getKd_kiloan() {
        return kd_kiloan;
    }

    public void setKd_kiloan(String kd_kiloan) {
        this.kd_kiloan = kd_kiloan;
    }

    public double getHargaPerKilo() {
        return hargaPerKilo;
    }

    public void setHargaPerKilo(double hargaPerKilo) {
        this.hargaPerKilo = hargaPerKilo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
