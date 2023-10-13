package tn.esprit.msclaim.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.msclaim.Entities.Claim;
import tn.esprit.msclaim.Services.ClaimService;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("/claim")
public class ClaimController {
@Autowired
    ClaimService claimService;
    @PostMapping()
    public Claim addClaim(@RequestBody Claim claim) {
        return claimService.addClaim(claim);
    }
    @PostMapping("/{claimId}/{invoiceNumber}")
    public void isClaimValid (@PathVariable Long claimId ,@PathVariable String invoiceNumber)  {
         claimService.isClaimValid(claimId,invoiceNumber);
    }

//    @PostMapping("/sendemail")
//    public void sendEmail(@RequestBody String from ,@RequestBody String to, @RequestBody String subject, @RequestBody String text) {
//
//        claimService.sendSimpleMessage(from,to, subject, text);
//        ResponseEntity.ok("Request processed successfully");
//
//    }

    @PutMapping()
    public Claim UpdateClaim(@RequestBody Claim claim) {
        return	claimService.UpdateClaim(claim);
    }

    @GetMapping("/{id}")
    public Claim retrieveclaimById(@PathVariable Long id ) {
        return	claimService.retrieveclaimById(id);
    }

    @GetMapping()
    public List<Claim> retrieveAllclaim() {
        return	claimService.retrieveAllclaim();
    }

    @DeleteMapping("/{id}")
    public Boolean DeleteClaim(@PathVariable Long id) {
        return	claimService.DeleteClaim(id);
    }
//    @PostMapping("/create")
//    public void createClaim(@RequestBody Long id) {
//        claimService.createClaim(id);
//    }



}
