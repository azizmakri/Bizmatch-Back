package com.esprit.penetrationmarketing.rest;

import com.esprit.penetrationmarketing.persistence.entity.CampagneMarketing;
import com.esprit.penetrationmarketing.persistence.entity.Contenu;
import com.esprit.penetrationmarketing.persistence.enumeration.TypeContenu;
import com.esprit.penetrationmarketing.services.interfaces.ContenuService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/marketing")
@AllArgsConstructor
public class ContenuController {
    @Autowired
    private ContenuService contenuService;

   /* @PostMapping("/contenu/add-contenu/{idCampagne}")
    public Contenu AddContenu(@RequestBody Contenu contenu,@PathVariable Long idCampagne){
        return contenuService.AddContenu(contenu,idCampagne);
    }*/
       @PostMapping("/contenu/addavecImage")
   public ResponseEntity<Contenu> addContenu(
           @RequestParam("type") TypeContenu type,
           @RequestParam("titre") String titre,
           @RequestParam("description") String description,
           @RequestParam("lien") String lien,
           @RequestParam("image") MultipartFile image,
           @RequestParam("dateCreation") Date dateCreation,
           @RequestParam("idCampagne") Long idCampagne){

        // récupération de campagne
       CampagneMarketing campagneMarketing = new CampagneMarketing();
        campagneMarketing.setId(idCampagne);

       // appel du service pour ajouter l'offre produit
       Contenu savedContenu = contenuService.AddContenu( type,  titre,  description,  lien,  image,  dateCreation,  campagneMarketing);

       return ResponseEntity.ok(savedContenu);
   }
    @PostMapping("/contenu/add")
    public Contenu add(@RequestBody Contenu contenu) {
        return contenuService.save(contenu);
    }
    @PutMapping("/contenu/update")
    public Contenu Update(@RequestBody Contenu contenu) {
        return	contenuService.Update(contenu);
    }

    @GetMapping("/contenu/")
    public List<Contenu> getAll() {
        return contenuService.findAll();
    }

    @GetMapping("/contenu/{id}")
    public Contenu getById(@PathVariable Long id) {
        return contenuService.findById(id);
    }

    @DeleteMapping("/contenu/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return contenuService.deleteById(id);
    }

}
