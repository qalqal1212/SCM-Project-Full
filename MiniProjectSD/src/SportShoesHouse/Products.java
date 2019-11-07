/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportShoesHouse;

/**
 *
 * @author aisyahzawanah
 */
public class Products 
{
    public int ProductCode; 
    public String ProductName; 
    public String ProductBrand; 
    public float ProductPrice; 
    public int ProductQuantity	; 
    public byte[] ProductImage; 
    
    public Products(int Pcode, String Pname, String Pbrand, float Pprice, int Pquantity, byte [] Pimage)
    {
        this.ProductCode = Pcode; 
        this.ProductName = Pname; 
        this.ProductBrand = Pbrand; 
        this.ProductPrice = Pprice; 
        this.ProductQuantity = Pquantity;
        this.ProductImage = Pimage;    
    }

    Products(int aInt, String string, String string0, float parseFloat, byte[] bytes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getProductCode()
    {
        return ProductCode; 
    }
    
    public String getProductName()
    {
        return ProductName;
    }
    
    public String getProductBrand()
    {
        return ProductBrand; 
    }
    
    public float getProductPrice()
    {
        return ProductPrice; 
    }
    
    public int getProductQuantity()
    {
        return ProductQuantity; 
    }
    
    public byte[] getProductImage()
    {
        return ProductImage;
    }
}
