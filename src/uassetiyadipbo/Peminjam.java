/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uassetiyadipbo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class Peminjam {
    private String kode;
    private String nama;
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    private boolean getSuccess;
    
    public void tambah()
    {
        this.getSuccess = false;
        
        Connection conn = Konektor.init();
        
        String sql = "INSERT INTO peminjam (kode,nama) VALUES ('"+this.kode+"', '"+this.nama+"')";

        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
            
            this.getSuccess = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void hapus()
    {
        this.getSuccess = false;
        
        Connection conn = Konektor.init();
        
        String sql = "DELETE FROM peminjam WHERE kode = '"+this.kode+"'";

        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
            
            this.getSuccess = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ubah()
    {
        this.getSuccess = false;
        
        Connection conn = Konektor.init();
        
        String sql = "UPDATE peminjam SET kode = '"+this.kode+"', nama = '"+this.nama+"' WHERE kode = '"+this.kode+"'";

        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
            
            this.getSuccess = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Peminjam> getAll()
    {
        List<Peminjam> peminjams = new ArrayList<Peminjam> ();
        
        this.getSuccess = false;
        
        Connection conn = Konektor.init();
        
        String sql = "SELECT * FROM peminjam";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Peminjam tempPeminjam = new Peminjam();
                
                tempPeminjam.setKode(rs.getString("kode"));
                tempPeminjam.setNama(rs.getString("nama"));
                
                peminjams.add(tempPeminjam);
            }
            
            this.getSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return peminjams;
    }
    
    public void get()
    {
        this.getSuccess = false;
        
        Connection conn = Konektor.init();
        
        String sql = "SELECT * FROM peminjam WHERE kode = '" + this.kode + "'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                this.setKode(rs.getString("kode"));
                this.setNama(rs.getString("nama"));
                
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
    
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
}
