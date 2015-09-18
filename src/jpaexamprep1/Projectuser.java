/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaexamprep1;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sindt
 */
@Entity
@Table(name = "projectuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projectuser.findAll", query = "SELECT p FROM Projectuser p"),
    @NamedQuery(name = "Projectuser.findByProjectUserID", query = "SELECT p FROM Projectuser p WHERE p.projectUserID = :projectUserID"),
    @NamedQuery(name = "Projectuser.findByUsername", query = "SELECT p FROM Projectuser p WHERE p.username = :username"),
    @NamedQuery(name = "Projectuser.findByEmail", query = "SELECT p FROM Projectuser p WHERE p.email = :email"),
    @NamedQuery(name = "Projectuser.findByCreated", query = "SELECT p FROM Projectuser p WHERE p.created = :created")})
public class Projectuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "projectUser_ID")
    private Long projectUserID;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Project> projectList;

    public Projectuser() {
    }

    public Projectuser(Long projectUserID) {
        this.projectUserID = projectUserID;
    }

    public Long getProjectUserID() {
        return projectUserID;
    }

    public void setProjectUserID(Long projectUserID) {
        this.projectUserID = projectUserID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectUserID != null ? projectUserID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projectuser)) {
            return false;
        }
        Projectuser other = (Projectuser) object;
        if ((this.projectUserID == null && other.projectUserID != null) || (this.projectUserID != null && !this.projectUserID.equals(other.projectUserID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaexamprep1.Projectuser[ projectUserID=" + projectUserID + " ]";
    }
    
}
