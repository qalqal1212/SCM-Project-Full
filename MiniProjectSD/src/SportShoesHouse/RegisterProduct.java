/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportShoesHouse;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author eyya
 */
public class RegisterProduct extends javax.swing.JFrame {

    /**
     * Creates new form RegisterProduct
     */
    public RegisterProduct() {
        initComponents();
    }

    String Images = null;
    
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
    
    
    public boolean checkInputs()
    {
        if(
              jTextFieldProductCode.getText() == null
              || jTextFieldProductName.getText() == null
              || jComboBoxProductBrand.getSelectedItem() == null
              || jTextFieldProductPrice.getText() == null
              || jTextFieldProductQuantity.getText() == null
          )
        {
            return false;
        }
        else
        {
            try
            {
                Float.parseFloat(jTextFieldProductPrice.getText());
                return true;
            }
            catch(Exception ex)
            {
                return false;
            }
        }
    }    
    
    //resize image 
    public ImageIcon ResizeImage(String imagePath, byte[]pic )
    {
        ImageIcon myImage = null; 
        
        if(imagePath != null)
        {
            myImage = new ImageIcon (imagePath);
        }
        else 
        {
            myImage = new ImageIcon(pic);
        }
        
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(JLabelImage.getWidth(), JLabelImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon (img2);
        
        return image;
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
        DefaultTableModel model = (DefaultTableModel)jTableProductsDetail.getModel();
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
        
    public void ShowItem (int index)
    {
        jTextFieldProductCode.setText(Integer.toString(getProductList().get(index).getProductCode()));
        jTextFieldProductName.setText(getProductList().get(index).getProductName());
        jComboBoxProductBrand.setSelectedItem(getProductList().get(index).getProductBrand());
        jTextFieldProductPrice.setText(Float.toString(getProductList().get(index).getProductPrice()));
        jTextFieldProductQuantity.setText(Integer.toString(getProductList().get(index).getProductQuantity()));     
        JLabelImage.setIcon(ResizeImage(null, getProductList().get(index).getProductImage()));   
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
            String searchQuery = "SELECT * FROM products WHERE CONCAT (ProductCode,ProductName,ProductBrand,ProductPrice,ProductQuantity) LIKE '%"+ValToSearch+"%'";
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
    
    public void findProduct()
    {
        ArrayList<Products> products = ListProduct(jTextFieldProductSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ProductCode", "ProductName", "ProductBrand", "ProductPrice", "ProductQuantity"});
        Object[] row = new Object[6];
          
        for(int i = 0; i < products.size(); i++)
        {
            row[0] = products.get(i).getProductCode();
            row[1] = products.get(i).getProductName();
            row[2] = products.get(i).getProductBrand();
            row[3] = products.get(i).getProductPrice();
            row[4] = products.get(i).getProductQuantity();
            
            model.addRow(row);
        }
           jTableProductsDetail.setModel(model);
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
        jPanel2 = new javax.swing.JPanel();
        jLabelPwd1 = new javax.swing.JLabel();
        jLabelPwd = new javax.swing.JLabel();
        jButtonProductImage = new javax.swing.JButton();
        jLabelUsername1 = new javax.swing.JLabel();
        JLabelImage = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelPwd2 = new javax.swing.JLabel();
        jLabelUsername2 = new javax.swing.JLabel();
        jButtonAddProduct = new javax.swing.JButton();
        jButtonEditProduct = new javax.swing.JButton();
        jButtonDeleteProduct = new javax.swing.JButton();
        jButtonClearProduct = new javax.swing.JButton();
        jTextFieldProductCode = new javax.swing.JTextField();
        jTextFieldProductName = new javax.swing.JTextField();
        jTextFieldProductPrice = new javax.swing.JTextField();
        jTextFieldProductQuantity = new javax.swing.JTextField();
        jComboBoxProductBrand = new javax.swing.JComboBox<>();
        jButtonShowProductsList = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductsDetail = new javax.swing.JTable();
        jTextFieldProductSearch = new javax.swing.JTextField();
        jButtonProductSearch = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabelBack = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuHome = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register Products");

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPwd1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelPwd1.setText("Price per unit RM");
        jPanel2.add(jLabelPwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 30));

        jLabelPwd.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelPwd.setText("Product Name");
        jPanel2.add(jLabelPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 60, 110, 30));

        jButtonProductImage.setText("Choose Image");
        jButtonProductImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductImageActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonProductImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, 30));

        jLabelUsername1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelUsername1.setText("Brand");
        jPanel2.add(jLabelUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 100, 60, 30));

