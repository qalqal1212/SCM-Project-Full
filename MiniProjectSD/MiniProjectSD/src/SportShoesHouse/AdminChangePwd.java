/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportShoesHouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author eyya
 */
public class AdminChangePwd extends javax.swing.JFrame {

    String username;
    /**
     * Creates new form ChangePwd
     */
    public AdminChangePwd() {
        initComponents();
    }
    
    public AdminChangePwd(String User) 
    {
        username = User;
        initComponents();
    }
    
    //Connection Database
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelUsername3 = new javax.swing.JLabel();
        jLabelPwd3 = new javax.swing.JLabel();
        jLabelUsername4 = new javax.swing.JLabel();
        jLabelPwd4 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordFieldPwdOld = new javax.swing.JPasswordField();
        jPasswordFieldPwdNew = new javax.swing.JPasswordField();
        jPasswordFieldPwdConf = new javax.swing.JPasswordField();
        jButtonChangePassword = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabelBack = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuHome = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Change Password");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setToolTipText("SSHIMS");

        jLabel3.setBackground(new java.awt.Color(255, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Authentic Shoes Inventory Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel3)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 780, 50));

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));
        jPanel3.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Change Password");
        jLabel4.setToolTipText("");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(30, 10, 225, 41);

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("ADMIN PANEL");
        jLabel5.setToolTipText("");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(30, 50, 102, 22);

        jLabelUsername3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelUsername3.setText("User Name");
        jPanel3.add(jLabelUsername3);
        jLabelUsername3.setBounds(80, 110, 90, 30);

        jLabelPwd3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelPwd3.setText("Old Password");
        jPanel3.add(jLabelPwd3);
        jLabelPwd3.setBounds(70, 150, 100, 30);

        jLabelUsername4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelUsername4.setText("New Password");
        jPanel3.add(jLabelUsername4);
        jLabelUsername4.setBounds(60, 190, 110, 30);

        jLabelPwd4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelPwd4.setText("Confirm Password");
        jPanel3.add(jLabelPwd4);
        jLabelPwd4.setBounds(40, 230, 130, 30);

        jTextFieldUsername.setToolTipText("Insert username only");
        jPanel3.add(jTextFieldUsername);
        jTextFieldUsername.setBounds(170, 110, 170, 30);

        jPasswordFieldPwdOld.setToolTipText("Current Password");
        jPanel3.add(jPasswordFieldPwdOld);
        jPasswordFieldPwdOld.setBounds(170, 150, 170, 30);

        jPasswordFieldPwdNew.setToolTipText("New password contain 4 character atleast");
        jPanel3.add(jPasswordFieldPwdNew);
        jPasswordFieldPwdNew.setBounds(170, 190, 170, 30);

        jPasswordFieldPwdConf.setToolTipText("Confirmation password");
        jPanel3.add(jPasswordFieldPwdConf);
        jPasswordFieldPwdConf.setBounds(170, 230, 170, 30);

        jButtonChangePassword.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jButtonChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        jButtonChangePassword.setText("Save");
        jButtonChangePassword.setToolTipText("Save details");
        jButtonChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangePasswordActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonChangePassword);
        jButtonChangePassword.setBounds(150, 270, 93, 33);

        jButtonClear.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jButtonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reset1.png"))); // NOI18N
        jButtonClear.setText("Clear");
        jButtonClear.setToolTipText("Clear all");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonClear);
        jButtonClear.setBounds(250, 270, 93, 33);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 400, 360));

        jPanel4.setBackground(new java.awt.Color(153, 255, 204));

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Edit Admin Profile");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, -1));

        jLabelBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Back_Arrow_50px.png"))); // NOI18N
        jLabelBack.setToolTipText("Previous page");
        jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        jMenuHome.setText("Home");
        jMenuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuHomeMouseClicked(evt);
            }
        });
        jMenuHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHomeActionPerformed(evt);
            }
        });
        jMenuBar.add(jMenuHome);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(782, 562));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHomeActionPerformed
        // TODO add your handling code here:
        new AdminHomepage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuHomeActionPerformed

    private void jButtonChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangePasswordActionPerformed
      
    String Newpass=String.valueOf(jPasswordFieldPwdNew.getPassword());
    String ConfPass=String.valueOf(jPasswordFieldPwdConf.getPassword());
    String OldPass=String.valueOf(jPasswordFieldPwdOld.getPassword());
    String uName=jTextFieldUsername.getText();
        
        if (uName.equals("")) 
        {
            JOptionPane.showMessageDialog(this, "Please enter your username","Error", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        else if (OldPass.equals("")) 
        {
            JOptionPane.showMessageDialog( this, "Please enter your old password","Error", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        else if (Newpass.equals("")) 
        {
            JOptionPane.showMessageDialog( this, "Please enter new password","Error", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        else if (ConfPass.equals("")) 
        {
            JOptionPane.showMessageDialog( this, "Please enter confirmed password","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if (Newpass.length()< 4) 
        {
            JOptionPane.showMessageDialog(this,"The New Password Should be of Atleast 4 Characters","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if ((Newpass).equals(OldPass)) 
        {
            JOptionPane.showMessageDialog(this,"Password is same..Re-enter new password","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if (!(Newpass).equals(ConfPass)) 
        {
            JOptionPane.showMessageDialog(this,"New Password doesn't match with Confirmed Password","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try
        {
            conn = MysqlConnect.ConnectDB();
            String sql= "select admin_username,admin_password from admin";
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
            while(rs.next())
            {
                String usrname = rs.getString("admin_username").trim();
                String passwd = rs.getString("admin_password").trim();
                
                if(uName.equals(usrname) && OldPass.equals(passwd))
                {
                    conn = MysqlConnect.ConnectDB();
                    String sql1= "update admin set admin_password= '" + Newpass + "' where admin_username= '" + uName + "' and admin_password = '" + OldPass + "'";
                    Statement stmt = conn.createStatement();
                    stmt.execute(sql1.toString());
                    stmt.close();
                    JOptionPane.showMessageDialog(this,"Password Successfully Changed");
                    jTextFieldUsername.setText("");
                    jPasswordFieldPwdOld.setText("");
                    jPasswordFieldPwdNew.setText("");
                    jPasswordFieldPwdConf.setText("");
                    LoginAdmin frm = new LoginAdmin();
                    this.hide();
                    frm.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"invalid user name or password","Error", JOptionPane.ERROR_MESSAGE);
                    jTextFieldUsername.setText("");
                    jPasswordFieldPwdOld.setText("");
                    jPasswordFieldPwdNew.setText("");
                    jPasswordFieldPwdConf.setText("");
                }
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex);
        }   
    }//GEN-LAST:event_jButtonChangePasswordActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
        jTextFieldUsername.setText("");
        jPasswordFieldPwdOld.setText("");
        jPasswordFieldPwdNew.setText("");
        jPasswordFieldPwdConf.setText("");
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
        // TODO add your handling code here:
        AdminHomepage m = new AdminHomepage(username);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelBackMouseClicked

    private void jMenuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuHomeMouseClicked
        // TODO add your handling code here:
        AdminHomepage ah = new AdminHomepage();
        ah.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuHomeMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling cjLabelusernameode here:
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(AdminChangePwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminChangePwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminChangePwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminChangePwd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display theS form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminChangePwd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChangePassword;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelPwd3;
    private javax.swing.JLabel jLabelPwd4;
    private javax.swing.JLabel jLabelUsername3;
    private javax.swing.JLabel jLabelUsername4;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordFieldPwdConf;
    private javax.swing.JPasswordField jPasswordFieldPwdNew;
    private javax.swing.JPasswordField jPasswordFieldPwdOld;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
