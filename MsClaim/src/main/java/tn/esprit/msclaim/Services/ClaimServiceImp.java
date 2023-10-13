package tn.esprit.msclaim.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.msclaim.Entities.*;
import tn.esprit.msclaim.Repositories.ClaimRepo;
import tn.esprit.msclaim.Repositories.FactureRepo;
import tn.esprit.msclaim.Repositories.ProductRepo;
import tn.esprit.msclaim.Repositories.UserRepo;

import java.util.List;

@Service
@Slf4j
public class ClaimServiceImp implements ClaimService{
    @Autowired
    ClaimRepo claimRepo;
    @Autowired
    ProductRepo productRepo ;
   @Autowired
    UserRepo userRepo;
    @Autowired
    FactureRepo factureRepo;

    @Autowired
     JavaMailSender javaMailSender;

    @Autowired
    UserService userService;
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendSimpleMessage(String from,String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }


    @Override
    public Claim addClaim(Claim claim) {
        return claimRepo.save(claim);
    }

    @Override
    public Claim UpdateClaim(Claim claim) {
        return claimRepo.save(claim);
    }

    @Override
    public Boolean DeleteClaim(Long id) {
        if (claimRepo.existsById(id)) {
            claimRepo.deleteById(id);
            return true;
        }
        else {return false;}
    }

    @Override
    public Claim retrieveclaimById(Long id) {
        return claimRepo.findById(id).orElse(null);
    }

    @Override
    public List<Claim> retrieveAllclaim() {
        return claimRepo.findAll();
    }

   /* @Override

    public Claim validerClaimProduit(Claim claim,Long idCart) {
        // Vérifier si la récl amation est de type ClaimProduct
        if (!claim.getCategoryClaim().equals(CategoryClaim.PRODUCTCLAIM)) {
            return null;
        }

        // Récupérer le produit correspondant à l'ID de produit de la réclamation
        Product product1 = productRepo3.findById(claim.getProduct().getIdProduct()).orElse(null);
        if (product1 == null) {
             log.info("aucun produit correspondand");
        }

        // Vérifier si le produit a été précédemment commandé par le même client
        List<Cart>  carts = product.getCart();
        Product product = productRepo


        boolean hasOrderedBefore = false;
        for (Cart cart : carts) {
            if (order.getCustomer().getId() == claim.getCustomerId()) {
                hasOrderedBefore = true;
                break;
            }
        }
        if (!hasOrderedBefore) {
            return null;
        }

        // Mettre à jour le statut de la réclamation en "validee"
        claim.setStatus(ClaimStatus.VALIDEE);
        Claim updatedClaim = claimRepository.save(claim);

        return updatedClaim;
    }*/

//    public void  isClaimValid(Long claimId, String invoiceNumber) {
//        Claim claim = claimRepo.findById(claimId).orElse(null);
//        Facture facture = factureRepo.findByReference(invoiceNumber);
//        if (facture != null && facture.getClaim().equals(claim)) {
//            // Invoice number exists and is associated with the claim
//
//            claimRepo.save(claim);
//        } else {
//            // Invoice number doesn't exist or is not associated with the claim
//            claimRepo.delete(claim);
//        }
//    }

    @Override
    public void createClaim(Long supplierId) {
        User user = userService.getUserByid(supplierId);
        Claim claim = new Claim();
        claim.setUser(user);
        claimRepo.save(claim);

        List<Claim> claims = claimRepo.findByUser(user);
        if (claims.size() >= 200 ) {
            userService.blockUser(user);
            sendEmail(user.getEmail());
        }
    }
    private void sendEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email);
        message.setTo(email);
        message.setSubject("Your account has been blocked");
        message.setText("Your account has been blocked because you have hit 200 claims on our website.");
        javaMailSender.send(message);
    }

}











