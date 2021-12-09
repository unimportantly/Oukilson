package fr.oukilson.app.entity;

import java.sql.Blob;
import java.util.*;

public class User {

    private UUID UUID;
    private String password;
    private String firstName;
    private String lastName;
    private String email; //TODO test unicité du mail
    private String nickname; //TODO test unicité du nickname
    private Blob icon;
    private List<Token> token;
    /*
    if needs to be ordered we use a list because it has methods(?) to get first & last
    so it's good if we also just need to get a FIFO(PAPS)
    otherwise using a hashmap is better because it's faster (don't need to run through the
    entire list and then compare with the object, just compare with the key)
     */
    private HashMap<UUID, User> friendList;
    private HashMap<UUID, User> deniedList;
    private HashMap<UUID, Game> userGameList;
    private HashMap<UUID, Game> userLikeList;

    /**
     * empty constructor
     */
    public User() {
    }

    /**
     * basic constructor for testing purposes
     * @param nickname user nickname
     */
    public User(String nickname) {
        this.nickname = nickname;
    }

    /**
     * constructor with nick & email, the two basic parameters at account creation
     * @param nickname user chosen nickname
     * @param email user's email address
     * @throws IllegalArgumentException if the nickname/email is either too short or long or invalid etc
     */
    public User(String nickname,String email) throws IllegalArgumentException{
        this.setNickname(nickname);
        this.setEmail(email);
        this.friendList = new HashMap<UUID, User>();
        this.deniedList = new HashMap<UUID, User>();
        this.userGameList = new HashMap<UUID, Game>();
        this.userLikeList = new HashMap<UUID, Game>();
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
        this.friendList = new HashMap<UUID, User>();
        this.deniedList = new HashMap<UUID, User>();
        this.userGameList = new HashMap<UUID, Game>();
        this.userLikeList = new HashMap<UUID, Game>();
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
        this.friendList = new HashMap<UUID, User>();
        this.deniedList = new HashMap<UUID, User>();
        this.userGameList = new HashMap<UUID, Game>();
        this.userLikeList = new HashMap<UUID, Game>();
    }

