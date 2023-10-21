package com.esprit.penetrationmarketing.services.implementation;

import com.esprit.penetrationmarketing.persistence.entity.CampagneMarketing;
import com.esprit.penetrationmarketing.persistence.entity.Contenu;
import com.esprit.penetrationmarketing.persistence.enumeration.TypeContenu;
import com.esprit.penetrationmarketing.repositories.ContenuRepository;
import com.esprit.penetrationmarketing.services.interfaces.CampagneMarketingService;
import com.esprit.penetrationmarketing.services.interfaces.ContenuService;
import com.esprit.penetrationmarketing.services.interfaces.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
@Service
public class ContenuServiceIMP implements ContenuService {
    @Autowired
    private ContenuRepository ContenuRepository;
    @Autowired
    private CampagneMarketingService CampagneRepository;

    @Autowired
    UploadFileService uploadFileService;

    @Value("${file.upload}")
    private String pathFile;
    @Override
    public Contenu AddContenu(TypeContenu type, String titre, String description, String lien, MultipartFile image, Date dateCreation,   CampagneMarketing campagneMarketing) {

        // Sauvegarde de l'image
        boolean fileAdded = uploadFileService.addFile(image);
        if (!fileAdded) {
            throw new RuntimeException("Erreur lors de la sauvegarde de l'image.");
        }
        String imagePath = pathFile + image.getOriginalFilename();


        // Création de l'objet OffreProduit
        Contenu contenu = new Contenu();
        contenu.setType(type);
        contenu.setTitre(titre);
        contenu.setDescription(description);
        contenu.setLien(lien);
        contenu.setImage(imagePath);
        contenu.setDateCreation(dateCreation);
        contenu.setCampagneMarketing(campagneMarketing);


        Contenu savedContenu =ContenuRepository.save(contenu);


        return savedContenu;
    }

    @Override
    public Contenu save(Contenu contenu) {
        return ContenuRepository.save(contenu);
    }

    @Override
    public Contenu Update(Contenu contenu) {
        return ContenuRepository.save(contenu);
    }

    @Override
    public List<Contenu> findAll() {
        return ContenuRepository.findAll();
    }

    @Override
    public Contenu findById(Long id) {
        return ContenuRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (ContenuRepository.existsById(id)) {
            ContenuRepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
}
