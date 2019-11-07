/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportShoesHouse;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author MIIT
 */
public class MysqlConnect 
{
    Connection conn = null;
    
    public static Connection ConnectDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sportshoeshouse", "root", "");
            //JOptionPane.showMessageDialog(null, "Connected to Database");
            return conn;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
