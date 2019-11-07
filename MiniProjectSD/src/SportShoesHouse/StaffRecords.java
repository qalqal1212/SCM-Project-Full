/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SportShoesHouse;

/**
 *
 * @author Miit
 */
public class StaffRecords 
{
    public int ID;
    public String Name;
    public String Role; 
    public String Username;
    public String Password;
    
    public StaffRecords (int ID, String sName, String sRole, String sUsername, String sPass)
    {
        this.ID = ID; 
        this.Name = sName;
        this.Role = sRole; 
        this.Username = sUsername; 
        this.Password = sPass;
    }
    
    public int getID()
    {
        return ID; 
    }
    
    public String getName()
    {
        return Name;
    }
    
    public String getRole()
    {
        return Role;
    }
    
    public String getUsername()
    {
        return Username;
    }
    
    public String getPassword()
    {
        return Password;
    }
}