    //methods
    /**
     * method to add a user-friend to main user's friend list
     * @param user a user object to be added to the list
     * @throws IllegalArgumentException if the user is already on the friend or denied list
     */
    public void addUserToFriendList(User user) throws IllegalArgumentException{
        if(!Tools.userOnList(user, this.getFriendList())) {
            this.getFriendList().put(user.getUUID(), user);
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
        if(!Tools.userOnList(user, this.getDeniedList())) {
            this.getDeniedList().put(user.getUUID(), user);
        }
        else {
            throw new IllegalArgumentException("user already on list");
        }
        this.setDeniedList(this.getDeniedList());
    }

    /**
     * method to add a game to a user's owned game list
     * @param game to add to the list
     * @throws IllegalArgumentException if the game's already on the list
     */
    public void addGameToOwnedGameList(Game game) throws IllegalArgumentException{
        if(!Tools.gameOnList(game, this.getUserGameList())) {
            this.getUserGameList().put(game.getUUID(), game);
        }
        else {
            throw new IllegalArgumentException("you own that game already");
        }
        this.setUserGameList(this.getUserGameList());
    }

    /**
     * method to add a game to a user's liked game list
     * @param game to add to the list
     * @throws IllegalArgumentException if the game's already on the list
     */
    public void addGameToLikedGameList(Game game) throws IllegalArgumentException{
        if(!Tools.gameOnList(game, this.getUserLikeList())) {
            this.getUserLikeList().put(game.getUUID(), game);
        }
        else {
            throw new IllegalArgumentException("you like that game already");
        }
        this.setUserLikeList(this.getUserLikeList());
    }

    /**
     * method to remove a user from the friend list
     * @param user a user object to be removed from the list
     * @throws IllegalArgumentException if the user isn't on the list the main user wants to remove them from
     */
    public void removeUserFromFriendList(User user) throws IllegalArgumentException{
        if(Tools.userOnList(user, this.getFriendList())) {
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
        if(Tools.userOnList(user, this.getDeniedList())) {
            this.getDeniedList().remove(user);
        }
        else {
            throw new IllegalArgumentException("user is not on list.");
        }
        this.setDeniedList(this.getDeniedList());
    }

    /**
     * Method to remove a game from a user's owned game list
     * @param game game to remove from the list
     * @throws IllegalArgumentException if game isn't on the list
     */
    public void removeGameFromOwnedGameList(Game game) throws IllegalArgumentException{
        if(Tools.gameOnList(game, this.getUserGameList())) {
            this.getUserGameList().remove(game);
        }
        else {
            throw new IllegalArgumentException("game is not on list.");
        }
        this.setUserGameList(this.getUserGameList());
    }

    /**
     * Method to remove a game from a user's liked game list
     * @param game game to remove from the list
     * @throws IllegalArgumentException if game isn't on the list
     */
    public void removeGameFromLikedGameList(Game game) throws IllegalArgumentException{
        if(Tools.gameOnList(game, this.getUserLikeList())) {
            this.getUserLikeList().remove(game);
        }
        else {
            throw new IllegalArgumentException("game is not on list.");
        }
        this.setUserLikeList(this.getUserLikeList());
    }




    //g&s


    public java.util.UUID getUUID() {
        return UUID;
    }

    public void setUUID(java.util.UUID UUID) {
        this.UUID = UUID;
    }

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
    public void setNickname(String nickname) throws IllegalArgumentException{
    String regex = "^[a-zA-Z0-9_-]{3,45}$";
        if (!Tools.checkRegex(regex, nickname)) {
            throw new IllegalArgumentException("username must be valid");
        }
        else {
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
        String regex = "\\b[\\w.!#$%&’*+\\/=?^`{|}~-]+@[\\w-]+(?:\\.[\\w-]+)*\\b{10,45}$";
        if (!Tools.checkRegex(regex, email)) {
            throw new IllegalArgumentException("email must be valid.");
        }
        else {
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
        String regex = "^[a-zA-Z]{2,45}$";
        if (!Tools.checkRegex(regex, firstName)) {
            throw new IllegalArgumentException("input is invalid");
        }
        else {
            this.firstName = firstName;
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
        String regex = "^[a-zA-Z]{2,45}$";
        if (!Tools.checkRegex(regex, lastName)) {
            throw new IllegalArgumentException("input is invalid");
        }
        else {
            this.lastName = lastName;
        }
    }

    /**
     * getter for a user's friend list
     * @return a user's friend list
     */
    public HashMap<UUID, User> getFriendList(){
        return friendList;
    }

    /**
     * setter for a user's friend list
     * @param friendList list of users the user's chosen as friends
     */
    public void setFriendList(HashMap<UUID, User> friendList) {
        this.friendList = friendList;
    }

    /**
     * get a user's denied list
     * @return a denied list object
     */
    public HashMap<UUID, User> getDeniedList() {
        return deniedList;
    }

    /**
     * set a denied list object
     * @param deniedList new object to replace the existing one
     */
    public void setDeniedList(HashMap<UUID, User> deniedList) {
        this.deniedList = deniedList;
    }

    /**
     * get a user's owned game list
     * @return the list of objects
     */
    public HashMap<UUID, Game> getUserGameList() {
        return userGameList;
    }

    /**
     * set a list of owned game objects for this user
     * @param userGameList list of objects to set
     */
    public void setUserGameList(HashMap<UUID, Game> userGameList) {
        this.userGameList = userGameList;
    }

    /**
     * get a user's liked game list
     * @return a list of liked games objects for the user
     */
    public HashMap<UUID, Game> getUserLikeList() {
        return userLikeList;
    }

    /**
     * set a list of liked games objects for this user
     * @param userLikeList the list of objects to set
     */
    public void setUserLikeList(HashMap<UUID, Game> userLikeList) {
        this.userLikeList = userLikeList;
    }

}
