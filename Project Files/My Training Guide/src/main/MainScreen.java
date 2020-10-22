/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import main.helper.DBConnection;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Baler-Gamer
 */
public class MainScreen extends javax.swing.JFrame {
    public static Connection con;
    public static PreparedStatement pst;
    public static ResultSet res;
    public static JFileChooser file = new JFileChooser();
    public static File f;
    public static int userID;
    public static String userCv;
    public static String uName;

    /**
     * Creates new form MainScreen
     */
    public MainScreen(String userName, int id, String cv) {
        initComponents();
        this.setLocationRelativeTo(null);
        userNameText.setText(userName);
        userID = id;
        userCv = cv;
        uName = userName;
        companyTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        companyTable.clearSelection();
        companyTable.removeColumn(companyTable.getColumnModel().getColumn(0));
        ReLoadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        srchBox = new javax.swing.JTextField();
        logoutBtn = new javax.swing.JLabel();
        userNameText = new javax.swing.JLabel();
        sendBtn = new javax.swing.JButton();
        srchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        companyTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("الصفحة الرئيسية ");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(817, 743));
        setMinimumSize(new java.awt.Dimension(817, 743));
        setResizable(false);
        setSize(new java.awt.Dimension(817, 743));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(null);

        srchBox.setBackground(new java.awt.Color(204, 204, 204));
        srchBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 25, 1, 25));
        jPanel1.add(srchBox);
        srchBox.setBounds(30, 140, 230, 40);

        logoutBtn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logout.png"))); // NOI18N
        logoutBtn.setText("تسجيل خروج ");
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });
        jPanel1.add(logoutBtn);
        logoutBtn.setBounds(20, 20, 110, 30);

        userNameText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userNameText.setForeground(new java.awt.Color(0, 153, 204));
        userNameText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userNameText.setText("Easin Sazzad");
        jPanel1.add(userNameText);
        userNameText.setBounds(140, 20, 330, 30);

        sendBtn.setBackground(new java.awt.Color(0, 102, 153));
        sendBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sendBtn.setForeground(new java.awt.Color(240, 240, 240));
        sendBtn.setText("إرسال ");
        sendBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendBtnMouseClicked(evt);
            }
        });
        jPanel1.add(sendBtn);
        sendBtn.setBounds(30, 520, 200, 40);

        srchBtn.setBackground(new java.awt.Color(0, 153, 255));
        srchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_search_20px_1.png"))); // NOI18N
        srchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                srchBtnMouseClicked(evt);
            }
        });
        jPanel1.add(srchBtn);
        srchBtn.setBounds(270, 140, 73, 40);

        companyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "رقم هوية التدريب ", "اسم التدريب ", "اسم جهة التدريب ", "القطاع ", "تاريخ بدء التدريب ", "وقت التدريب "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        companyTable.setFocusable(false);
        companyTable.setRowHeight(30);
        companyTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(companyTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 190, 770, 320);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_reset_20px.png"))); // NOI18N
        jLabel1.setText(" إعادة التعيين ");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(650, 150, 150, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(710, 0, 100, 100);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("<html> <style> p{ text-align: center; } .title{ font-size:12px; font-weight:bold; } .title-center{ text-align: center; margin-top: 5px; font-size: 11px; } </style> \n<p class=\"title\">مرحباً بكم في موقعنا دليلي للتدريب </p> <p class=\"title-center\">لخاص للمرحلة الجامعية المتوسطة </p> <p class=\"title-center\">بأشراف الاستاذة: مشاعل الموسى</p> \n<p class=\"title-center\">يسرنا ان تنظموا لنا وتقدموا على مايناسب مجالاتكم ..</p>\n<p class=\"title-center\"> استمتعوا معنا</p>\n</html>"); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(380, -10, 310, 130);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("<html>\n<p>+966599882851</p>\n<p>‏‭+966593655441</p>\n</html>");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 590, 820, 50);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ارقام التواصل :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 570, 820, 20);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("<html>\n<style>\np{\ntext-align:center;\nmargin-top:5px;\n}\n.t{\nfont-size: 8px;\nfont-weight: bold;\n}\n</style>\n<p class=\"t\">*البريد الالكتروني: </p>\n<p><a href=\"mailto:training_guiide@gmail.com\">training_guiide@gmail.com</a></p>\n<p class=\"t\">*حساب تويتر:</p>\n</html>");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 640, 820, 55);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_twitter_circled_20px.png"))); // NOI18N
        jLabel7.setText("@traning_guiide");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 700, 820, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        this.dispose();
        new StartScreen().setVisible(true);
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void sendBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendBtnMouseClicked
        if(companyTable.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(rootPane, "الرجاء اختيار جهه التدريب للأرسال");
        }
        else{
            int result = JOptionPane.showConfirmDialog(rootPane, "هل أنت متأكد من التقديم على هذه الجهه التدريبيه؟","Confirmation",
                    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION)
            {
                int row = companyTable.getSelectedRow();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();
                
                String trainingId = companyTable.getModel().getValueAt(row, 0).toString();
                String myDate = dtf.format(now);
                
                con = DBConnection.getConnection();
                
                try {
                    pst = con.prepareStatement("insert into applications (training_id,applicant_id,applicant_name,submission_date,"
                            + "cv) values(?,?,?,?,?)");
                    pst.setString(1,trainingId);
                    pst.setInt(2, userID);
                    pst.setString(3,uName);
                    pst.setString(4,myDate);
                    pst.setString(5, userCv);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(rootPane, "تم التقديم على الجهه التدريبيه بنجاح");
                    con.close();
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }//GEN-LAST:event_sendBtnMouseClicked

    private void srchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_srchBtnMouseClicked
        if(srchBox.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "الرجاء إدخال النص للبحث");
        }
        else
        {
            DefaultTableModel model = (DefaultTableModel)companyTable.getModel();
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            filterSearch(srchBox.getText());
        }
    }//GEN-LAST:event_srchBtnMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        DefaultTableModel model = (DefaultTableModel)companyTable.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        ReLoadTable();
    }//GEN-LAST:event_jLabel1MouseClicked

    public void filterSearch(String text)
    {
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement("select * from trainings where ins_name like '%"+text+"%' or"
                    + " training_name like '%"+text+"%' or training_time like '"+text+"'"
                            + " or sector like '%"+text+"%' order by id desc");
            res = pst.executeQuery();
            while(res.next())
            {
                int tId = res.getInt("ID");
                String insName = res.getString("ins_name");
                String tName = res.getString("training_name");
                String tDate = res.getString("training_start_date");
                String tTime = res.getString("training_time");
                String sector = res.getString("sector");
                DefaultTableModel model = (DefaultTableModel)companyTable.getModel();
                model.addRow(new Object[]{tId,tName,insName,sector,tDate,tTime});
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }
//Load the company table
    public void ReLoadTable()
    {
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement("select * from trainings order by id desc");
            res = pst.executeQuery();
            while(res.next())
            {
                int tId = res.getInt("ID");
                String insName = res.getString("ins_name");
                String tName = res.getString("training_name");
                String tDate = res.getString("training_start_date");
                String tTime = res.getString("training_time");
                String sector = res.getString("sector");
                
                DefaultTableModel model = (DefaultTableModel)companyTable.getModel();
                model.addRow(new Object[]{tId,tName,insName,sector,tDate,tTime});
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable companyTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JButton sendBtn;
    private javax.swing.JTextField srchBox;
    private javax.swing.JButton srchBtn;
    private javax.swing.JLabel userNameText;
    // End of variables declaration//GEN-END:variables
}
