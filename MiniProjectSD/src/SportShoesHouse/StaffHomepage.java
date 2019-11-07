/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportShoesHouse;

import javax.swing.JOptionPane;

/**
 *
 * @author eyya
 */
public class StaffHomepage extends javax.swing.JFrame {

    String username;
    /**
     * Creates new form StaffPortal
     */
    public StaffHomepage() {
        initComponents();
    }
    
    public StaffHomepage(String User) 
    {
        username = User;
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

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelLogout = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jBtnProdOrder = new javax.swing.JPanel();
        jLabelProdOrder = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jBtnProdCat = new javax.swing.JPanel();
        jLabelProdCat = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jBtnStaffProf = new javax.swing.JPanel();
        jLabelEmpProfile = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelEmpName = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(249, 249, 249));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(153, 255, 204));
        jPanel4.setToolTipText("SSHIMS");
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(253, 253, 253));

        jLabelLogout.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabelLogout.setForeground(new java.awt.Color(21, 198, 198));
        jLabelLogout.setText("Logout");
        jLabelLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabelLogout)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel5.setText("Authentic Shoes Inventory Management System");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 34, 830, 52));

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 35)); // NOI18N
        jLabel4.setText("Staff Portal");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 190, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 1, 35)); // NOI18N
        jLabel7.setText("Welcome");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel8.setText("to");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 280, 360));

        jBtnProdOrder.setBackground(new java.awt.Color(249, 249, 249));
        jBtnProdOrder.setToolTipText("Shoes Ordering");
        jBtnProdOrder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProdOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Buying_100px.png"))); // NOI18N
        jLabelProdOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProdOrderMouseClicked(evt);
            }
        });
        jBtnProdOrder.add(jLabelProdOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 150, 90));

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(73, 196, 220));
        jLabel11.setText("Product Ordering");
        jBtnProdOrder.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 170, 60));

        jPanel2.add(jBtnProdOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 190, 170));

        jBtnProdCat.setBackground(new java.awt.Color(249, 249, 249));
        jBtnProdCat.setToolTipText("Shoes Catalog");
        jBtnProdCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnProdCatMouseClicked(evt);
            }
        });
        jBtnProdCat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelProdCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Brochure_100px.png"))); // NOI18N
        jLabelProdCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProdCatMouseClicked(evt);
            }
        });
        jBtnProdCat.add(jLabelProdCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 140, 90));

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(73, 196, 220));
        jLabel9.setText("Product Catalog");
        jBtnProdCat.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 160, 60));

        jPanel2.add(jBtnProdCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 190, 170));

        jBtnStaffProf.setBackground(new java.awt.Color(249, 249, 249));
        jBtnStaffProf.setToolTipText("Edit Staff Profile");
        jBtnStaffProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnStaffProfMouseClicked(evt);
            }
        });
        jBtnStaffProf.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelEmpProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Contact_100px.png"))); // NOI18N
        jLabelEmpProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEmpProfileMouseClicked(evt);
            }
        });
        jBtnStaffProf.add(jLabelEmpProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 140, 90));

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(73, 196, 220));
        jLabel6.setText("Staff Profile");
        jBtnStaffProf.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 140, 60));

        jPanel2.add(jBtnStaffProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 190, 170));

        jLabelEmpName.setText("Name staff login");
        jPanel2.add(jLabelEmpName, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 90, 120, 20));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_User_20px_3.png"))); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 789, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(794, 552));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnStaffProfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnStaffProfMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnStaffProfMouseClicked

    private void jLabelLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseClicked
        // TODO add your handling code here:
        { 
            String ObjButtons[] = {"Yes","No"};
            int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to logout?","Sport Shoes House",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
            if(PromptResult==JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(null, "User Log Out");
                new LoginStaff().setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_jLabelLogoutMouseClicked

    private void jLabelEmpProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEmpProfileMouseClicked
        // TODO add your handling code here:
        StaffChangePwd s = new StaffChangePwd(username);
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelEmpProfileMouseClicked

    private void jLabelProdOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProdOrderMouseClicked
        // TODO add your handling code here:
        Ordering2 o = new Ordering2();
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelProdOrderMouseClicked

    private void jLabelProdCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProdCatMouseClicked
        // TODO add your handling code here:
        ProductCatalogStaff p = new ProductCatalogStaff();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelProdCatMouseClicked

    private void jBtnProdCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnProdCatMouseClicked
        // TODO add your handling code here:
        ProductCatalogStaff p = new ProductCatalogStaff();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnProdCatMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        jLabelEmpName.setText(username);
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
            java.util.logging.Logger.getLogger(StaffHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffHomepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jBtnProdCat;
    private javax.swing.JPanel jBtnProdOrder;
    private javax.swing.JPanel jBtnStaffProf;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEmpName;
    private javax.swing.JLabel jLabelEmpProfile;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelProdCat;
    private javax.swing.JLabel jLabelProdOrder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
