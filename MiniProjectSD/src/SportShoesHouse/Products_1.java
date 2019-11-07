/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportShoesHouse;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

/**
 *
 * @author aisyahzawanah
 */
@Entity
@Table(name = "products", catalog = "sportshoeshouse", schema = "")
@NamedQueries({
    @NamedQuery(name = "Products_1.findAll", query = "SELECT p FROM Products_1 p")
    , @NamedQuery(name = "Products_1.findByProductCode", query = "SELECT p FROM Products_1 p WHERE p.productCode = :productCode")
    , @NamedQuery(name = "Products_1.findByProductName", query = "SELECT p FROM Products_1 p WHERE p.productName = :productName")
    , @NamedQuery(name = "Products_1.findByProductBrand", query = "SELECT p FROM Products_1 p WHERE p.productBrand = :productBrand")
    , @NamedQuery(name = "Products_1.findByProductPrice", query = "SELECT p FROM Products_1 p WHERE p.productPrice = :productPrice")
    , @NamedQuery(name = "Products_1.findByProductQuantity", query = "SELECT p FROM Products_1 p WHERE p.productQuantity = :productQuantity")})
public class Products_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductCode")
    private Integer productCode;
    @Basic(optional = false)
    @Column(name = "ProductName")
    private String productName;
    @Basic(optional = false)
    @Column(name = "ProductBrand")
    private String productBrand;
    @Basic(optional = false)
    @Column(name = "ProductPrice")
    private float productPrice;
    @Basic(optional = false)
    @Column(name = "ProductQuantity")
    private int productQuantity;
    @Basic(optional = false)
    @Lob
    @Column(name = "ProductImage")
    private byte[] productImage;
    
    public ImageIcon getImage() 
    {
        return new ImageIcon(new ImageIcon(productImage).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
    }

    public Products_1() {
    }

    public Products_1(Integer productCode) {
        this.productCode = productCode;
    }

    public Products_1(Integer productCode, String productName, String productBrand, float productPrice, int productQuantity, byte[] productImage) {
        this.productCode = productCode;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productImage = productImage;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        Integer oldProductCode = this.productCode;
        this.productCode = productCode;
        changeSupport.firePropertyChange("productCode", oldProductCode, productCode);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        String oldProductName = this.productName;
        this.productName = productName;
        changeSupport.firePropertyChange("productName", oldProductName, productName);
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        String oldProductBrand = this.productBrand;
        this.productBrand = productBrand;
        changeSupport.firePropertyChange("productBrand", oldProductBrand, productBrand);
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        float oldProductPrice = this.productPrice;
        this.productPrice = productPrice;
        changeSupport.firePropertyChange("productPrice", oldProductPrice, productPrice);
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        int oldProductQuantity = this.productQuantity;
        this.productQuantity = productQuantity;
        changeSupport.firePropertyChange("productQuantity", oldProductQuantity, productQuantity);
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        byte[] oldProductImage = this.productImage;
        this.productImage = productImage;
        changeSupport.firePropertyChange("productImage", oldProductImage, productImage);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productCode != null ? productCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products_1)) {
            return false;
        }
        Products_1 other = (Products_1) object;
        if ((this.productCode == null && other.productCode != null) || (this.productCode != null && !this.productCode.equals(other.productCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SportShoesHouse.Products_1[ productCode=" + productCode + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
