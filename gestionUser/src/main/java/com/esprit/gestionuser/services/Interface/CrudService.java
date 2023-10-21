package com.esprit.gestionuser.services.Interface;

import com.esprit.gestionuser.persistence.entity.User;
import com.esprit.gestionuser.persistence.enumeration.Domaines;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface CrudService<T,ID>{

        List<T> retrieveAll();
    void add(T t);
    public User UpdateAvecImage(String userFirstName, String userLastName, MultipartFile image, Domaines domaines, String siteWeb, String facebook,String linkedIn,String aboutMe,String location);

    void update(T t);
    void remove(ID id);
    T retrieve(ID id);
}

