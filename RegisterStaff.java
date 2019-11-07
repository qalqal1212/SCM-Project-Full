/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportShoesHouse;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eyya
 */
public class RegisterStaff extends javax.swing.JFrame {

        //Connection Database
    Connection conn = null;
    PreparedStatement pst = null;
    
    /**
     * Creates new form RegisterStaff
     */
    public RegisterStaff() {
        initComponents();
    }
    
    public Connection getConnection()
    {
        Connection con = null;
        
        try 
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/sportshoeshouse","root","");
            return con;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RegisterStaff.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public boolean checkInputs()
    {
        if(    
            jTextBoxStaffID.getText() == null
            || jTextBoxStaffName.getText() == null
            || jTextBoxRole.getText() == null
            || jTextBoxUsername.getText() == null
            || jTextBoxPassword.getText() == null
          )
        {
            return false;
        }
        else
        {
           return true;
        }
    }    

    //Display Data in JTable
    //Fill ArrayList with the data 
    public ArrayList<StaffRecords>getStaffList()
    {
            ArrayList <StaffRecords> staffList = new ArrayList <StaffRecords>();
            Connection con =getConnection();
            String query = "SELECT * FROM staff";
            
            Statement st;
            ResultSet rs;   
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            StaffRecords staffRecords; 
            
            while(rs.next())
            {
                staffRecords = new StaffRecords(rs.getInt("ID"), rs.getString("Name"),rs.getString("Role"),rs.getString("Username"), rs.getString("Password"));
                staffList.add(staffRecords);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
     return staffList;
    }

    //populate the JTable
    public void Show_Staff_In_JTable()
    {
        ArrayList<StaffRecords> list = getStaffList();
        DefaultTableModel model = (DefaultTableModel)jTableStaffRecords.getModel();
        // clear jtable content
        model.setRowCount(0);
          Object[] row = new Object[6];
          
           for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getRole();
            row[3] = list.get(i).getUsername();
            row[4] = list.get(i).getPassword();
            
            model.addRow(row);
        }
    }      
    
    public void ShowItem (int index)
    {
        jTextBoxStaffID.setText(Integer.toString(getStaffList().get(index).getID()));
        jTextBoxStaffName.setText(getStaffList().get(index).getName());
        jTextBoxRole.setText(getStaffList().get(index).getRole());
        jTextBoxUsername.setText(getStaffList().get(index).getUsername());
        jTextBoxPassword.setText(getStaffList().get(index).getPassword());        
    }

    //function to return products arraylist with particular data
    public ArrayList<StaffRecords> ListStaff (String ValToSearch) 
    {
        ArrayList<StaffRecords> staffList = new ArrayList<StaffRecords>();
        
        Statement st;
        ResultSet rs;
        
        try
        {
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM staff WHERE CONCAT (ID,Name,Role,Username,Password) LIKE '%"+ValToSearch+"%'";
            rs = st.executeQuery(searchQuery);
             
            StaffRecords staffRecords;
             
             while(rs.next())
            {
                staffRecords = new StaffRecords(rs.getInt("ID"), rs.getString("Name"),rs.getString("Role"),rs.getString("Username"), rs.getString("Password"));
                staffList.add(staffRecords);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
         
        return staffList;       
    }   

    public void findStaffRecords()
    {
        ArrayList<StaffRecords> staffRecords = ListStaff(jTextBoxSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID", "Name", "Role", "Username", "Password"});
        Object[] row = new Object[6];
          
        for(int i = 0; i < staffRecords.size(); i++)
        {
            row[0] = staffRecords.get(i).getID();
            row[1] = staffRecords.get(i).getName();
            row[2] = staffRecords.get(i).getRole();
            row[3] = staffRecords.get(i).getUsername();
            row[4] = staffRecords.get(i).getPassword();
            
            model.addRow(row);
        }
        jTableStaffRecords.setModel(model);
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLblUsername = new javax.swing.JLabel();
        jLabelStaffName = new javax.swing.JLabel();
        jLabelRole = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonShowTable = new javax.swing.JButton();
        jLabelPassword = new javax.swing.JLabel();
        jTextBoxStaffID = new javax.swing.JTextField();
        jTextBoxStaffName = new javax.swing.JTextField();
        jTextBoxRole = new javax.swing.JTextField();
        jTextBoxUsername = new javax.swing.JTextField();
        jTextBoxPassword = new javax.swing.JTextField();
        jButtonClear = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStaffRecords = new javax.swing.JTable();
        jTextBoxSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabelBack = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuHome = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Employee");

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(153, 255, 204));
        jPanel5.setToolTipText("SSHIMS");

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Authentic Shoes Inventory Management System");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel7)
                .addContainerGap(197, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 850, 50));

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLblUsername.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLblUsername.setText("Username");
        jPanel2.add(jLblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 80, -1));

        jLabelStaffName.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelStaffName.setText("Staff Name");
        jPanel2.add(jLabelStaffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 60, 90, -1));

        jLabelRole.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelRole.setText("Role");
        jPanel2.add(jLabelRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 100, 50, -1));

