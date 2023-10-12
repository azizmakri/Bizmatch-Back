package com.esprit.gestionmarche.services.Implementation;

import com.esprit.gestionmarche.persistence.entity.DecouverteMarche;
import com.esprit.gestionmarche.persistence.entity.OpportuniteMarche;
import com.esprit.gestionmarche.repositories.DecouverteMarcheRepository;
import com.esprit.gestionmarche.repositories.OpportuniteMarcheRepository;
import com.esprit.gestionmarche.services.Interface.DecouverteMarcheService;
import com.esprit.gestionmarche.services.Interface.OpportuniteMarcheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class OpportuniteMarcheServiceIMP implements OpportuniteMarcheService {


    @Autowired
    private OpportuniteMarcheRepository OppPrepository;

    @Autowired
    private OpportuniteMarcheRepository repository;


    @Override
    public List<OpportuniteMarche> findAll() {
        return repository.findAll();
    }
    @Override
    public OpportuniteMarche save(OpportuniteMarche opportuniteMarche) {
        return repository.save(opportuniteMarche);
    }

    @Override
    public OpportuniteMarche Update(OpportuniteMarche opportuniteMarche) {
        return repository.save(opportuniteMarche);
    }


    @Override
    public OpportuniteMarche findById(Integer id)  {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        else {return false;}
    }

    @Override
    public String notif(DecouverteMarche decouverte, OpportuniteMarche opportunite) {
        String message = "Notification pour la découverte de marché: " + decouverte.getNom() + ":\n";
        message += "La meilleure opportunité est: " + opportunite.getNom() + ":\n";
        message += "Description : " + opportunite.getDescription() + "\n";
        message += "Taille du marché : " + opportunite.getTailleMarche() + "\n";
        message += "Rentabilité : " + opportunite.getRentabilite() + "\n";
        message += "Vous pouvez considérer cette opportunité." ;
        return message;
    }

@Override
    public OpportuniteMarche trouverMeilleurMatch(DecouverteMarche decouverte)  {
        OpportuniteMarche meilleurMatch = null;
        double meilleureNote = 0.0; // Initialisation à 0 pour le scoring

        List<OpportuniteMarche> opportunites = OppPrepository.findAll();

        for (OpportuniteMarche opportunite : opportunites) {
            double note = 0.0;

            if (decouverte.getNom() != null && decouverte.getNom().equals(opportunite.getNom())) {
                note += 1.0; // ajustez le poids de cette condition selon vos besoins
            }

            if (decouverte.getDescription() != null && decouverte.getDescription().equals(opportunite.getDescription())) {
                note += 1.0; // ajustez le poids de cette condition selon vos besoins
            }

            if (decouverte.getTaillePotentielle() != null && decouverte.getTaillePotentielle() <= opportunite.getTailleMarche()) {
                note += 1.0; // considère qu'une taille de marché plus grande ou égale est bénéfique
            }

            if (decouverte.getTypeService() != null && decouverte.getTypeService().equals(opportunite.getTypeService())) {
                note += 1.0; // correspondance exacte sur le type de service
            }



            if (note > meilleureNote) {
                meilleurMatch = opportunite;
                meilleureNote = note;
            }
        }

        // call the notif method to send the notification
        notif(decouverte, meilleurMatch);

        return meilleurMatch;
    }

    @Override
    public String accepterMatch(OpportuniteMarche match) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous accepter le matching ? (oui ou non)");
        String reponse = scanner.nextLine();

        if ("oui".equalsIgnoreCase(reponse)) {
            match.setAccepte(true); // Suppose que vous avez un attribut 'accepte' dans OpportuniteMarche
            OppPrepository.save(match);
            return "Matching accepté, vous pouvez procéder.";
        } else {
            match.setAccepte(false); // Suppose que vous avez un attribut 'accepte' dans OpportuniteMarche
            OppPrepository.save(match);
            return "Matching refusé.";
        }
    }
}
