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
public class admin {
    private int id_pegawai;
    private String username;
    private String password;

    public admin(int id_pegawai, String username, String password) {
        this.id_pegawai = id_pegawai;
        this.username = username;
        this.password = password;
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(int id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
