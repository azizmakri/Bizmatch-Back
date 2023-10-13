package com.esprit.bizmatch.services.Implementation;

import com.esprit.bizmatch.persistence.entity.User;
import com.esprit.bizmatch.persistence.entity.UserMail;
import com.esprit.bizmatch.repositories.IUserEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class EmailServiceImpl implements IUserEmailRepository {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private VerificationTokenService verificationTokenService;

    @Override
    public void sendCodeByMail(UserMail mail) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("saebizmatch@gmail.com");
            helper.setTo(mail.getTo());
            helper.setSubject("Code Active");

            // Corps HTML de l'e-mail, avec référence à l'image attachée via son Content-ID
            String htmlMsg = "<div style='font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 50px;'>" +
                    "<div style='background-color: #ffffff; padding: 50px; border-radius: 8px; max-width: 600px; margin: auto; box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);'>" +
                    "<div style='text-align:center; margin-bottom:20px;'>" +
                    "<img src='https://i.postimg.cc/76KbDLSc/logobiz.png' alt='logo' width='100' height='100' />" +
                    "</div>" +
                    "<h1 style='color: #333333; font-size: 24px; margin-bottom: 20px; text-align:center;'>Welcome to BizMatch!</h1>" +
                    "<p style='color: #666666; font-size: 16px; line-height: 1.5; margin-bottom: 20px; text-align:center;'>Thanks for signing up. Please use the following code to complete your registration:</p>" +
                    "<p style='background-color: #709fdc; display: inline-block; padding: 10px 20px; color: #ffffff; border-radius: 4px; font-size: 18px; font-weight: bold; text-align:center;'>" + mail.getCode() + "</p>" +
                    "<p style='color: #666666; font-size: 16px; line-height: 1.5; margin-top: 20px; text-align:center;'>If you didn’t make this request, you can ignore this email.</p>" +
                    "</div></div>";


            message.setContent(htmlMsg, "text/html");

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    public void sendVerificationEmail(User user) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(user.getUserEmail());
            user.setVerificationToken(verificationTokenService.generateVerificationToken());
            helper.setSubject("Vérification du compte");

            String htmlMsg = "<div style='font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 50px;'>" +
                    "<div style='background-color: #ffffff; padding: 50px; border-radius: 8px; max-width: 600px; margin: auto; box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);'>" +
                    "<div style='text-align:center; margin-bottom:20px;'>" +
                    "<img src='https://i.postimg.cc/76KbDLSc/logobiz.png' alt='logo' width='100' height='100' />" +
                    "</div>" +
                    "<h1 style='color: #333333; font-size: 24px; margin-bottom: 20px; text-align:center;'>Bonjour " + user.getUserFirstName() + ",</h1>" +
                    "<p style='color: #666666; font-size: 16px; line-height: 1.5; margin-bottom: 20px; text-align:center;'>Veuillez cliquer sur le bouton ci-dessous pour activer votre compte :</p>" +
                    "<div style='text-align:center; margin-top:20px;'>" +
                    "<a href='http://localhost:8083/auth/activate?token=" + user.getVerificationToken() + "' style='background-color: #709fdc; display: inline-block; padding: 10px 20px; color: #ffffff; border-radius: 4px; font-size: 18px; font-weight: bold; text-decoration: none;'>Activer le compte</a>" +
                    "</div>" +
                    "</div></div>";


            message.setContent(htmlMsg, "text/html");

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }



    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

}