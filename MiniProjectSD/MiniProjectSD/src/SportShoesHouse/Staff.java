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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author aisyahzawanah
 */
@Entity
@Table(name = "staff", catalog = "sportshoeshouse", schema = "")
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")
    , @NamedQuery(name = "Staff.findByStaffID", query = "SELECT s FROM Staff s WHERE s.ID = :ID")
    , @NamedQuery(name = "Staff.findByStaffName", query = "SELECT s FROM Staff s WHERE s.Name = :Name")
    , @NamedQuery(name = "Staff.findByStaffRole", query = "SELECT s FROM Staff s WHERE s.Role = :Role")
    , @NamedQuery(name = "Staff.findByStaffUsername", query = "SELECT s FROM Staff s WHERE s.Username = :Username")
    , @NamedQuery(name = "Staff.findByStaffPass", query = "SELECT s FROM Staff s WHERE s.Password = :Password")})
public class Staff implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer ID;
    @Basic(optional = false)
    @Column(name = "Name")
    private String Name;
    @Basic(optional = false)
    @Column(name = "Role")
    private String Role;
    @Basic(optional = false)
    @Column(name = "Username")
    private String Username;
    @Basic(optional = false)
    @Column(name = "Password")
    private String Password;

    public Staff() {
    }

    public Staff(Integer ID) {
        this.ID = ID;
    }

    public Staff(Integer ID, String Name, String Role, String Username, String Password) {
        this.ID = ID;
        this.Name = Name;
        this.Role = Role;
        this.Username = Username;
        this.Password = Password;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        Integer oldID = this.ID;
        this.ID = ID;
        changeSupport.firePropertyChange("ID", oldID, ID);
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        String oldName = this.Name;
        this.Name = Name;
        changeSupport.firePropertyChange("Name", oldName, Name);
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        String oldRole = this.Role;
        this.Role = Role;
        changeSupport.firePropertyChange("Role", oldRole, Role);
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        String oldUsername = this.Username;
        this.Username = Username;
        changeSupport.firePropertyChange("Username", oldUsername, Username);
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        String oldPassword = this.Password;
        this.Password = Password;
        changeSupport.firePropertyChange("Password", oldPassword, Password);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ID != null ? ID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.ID == null && other.ID != null) || (this.ID != null && !this.ID.equals(other.ID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SportShoesHouse.Staff[ ID=" + ID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
