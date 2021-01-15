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
import java.util.Date;
import java.util.List;

/**
 *
 * @author asus
 */
public class Peminjaman {
    private int id;
    private Buku buku;
    private Peminjam peminjam;
    private String tanggal;
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    private boolean getSuccess;
//    
//    public void tambah()
//    {
//        this.getSuccess = false;
//        
//        Connection conn = Konektor.init();
//        
//        String sql = "INSERT INTO peminjam (kode,nama) VALUES ('"+this.kode+"', '"+this.nama+"')";
//
//        try {
//            stmt = conn.createStatement();
//            stmt.execute(sql);
//            
//            this.getSuccess = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public void hapus()
//    {
//        this.getSuccess = false;
//        
//        Connection conn = Konektor.init();
//        
//        String sql = "DELETE FROM peminjam WHERE kode = '"+this.kode+"'";
//
//        try {
//            stmt = conn.createStatement();
//            stmt.execute(sql);
//            
//            this.getSuccess = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public void ubah()
//    {
//        this.getSuccess = false;
//        
//        Connection conn = Konektor.init();
//        
//        String sql = "UPDATE peminjam SET kode = '"+this.kode+"', nama = '"+this.nama+"' WHERE kode = '"+this.kode+"'";
//
//        try {
//            stmt = conn.createStatement();
//            stmt.execute(sql);
//            
//            this.getSuccess = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
    public List<Peminjaman> getAll()
    {
        List<Peminjaman> peminjamans = new ArrayList<Peminjaman> ();
        
        this.getSuccess = false;
        
        Connection conn = Konektor.init();
        
        String sql = "SELECT * FROM peminjaman";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Peminjaman tempPeminjaman = new Peminjaman();
                
                tempPeminjaman.setId(rs.getInt("id"));
                
                Buku buku = new Buku();
                buku.setKode(rs.getString("kode_buku"));
                buku.get();
                tempPeminjaman.setBuku(buku);

                Peminjam peminjam = new Peminjam();
                peminjam.setKode(rs.getString("kode_peminjam"));
                peminjam.get();
                tempPeminjaman.setPeminjam(peminjam);
                
                tempPeminjaman.setTanggal(rs.getString("tanggal"));
                
                peminjamans.add(tempPeminjaman);
            }
            
            this.getSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return peminjamans;
    }
    
    public void get()
    {
        this.getSuccess = false;
        
        Connection conn = Konektor.init();
        
        String sql = "SELECT * FROM peminjaman WHERE id = '" + this.id + "'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                this.setId(rs.getInt("id"));
                
                Buku buku = new Buku();
                buku.setKode(rs.getString("kode_buku"));
                buku.get();
                this.setBuku(buku);

                Peminjam peminjam = new Peminjam();
                peminjam.setKode(rs.getString("kode_peminjam"));
                peminjam.get();
                this.setPeminjam(peminjam);
                
                this.setTanggal(rs.getString("tanggal"));
                
                this.getSuccess = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTanggal() {
        return this.tanggal;
    }
    
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    public Buku getBuku() {
        return this.buku;
    }
    
    public void setBuku(Buku buku) {
        this.buku = buku;
    }
    
    public Peminjam getPeminjam() {
        return this.peminjam;
    }
    
    public void setPeminjam(Peminjam peminjam) {
        this.peminjam = peminjam;
    }
}
