package tn.esprit.msclaim.Services;

import tn.esprit.msclaim.Entities.Claim;

import java.util.List;

public interface ClaimService {
    public Claim addClaim(Claim claim);
    public Claim UpdateClaim(Claim claim);
    public Boolean DeleteClaim(Long id);
    public Claim retrieveclaimById(Long id);
    public List<Claim> retrieveAllclaim();
    //public void isClaimValid(Long claimId, String invoiceNumber) ;
    public void createClaim(Long supplierId);
    public void sendSimpleMessage(String from,String to, String subject, String text);
    public Claim validerClaimProduit(Claim claim) ;
}


