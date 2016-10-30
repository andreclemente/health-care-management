/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name="CAREGIVERS",
        uniqueConstraints =@UniqueConstraint(columnNames = {"NAME"} ))
@NamedQueries({@NamedQuery(name="getAllCaregivers",
        query="SELECT c FROM Caregiver c ORDER BY c.name")})
public class Caregiver implements Serializable {

    @Id
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String name;
    private List<Patient> patients;

    public Caregiver(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.patients = new LinkedList<>();
    }

    public Caregiver() {
        this.patients = new LinkedList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    
    
    
}
