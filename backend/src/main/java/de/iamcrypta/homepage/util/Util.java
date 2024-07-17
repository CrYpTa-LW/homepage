package de.iamcrypta.homepage.util;

import de.iamcrypta.homepage.model.SongTemp;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Util {
    public static List<SongTemp> fixSongAddedByNames(List<SongTemp> temps){

        for(SongTemp temp:temps){
            temp.setAddedBy(userIdToString(temp.getAddedBy()));
        }
        return temps;
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static String userIdToString(String id){
        return switch (id) {
            case "1192492157" -> "Leon";
            case "severin.jessen" -> "Severin";
            case "telemekel53", "finn.goossen" -> "Finn";
            case "ysmarichino" -> "Marian";
            case "jezze712" -> "Jan";
            default -> "N/A";
        };
    }

    public static List<String> getAllPlaylistUsers(){
        List<String> users = new ArrayList<>();
        users.add("1192492157");
        users.add("severin.jessen");
        users.add("telemekel53");
        users.add("finn.goossen");
        users.add("ysmarichino");
        users.add("jezze712");
        return users;
    }
}
