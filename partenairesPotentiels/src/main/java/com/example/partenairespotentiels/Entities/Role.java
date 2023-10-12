package com.example.partenairespotentiels.Entities;



import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "Role")
public class Role {
    @Id
    private String roleName;
    private String roleDescription;

}
