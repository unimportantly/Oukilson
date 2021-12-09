package fr.oukilson.app.entity;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;
import java.util.UUID;

public class ToolsTest {

    @Test
    @DisplayName("Test of regex checker, expect true")
    public void testCheckRegexTrue(){
        String regex = "^[a-zA-Z]{2,45}$";
        String firstname = "alain";
        Assertions.assertTrue(Tools.checkRegex(regex, firstname));
    }


    @Test
    @DisplayName("Test of regex checker, expect false")
    public void testCheckRegexFalse(){
        String regex = "^[a-zA-Z]{2,45}$";
        String firstname = "a";
        Assertions.assertFalse(Tools.checkRegex(regex, firstname));
    }

//TODO find out why the friend list is initialized as null instead of empty
    //TODO => making it impossible to add the first user
    @Test
    @DisplayName("Test of userOnList checker, expect true")
    public void testUserOnListTrue(){
        User user = new User("jean");
        User otherUser = new User("pierre");
        otherUser.setUUID(UUID.randomUUID());
        HashMap<UUID, User> friendList = new HashMap<>();
        friendList.put(otherUser.getUUID(), otherUser);
        user.setFriendList(friendList);
        Assertions.assertTrue(Tools.userOnList(otherUser, user.getFriendList()));
    }

    @Test
    @DisplayName("Test of userOnList checker, expect false")
    public void testUserOnListFalse(){
        User user = new User("jean");
        User otherUser = new User("pierre");
        HashMap<UUID, User> friendList = new HashMap<>();
        user.setFriendList(friendList);
        otherUser.setUUID(UUID.randomUUID());
        Assertions.assertFalse(Tools.userOnList(otherUser, user.getFriendList()));
    }

    @Test
    @DisplayName("Test of gameOnList checker, expect true")
    public void testGameOnListTrue(){
        User user = new User("jean");
        Game game = new Game("Doom");
        game.setUUID(UUID.randomUUID());
        HashMap<UUID, Game> gameList = new HashMap<>();
        gameList.put(game.getUUID(), game);
        user.setUserGameList(gameList);
        Assertions.assertTrue(Tools.gameOnList(game, user.getUserGameList()));
    }

    @Test
    @DisplayName("Test of gameOnList checker, expect false")
    public void testGameOnListFalse(){
        User user = new User("jean");
        Game game = new Game("Doom");
        game.setUUID(UUID.randomUUID());
        HashMap<UUID, Game> gameList = new HashMap<>();
        user.setUserGameList(gameList);
        Assertions.assertFalse(Tools.gameOnList(game, user.getUserGameList()));
    }
}

