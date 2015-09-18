/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaexamprep1;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sindt
 */
@Entity
@Table(name = "task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
    @NamedQuery(name = "Task.findByTaskId", query = "SELECT t FROM Task t WHERE t.taskId = :taskId"),
    @NamedQuery(name = "Task.findByName", query = "SELECT t FROM Task t WHERE t.name = :name"),
    @NamedQuery(name = "Task.findByDescription", query = "SELECT t FROM Task t WHERE t.description = :description"),
    @NamedQuery(name = "Task.findByHoursAssigned", query = "SELECT t FROM Task t WHERE t.hoursAssigned = :hoursAssigned"),
    @NamedQuery(name = "Task.findByHoursUsed", query = "SELECT t FROM Task t WHERE t.hoursUsed = :hoursUsed"),
    @NamedQuery(name = "Task.findByProjectId", query = "SELECT t FROM Task t WHERE t.projectId = :projectId")})
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "task_id")
    private Long taskId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "hoursAssigned")
    private Integer hoursAssigned;
    @Column(name = "hoursUsed")
    private Integer hoursUsed;
    @Column(name = "project_id")
    private BigInteger projectId;

    public Task() {
    }

    public Task(Long taskId) {
        this.taskId = taskId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHoursAssigned() {
        return hoursAssigned;
    }

    public void setHoursAssigned(Integer hoursAssigned) {
        this.hoursAssigned = hoursAssigned;
    }

    public Integer getHoursUsed() {
        return hoursUsed;
    }

    public void setHoursUsed(Integer hoursUsed) {
        this.hoursUsed = hoursUsed;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaexamprep1.Task[ taskId=" + taskId + " ]";
    }
    
}
