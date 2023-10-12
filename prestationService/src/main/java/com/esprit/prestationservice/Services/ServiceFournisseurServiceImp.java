package com.esprit.prestationservice.Services;

import com.esprit.prestationservice.Entities.ServiceFournisseur;
import com.esprit.prestationservice.Entities.User;
import com.esprit.prestationservice.Repositories.ServiceRepo;
import com.esprit.prestationservice.Repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class ServiceFournisseurServiceImp implements ServiceFournisseurService{

    public final ServiceRepo serviceRepo;
    public final UserRepo userRepo;

    private List<String> fetchBadWords() {
        List<String> badWords = new ArrayList<>();
        try {
            URL url = new URL("https://docs.google.com/spreadsheets/d/1hIEi2YG3ydav1E06Bzf2mQbGZ12kh2fe4ISgLg_UBuM/export?format=csv");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > 0) {
                    badWords.add(values[0]);
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return badWords;
    }
    public String convertEmoticonsToEmoji(String text) {
        Map<String, String> emoticonMap = new HashMap<>();
        emoticonMap.put(":)", "\uD83D\uDE42");
        emoticonMap.put(":(", "\uD83D\uDE41");
        emoticonMap.put(":D", "\uD83D\uDE00");
        emoticonMap.put(":P", "\uD83D\uDE1B");
        emoticonMap.put("<3", "\uD83D\uDC97");

        for (Map.Entry<String, String> entry : emoticonMap.entrySet()) {
            String pattern = Pattern.quote(entry.getKey()); // escape any special characters
            text = text.replaceAll(pattern, entry.getValue());
        }

        return text;
    }

    @Override
    public ServiceFournisseur addService(ServiceFournisseur serviceFournisseur, String idUser) {
        User user = userRepo.findById(idUser).orElse(null);
        System.out.println("id user "+idUser);
        if (user != null && serviceFournisseur.getDescription() != null) {
            String commentTextWithEmoji = convertEmoticonsToEmoji(serviceFournisseur.getDescription());
            serviceFournisseur.setDescription(commentTextWithEmoji);
            List<String> badWords = fetchBadWords();

            for (String badWord : badWords) {
                if (serviceFournisseur.getDescription().toLowerCase().contains(badWord.toLowerCase())) {
                    String asterisks = String.join("", Collections.nCopies(badWord.length(), "*"));
                    serviceFournisseur.setDescription(serviceFournisseur.getDescription().toLowerCase().replace(badWord.toLowerCase(), asterisks));
                }
            }

            serviceFournisseur.setFournisseur(user);
            serviceFournisseur.setDateCreation(new Date());
            System.out.println("this my comment "+ serviceFournisseur);

            return serviceRepo.save(serviceFournisseur);

        } else {
            return null;
        }
    }

    @Override
    public List<ServiceFournisseur> getAllServices() {
        return serviceRepo.findAll();
    }

    @Override
    public ServiceFournisseur editService(ServiceFournisseur serviceFournisseur, String idUser, Long idService) {
        User user =userRepo.findById(idUser).orElse(null);
        ServiceFournisseur sf =serviceRepo.findById(idService).orElse(null);
        if (sf!=null && sf.getFournisseur().equals(user)&&serviceFournisseur.getDescription()!=null){
            List<String> badWords = fetchBadWords();
            String text = serviceFournisseur.getDescription();
            for (String word : badWords) {
                if (text.toLowerCase().contains(word.toLowerCase())) {
                    return null;
                }
            }
            text = convertEmoticonsToEmoji(text);
            serviceFournisseur.setDescription(text);
            serviceFournisseur.setDateCreation(sf.getDateCreation());
            serviceFournisseur.setNbLiked(sf.getNbLiked());
            serviceFournisseur.setNbDisliked(sf.getNbDisliked());
            serviceFournisseur.setFournisseur(sf.getFournisseur());
            return serviceRepo.save(serviceFournisseur);
        }
        else return null;
    }

    @Override
    public void deleteService(Long serviceId, String idUser) {
            User user=userRepo.findById(idUser).orElse(null);
            ServiceFournisseur sf=serviceRepo.findById(serviceId).orElse(null);
            if(user!=null&&sf!=null){
                if (sf.getFournisseur().equals(user))
                    serviceRepo.deleteById(serviceId);
            }
        }


    @Override
    public ServiceFournisseur getById(Long serviceId) {
        return serviceRepo.findById(serviceId).orElse(null);
    }
}
