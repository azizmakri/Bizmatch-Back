package com.esprit.penetrationmarketing.services.interfaces;

import com.esprit.penetrationmarketing.persistence.entity.CampagneMarketing;
import com.esprit.penetrationmarketing.persistence.entity.Contenu;
import com.esprit.penetrationmarketing.persistence.enumeration.TypeContenu;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface ContenuService {
    public Contenu AddContenu(TypeContenu type, String titre, String description, String lien, MultipartFile image, Date dateCreation, CampagneMarketing campagneMarketing);

     public Contenu save(Contenu contenu);
    public Contenu Update(Contenu contenu);

    public List<Contenu> findAll();
    public  Contenu findById(Long id);
    public boolean deleteById(Long id);
}
