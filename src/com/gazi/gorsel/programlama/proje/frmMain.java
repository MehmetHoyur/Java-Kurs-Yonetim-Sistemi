/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gazi.gorsel.programlama.proje;
import com.gazi.gorsel.programlama.proje.cnnct;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MEHMETHOYUR
 */
public class frmMain extends javax.swing.JFrame {
   frmOgrenci frmo=new frmOgrenci();
   frmogretmen frmp=new frmogretmen();
   frmYonetici frmy=new frmYonetici();
  
   
    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlgiris = new javax.swing.JPanel();
        btngiris = new javax.swing.JButton();
        btnforgot = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtkadi = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        btndark = new javax.swing.JToggleButton();
        lblad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout());

        pnlgiris.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlgiris.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlgiris.setFont(new java.awt.Font("Ebrima", 3, 14)); // NOI18N
        pnlgiris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btngiris.setText("Giriş");
        btngiris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngirisActionPerformed(evt);
            }
        });
        pnlgiris.add(btngiris, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 328, 124, 38));

        btnforgot.setText("Şifremi Unutum");
        pnlgiris.add(btnforgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 328, 131, 38));

        jLabel1.setText("Kullanıcı Adı");
        pnlgiris.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 206, -1, -1));

        jLabel2.setText("Şifre");
        pnlgiris.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 262, 58, -1));
        pnlgiris.add(txtkadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 212, 264, -1));
        pnlgiris.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 258, 264, -1));

        btndark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndarkActionPerformed(evt);
            }
        });
        pnlgiris.add(btndark, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 69, 19));

        lblad.setFont(new java.awt.Font("Segoe Print", 3, 18)); // NOI18N
        lblad.setText("Hoyur Müzik Kursu Giriş Paneli");
        pnlgiris.add(lblad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 360, 90));

        getContentPane().add(pnlgiris);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//tamamlandı
    private void btndarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndarkActionPerformed
        if (btndark.isSelected()) {
            pnlgiris.setBackground(Color.BLACK);
            jLabel1.setForeground(Color.WHITE);
            jLabel2.setForeground(Color.WHITE);
            btngiris.setBackground(Color.BLACK);
            btngiris.setForeground(Color.WHITE);
            btnforgot.setBackground(Color.BLACK);
            btnforgot.setForeground(Color.WHITE);
            txtkadi.setBackground(Color.BLACK);
            txtkadi.setForeground(Color.WHITE);
            txtpass.setBackground(Color.BLACK);
            txtpass.setForeground(Color.WHITE);
            lblad.setForeground(Color.WHITE);
            
            
        }
        else{
        pnlgiris.setBackground(Color.white);
        jLabel1.setForeground(Color.BLACK);
        jLabel2.setForeground(Color.BLACK);
        btngiris.setBackground(Color.WHITE);
        btngiris.setForeground(Color.BLACK);
        btnforgot.setBackground(Color.WHITE);
        btnforgot.setForeground(Color.BLACK);
        txtkadi.setBackground(Color.WHITE);
        txtkadi.setForeground(Color.black);
        txtpass.setBackground(Color.white);
        txtpass.setForeground(Color.black);
        lblad.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_btndarkActionPerformed

    private void btngirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngirisActionPerformed
        
        
        
        
       try {
           cnnct cn=new cnnct();
           String kadi;
           
           int pass;
           kadi=txtkadi.getText();
           pass=Integer.parseInt(txtpass.getText());
           String sorgu = "Select count(kullaniciadi) as giris from tblgirisler where kullaniciadi='"+kadi+"'and sifre="+pass;
           String sorgu2="Select statu from tblgirisler where kullaniciadi='"+kadi+"'and sifre="+pass;
           cn.baglan();
           ResultSet rs1=cn.girisyetkisi(sorgu2);
           ResultSet rs=cn.getir(sorgu);
           
           while(rs.next()) {
              
               if (rs.getInt("giris")==1) {
                   setVisible(false);
                   
               }
                   while (rs1.next()) {
                    String statu=rs1.getString("statu");
                  if (statu.equals("ogrenci")||statu.equals("Öğrenci")) {
                       frmo.setVisible(true);
                       frmp.setVisible(false);
                       frmy.setVisible(false);
                   }
                   if (statu.equals("personel")||statu.equals("Öğretmen")) {
                       frmp.setVisible(true);
                       frmo.setVisible(false);
                       frmy.setVisible(false);
                   }
                   
                   if (statu.equals("yonetici")||statu.equals("Admin")||statu.equals("Müdür")) {
                       frmy.setVisible(true);
                       frmo.setVisible(false);
                       frmp.setVisible(false);
                   }
                       
                   }
           }
       } catch (SQLException ex) {
           System.out.println("hata="+ex);      }
       
       
       
    }//GEN-LAST:event_btngirisActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btndark;
    private javax.swing.JButton btnforgot;
    private javax.swing.JButton btngiris;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblad;
    private javax.swing.JPanel pnlgiris;
    private static javax.swing.JTextField txtkadi;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
