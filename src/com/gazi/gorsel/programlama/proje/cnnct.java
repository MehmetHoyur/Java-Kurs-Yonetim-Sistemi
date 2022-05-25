/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gazi.gorsel.programlama.proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.gazi.gorsel.programlama.proje.frmYonetici.*;
import java.sql.PreparedStatement;

/**
 *
 * @author MEHMETHOYUR
 */
public class cnnct {
    static Connection cnn=null; 
    static Statement stm=null;
    public void baglan(){
        
     try {
            
             cnn = DriverManager.getConnection("jdbc:postgresql://localhost/kursyonetimdb", "postgres", "mehmet123");
           
        
         System.out.println("Bağlantı Başarılı");
         } catch (SQLException e) {
             System.out.println(e.getMessage());
             JOptionPane.showMessageDialog(new frmMain(), "Bağlantıda Sorun oluştu", "Hata",JOptionPane.ERROR_MESSAGE);
         }
}
    public void ekle(String sorgu){
        try {
            stm=cnn.createStatement();
            stm.executeUpdate(sorgu);
        } catch (SQLException ex) {
            System.out.println("hata="+ex);
        }
    
    }
    public void sil(String sorgu){
        try {
            stm=cnn.createStatement();
            stm.executeUpdate(sorgu);
        } catch (SQLException ex) {
            System.out.println("hata="+ex);
        }
    }
    public void guncelle(String sorgu){
        try {
            stm=cnn.createStatement();
            stm.executeUpdate(sorgu);
        } catch (SQLException ex) {
            System.out.println("hata="+ex);
        }
    
   }
    public ResultSet getir(String sorgu){
            ResultSet rs=null;
        try {
            stm=cnn.createStatement();
            rs=stm.executeQuery(sorgu);
        } catch (SQLException ex) {
            System.out.println("Ekleme Başarısız");
        }
        return rs;
    }

    public ResultSet girisyetkisi(String sorgu2){
            ResultSet rs2=null;
        try {
            stm=cnn.createStatement();
            rs2=stm.executeQuery(sorgu2);
        } catch (SQLException ex) {
            System.out.println("Ekleme Başarısız");
        }
        return rs2;
    }
    public  ResultSet  kurslar (String sorgu){ 
        
       ResultSet rs=null;
            
            try {
                
               
                stm=cnn.createStatement();
                rs=stm.executeQuery(sorgu);
            } catch (SQLException ex) {
                Logger.getLogger(cnnct.class.getName()).log(Level.SEVERE, null, ex);
            }

        return rs;
        
    }
}
