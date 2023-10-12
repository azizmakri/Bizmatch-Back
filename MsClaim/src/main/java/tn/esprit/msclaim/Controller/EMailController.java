package tn.esprit.msclaim.Controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.msclaim.Services.EmailService;

@RestController
@RequestMapping("/email")
public class EMailController {
    @Autowired
   EmailService emailService;





    }

