/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportShoesHouse;
import java.sql.*;

/**
 *
 * @author eyya
 */
public class MiniProjectSD {

    /**
     * @param args the command line arguments
     */
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/sportshoeshouse";
    
    public static void main(String[] args) 
    {
        SplashScreen s = new SplashScreen();
        s.setVisible(true);
        
        //Database Connection
        Connection conn = null;
        
        try
        {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.print("Connected!");  
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }
    
}
