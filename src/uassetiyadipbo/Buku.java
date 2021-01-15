/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uassetiyadipbo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author asus
 */
public class Buku {
    private String kode;
    private String judul;
    private String penulis;
    private String penerbit;
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    private boolean getSuccess;
    
    public void get(String kode)
    {
        this.getSuccess = false;
        
        Connection conn = Konektor.init();
        
        String sql = "SELECT * FROM buku WHERE kode = '" + kode + "'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                this.setKode(rs.getString("kode"));
                this.setJudul(rs.getString("judul"));
                this.setPenulis(rs.getString("Penulis"));
                this.setPenerbit(rs.getString("Penerbit"));
                
                this.getSuccess = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public String getKode() {
        return this.kode;
    }
    
    public void setKode(String kode) {
        this.kode = kode;
    }
    
    public String getJudul() {
        return this.judul;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return this.penulis;
    }
    
    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return this.penerbit;
    }
    
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
    
    public boolean getSuccess() {
        return this.getSuccess;
    }
}
