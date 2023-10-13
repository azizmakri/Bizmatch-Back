package com.esprit.penetrationmarketing.services.implementation;

import com.esprit.penetrationmarketing.persistence.entity.CampagneMarketing;
import com.esprit.penetrationmarketing.persistence.entity.MesureEfficacite;
import com.esprit.penetrationmarketing.persistence.enumeration.TypeMesure;
import com.esprit.penetrationmarketing.repositories.CampagneMarketingRepository;
import com.esprit.penetrationmarketing.repositories.MesureEfficaciteRepository;
import com.esprit.penetrationmarketing.services.interfaces.MesureEfficaciteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MesureEfficaciteServiceIMP implements MesureEfficaciteService {
    @Autowired
    private MesureEfficaciteRepository  MERepository;
    @Autowired
    private CampagneMarketingRepository campagneMarketingRepository;
    @Override
    public MesureEfficacite save(MesureEfficacite mesureEfficacite) {
        return MERepository.save(mesureEfficacite);
    }

    @Override
    public MesureEfficacite Update(MesureEfficacite mesureEfficacite) {
        return MERepository.save(mesureEfficacite);
    }

    @Override
    public List<MesureEfficacite> findAll() {
        return MERepository.findAll();
    }

    @Override
    public MesureEfficacite findById(Long id) {
        return MERepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        if (MERepository.existsById(id)) {
            MERepository.deleteById(id);
            return true;
        }
        else {return false;}
    }

    @Override
    public Double calculerROI(Long campagneId) {
        CampagneMarketing campagne = campagneMarketingRepository.findById(campagneId)
                .orElseThrow(() -> new IllegalArgumentException("Campagne non trouvée"));

        Double budget = campagne.getBudget();
        List<MesureEfficacite> mesures = MERepository.findByCampagneMarketing(campagne);

        Double revenu = mesures.stream()
                .filter(m -> m.getTypeMesure() == TypeMesure.TAUX_DE_CONVERSION)
                .mapToDouble(MesureEfficacite::getValeur)
                .sum();

        return (revenu - budget) / budget * 100; // Formule simplifiée du Retour sur investissement
    }


}
