package fr.oukilson.app.entity;

import java.util.HashMap;
import java.util.UUID;
import java.util.regex.Pattern;

public class Tools {


/*
TODO unify all regex to compare to input(get a regex for the email(incl length & all) & another one for other strings
while putting the compile/matcher/find in another function
 */

    /**
     * compares a string of characters to a given regex and returns matching status
     * @param regex string of characters that define the accepted or *not* accepted list of chars
     * @param string string of characters we wish to check the individual characters of
     * @return true if the string is valid(conform to the regex), false if it isn't
     */
    public static boolean checkRegex(String regex, String string){
        boolean isValid = Pattern.compile(regex).matcher(string).find();
        return isValid;
    }




    public static boolean userOnList(User user, HashMap map){
        boolean isOnList = false;
        if(map.containsKey(user.getUUID())){
            isOnList = true;
        }
        return isOnList;
    }

    public static boolean gameOnList(Game game, HashMap map){
        boolean isOnList = false;
        if(map.containsKey(game.getUUID())){
            isOnList = true;
        }
        return isOnList;
    }
}