        JLabelImage.setBackground(new java.awt.Color(236, 236, 236));
        JLabelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JLabelImage.setOpaque(true);
        jPanel2.add(JLabelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 168, 173));

        jLabelUsername.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelUsername.setText("Product Code");
        jPanel2.add(jLabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 110, 30));

        jLabelPwd2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelPwd2.setText("Quantity");
        jPanel2.add(jLabelPwd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 180, 80, 30));

        jLabelUsername2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabelUsername2.setText("Upload Image");
        jPanel2.add(jLabelUsername2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 100, 30));

        jButtonAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/if_plus-circle_2561291.png"))); // NOI18N
        jButtonAddProduct.setText("Add");
        jButtonAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProductActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 100, -1));

        jButtonEditProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        jButtonEditProduct.setText("Edit");
        jButtonEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditProductActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEditProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 100, -1));

        jButtonDeleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        jButtonDeleteProduct.setText("Delete");
        jButtonDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteProductActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonDeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 100, -1));

        jButtonClearProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reset1.png"))); // NOI18N
        jButtonClearProduct.setText("Clear");
        jButtonClearProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearProductActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonClearProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 100, -1));
        jPanel2.add(jTextFieldProductCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 163, 32));
        jPanel2.add(jTextFieldProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 163, 32));

        jTextFieldProductPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductPriceActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 163, 32));

        jTextFieldProductQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductQuantityActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldProductQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 163, 32));

        jComboBoxProductBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CDGxConverse", "Adidas", "Balenciaga" }));
        jComboBoxProductBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProductBrandActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxProductBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 163, 30));

        jButtonShowProductsList.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonShowProductsList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_Property_25px.png"))); // NOI18N
        jButtonShowProductsList.setText("Records");
        jButtonShowProductsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowProductsListActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonShowProductsList, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 153, 100, 30));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 730, 260));

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
                .addGap(121, 121, 121)
                .addComponent(jLabel7)
                .addContainerGap(322, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 940, 50));

        jPanel7.setBackground(new java.awt.Color(153, 255, 204));
        jPanel7.setLayout(null);

        jTableProductsDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "Brand", "Price", "Quantity"
            }
        ));
        jTableProductsDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductsDetailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProductsDetail);

        jPanel7.add(jScrollPane1);
        jScrollPane1.setBounds(50, 70, 630, 100);
        jPanel7.add(jTextFieldProductSearch);
        jTextFieldProductSearch.setBounds(220, 20, 160, 32);

        jButtonProductSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search1.png"))); // NOI18N
        jButtonProductSearch.setText("Search");
        jButtonProductSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductSearchActionPerformed(evt);
            }
        });
        jPanel7.add(jButtonProductSearch);
        jButtonProductSearch.setBounds(390, 20, 110, 29);

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 730, 190));

        jPanel8.setBackground(new java.awt.Color(153, 255, 204));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 51));
        jLabel8.setText("Register Product");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, -1));

        jLabelBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Back_Arrow_50px.png"))); // NOI18N
        jLabelBack.setToolTipText("Previous page");
        jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackMouseClicked(evt);
            }
        });
        jPanel4.add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -20, 930, 590));

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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(937, 629));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHomeActionPerformed
        // TODO add your handling code here:
        new AdminHomepage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuHomeActionPerformed

    private void jComboBoxProductBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProductBrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProductBrandActionPerformed

    private void jButtonAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddProductActionPerformed
        // TODO add your handling code here:
        if (checkInputs() && Images != null)
        {
            Connection con = getConnection();
            try 
            {
                PreparedStatement ps = con.prepareStatement("Insert INTO products (ProductCode, ProductName, ProductBrand, ProductPrice, ProductQuantity, ProductImage)" + "values(?,?,?,?,?,?)");
        
                ps.setString(1, jTextFieldProductCode.getText());
                
                ps.setString(2, jTextFieldProductName.getText());
                
                String value = jComboBoxProductBrand.getSelectedItem().toString();
                ps.setString(3, value);
                
                ps.setString(4, jTextFieldProductPrice.getText());
                ps.setString(5, jTextFieldProductQuantity.getText());

            
                InputStream img = new FileInputStream(new File(Images));
                ps.setBlob(6, img);
                ps.executeUpdate();
                Show_Products_In_JTable();
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
    }//GEN-LAST:event_jButtonAddProductActionPerformed

    private void jTextFieldProductPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductPriceActionPerformed

    private void jButtonProductImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductImageActionPerformed
        // TODO add your handling code here:       
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
       
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            JLabelImage.setIcon(ResizeImage(path,null));
            Images = path;
        }
        else 
        {
            System.out.println("No file selected");
        }        
    }//GEN-LAST:event_jButtonProductImageActionPerformed

    private void jButtonShowProductsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowProductsListActionPerformed
        // TODO add your handling code here:
         Show_Products_In_JTable();       
    }//GEN-LAST:event_jButtonShowProductsListActionPerformed

    private void jButtonEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditProductActionPerformed
        // TODO add your handling code here:
        
        if (checkInputs() && jTextFieldProductCode.getText() != null)
        {
            String UpdateQuery = null; 
            PreparedStatement ps = null; 
            Connection con = getConnection();
            
            //update without image 
            if (Images == null)
            {
                try 
                {
                    UpdateQuery = "UPDATE products SET ProductName = ?, ProductBrand = ?, ProductPrice = ?, ProductQuantity =? WHERE ProductCode =?"; 
                            
                            
                    ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1, jTextFieldProductName.getText());
                    
                    String value = jComboBoxProductBrand.getSelectedItem().toString();
                    ps.setString(2, value);
                    
                    ps.setString(3, jTextFieldProductPrice.getText());
                    ps.setString(4, jTextFieldProductQuantity.getText());
    
                    ps.setInt(5, Integer.parseInt(jTextFieldProductCode.getText()));
                    ps.executeUpdate();
                    Show_Products_In_JTable();
                    JOptionPane.showMessageDialog(null, "Data updated!");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            //update with image
            else 
            {
                try 
                {
                    InputStream img = new FileInputStream(new File(Images));
                
                    UpdateQuery = "UPDATE products SET ProductName = ?, ProductBrand = ?, ProductPrice = ?, ProductQuantity =?, ProductImage = ? WHERE ProductCode =?"; 
                
                    ps = con.prepareStatement(UpdateQuery);
                    
                    ps.setString(1, jTextFieldProductName.getText());
                    
                    String value = jComboBoxProductBrand.getSelectedItem().toString();
                    ps.setString(2, value);
                    
                    ps.setString(3, jTextFieldProductPrice.getText());
                    ps.setString(4, jTextFieldProductQuantity.getText());
                    
                    ps.setBlob(5,img);
                    ps.setInt(6, Integer.parseInt(jTextFieldProductCode.getText()));
                    ps.executeUpdate();
                    Show_Products_In_JTable();
                    JOptionPane.showMessageDialog(null, "Data updated!");
                    
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
        }
        } 
        
        else 
        {
            JOptionPane.showMessageDialog(null, "One or more fields are empty or wrong");
        }        
    }//GEN-LAST:event_jButtonEditProductActionPerformed

    private void jTableProductsDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductsDetailMouseClicked
        // TODO add your handling code here:
        int index = jTableProductsDetail.getSelectedRow();
        ShowItem(index);        
    }//GEN-LAST:event_jTableProductsDetailMouseClicked

    private void jButtonDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteProductActionPerformed
        // TODO add your handling code here:
        if (!jTextFieldProductCode.getText().equals(""))
        {
            try 
            {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE ProductCode =?");
                
                
                String ObjButtons[] = {"Yes","No"};
                int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to delete this product?","Product Details",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
                if(PromptResult==JOptionPane.YES_OPTION)
                {
                    int id = Integer.parseInt(jTextFieldProductCode.getText());
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    Show_Products_In_JTable();
                   JOptionPane.showMessageDialog(null, "Product Deleted ");
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(RegisterProduct.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Product Not Deleted!");
            }
        }
        
        else 
        {
            JOptionPane.showMessageDialog(null, "Product not deleted : Hijab code to delete");
        }       
    }//GEN-LAST:event_jButtonDeleteProductActionPerformed

    private void jButtonProductSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductSearchActionPerformed
        // TODO add your handling code here:
        findProduct();
    }//GEN-LAST:event_jButtonProductSearchActionPerformed

    private void jButtonClearProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearProductActionPerformed
        // TODO add your handling code here:
        jTextFieldProductCode.setText("");
        jTextFieldProductName.setText("");
        jComboBoxProductBrand.setSelectedItem("");
        jTextFieldProductPrice.setText("");
        jTextFieldProductQuantity.setText("");
        JLabelImage.setText("");
    }//GEN-LAST:event_jButtonClearProductActionPerformed

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
        // TODO add your handling code here:
        ProductMenu p = new ProductMenu();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabelBackMouseClicked

    private void jTextFieldProductQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductQuantityActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelImage;
    private javax.swing.JButton jButtonAddProduct;
    private javax.swing.JButton jButtonClearProduct;
    private javax.swing.JButton jButtonDeleteProduct;
    private javax.swing.JButton jButtonEditProduct;
    private javax.swing.JButton jButtonProductImage;
    private javax.swing.JButton jButtonProductSearch;
    private javax.swing.JButton jButtonShowProductsList;
    private javax.swing.JComboBox<String> jComboBoxProductBrand;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelPwd;
    private javax.swing.JLabel jLabelPwd1;
    private javax.swing.JLabel jLabelPwd2;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLabelUsername1;
    private javax.swing.JLabel jLabelUsername2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductsDetail;
    private javax.swing.JTextField jTextFieldProductCode;
    private javax.swing.JTextField jTextFieldProductName;
    private javax.swing.JTextField jTextFieldProductPrice;
    private javax.swing.JTextField jTextFieldProductQuantity;
    private javax.swing.JTextField jTextFieldProductSearch;
    // End of variables declaration//GEN-END:variables
}
