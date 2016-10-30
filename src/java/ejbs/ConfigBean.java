/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author ASUS
 */
@Singleton
@Startup
public class ConfigBean {

    @EJB
    CaregiverBean caregiverBean;
    
    @PostConstruct
    public void populateDB(){
        try{
            caregiverBean.createCaregiver("1111111", "Manuel", "Manuel");
            caregiverBean.createCaregiver("2222222", "Antonio", "António");
            caregiverBean.createCaregiver("3333333", "Ana", "Ana");
            caregiverBean.createCaregiver("4444444", "Jose", "José");
        }catch(Exception e){
            System.out.println("Error in ConfigBean");
        }
            
    }
}
