/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportShoesHouse;

import static SportShoesHouse.Ordering.jTextAreaSummary;
import static SportShoesHouse.Ordering.jTextFieldGst;
import static SportShoesHouse.Ordering.jTextFieldOverallTot;
import static SportShoesHouse.Ordering.jTextFieldSubTotal;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haiqal
 */
public class Ordering2 extends javax.swing.JFrame {

    /**
     * Creates new form Ordering2
     */
    public Ordering2() {
        initComponents();
    }

    String Images = null;
    double subtotal = 0, tax = 0, total = 0, price = 0;
    double quantity, price2;
    String paymentConvert = "";
    String sizeConvert = "";

    DecimalFormat df = new DecimalFormat("0.00");

    public Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/sportshoeshouse", "root", "");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(RegisterProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    // public boolean checkInputs()
    // {
    //    if(
    //          jTextFieldProductCode.getText() == null
    //          || jTextFieldProductName.getText() == null
    //          || jTxtBrand.getText()== null
    //           || jTextFieldProductPrice.getText() == null
    //          || jTextFieldProductQuantity.getText() == null
    //       )
    //     {
    //          return false;
    //      }
    //      else
    //      {
    //           try
    //          {
    //              Float.parseFloat(jTextFieldProductPrice.getText());
    //              return true;
    //          }
    //         catch(Exception ex)
    //         {
    //              return false;
    //           }
    //       }
    //   }    
    public ImageIcon ResizeImage(String imagePath, byte[] pic) {
        ImageIcon myImage = null;

        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(pic);
        }

        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(jLblImage.getWidth(), jLblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);

