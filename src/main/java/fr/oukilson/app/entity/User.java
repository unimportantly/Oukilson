package fr.oukilson.app.entity;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String UID;
    private String password;
    private String firstName;
    private String lastName;
    private String email; //TODO test unicité du mail
    private String nickname; //TODO test unicité du nickname
    private Blob icon;
    private List<Token> token;
    private List<User> friendList;
    private List<User> deniedList;
    private List<Game> userGameList;
    private List<Game> userLikeList;
    private final int maxLength = 45;
    private final int minLength = 1;
    /**
     * empty constructor
     */
    public User() {
    }

    /**
     * nickname only constructor
     * @param nickname user input nickname
     * @throws IllegalArgumentException if the nickname is either too short or too long or contains illegal characters
     */
    public User(String nickname) throws IllegalArgumentException{
        this.setNickname(nickname);
        this.friendList = new ArrayList<>();
        this.deniedList = new ArrayList<>();
        this.userGameList = new ArrayList<>();
        this.userLikeList = new ArrayList<>();
    }

    /**
     * constructor with nick & email, the two basic parameters at account creation
     * @param nickname user chosen nickname
     * @param email user's email address
     * @throws IllegalArgumentException if the nickname/email is either too short or long or invalid etc
     */
    public User(String nickname,String email) throws IllegalArgumentException{
        this(nickname);
        this.setEmail(email);
        this.friendList = new ArrayList<>();
        this.deniedList = new ArrayList<>();
        this.userGameList = new ArrayList<>();
        this.userLikeList = new ArrayList<>();
    }

    /**
     * constructor with 3 arguments
     * @param firstName user's first name, can be null
     * @param email user's email
     * @param nickname user's nickname
     * @throws IllegalArgumentException too long/short, invalid input
     */
    public User(String nickname, String email, String firstName) throws IllegalArgumentException{
        this(nickname, email);
        this.setFirstName(firstName);
        this.friendList = new ArrayList<>();
        this.deniedList = new ArrayList<>();
        this.userGameList = new ArrayList<>();
        this.userLikeList = new ArrayList<>();
    }

    /**
     * constructor with 4 arguments, instantiates lists
     * @param nickname user's nickname
     * @param email user's email
     * @param firstName user's first name, can be null
     * @param lastName user's last name, can be null
     * @throws IllegalArgumentException too long or too short or invalid input
     */
    public User(String nickname, String email, String firstName, String lastName) throws IllegalArgumentException{
        this(nickname, email, firstName);
        this.setLastName(lastName);
        this.friendList = new ArrayList<>();
        this.deniedList = new ArrayList<>();
        this.userGameList = new ArrayList<>();
        this.userLikeList = new ArrayList<>();
    }

    //methods
    /**
     * method to add a user-friend to main user's friend list
     * @param user a user object to be added to the list
     * @throws IllegalArgumentException if the user is already on the friend or denied list
     */
    public void addUserToFriendList(User user) throws IllegalArgumentException{
        if(!Tools.isOnList(this, user)) {
            this.getFriendList().add(user);
        }
        else {
            throw new IllegalArgumentException("user already on a list");
        }
        this.setFriendList(this.getFriendList());
    }

    /**
     * method to add an unwanted user to main user's denied list
     * @param user a user object to be added to the list
     * @throws IllegalArgumentException if the user is already on the friend or denied list
     */
    public void addUserToDeniedList(User user) throws IllegalArgumentException{
        if(!Tools.isOnList(this, user)) {
            this.getDeniedList().add(user);
        }
        else {
            throw new IllegalArgumentException("user already denied");
        }
        this.setDeniedList(this.getDeniedList());
    }

    /**
     * method to remove a user from the friend list
     * @param user a user object to be removed from the list
     * @throws IllegalArgumentException if the user isn't on the list the main user wants to remove them from
     */
    public void removeUserFromFriendList(User user) throws IllegalArgumentException{
        if(Tools.onFriendList(this, user)) {
            this.getFriendList().remove(user);
        }
        else {
            throw new IllegalArgumentException("user is not on list.");
        }
        this.setFriendList(this.getFriendList());
    }

    /**
     * method to remove a user from the denied list
     * @param user a user object to be removed from the list
     * @throws IllegalArgumentException if the user isn't on the list the main user wants to remove them from
     */
    public void removeUserFromDeniedList(User user) throws IllegalArgumentException{
        if(Tools.onDeniedList(this, user)) {
            this.getDeniedList().remove(user);
        }
        else {
            throw new IllegalArgumentException("user is not on list.");
        }
        this.setDeniedList(this.getDeniedList());
    }

    //g&s
    /**
     * getter for user's nickname
     * @return user's nickname
     */
    public String getNickname() {
        return nickname;
    }


    /**
     * setter for a user's nickname
     * @param nickname new user nickname
     */
    public void setNickname(String nickname){

    if (Tools.checkValidString(nickname, 45, 2)) {
            this.nickname = nickname;
        }
    }

    /**
     * getter for user's email
     * @return user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter for a user's email
     * @param email user's new email
     */
    public void setEmail(String email) throws IllegalArgumentException{
        if (!Tools.patternMatches(email)) {
            throw new IllegalArgumentException("email must be valid.");
        }
        if (Tools.checkValidEmailString(email, maxLength, minLength)) {
            this.email = email;
        }
    }

    /**
     * getter for user's first name
     * @return user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter for a user's first name
     * @param firstName a user's new first name
     * @throws IllegalArgumentException if new name is too long, too short, or generally invalid
     */
    public void setFirstName(String firstName) throws IllegalArgumentException{

        if (Tools.checkValidString(firstName, maxLength, minLength) && Tools.checkDigits(firstName)) {
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("input is invalid");
        }
    }



    /**
     * getter for user's last name
     * @return user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter for a user's last name
     * @param lastName user's new last name(congrats on the wedding/divorce i guess)
     * @throws IllegalArgumentException if new name is too long, too short, or generally invalid
     */
    public void setLastName(String lastName) throws IllegalArgumentException{

        if (Tools.checkValidString(lastName, maxLength, minLength) && Tools.checkDigits(lastName)) {
            this.lastName = lastName;
        }
        else {
            throw new IllegalArgumentException("input is invalid");
        }
    }

    /**
     * getter for a user's friend list
     * @return a user's friend list
     */
    public List<User> getFriendList(){
        return friendList;
    }

    /**
     * setter for a user's friend list
     * @param friendList list of users the user's chosen as friends
     */
    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }

    /**
     * get a user's denied list
     * @return a denied list object
     */
    public List<User> getDeniedList() {
        return deniedList;
    }

    /**
     * set a denied list object
     * @param deniedList new object to replace the existing one
     */
    public void setDeniedList(List<User> deniedList) {
        this.deniedList = deniedList;
    }

    /**
     * get a user's owned game list
     * @return the list of objects
     */
    public List<Game> getUserGameList() {
        return userGameList;
    }

    /**
     * set a list of owned game objects for this user
     * @param userGameList list of objects to set
     */
    public void setUserGameList(List<Game> userGameList) {
        this.userGameList = userGameList;
    }

    /**
     * get a user's liked game list
     * @return a list of liked games objects for the user
     */
    public List<Game> getUserLikeList() {
        return userLikeList;
    }

    /**
     * set a list of liked games objects for this user
     * @param userLikeList the list of objects to set
     */
    public void setUserLikeList(List<Game> userLikeList) {
        this.userLikeList = userLikeList;
    }
}
