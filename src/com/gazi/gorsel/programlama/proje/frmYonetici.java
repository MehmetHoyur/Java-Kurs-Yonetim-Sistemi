/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gazi.gorsel.programlama.proje;
import com.gazi.gorsel.programlama.proje.cnnct;
import static java.lang.Math.random;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author MEHMETHOYUR
 */
public class frmYonetici extends javax.swing.JFrame {
  
    /**
     * Creates new form frmYonetici
     */
    public frmYonetici() {
        initComponents();
         tabloyagetir();
         pertablogetir();
         sifreler();
    }
public void tabloyagetir(){
    DefaultTableModel model=(DefaultTableModel) tblogr.getModel();
    DefaultTableModel model2=(DefaultTableModel) tblper.getModel();
    cnnct cn=new cnnct();
    cn.baglan();
    String sorgu="Select * from tblogrenci";
            ResultSet rs=cn.getir(sorgu);
        try {
            
            
            while (rs.next()) {
                String ograd=rs.getString("ad");
                String ogrsoyad=rs.getString("soyad");
                int ucret=rs.getInt("ucret");
                String kurs=rs.getString("kurs");
                String telno=rs.getString("telno");
                String ogrno=rs.getString("ogrencino");
                Object[] liste={ograd,ogrsoyad,ogrno,telno,kurs,ucret};
                model.addRow(liste);
            }   } catch (SQLException ex) {
            System.out.println("hata="+ex);
        }
}


public void pertablogetir(){
 DefaultTableModel model2=(DefaultTableModel) tblper.getModel();
 cnnct cn=new cnnct();
 cn.baglan();
 String sorgu="Select *from tblcalisan";
 ResultSet rs=cn.getir(sorgu);
        try {
            while(rs.next()){
                String perad=rs.getString("ad");
                String persoyad=rs.getString("soyad");
                String verdigikurs=rs.getString("verdigikurs");
                String statu=rs.getString("statu");
                String telno=rs.getString("cepno");
                String maas=rs.getString("maas");
                Object[] liste={perad,persoyad,verdigikurs,statu,telno,maas};
                model2.addRow(liste);
            }      } catch (SQLException ex) {
            Logger.getLogger(frmYonetici.class.getName()).log(Level.SEVERE, null, ex);
        }
}


public void temizle(){
txtograd.setText("");
txtogrsoyad.setText("");
txtogrtel.setText("");
txtogrucret.setText("");
txtogrno.setText("");
ogrkurs.setSelectedItem("");


}

public void temizleper(){
perad.setText("");
persoyad.setText("");
percmb.setSelectedItem("");
permaas.setText("");
percep.setText("");
perstatu.setSelectedItem("");
}


public void ackapa(){
String abc=percmb.getSelectedItem().toString();
           
            if (abc.equals("Öğetmen")) {
            percmb.enable(true);
        }
            else{
             percmb.enable(false);
             System.out.println(abc);
            }
}

public void giris_olusturogr(){
cnnct cn=new cnnct();
Random rnd=new  Random();
        int sifre=rnd.nextInt(9000-1000)+9000;
String sorgu="Insert into tblgirisler(kullaniciadi,sifre,statu) Values('"+txtograd.getText()+txtogrsoyad.getText()+"','"+sifre+"','Öğrenci')";
    JOptionPane.showMessageDialog(rootPane, "Kullanıcı Adı="+txtograd.getText()+txtogrsoyad.getText()+"  Şifre="+sifre);

cn.ekle(sorgu);

}


public void giris_olusturper(){
cnnct cn=new cnnct();
Random rnd=new Random();
int sifre=rnd.nextInt(9000-1000)+9000;
String sorgu="Insert into tblgirisler(kullaniciadi,sifre,statu)Vales( '"+perad.getText()+persoyad.getText()+"','"+sifre+"','"+perstatu.getSelectedItem().toString()+"')";
JOptionPane.showMessageDialog(rootPane, "Kullanıcı Adı="+perad.getText()+persoyad.getText()+"  Şifre="+sifre);
        cn.ekle(sorgu);

}

void sifreler(){
    cnnct cn=new cnnct();
    DefaultTableModel model=(DefaultTableModel) tblogrsifre.getModel();
    DefaultTableModel model2=(DefaultTableModel) tblpergiris.getModel();
    String sorgu="select*from tblgirisler";
 
    
    ResultSet rs=cn.getir(sorgu);

   
        try {
            while (rs.next()) {
                String statu1=rs.getString("statu");
                if (statu1.equals("Öğrenci")||statu1.equals("ogrenci")) {
                    String kadi=rs.getString("kullaniciadi");
                String sifre=rs.getString("sifre");
                Object [] liste1={kadi,sifre};
                model.addRow(liste1);
                }
                else{
                    String kadi2=rs.getString("kullaniciadi");
                String sifre2=rs.getString("sifre");
                String statu=rs.getString("statu");
                Object[]liste2={kadi2,sifre2,statu};
                model2.addRow(liste2);
                }
                
                
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(frmYonetici.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        persoyad = new javax.swing.JTextField();
        perad = new javax.swing.JTextField();
        percep = new javax.swing.JTextField();
        permaas = new javax.swing.JTextField();
        percmb = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblper = new javax.swing.JTable();
        btnperekle = new javax.swing.JButton();
        btnpersil = new javax.swing.JButton();
        btnperupd = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        perstatu = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtograd = new javax.swing.JTextField();
        txtogrsoyad = new javax.swing.JTextField();
        txtogrno = new javax.swing.JTextField();
        txtogrtel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ogrkurs = new javax.swing.JComboBox<>();
        btnekleogr = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblogr = new javax.swing.JTable();
        bntsilogr = new javax.swing.JButton();
        bntguncelleogr = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtogrucret = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblpergiris = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblogrsifre = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel7.setText("Personel Ad");

        jLabel8.setText("Personel Soyad");

        jLabel10.setText("Personel Cep");

        jLabel11.setText("Maaş");

        jLabel12.setText("Verdiği Hizmet");

        percmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        tblper.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AD", "SOYAD", "HİZMET", "STATÜ", "CEPTEL", "MAAŞ"
            }
        ));
        tblper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblperMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblper);