        return image;
    }

    public ArrayList<Products> getProductList() {
        ArrayList<Products> productList = new ArrayList<Products>();
        Connection con = getConnection();
        String query = "SELECT * FROM products";

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Products products;

            while (rs.next()) {
                products = new Products(rs.getInt("ProductCode"), rs.getString("ProductName"), rs.getString("ProductBrand"), Float.parseFloat(rs.getString("ProductPrice")), rs.getInt("ProductQuantity"), rs.getBytes("ProductImage"));
                productList.add(products);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegisterProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    public void Show_Products_In_JTable() {
        ArrayList<Products> list = getProductList();
        DefaultTableModel model = (DefaultTableModel) jTableProductsDetail.getModel();
        // clear jtable content
        model.setRowCount(0);
        Object[] row = new Object[6];

        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getProductCode();
            row[1] = list.get(i).getProductName();
            row[2] = list.get(i).getProductBrand();
            row[3] = list.get(i).getProductPrice();
            row[4] = list.get(i).getProductQuantity();

            model.addRow(row);
        }
    }

    public void ShowItem(int index) {
        jTextFieldProductCode.setText(Integer.toString(getProductList().get(index).getProductCode()));
        jTextFieldProductName.setText(getProductList().get(index).getProductName());
        jTxtBrand.setText(getProductList().get(index).getProductBrand());
        jTextFieldProductPrice.setText(Float.toString(getProductList().get(index).getProductPrice()));
        jTextFieldProductQuantity.setText(Integer.toString(getProductList().get(index).getProductQuantity()));
        jLblImage.setIcon(ResizeImage(null, getProductList().get(index).getProductImage()));
        jTextFieldItem.setText(getProductList().get(index).getProductName());
    }

    public ArrayList<Products> ListProduct(String ValToSearch) {
        ArrayList<Products> productList = new ArrayList<Products>();

        Statement st;
        ResultSet rs;

        try {
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM products WHERE CONCAT (ProductCode,ProductName,ProductBrand,ProductPrice,ProductQuantity) LIKE '%" + ValToSearch + "%'";
            rs = st.executeQuery(searchQuery);

            Products products;

            while (rs.next()) {
                products = new Products(rs.getInt("ProductCode"), rs.getString("ProductName"), rs.getString("ProductBrand"), Float.parseFloat(rs.getString("ProductPrice")), rs.getInt("ProductQuantity"), rs.getBytes("ProductImage"));
                productList.add(products);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return productList;
    }

    public void findProduct() {
        ArrayList<Products> products = ListProduct(jTextFieldProductSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ProductCode", "ProductName", "ProductBrand", "ProductPrice", "ProductQuantity"});
        Object[] row = new Object[6];

        for (int i = 0; i < products.size(); i++) {
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

        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jTextFieldProductSearch = new javax.swing.JTextField();
        jButtonProductSearch = new javax.swing.JButton();
        jBtnShowProducts = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLblImage = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldProductCode = new javax.swing.JTextField();
        jTextFieldProductName = new javax.swing.JTextField();
        jTextFieldProductPrice = new javax.swing.JTextField();
        jTxtBrand = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldProductQuantity = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductsDetail = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSummary = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        jLabelSize = new javax.swing.JLabel();
        jComboBoxSize = new javax.swing.JComboBox<>();
        jLabelItem = new javax.swing.JLabel();
        jButtonCalTotal = new javax.swing.JButton();
        jLabelSubTot = new javax.swing.JLabel();
        jLabelGST = new javax.swing.JLabel();
        jLabelGST1 = new javax.swing.JLabel();
        jButtonAddItem = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabelQty = new javax.swing.JLabel();
        jTextFieldQty = new javax.swing.JTextField();
        jLabelPrice = new javax.swing.JLabel();
        jLabelSize1 = new javax.swing.JLabel();
        jRadioButtonCOD = new javax.swing.JRadioButton();
        jRadioButtonOnlineBanking = new javax.swing.JRadioButton();
        jLabelCustName = new javax.swing.JLabel();
        jTextFieldCustName = new javax.swing.JTextField();
        jLabelAddress = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaAddress = new javax.swing.JTextArea();
        jTextFieldItem = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JLabel();
        jTextFieldSubTotal = new javax.swing.JLabel();
        jTextFieldGst = new javax.swing.JLabel();
        jTextFieldOverallTot = new javax.swing.JLabel();
        jButtonOrderView = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel10.setBackground(new java.awt.Color(153, 255, 204));

        jButtonProductSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        jButtonProductSearch.setText("Search");
        jButtonProductSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductSearchActionPerformed(evt);
            }
        });

        jBtnShowProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_Property_25px.png"))); // NOI18N
        jBtnShowProducts.setText("Show Products");
        jBtnShowProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShowProductsActionPerformed(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(153, 255, 204));

        jLblImage.setBackground(new java.awt.Color(236, 236, 236));
        jLblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLblImage.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel10.setText("Product Code");

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel11.setText("Product Name");

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel12.setText("Brand");

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel13.setText("Price Per Unit RM");

        jTextFieldProductCode.setEnabled(false);

        jTextFieldProductName.setEnabled(false);

        jTextFieldProductPrice.setEnabled(false);
        jTextFieldProductPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductPriceActionPerformed(evt);
            }
        });

        jTxtBrand.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel14.setText("Quantity");

        jTextFieldProductQuantity.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldProductCode)
                        .addComponent(jTextFieldProductName)
                        .addComponent(jTextFieldProductPrice)
                        .addComponent(jTxtBrand, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                    .addComponent(jTextFieldProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jTxtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(153, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        jLabel1.setText("Authentic Shoes Inventory Management System");

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel9.setText("Odering Details");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jTableProductsDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
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
        jScrollPane2.setViewportView(jTableProductsDetail);

        jPanel12.setBackground(new java.awt.Color(153, 255, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Purchase Order", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 13))); // NOI18N

        jTextAreaSummary.setColumns(20);
        jTextAreaSummary.setRows(5);
        jTextAreaSummary.setEnabled(false);
        jScrollPane1.setViewportView(jTextAreaSummary);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(153, 255, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Order", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 13))); // NOI18N

        jLabelSize.setText("Size :");

        jComboBoxSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabelItem.setText("Item:");

        jButtonCalTotal.setText("Calculate (RM)");
        jButtonCalTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalTotalActionPerformed(evt);
            }
        });

        jLabelSubTot.setText("Sub Total RM :");

        jLabelGST.setText("GST 6% RM :");

        jLabelGST1.setText("Overall Total (RM) :");

        jButtonAddItem.setText("Add More Item");
        jButtonAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddItemActionPerformed(evt);
            }
        });

        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jLabelQty.setText("Quantity:");

        jLabelPrice.setText("Price:");

        jLabelSize1.setText("Payment:");

        jRadioButtonCOD.setText("Cash-On-Delivery");

        jRadioButtonOnlineBanking.setText("Online Banking");

        jLabelCustName.setText("Customer Name:");

        jLabelAddress.setText("Address:");

        jTextAreaAddress.setColumns(20);
        jTextAreaAddress.setRows(5);
        jScrollPane3.setViewportView(jTextAreaAddress);

        jTextFieldItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldItem.setEnabled(false);

        jTextFieldPrice.setEnabled(false);

        jTextFieldSubTotal.setEnabled(false);

        jTextFieldGst.setEnabled(false);

        jTextFieldOverallTot.setEnabled(false);

        jButtonOrderView.setText("Order View");
        jButtonOrderView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrderViewActionPerformed(evt);
            }
        });

        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButtonAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCalTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelSubTot)
                                    .addComponent(jLabelPrice)
                                    .addComponent(jLabelGST)
                                    .addComponent(jLabelGST1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(jButtonBack, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonOrderView, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldGst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldOverallTot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelSize1))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelCustName)
                                    .addComponent(jLabelItem)
                                    .addComponent(jLabelQty)
                                    .addComponent(jLabelSize)
                                    .addComponent(jLabelAddress))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldQty, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jRadioButtonCOD)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonOnlineBanking))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                            .addComponent(jTextFieldCustName)
                            .addComponent(jTextFieldItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCustName)
                    .addComponent(jTextFieldCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSize1)
                    .addComponent(jRadioButtonCOD)
                    .addComponent(jRadioButtonOnlineBanking))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSize)
                    .addComponent(jComboBoxSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelItem)
                    .addComponent(jTextFieldItem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQty)
                    .addComponent(jTextFieldQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddItem)
                    .addComponent(jButtonCalTotal))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPrice)
                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSubTot)
                    .addComponent(jTextFieldSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGST)
                    .addComponent(jTextFieldGst, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabelGST1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonReset)
                            .addComponent(jButtonBack)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTextFieldOverallTot, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOrderView)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jTextFieldProductSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonProductSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnShowProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 863, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldProductSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonProductSearch)
                            .addComponent(jBtnShowProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))))
        );

        jScrollPane5.setViewportView(jPanel10);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        jMenu1.setText("Home");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonProductSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductSearchActionPerformed
        // TODO add your handling code here:
        findProduct();
    }//GEN-LAST:event_jButtonProductSearchActionPerformed

    private void jTableProductsDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductsDetailMouseClicked
        // TODO add your handling code here:
        int index = jTableProductsDetail.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_jTableProductsDetailMouseClicked

    private void jTextFieldProductPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductPriceActionPerformed

    private void jBtnShowProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShowProductsActionPerformed
        // TODO add your handling code here:
        Show_Products_In_JTable();
    }//GEN-LAST:event_jBtnShowProductsActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        dispose();
        new StaffHomepage().setVisible(true);
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonOrderViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrderViewActionPerformed
        // TODO add your handling code here:
         String UpdateQuery = null;
        PreparedStatement ps = null;
        Connection con = getConnection();
        try {
             String pcode = jTextFieldProductCode.getText();
             int  nquantity = Integer.parseInt(jTextFieldQty.getText());
             int oldquantity =Integer.parseInt(jTextFieldProductQuantity.getText());
             int newquan = oldquantity - nquantity;

            UpdateQuery = "UPDATE products SET ProductQuantity =? WHERE ProductCode =?";
            ps = con.prepareStatement(UpdateQuery);
            ps.setDouble(1, newquan);
            ps.setString(2, pcode);
            ps.executeUpdate();

        } catch (SQLException ex) {

        }
        ViewOrder v = new ViewOrder();

        ViewOrder.jLabelCustName.setText(this.jTextFieldCustName.getText());
        ViewOrder.jTextAreaAddress.setText(this.jTextAreaAddress.getText());
        ViewOrder.jLabelSummary.setText(this.jTextAreaSummary.getText());
        ViewOrder.jLabelSubTotal.setText(this.jTextFieldSubTotal.getText());
        jLabelGST.setText(this.jTextFieldGst.getText());
        ViewOrder.jLabelOvrTotal.setText(this.jTextFieldOverallTot.getText());
        v.setVisible(true);
    }//GEN-LAST:event_jButtonOrderViewActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
        jTextFieldItem.setText("");
        //     x=0;y=0;z=0;
        jTextFieldCustName.setText(null);
        jTextAreaAddress.setText(null);
        jComboBoxSize.setSelectedIndex(0);
        jTextFieldQty.setText(null);
        jTextFieldPrice.setText(null);
        jTextFieldSubTotal.setText(null);
        jTextFieldGst.setText(null);
        jTextFieldOverallTot.setText(null);
        jTextAreaSummary.setText(null);
        //      subtotal=0;
        //       tax=0;
        //       total=0;
        //       price=0;
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddItemActionPerformed
        // TODO add your handling code here:
        jComboBoxSize.setSelectedIndex(0);
        jTextFieldQty.setText("");
        jTextFieldPrice.setText("");
        jTextFieldItem.setText("");
    }//GEN-LAST:event_jButtonAddItemActionPerformed

    private void jButtonCalTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalTotalActionPerformed
        // TODO add your handling code here:
        if (jTextFieldQty.getText() != null) {

            //String UpdateQuery = null;
            //PreparedStatement ps = null;
            //Connection con = getConnection();
            try {
                if (jTextFieldItem.getText().equalsIgnoreCase("")) {

                    jTextFieldItem.requestFocus();
                    jTextFieldCustName.setText(null);
                    jTextAreaAddress.setText(null);
                    jTextFieldPrice.setText(null);
                    jTextFieldSubTotal.setText(null);
                    jTextFieldGst.setText(null);
                    jTextFieldOverallTot.setText(null);
                    jTextAreaSummary.setText(null);
                    subtotal = 0;
                    tax = 0;
                    total = 0;
                    price = 0;

                    JOptionPane.showMessageDialog(null, "Error, Please Enter Item First");//edit

                } else {
                    calculateprice();
                    subtotal = subtotal + price;
                    tax = subtotal * 0.06;
                    total = subtotal + tax;

                    jTextFieldSubTotal.setText(String.valueOf(df.format(subtotal)));
                    jTextFieldGst.setText(String.valueOf(df.format(tax)));
                    jTextFieldOverallTot.setText(String.valueOf(df.format(total)));

                    //UpdateQuery = "UPDATE products SET ProductQuantity =? WHERE ProductCode =?";
                    //ps = con.prepareStatement(UpdateQuery);
                    //ps.setString(1, jTextFieldProductQuantity.getText());
                    // ps.executeUpdate();
                    // Show_Products_In_JTable();
                }
                //} catch (SQLException ex) {

            } catch (NegativeNumberException ex){
                JOptionPane.showMessageDialog(null, "Number Must Not Be Negative!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }//GEN-LAST:event_jButtonCalTotalActionPerformed

    public double calculate(double payment) {
        quantity = Double.parseDouble((String) jTextFieldQty.getText());
        price2 = Double.parseDouble((String) jTextFieldProductPrice.getText());
        double price = (quantity * price2) + payment;
        return price;
    }

    public void calculateprice() throws NegativeNumberException {
        
        String UpdateQuery = null;
        PreparedStatement ps = null;
        Connection con = getConnection();
        try {
            
          
            double payment = 0;

            if (jRadioButtonCOD.isSelected()) {
                payment = 5;
            } else if (jRadioButtonOnlineBanking.isSelected()) {
                payment = 7.9;
            }

            price = calculate(payment);
            price = this.price;
            jTextFieldPrice.setText(String.valueOf(price));

            if (payment == 5) {
                paymentConvert = "Cash-On-Delivery : RM5.00 ";
            } else if (payment == 7.9) {
                paymentConvert = "Online Banking :RM7.90";
            } else {

            }
              if(quantity < 1){
                throw new NegativeNumberException();
            }

            
            
            jTextAreaSummary.append("\n" + String.valueOf(jTextFieldItem.getText()) + "\t  x  " + quantity + "\tSize :" + jComboBoxSize.getSelectedItem()
                    + "\t\t Total Price : RM  " + df.format(price) + "\t" + paymentConvert);

            UpdateQuery = "UPDATE products SET ProductQuantity =? WHERE ProductCode =?";
            ps = con.prepareStatement(UpdateQuery);
            ps.setDouble(1, payment);
            ps.setString(2, jTextFieldQty.getText());
            ps.executeUpdate();
            Show_Products_In_JTable();

            

        } catch (SQLException ex) {

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
            java.util.logging.Logger.getLogger(Ordering2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ordering2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ordering2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ordering2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ordering2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnShowProducts;
    private javax.swing.JButton jButtonAddItem;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonCalTotal;
    private javax.swing.JButton jButtonOrderView;
    private javax.swing.JButton jButtonProductSearch;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JComboBox<String> jComboBoxSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelCustName;
    private javax.swing.JLabel jLabelGST;
    private javax.swing.JLabel jLabelGST1;
    private javax.swing.JLabel jLabelItem;
    private javax.swing.JLabel jLabelPrice;
    private javax.swing.JLabel jLabelQty;
    private javax.swing.JLabel jLabelSize;
    private javax.swing.JLabel jLabelSize1;
    private javax.swing.JLabel jLabelSubTot;
    private javax.swing.JLabel jLblImage;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButtonCOD;
    private javax.swing.JRadioButton jRadioButtonOnlineBanking;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableProductsDetail;
    public static javax.swing.JTextArea jTextAreaAddress;
    public static javax.swing.JTextArea jTextAreaSummary;
    public static javax.swing.JTextField jTextFieldCustName;
    public static javax.swing.JLabel jTextFieldGst;
    private javax.swing.JLabel jTextFieldItem;
    public static javax.swing.JLabel jTextFieldOverallTot;
    private javax.swing.JLabel jTextFieldPrice;
    private javax.swing.JTextField jTextFieldProductCode;
    private javax.swing.JTextField jTextFieldProductName;
    private javax.swing.JTextField jTextFieldProductPrice;
    private javax.swing.JTextField jTextFieldProductQuantity;
    private javax.swing.JTextField jTextFieldProductSearch;
    private javax.swing.JTextField jTextFieldQty;
    public static javax.swing.JLabel jTextFieldSubTotal;
    private javax.swing.JTextField jTxtBrand;
    // End of variables declaration//GEN-END:variables
}
