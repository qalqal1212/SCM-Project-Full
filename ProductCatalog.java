/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportShoesHouse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eyya
 */
public class ProductCatalog extends javax.swing.JFrame {

    /**
     * Creates new form ProductCatalog
     */
    public ProductCatalog() {
        initComponents();
    }
    
    //connection to database    
    public Connection getConnection()
    {
        Connection con = null;
        
        try 
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/sportshoeshouse", "root", "");
            return con;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RegisterProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
    } 
    
    //function to return products arraylist with particular data
    public ArrayList<Products> ListProduct (String ValToSearch) 
    {
        ArrayList<Products> productList = new ArrayList<Products>();
        
        Statement st;
        ResultSet rs;
        
        try
        {
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM products WHERE CONCAT (ProductCode,ProductName,ProductBrand,ProductPrice,ProductQuantity, ProductImage) LIKE '%"+ValToSearch+"%'";
            rs = st.executeQuery(searchQuery);
             
            Products products; 
             
            while(rs.next())
            {
                products = new Products(rs.getInt("ProductCode"), rs.getString("ProductName"),rs.getString("ProductBrand"),Float.parseFloat(rs.getString("ProductPrice")), rs.getInt("ProductQuantity"), rs.getBytes("ProductImage"));
                productList.add(products);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return productList;     
    } 
    
    //search for product
    public void findProduct()
    {
        ArrayList<Products> products = ListProduct(jTextFieldProductSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ProductCode", "ProductName", "ProductBrand", "ProductPrice", "ProductQuantity", "ProductImage"});
        Object[] row = new Object[6];
          
        for(int i = 0; i < products.size(); i++)
        {
            row[0] = products.get(i).getProductCode();
            row[1] = products.get(i).getProductName();
            row[2] = products.get(i).getProductBrand();
            row[3] = products.get(i).getProductPrice();
            row[4] = products.get(i).getProductQuantity();
            row[5] = products.get(i).getProductImage();
            
            model.addRow(row);
        }
           jTableProdCat.setModel(model);
    }
    
        
    //Display Data in JTable
    //Fill ArrayList wit the data 
    public ArrayList<Products>getProductList()
    {
        ArrayList <Products> productList = new ArrayList <Products>();
        Connection con =getConnection();
        String query = "SELECT * FROM products";
            
        Statement st;
        ResultSet rs;
        
        try 
        {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Products products; 
            
            while(rs.next())
            {
                products = new Products(rs.getInt("ProductCode"), rs.getString("ProductName"),rs.getString("ProductBrand"),Float.parseFloat(rs.getString("ProductPrice")), rs.getInt("ProductQuantity"), rs.getBytes("ProductImage"));
                productList.add(products);
            }
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RegisterProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
     return productList;
    }
    
    //populate the JTable
    public void Show_Products_In_JTable()
    {
        ArrayList<Products> list = getProductList();
        DefaultTableModel model = (DefaultTableModel)jTableProdCat.getModel();
        // clear jtable content
        model.setRowCount(0);
        Object[] row = new Object[6];
          
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getProductCode();
            row[1] = list.get(i).getProductName();
            row[2] = list.get(i).getProductBrand();
            row[3] = list.get(i).getProductPrice();
            row[4] = list.get(i).getProductQuantity();
            
            model.addRow(row);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("sportshoeshouse?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        products_1Query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Products_1 p");
        products_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : products_1Query.getResultList();
        products_1Query1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Products_1 p");
        products_1List1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : products_1Query1.getResultList();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProdCat = new javax.swing.JTable();
        jLabelBack = new javax.swing.JLabel();
        jButtonPrintProdCatAdmin1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldProductSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuHome = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product Catalog");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(153, 255, 204));
        jPanel6.setToolTipText("SSHIMS");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Authentic Shoes Inventory Management System");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel5)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 790, 50));

        jPanel7.setBackground(new java.awt.Color(236, 236, 236));
        jPanel7.setLayout(null);

        jTableProdCat.setRowHeight(100);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, products_1List, jTableProdCat);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productCode}"));
        columnBinding.setColumnName("Product Code");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productName}"));
        columnBinding.setColumnName("Product Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productBrand}"));
        columnBinding.setColumnName("Product Brand");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productPrice}"));
        columnBinding.setColumnName("Product Price");
        columnBinding.setColumnClass(Float.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productQuantity}"));
        columnBinding.setColumnName("Product Quantity");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${image}"));
        columnBinding.setColumnName("Product Image");
        columnBinding.setColumnClass(javax.swing.ImageIcon.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTableProdCat);

        jPanel7.add(jScrollPane2);
        jScrollPane2.setBounds(10, 10, 680, 250);

        jLabelBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Back_Arrow_50px.png"))); // NOI18N
        jLabelBack.setToolTipText("Previous page");
        jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackMouseClicked(evt);
            }
        });
        jPanel7.add(jLabelBack);
        jLabelBack.setBounds(20, 290, 50, 50);

        jButtonPrintProdCatAdmin1.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jButtonPrintProdCatAdmin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_Property_25px.png"))); // NOI18N
        jButtonPrintProdCatAdmin1.setText("Records");
        jButtonPrintProdCatAdmin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintProdCatAdmin1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonPrintProdCatAdmin1);
        jButtonPrintProdCatAdmin1.setBounds(530, 290, 160, 40);

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 700, 370));

        jPanel8.setBackground(new java.awt.Color(153, 255, 204));

        jLabel7.setBackground(new java.awt.Color(255, 153, 153));
        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Product Catalog (Admin)");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 240, -1));
        jPanel5.add(jTextFieldProductSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 140, 29));

        jButtonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search1.png"))); // NOI18N
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 100, 30));
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 520));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        jMenuHome.setText("Home");
        jMenuHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHomeActionPerformed(evt);
            }
        });
        jMenuBar.add(jMenuHome);

        setJMenuBar(jMenuBar);

        bindingGroup.bind();

        setSize(new java.awt.Dimension(778, 563));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHomeActionPerformed
        // TODO add your handling code here:
        new MainPage().setVisible(true);
       
    }//GEN-LAST:event_jMenuHomeActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
        findProduct();
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
        // TODO add your handling code here:
        ProductMenu p = new ProductMenu();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelBackMouseClicked

    private void jButtonPrintProdCatAdmin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintProdCatAdmin1ActionPerformed
        // TODO add your handling code here:
        Show_Products_In_JTable(); 
    }//GEN-LAST:event_jButtonPrintProdCatAdmin1ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductCatalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductCatalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductCatalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductCatalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductCatalog().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButtonPrintProdCatAdmin1;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProdCat;
    private javax.swing.JTextField jTextFieldProductSearch;
    private java.util.List<SportShoesHouse.Products_1> products_1List;
    private java.util.List<SportShoesHouse.Products_1> products_1List1;
    private javax.persistence.Query products_1Query;
    private javax.persistence.Query products_1Query1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
