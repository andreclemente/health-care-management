/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
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
@Table(name="PATIENTS",
        uniqueConstraints =@UniqueConstraint(columnNames = {"NAME"} ))
@NamedQueries({@NamedQuery(name="getAllPatients",
        query="SELECT p FROM Patient p ORDER BY p.name")})
public class Patient implements Serializable {

    @Id
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String name;

    public Patient(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public Patient() {
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
    
    
   
    
}
