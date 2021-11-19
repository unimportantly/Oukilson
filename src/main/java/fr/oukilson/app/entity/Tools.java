package fr.oukilson.app.entity;

import java.util.regex.Pattern;

public class Tools {

    //TODO ne pas renvoyer d'exceptions, renvoyer un "prédicat" -> vrai ou faux
    /**
     * method to check the validity of the email's format
     * @param emailAddress user's email
     * @return true if email is valid
     */
    public static boolean patternMatches(String emailAddress){
        boolean isMatch = false;
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
       if (Pattern.compile(regexPattern).matcher(emailAddress).matches()) {
           isMatch = true;
        }
      return isMatch;
    }

    /**
     * checks if length of param is valid( 0 < param < 46)
     * @param string string input by user(names, emails, etc)
     * @return validity of string
     */
    public static boolean checkLength(String string, int maxLength, int minLength){
        boolean isValid = string.length() <= maxLength && string.length() >= minLength;
        return isValid;
    }

    /**
     * Checks if user input contains blank spaces
     * @param string user's name
     * @return true if the name is valid
     */
    public static boolean checkBlanks(String string){
        boolean isValid = !string.contains(" ");
        return isValid;
    }

    /**
     * checks for special characters in user input
     * @param string user input
     * @return true if the string is valid
     */
    public static boolean checkSpecialCharacters(String string){
        String regexPattern = "[`~!@#$%^&*()_+[\\\\]\\\\\\\\;\\',./{}|:\\\"<>?]";
        boolean isValid = !Pattern.compile(regexPattern).matcher(string).find();
        return isValid;
    }

    /**
     * checks if there are any illegal digits in the string
     * @param string user input
     * @return true if string is valid
     */
    public static boolean checkDigits(String string){
        String regexPattern = "[0-9]";
        boolean isValid = !Pattern.compile(regexPattern).matcher(string).find();
        return isValid;
    }


    //TODO allow particles(Cecile De France)

    /**
     * check overall validity of string
     * @param string string to be checked
     * @param maxLength max acceptable length of string (in database)
     * @param minLength min acceptable length of string
     * @return true if string is valid
     */
    public static boolean checkValidString(String string, int maxLength, int minLength){
        boolean isValid = checkLength(string, maxLength, minLength) && checkBlanks(string) && checkSpecialCharacters(string);
        return isValid;
    }

    /**
     * checks for string validity
     * @param string user input
     * @param maxLength max length allowed for user input
     * @param minLength min acceptable length of string
     * @return true if input is valid
     */
    public static boolean checkValidEmailString(String string, int maxLength, int minLength) throws IllegalArgumentException{
        boolean isValid = patternMatches(string) && checkLength(string, maxLength, minLength) && checkBlanks(string);
        return isValid;
    }
    /**
     * checks if user is already on friend list
     * @param mainUser main user, trying to add a friend to list
     * @param otherUser potential friend
     * @return is already on friend list y/n
     */
    public static boolean onFriendList (User mainUser, User otherUser){
        boolean isOnList = false;
            for (User user : mainUser.getFriendList()) {
                if (otherUser.getNickname().equals(user.getNickname())) {
                    isOnList = true;
                    break;
                }
            }
        return isOnList;
    }
    /**
     * checks if user is already on denied list
     * @param mainUser main user, trying to add a denied to list
     * @param otherUser potential denied
     * @return is already on denied list y/n
     */
    public static boolean onDeniedList (User mainUser, User otherUser){
        boolean isOnList = false;
        for (User user : mainUser.getDeniedList()) {
            if (otherUser.getNickname().equals(user.getNickname())) {
                isOnList = true;
                break;
            }
        }
       return isOnList;
    }

    /**
     * check if user is on list
     * @param mainUser list owner
     * @param user potentially on list
     * @return if already on list
     * @throws IllegalArgumentException already on list
     */
    public static boolean isOnList( User mainUser, User user){
        boolean isOnList = onDeniedList(mainUser, user) && onFriendList(mainUser, user);
        return isOnList;
    }
}
