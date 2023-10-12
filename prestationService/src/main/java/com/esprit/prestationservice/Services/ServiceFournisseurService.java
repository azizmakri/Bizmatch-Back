package com.esprit.prestationservice.Services;

import com.esprit.prestationservice.Entities.ServiceFournisseur;

import java.util.List;

public interface ServiceFournisseurService {
    public List<ServiceFournisseur> getAllServices();

    ServiceFournisseur editService(ServiceFournisseur serviceFournisseur, String idUser, Long idService);

    public void deleteService(Long serviceId, String idUser);

    ServiceFournisseur addService(ServiceFournisseur serviceFournisseur, String idUser);

    public ServiceFournisseur getById(Long serviceId);
}
