package tn.esprit.msclaim.DTOentities;

import lombok.Builder;
import lombok.Data;
//import tn.esprit.ms_facturee.Entities.FactureAvoir;

import java.io.Serializable;

/**
 * A DTO for the {@link tn.esprit.ms_facturee.Entities.Facture} entity
 */
@Data
@Builder
public class ClaimDto implements Serializable {
    private final String topicFacture;
    private final boolean archive;
    private final String reference;
    private final String priceTotal;
//    private final FactureAvoir factureAvoir;
}