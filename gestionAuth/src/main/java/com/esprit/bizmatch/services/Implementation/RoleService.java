package com.esprit.bizmatch.services.Implementation;

import com.esprit.bizmatch.persistence.entity.Role;
import com.esprit.bizmatch.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService {
    @Autowired
    private RoleRepository roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}