        btnperekle.setText("Personel Ekle");
        btnperekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnperekleActionPerformed(evt);
            }
        });

        btnpersil.setText("Personel Sil");
        btnpersil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpersilActionPerformed(evt);
            }
        });

        btnperupd.setText("Personel Güncelle");
        btnperupd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnperupdActionPerformed(evt);
            }
        });

        jLabel13.setText("Statü");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(persoyad)
                            .addComponent(perad))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(permaas)
                                    .addComponent(percmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnperekle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnpersil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnperupd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(perstatu, 0, 165, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(38, 38, 38)
                                .addComponent(percep)))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(perad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(persoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(percep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(permaas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(percmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(perstatu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnperekle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnpersil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnperupd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Personel Ekle", jPanel2);

        jLabel2.setText("Ogrenci Adi");

        jLabel3.setText("Ogrenci Soyadi");

        jLabel4.setText("Öğrenci Numarası");

        jLabel5.setText("Telefon Numarası");

        jLabel1.setText("Aldığı Kurs");

        ogrkurs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        btnekleogr.setText("Ekle");
        btnekleogr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnekleogrActionPerformed(evt);
            }
        });

        tblogr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ad", "Soyad", "Numara", "Tel No", "Aldıığı Kurs", "Ücret"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblogr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblogrMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblogr);

        bntsilogr.setText("Sil");
        bntsilogr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntsilogrActionPerformed(evt);
            }
        });

        bntguncelleogr.setText("Güncelle");
        bntguncelleogr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntguncelleogrActionPerformed(evt);
            }
        });

        jLabel6.setText("Ücret");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtogrno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtograd, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtogrsoyad)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnekleogr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtogrtel)
                            .addComponent(ogrkurs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntsilogr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntguncelleogr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtogrucret))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtograd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtogrsoyad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtogrno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtogrtel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(txtogrucret, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ogrkurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(39, 39, 39)
                .addComponent(btnekleogr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntsilogr)
                .addGap(18, 18, 18)
                .addComponent(bntguncelleogr)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Öğrenci EKle", jPanel1);

        tblpergiris.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kullanıcı Adı", "Şifre", "Statü"
            }
        ));
        jScrollPane3.setViewportView(tblpergiris);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Personeller", jPanel4);

        tblogrsifre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kullanıcı Adı", "Şifre"
            }
        ));
        jScrollPane4.setViewportView(tblogrsifre);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Öğrenciler", jPanel5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Girişler", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 //tamamlandı
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
                                      
            try {
                // TODO add your handling code here:
                cnnct cn=new cnnct();
                cn.baglan();
                String sorgu="select kursadi from tblkurslar";
                ResultSet rs=cn.kurslar(sorgu);
                while (rs.next()) {
                    
                    ogrkurs.addItem(rs.getString("kursadi"));
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmYonetici.class.getName()).log(Level.SEVERE, null, ex);
            } 
            try {   
            cnnct cn=new cnnct();
            cn.baglan();
            String sorgu="select * from statuler";
            ResultSet rs=cn.kurslar(sorgu);
            while(rs.next()){
                perstatu.addItem(rs.getString("statu"));
                percmb.addItem(rs.getString("hizmet"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frmYonetici.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       
    }//GEN-LAST:event_formWindowOpened

    private void btnekleogrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnekleogrActionPerformed
         DefaultTableModel model=(DefaultTableModel) tblogr.getModel();
         String sorgu="INSERT INTO tblogrenci( ad, soyad, ucret, kurs, telno,ogrencino)VALUES ('"+txtograd.getText()+"','"+txtogrsoyad.getText()+"','"+Integer.parseInt(txtogrucret.getText())+"','"+ogrkurs.getSelectedItem().toString()+"','"+txtogrtel.getText()+"','"+txtogrno.getText()+"')";
         cnnct cn=new cnnct();
         cn.ekle(sorgu);
         cn.baglan();
         model.getDataVector().removeAllElements();
        tabloyagetir();
        giris_olusturogr();
        
       
         
    }//GEN-LAST:event_btnekleogrActionPerformed

    private void bntsilogrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntsilogrActionPerformed
     DefaultTableModel model=(DefaultTableModel) tblogr.getModel();
         String sorgu="DELETE FROM tblogrenci where telno='"+txtogrtel.getText()+"'";
         cnnct cn=new cnnct();
         cn.sil(sorgu);
         cn.baglan();
         model.getDataVector().removeAllElements();
        tabloyagetir();
        temizle();
        
    }//GEN-LAST:event_bntsilogrActionPerformed

    private void tblogrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblogrMouseClicked
         DefaultTableModel table=(DefaultTableModel) tblogr.getModel();
      int row=tblogr.getSelectedRow();
     
      txtograd.setText(table.getValueAt(row, 0).toString());//Object olarak alındığı için stringe cast et
      txtogrsoyad.setText(table.getValueAt(row, 1).toString());
      ogrkurs.setSelectedItem(table.getValueAt(row, 4).toString());
      txtogrucret.setText(table.getValueAt(row,5).toString());
      txtogrno.setText(table.getValueAt(row, 2).toString());
      txtogrtel.setText(table.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tblogrMouseClicked

    private void bntguncelleogrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntguncelleogrActionPerformed
        DefaultTableModel model=(DefaultTableModel) tblogr.getModel();
        String sorgu="UPDATE public.tblogrenci SET ad='"+txtograd.getText()+"', soyad='"+txtogrsoyad.getText()+"', ucret='"+txtogrucret.getText()+"', kurs='"+ogrkurs.getSelectedItem().toString()+"', telno='"+txtogrtel.getText()+"', ogrencino='"+txtogrno.getText()+"' WHERE telno='"+txtogrtel.getText()+"'";
        cnnct cn=new cnnct();
        cn.guncelle(sorgu);
        cn.baglan();
        model.getDataVector().removeAllElements();
        tabloyagetir();
        temizle();
    }//GEN-LAST:event_bntguncelleogrActionPerformed

    private void btnperekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnperekleActionPerformed
        DefaultTableModel model=(DefaultTableModel) tblper.getModel();
        String sorgu="INSERT INTO public.tblcalisan (ad, soyad, verdigikurs, statu,cepno,maas) VALUES ('"+perad.getText()+"','"+persoyad.getText()+" ','"+percmb.getSelectedItem().toString()+"' , "
                + "'"+perstatu.getSelectedItem().toString()+"','"+percep.getText()+"','"+permaas.getText()+"');";
        cnnct cn=new cnnct();
        cn.ekle(sorgu);
        cn.baglan();
        model.getDataVector().removeAllElements();
        pertablogetir();
        temizleper();
    }//GEN-LAST:event_btnperekleActionPerformed

    private void tblperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblperMouseClicked
     DefaultTableModel model=(DefaultTableModel)tblper.getModel();
     int ow=tblper.getSelectedRow();
     perad.setText(model.getValueAt(ow, 0).toString());
     persoyad.setText(model.getValueAt(ow, 1).toString());
     percmb.setSelectedItem(model.getValueAt(ow, 2).toString());
     perstatu.setSelectedItem(model.getValueAt(ow, 3).toString());
     percep.setText(model.getValueAt(ow, 4).toString());
     permaas.setText(model.getValueAt(ow, 5).toString());
    }//GEN-LAST:event_tblperMouseClicked

    private void btnpersilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpersilActionPerformed
       DefaultTableModel model=(DefaultTableModel)tblper.getModel();
        cnnct cn=new cnnct();
        cn.baglan();
        String sorgu="DELETE FROM public.tblcalisan WHERE cepno='"+percep.getText()+"'";
        cn.sil(sorgu);
        model.getDataVector().removeAllElements();
        pertablogetir();
        temizleper();
                
        
    }//GEN-LAST:event_btnpersilActionPerformed

    private void btnperupdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnperupdActionPerformed
        DefaultTableModel model=(DefaultTableModel)tblper.getModel();
        String sorgu="Update tblcalisan set ad='"+perad.getText()+"',soyad='"+persoyad.getText()+"',verdigikurs='"+percmb.getSelectedItem().toString()+"',statu='"+perstatu.getSelectedItem().toString()+"',cepno='"+percep.getText()+"',maas='"+permaas.getText()+"' where cepno='"+percep.getText()+"'";
        cnnct cn=new cnnct();
        cn.guncelle(sorgu);
        cn.baglan();
        model.getDataVector().removeAllElements();
        pertablogetir();
        temizleper();
        
    }//GEN-LAST:event_btnperupdActionPerformed

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
            java.util.logging.Logger.getLogger(frmYonetici.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmYonetici.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmYonetici.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmYonetici.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmYonetici().setVisible(true);
                
                        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntguncelleogr;
    private javax.swing.JButton bntsilogr;
    private javax.swing.JButton btnekleogr;
    private javax.swing.JButton btnperekle;
    private javax.swing.JButton btnpersil;
    private javax.swing.JButton btnperupd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    public static javax.swing.JComboBox<String> ogrkurs;
    private javax.swing.JTextField perad;
    private javax.swing.JTextField percep;
    private javax.swing.JComboBox<String> percmb;
    private javax.swing.JTextField permaas;
    private javax.swing.JTextField persoyad;
    private javax.swing.JComboBox<String> perstatu;
    private javax.swing.JTable tblogr;
    private javax.swing.JTable tblogrsifre;
    private javax.swing.JTable tblper;
    private javax.swing.JTable tblpergiris;
    private javax.swing.JTextField txtograd;
    private javax.swing.JTextField txtogrno;
    private javax.swing.JTextField txtogrsoyad;
    private javax.swing.JTextField txtogrtel;
    private javax.swing.JTextField txtogrucret;
    // End of variables declaration//GEN-END:variables
}
