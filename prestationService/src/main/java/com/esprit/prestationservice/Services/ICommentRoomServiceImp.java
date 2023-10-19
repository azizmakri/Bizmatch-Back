package com.esprit.prestationservice.Services;

import com.esprit.prestationservice.Entities.CommentRoom;
import com.esprit.prestationservice.Entities.Room;
import com.esprit.prestationservice.Entities.User;
import com.esprit.prestationservice.Repositories.CommentRoomRepo;
import com.esprit.prestationservice.Repositories.RoomRepo;
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
public class ICommentRoomServiceImp implements ICommentRoomService{

    public final UserRepo userRepo;
    public final CommentRoomRepo commentRepo;
    public final RoomRepo roomRepo;

    private List<String> fetchBadWords() {
        List<String> badWords = new ArrayList<>();
        try {
            URL url = new URL("../../../Word_Filter - Sheet1.csv");
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
    public List<CommentRoom> getAllComments() {
        return commentRepo.findAll();
    }

    @Override
    public void deleteComment(Long commentId, String idUser) {
        User user=userRepo.findById(idUser).orElse(null);
        CommentRoom comment=commentRepo.findById(commentId).orElse(null);
        if(user!=null&&comment!=null){
            if (comment.getUser().equals(user))
                commentRepo.deleteById(commentId);
        }
    }

    @Override
    public CommentRoom addComment(CommentRoom commentRoom, String idUser, Long idRoom) {
        User user = userRepo.findById(idUser).orElse(null);
        System.out.println("id user "+idUser);
        Room room = roomRepo.findById(idRoom).orElse(null);
        System.out.println("this my idpost "+ idRoom);


        if (user != null && room != null && commentRoom.getDescriptionComment() != null) {
            String commentTextWithEmoji = convertEmoticonsToEmoji(commentRoom.getDescriptionComment());
            commentRoom.setDescriptionComment(commentTextWithEmoji);
            List<String> badWords = fetchBadWords();

            for (String badWord : badWords) {
                if (commentRoom.getDescriptionComment().toLowerCase().contains(badWord.toLowerCase())) {
                    String asterisks = String.join("", Collections.nCopies(badWord.length(), "*"));
                    commentRoom.setDescriptionComment(commentRoom.getDescriptionComment().toLowerCase().replace(badWord.toLowerCase(), asterisks));
                }
            }

            commentRoom.setUser(user);
            commentRoom.setRoom(room);
            commentRoom.setDateCreationComment(new Date());
            System.out.println("this my comment "+ commentRoom);

            return commentRepo.save(commentRoom);

        } else {
            return null;
        }
    }


}
