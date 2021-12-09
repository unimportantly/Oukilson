package fr.oukilson.app.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class UserTest {


    //Testing UserList methods
    @Test
    @DisplayName("Test of addUserToFriendList method, valid argument.")
    public void testAddUserToFriendListTrue(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        user.setUUID(UUID.randomUUID());
        mainUser.addUserToFriendList(user);
        Assertions.assertTrue(mainUser.getFriendList().containsKey(user.getUUID()));
    }

    @Test
    @DisplayName("Test of addUserToFriendList method, invalid argument.")
    public void testAddUserToFriendListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        user.setUUID(UUID.randomUUID());
        mainUser.addUserToFriendList(user);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addUserToFriendList(user));
    }

    @Test
    @DisplayName("Test of addUserToFriendList method, invalid argument.")
    public void testAddUserToFriendListOnOtherListException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        user.setUUID(UUID.randomUUID());
        mainUser.addUserToDeniedList(user);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addUserToFriendList(user));
    }

    @Test
    @DisplayName("Test of addUserToDeniedList method, valid argument.")
    public void testAddUserToDeniedListTrue(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        user.setUUID(UUID.randomUUID());
        mainUser.addUserToDeniedList(user);
        Assertions.assertTrue(mainUser.getDeniedList().containsKey(user.getUUID()));
    }

    @Test
    @DisplayName("Test of addUserToDeniedList method, invalid argument.")
    public void testAddUserToDeniedListOnOtherListException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        user.setUUID(UUID.randomUUID());
        mainUser.addUserToFriendList(user);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addUserToDeniedList(user));
    }



    @Test
    @DisplayName("Test of addUserToDeniedList method, invalid argument.")
    public void testAddUserToDeniedListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        user.setUUID(UUID.randomUUID());
        mainUser.addUserToDeniedList(user);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addUserToDeniedList(user));
    }


    @Test
    @DisplayName("Test of removeUserFromFriendList method, valid argument.")
    public void testRemoveUserToFriendListFalse(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        user.setUUID(UUID.randomUUID());
        mainUser.addUserToFriendList(user);
        mainUser.removeUserFromFriendList(user);
        Assertions.assertFalse(mainUser.getFriendList().containsKey(user.getUUID()));
    }

    @Test
    @DisplayName("Test of removeUserFromFriendList method, invalid argument.")
    public void testRemoveUserToFriendListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        user.setUUID(UUID.randomUUID());
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.removeUserFromFriendList(user));
    }

    @Test
    @DisplayName("Test of removeUserFromDeniedList method, valid argument.")
    public void testRemoveUserToDeniedListFalse(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        user.setUUID(UUID.randomUUID());
        mainUser.addUserToDeniedList(user);
        mainUser.removeUserFromDeniedList(user);
        Assertions.assertFalse(mainUser.getDeniedList().containsKey(user.getUUID()));
    }

    @Test
    @DisplayName("Test of removeUserFromDeniedList method, invalid argument.")
    public void testRemovedUserFromDeniedListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        user.setUUID(UUID.randomUUID());
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.removeUserFromDeniedList(user));
    }

    @Test
    @DisplayName("Test of addGameToOwnedGameList method, valid argument.")
    public void testAddGameToOwnedGameListTrue(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        game.setUUID(UUID.randomUUID());
        mainUser.addGameToOwnedGameList(game);
        Assertions.assertTrue(mainUser.getUserGameList().containsKey(game.getUUID()));
    }

    @Test
    @DisplayName("Test of addGameToOwnedGameList method, invalid argument.")
    public void testAddGameToOwnedGameListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        game.setUUID(UUID.randomUUID());
        mainUser.addGameToOwnedGameList(game);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addGameToOwnedGameList(game));
    }

    @Test
    @DisplayName("Test of removeGameFromOwnedGameList method, valid argument.")
    public void testRemoveGameFromOwnedGameListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        game.setUUID(UUID.randomUUID());
        mainUser.addGameToOwnedGameList(game);
        System.out.println(mainUser.getUserGameList());
        mainUser.removeGameFromOwnedGameList(game);
        System.out.println(mainUser.getUserGameList());
        Assertions.assertFalse(mainUser.getUserGameList().containsKey(game.getUUID()));
    }

    @Test
    @DisplayName("Test of removeGameFromOwnedGameList method, invalid argument.")
    public void testRemoveGameFromOwnedGameListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        game.setUUID(UUID.randomUUID());
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.removeGameFromOwnedGameList(game));
    }


    @Test
    @DisplayName("Test of addGameToLikedGameList method, valid argument.")
    public void testAddGameToLikedGameListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        game.setUUID(UUID.randomUUID());
        mainUser.addGameToLikedGameList(game);
        Assertions.assertTrue(mainUser.getUserLikeList().containsKey(game.getUUID()));
    }

    @Test
    @DisplayName("Test of addGameToLikedGameList method, invalid argument.")
    public void testAddGameToLikedGameListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        game.setUUID(UUID.randomUUID());
        mainUser.addGameToLikedGameList(game);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addGameToLikedGameList(game));
    }

    @Test
    @DisplayName("Test of removeGameFromLikedGameList method, valid argument.")
    public void testRemoveGameFromLikedGameListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        game.setUUID(UUID.randomUUID());
        mainUser.addGameToLikedGameList(game);
        mainUser.removeGameFromLikedGameList(game);
        Assertions.assertFalse(mainUser.getUserLikeList().containsKey(game.getUUID()));
    }

    @Test
    @DisplayName("Test of removeGameFromLikedGameList method, invalid argument.")
    public void testRemoveGameFromLikedGameListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        game.setUUID(UUID.randomUUID());
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.removeGameFromLikedGameList(game));
    }
}


