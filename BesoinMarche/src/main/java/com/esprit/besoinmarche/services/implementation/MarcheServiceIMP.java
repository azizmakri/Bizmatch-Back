package com.esprit.besoinmarche.services.implementation;

import com.esprit.besoinmarche.persistence.entity.Besoin;
import com.esprit.besoinmarche.persistence.entity.Critere;
import com.esprit.besoinmarche.persistence.entity.Marche;
import com.esprit.besoinmarche.repositories.BesoinRepository;
import com.esprit.besoinmarche.repositories.CritereRepository;
import com.esprit.besoinmarche.repositories.MarcheRepository;
import com.esprit.besoinmarche.services.interfaces.MarcheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcheServiceIMP implements MarcheService {
    @Autowired
    private MarcheRepository MRepository;

    @Autowired
    private CritereRepository critereRepository;


    @Autowired
    private BesoinRepository besoinRepository;
    private static final double weight1 = 0.3;
    private static final double weight2 = 0.4;
    private static final double weight3 = 0.3;
    @Override
    public Marche save(Marche marche) {
        return MRepository.save(marche);
    }

    @Override
    public Marche Update(Marche marche) {
        return MRepository.save(marche);
    }

    @Override
    public List<Marche> findAll() {
        return MRepository.findAll();
    }

    @Override
    public Marche findById(Long id) {
        return MRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (MRepository.existsById(id)) {
            MRepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
@Override
    public List<Marche> findMarchesByCritere(String nom, Double valeur) {
        List<Critere> criteres = critereRepository.findByNomAndValeur(nom, valeur);
        return MRepository.findByCriteresIn(criteres);
    }
    @Override
    public List<Marche> findBestMatch(long besoinId) {
        Besoin besoin=besoinRepository.findById(besoinId).orElse(null);
        List<Marche> allMarches = MRepository.findAll();
        return allMarches.stream()
                .filter(marche -> matchMarcheWithBesoin(marche, besoin))
                .sorted(Comparator.comparingDouble(this::calculateScore).reversed())
                .collect(Collectors.toList());
    }

    private boolean matchMarcheWithBesoin(Marche marche, Besoin besoin) {
        switch (besoin.getType()) {
            case PARTENARIAT:
                return marche.getCriteres().stream()
                        .anyMatch(critere -> critere.getValeur() >= 70);
            case FOURNISSEUR:
                return marche.getCriteres().stream()
                        .anyMatch(critere -> critere.getValeur() >= 50);
            case CLIENT:
                return marche.getCriteres().stream()
                        .anyMatch(critere -> critere.getValeur() >= 30);
            default:
                return false;
        }
    }

    private double calculateScore(Marche marche) {
        double weight1 = 0.5; // Poids pour la taille
        double weight2 = 0.3; // Poids pour la croissance prévue
        double weight3 = 0.2; // Poids pour la rentabilité

        return marche.getTaille() * weight1 +
                marche.getCroissancePrevue() * weight2 +
                marche.getRentabilite() * weight3;
    }
}

