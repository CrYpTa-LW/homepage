package de.iamcrypta.homepage.util;

import de.iamcrypta.homepage.model.SongTemp;

import java.util.List;

public class Util {
    public static List<SongTemp> fixSongAddedByNames(List<SongTemp> temps){

        for(SongTemp temp:temps){
            switch(temp.getAddedBy()){
                case "1192492157":
                    temp.setAddedBy("Leon");
                    break;
                case "severin.jessen":
                    temp.setAddedBy("Severin");
                    break;
                case "telemekel53", "finn.goossen":
                    temp.setAddedBy("Finn");
                    break;
                case "ysmarichino":
                    temp.setAddedBy("Marian");
                    break;
            }
        }
        return temps;
    }
}