        jLabelUsername.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelUsername.setText("Staff ID");
        jPanel2.add(jLabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 60, -1));

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/if_plus-circle_2561291.png"))); // NOI18N
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 110, -1));

        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 110, -1));

        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 110, -1));

        jButtonShowTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_Property_25px.png"))); // NOI18N
        jButtonShowTable.setText("Records");
        jButtonShowTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowTableActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonShowTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 110, -1));

        jLabelPassword.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelPassword.setText("Password");
        jPanel2.add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 180, 70, -1));

        jTextBoxStaffID.setToolTipText("Staff ID");
        jPanel2.add(jTextBoxStaffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 261, -1));

        jTextBoxStaffName.setToolTipText("insert staff name");
        jPanel2.add(jTextBoxStaffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 261, -1));
        jPanel2.add(jTextBoxRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 261, -1));

        jTextBoxUsername.setToolTipText("staff username");
        jPanel2.add(jTextBoxUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 261, -1));

        jTextBoxPassword.setToolTipText("staff password");
        jPanel2.add(jTextBoxPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 261, -1));

        jButtonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reset1.png"))); // NOI18N
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 110, -1));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 600, 230));

        jPanel6.setBackground(new java.awt.Color(153, 255, 204));
        jPanel6.setLayout(null);

        jTableStaffRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Role", "Username", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableStaffRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableStaffRecordsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableStaffRecords);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 580, 130);
        jPanel6.add(jTextBoxSearch);
        jTextBoxSearch.setBounds(150, 20, 181, 28);

        jButtonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search1.png"))); // NOI18N
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonSearch);
        jButtonSearch.setBounds(340, 19, 100, 30);

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 600, 220));

        jPanel7.setBackground(new java.awt.Color(153, 255, 204));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Register Staff");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 180, -1));

        jLabelBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Back_Arrow_50px.png"))); // NOI18N
        jLabelBack.setToolTipText("Previous page");
        jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackMouseClicked(evt);
            }
        });
        jPanel4.add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 620));

        jMenuHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        jMenuHome.setText("Home");
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(840, 613));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHomeActionPerformed
        // TODO add your handling code here:
        new AdminHomepage().setVisible(true);
    }//GEN-LAST:event_jMenuHomeActionPerformed

    private void jTableStaffRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableStaffRecordsMouseClicked
        // TODO add your handling code here:
        int index = jTableStaffRecords.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_jTableStaffRecordsMouseClicked

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        if (checkInputs())
        {
            Connection con = getConnection();
            try 
            {
                PreparedStatement ps = con.prepareStatement("Insert INTO staff (ID, Name, Role, Username, Password)" + "values(?,?,?,?,?)");
        
                ps.setString(1, jTextBoxStaffID.getText());
                ps.setString(2, jTextBoxStaffName.getText());
                ps.setString(3, jTextBoxRole.getText());
                ps.setString(4, jTextBoxUsername.getText());
                ps.setString(5, jTextBoxPassword.getText());                
            
                ps.executeUpdate();
                Show_Staff_In_JTable();
            
                JOptionPane.showMessageDialog(null, "Data inserted");
            }
            catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "One or more field are empty");
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        if (checkInputs() && jTextBoxStaffID.getText() != null)
        {
            String UpdateQuery =  null;
            PreparedStatement ps = null; 
            Connection con = getConnection();
            
            try 
            {
                UpdateQuery = "UPDATE staff SET Name=?, Role=?, Username=?, Password=? WHERE ID=? "; 
                                     
                ps = con.prepareStatement(UpdateQuery);

                ps.setString(1, jTextBoxStaffName.getText());
                ps.setString(2, jTextBoxRole.getText());
                ps.setString(3, jTextBoxUsername.getText());
                ps.setString(4, jTextBoxPassword.getText());
                ps.setInt(5, Integer.parseInt(jTextBoxStaffID.getText()));
                    
                ps.executeUpdate();
                Show_Staff_In_JTable();
                JOptionPane.showMessageDialog(null, "Data updated!");     
            }   
            catch (SQLException ex) 
            {
                Logger.getLogger(RegisterStaff.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "One or more fields are empty or wrong");
        }       
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:  
    if (!jTextBoxStaffID.getText().equals(""))
        {
            try 
            {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM staff WHERE ID =?");
                
                String ObjButtons[] = {"Yes","No"};
                int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to delete this staff?","Staff Details",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
                if(PromptResult==JOptionPane.YES_OPTION)
                {
                    int id = Integer.parseInt(jTextBoxStaffID.getText());
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    Show_Staff_In_JTable();
                   JOptionPane.showMessageDialog(null, "Staff Deleted ");
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(RegisterStaff.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Staff Not Deleted!");
            }
        }
        
        else 
        {
            JOptionPane.showMessageDialog(null, "Staff not deleted : Staff ID to be delete");
        }        
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonShowTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowTableActionPerformed
        // TODO add your handling code here:
        Show_Staff_In_JTable();
    }//GEN-LAST:event_jButtonShowTableActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
        jTextBoxStaffID.setText("");
        jTextBoxStaffName.setText("");
        jTextBoxRole.setText("");
        jTextBoxUsername.setText("");
        jTextBoxPassword.setText("");
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
        // TODO add your handling code here:
        AdminStaffMenu as = new AdminStaffMenu();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelBackMouseClicked

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
        findStaffRecords();
    }//GEN-LAST:event_jButtonSearchActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonShowTable;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelRole;
    private javax.swing.JLabel jLabelStaffName;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLblUsername;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableStaffRecords;
    private javax.swing.JTextField jTextBoxPassword;
    private javax.swing.JTextField jTextBoxRole;
    private javax.swing.JTextField jTextBoxSearch;
    private javax.swing.JTextField jTextBoxStaffID;
    private javax.swing.JTextField jTextBoxStaffName;
    private javax.swing.JTextField jTextBoxUsername;
    // End of variables declaration//GEN-END:variables
}
