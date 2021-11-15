package fr.oukilson.app.entity;

import java.util.regex.Pattern;

public class Tools {

    /**
     * method to check the validity of the email's format
     * @param emailAddress user's email
     * @return true if email is valid
     */
    public static boolean patternMatches(String emailAddress) throws IllegalArgumentException{
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
       if (!Pattern.compile(regexPattern).matcher(emailAddress).matches()) {
           throw new IllegalArgumentException("email address invalid.");
        }
      return true;
    }

    /**
     * checks if length of param is valid( 0 < param < 46)
     * @param string string input by user(names, emails, etc)
     * @return valid string
     * @throws IllegalArgumentException if string is of an invalid length
     */
    public static boolean checkLength(String string, int length) throws IllegalArgumentException{
        if (string.length() > length || string.length() <= 0) {
            throw new IllegalArgumentException ("input must be of valid length.");
        }
        return true;
    }

    /**
     * Checks if user input contains blank spaces
     * @param string user's name
     * @return true if the name has blanks and is thus invalid
     * @throws IllegalArgumentException if string contains invalid blank spaces
     */
    public static boolean checkBlanks(String string) throws IllegalArgumentException{
        if (string.contains(" ")){
            throw new IllegalArgumentException("input must not contain any blank spaces.");
        }
        return false;
    }

    /**
     * checks for special characters in user input
     * @param string user input
     * @return true is the string doesn't contain any invalid special characters
     * @throws IllegalArgumentException if the string contains special characters
     */
    public static boolean checkSpecialCharacters(String string) throws IllegalArgumentException{
        String regexPattern = "[`~!@#$%^&*()_+[\\\\]\\\\\\\\;\\',./{}|:\\\"<>?]";
        if (Pattern.compile(regexPattern).matcher(string).find()) {
            throw new IllegalArgumentException("input must not contain special characters");
        }
        return true;
    }

    /**
     * checks if there are any illegal digits in the string
     * @param string user input
     * @return true if string has digits
     * @throws IllegalArgumentException if string has any illegal digits
     */
    public static boolean checkDigits(String string) throws IllegalArgumentException {
        String regexPattern = "[0-9]";
        if (Pattern.compile(regexPattern).matcher(string).find()) {
            throw new IllegalArgumentException("input must not contain digits");
        }
        return false;
    }


    //TODO allow particles(Cecile De France)

    /**
     * checks for string validity
     * @param string user input
     * @param length max length allowed for user input
     * @return true if input is valid
     * @throws IllegalArgumentException if input is invalid
     */
    public static boolean checkValidString(String string, int length) throws IllegalArgumentException{
        boolean isValid = checkLength(string, length) && !checkBlanks(string) && checkSpecialCharacters(string);
        return isValid;
    }

    /**
     * checks for string validity
     * @param string user input
     * @param length max length allowed for user input
     * @return true if input is valid
     * @throws IllegalArgumentException if input is invalid
     */
    public static boolean checkValidEmailString(String string, int length) throws IllegalArgumentException{
        boolean isValid = checkLength(string, length) && !checkBlanks(string);
        return isValid;
    }
    /**
     * checks if user is already on friend list
     * @param mainUser main user, trying to add a friend to list
     * @param user potential friend
     * @return is already on friend list y/n
     * @throws IllegalArgumentException if user is already on friend list
     */
    public static boolean onFriendList (User mainUser, User user){
        boolean isFriend = false;
            for (int i = 0; i < mainUser.getFriendList().size(); i++) {
                if (user.getNickname().equals(mainUser.getFriendList().get(i).getNickname())) {
                    isFriend = true;
                    break;
                }
            }
        return isFriend;
    }
    /**
     * checks if user is already on denied list
     * @param mainUser main user, trying to add a denied to list
     * @param user potential denied
     * @return is already on denied list y/n
     * @throws IllegalArgumentException if user is already on denied list
     */
    public static boolean onDeniedList (User mainUser, User user){
        boolean isDenied = false;
        for (int i = 0; i < mainUser.getDeniedList().size(); i++) {
            if (user.getNickname().equals(mainUser.getDeniedList().get(i).getNickname())) {
                isDenied = true;
                break;
            }
        }
       return isDenied;
    }

    /**
     * check if user is on list
     * @param mainUser list owner
     * @param user potentially on list
     * @return if already on list
     * @throws IllegalArgumentException already on list
     */
    public static boolean isOnList( User mainUser, User user){
        boolean isOnList = onDeniedList(mainUser, user) || onFriendList(mainUser, user);
        return isOnList;
    }
}
