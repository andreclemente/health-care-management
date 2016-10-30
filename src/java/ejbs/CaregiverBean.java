/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entities.Caregiver;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ASUS
 */
@Stateless
public class CaregiverBean {

    @PersistenceContext
    private EntityManager em;
    
     public void createCaregiver(String username, String password, String name) {
        try {
            Caregiver caregiver = new Caregiver(username, password, name);
            em.persist(caregiver);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
     
     public void updateCaregiver(String username, String password, String name) {
        try {
            Caregiver caregiver = em.find(Caregiver.class, username);
            if (caregiver == null) {
                return;
            }
            caregiver.setPassword(password);
            caregiver.setName(name);

            em.merge(caregiver);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
     
     public List<Caregiver> getAllCaregivers() {
        try {
            List<Caregiver> caregivers = em.createNamedQuery("getAllCaregivers").getResultList();
            return caregivers;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public void removeCaregiver(String username) {
        try{
        Caregiver caregiver = em.find(Caregiver.class,username);
        if(caregiver == null){
            return;
        }
         em.remove(caregiver);
        }catch(Exception e){
            throw new EJBException(e.getMessage());
        }
    }
}
