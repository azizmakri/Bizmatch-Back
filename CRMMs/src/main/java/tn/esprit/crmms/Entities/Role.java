package tn.esprit.CRMMs.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name = "Role")
public class Role {
    //  -------------------farouk-------------------

    @Id
    private String roleName;
    private String roleDescription;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}

