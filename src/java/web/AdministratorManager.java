package web;


import ejbs.CaregiverBean;
import entities.Caregiver;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 *
 * @author ASUS
 */
@ManagedBean
@Named(value="administratorManager")
@SessionScoped
public class AdministratorManager implements Serializable {

    private String newUsername;
    private String newPassword;
    private String newName;
    private String newEmail;
    private Caregiver currentCaregiver;

    @EJB
    private CaregiverBean caregiverBean;
    
    private static final Logger LOGGER = Logger.getLogger("web.AdminstratorManager");
    
    public AdministratorManager() {
    }
    
    
    public String createStudent(){
        try{
            caregiverBean.createCaregiver(newUsername,newPassword,newName);
            return "index?faces-redirect=true";
        }catch(Exception e){
            LOGGER.warning("Error creating caregiver");
            return "admin_caregiver_create?faces-redirect=true";
        }
        
    }
    
    public String updateCaregiver(){
        try{
            caregiverBean.updateCaregiver(currentCaregiver.getUsername(),currentCaregiver.getPassword(),currentCaregiver.getName());
            return "index?faces-redirect=true";
        }catch(Exception e){
            LOGGER.warning("Error updating student");
            return "admin_caregivers_update?faces-redirect=true";
        }
        
    }
    
    public void removeCaregiver(ActionEvent event){
        try{
            UIParameter param = (UIParameter) event.getComponent().findComponent("deleteCaregiverId");
            String username = param.getValue().toString();
            caregiverBean.removeCaregiver(username);
        }catch(Exception e){
            LOGGER.warning("Error removing caregiver");
        }
    }
    
    public List<Caregiver> getAllCaregivers(){
        try{
            return caregiverBean.getAllCaregivers();
        }catch(Exception e){
            LOGGER.warning("Problem in method getAllCaregivers");
            return null;
        }
        
    }
    
    

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public Caregiver getCurrentCaregiver() {
        return currentCaregiver;
    }

    public void setCurrentCaregiver(Caregiver currentCaregiver) {
        this.currentCaregiver = currentCaregiver;
    }

  
    

}
