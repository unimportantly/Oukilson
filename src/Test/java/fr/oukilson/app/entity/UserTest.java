package fr.oukilson.app.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    //Tests of nickname getter
    @Test
    @DisplayName("Test of nickname getter with a valid argument.")
    public void testNicknameGetterNoException(){
        User user = new User();
        user.setNickname("Marc");
        Assertions.assertEquals(user.getNickname(), "Marc");
    }

    //testing email getter
    @Test
    @DisplayName("Test of email getter with a valid argument.")
    public void testEmailGetterNoException(){
        User user = new User("Marc", "marc@hotmail.com");
        Assertions.assertEquals(user.getEmail(), "marc@hotmail.com");
    }

    //Testing first name getter
    @Test
    @DisplayName("Test of first getter with a valid argument.")
    public void testFirstNameGetterNoException(){
        User user = new User("Marc", "marc@hotmail.com", "marcooooo");
        Assertions.assertEquals(user.getFirstName(), "marcooooo");
    }

    //Testing last name getter
    @Test
    @DisplayName("Test of last getter with a valid argument.")
    public void testLastNameGetterNoException(){
        User user = new User("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Assertions.assertEquals(user.getLastName(), "Penaud");
    }

    //Testing UserList methods
    @Test
    @DisplayName("Test of addUserToFriendList method, valid argument.")
    public void testAddUserToFriendListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        mainUser.addUserToFriendList(user);
        Assertions.assertEquals(mainUser.getFriendList().get(0).getNickname(), user.getNickname());
    }

    @Test
    @DisplayName("Test of addUserToFriendList method, invalid argument.")
    public void testAddUserToFriendListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        mainUser.addUserToFriendList(user);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addUserToFriendList(user));
    }

    @Test
    @DisplayName("Test of addUserToFriendList method, invalid argument.")
    public void testAddUserToFriendListOnOtherListException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        mainUser.addUserToDeniedList(user);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addUserToFriendList(user));
    }

    @Test
    @DisplayName("Test of addUserToDeniedList method, valid argument.")
    public void testAddUserToDeniedListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        mainUser.addUserToDeniedList(user);
        Assertions.assertEquals(mainUser.getDeniedList().get(0).getNickname(), user.getNickname());
    }

    @Test
    @DisplayName("Test of addUserToDeniedList method, invalid argument.")
    public void testAddUserToDeniedListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        mainUser.addUserToDeniedList(user);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addUserToDeniedList(user));
    }

    @Test
    @DisplayName("Test of addUserToDeniedList method, invalid argument.")
    public void testAddUserToDeniedListOnOtherListException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        mainUser.addUserToFriendList(user);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addUserToDeniedList(user));
    }

    @Test
    @DisplayName("Test of removeUserFromFriendList method, valid argument.")
    public void testRemoveUserToFriendListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        User otherUser = new User("paul", "jpaukl@gmail.com");
        mainUser.addUserToFriendList(user);
        mainUser.removeUserFromFriendList(user);
        mainUser.addUserToFriendList(otherUser);
        Assertions.assertEquals(mainUser.getFriendList().get(0),otherUser);
    }

    @Test
    @DisplayName("Test of removeUserFromFriendList method, invalid argument.")
    public void testRemoveUserToFriendListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.removeUserFromFriendList(user));
    }

    @Test
    @DisplayName("Test of removeUserFromDeniedList method, valid argument.")
    public void testRemoveUserToDeniedListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        User otherUser = new User("paul", "jpaukl@gmail.com");
        mainUser.addUserToDeniedList(user);
        mainUser.removeUserFromDeniedList(user);
        mainUser.addUserToDeniedList(otherUser);
        Assertions.assertEquals(mainUser.getDeniedList().get(0),otherUser);
    }

    @Test
    @DisplayName("Test of removeUserFromDeniedList method, invalid argument.")
    public void testRemovedUserFromDeniedListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        User user = new User("jean", "jean@gmail.com");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.removeUserFromDeniedList(user));
    }

    @Test
    @DisplayName("Test of addGameToOwnedGameList method, valid argument.")
    public void testAddGameToOwnedGameListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        mainUser.addGameToOwnedGameList(game);
        Assertions.assertEquals(mainUser.getUserGameList().get(0).getName(), game.getName());
    }

    @Test
    @DisplayName("Test of addGameToOwnedGameList method, invalid argument.")
    public void testAddGameToOwnedGameListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        mainUser.addGameToOwnedGameList(game);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addGameToOwnedGameList(game));
    }

    @Test
    @DisplayName("Test of removeGameFromOwnedGameList method, valid argument.")
    public void testRemoveGameFromOwnedGameListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        Game otherGame = new Game("marc");
        mainUser.addGameToOwnedGameList(game);
        mainUser.removeGameFromOwnedGameList(game);
        mainUser.addGameToOwnedGameList(otherGame);
        Assertions.assertEquals(mainUser.getUserGameList().get(0),otherGame);
    }

    @Test
    @DisplayName("Test of removeGameFromOwnedGameList method, invalid argument.")
    public void testRemoveGameFromOwnedGameListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.removeGameFromOwnedGameList(game));
    }


    @Test
    @DisplayName("Test of addGameToLikedGameList method, valid argument.")
    public void testAddGameToLikedGameListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        mainUser.addGameToLikedGameList(game);
        Assertions.assertEquals(mainUser.getUserLikeList().get(0).getName(), game.getName());
    }

    @Test
    @DisplayName("Test of addGameToLikedGameList method, invalid argument.")
    public void testAddGameToLikedGameListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        mainUser.addGameToLikedGameList(game);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.addGameToLikedGameList(game));
    }

    @Test
    @DisplayName("Test of removeGameFromLikedGameList method, valid argument.")
    public void testRemoveGameFromLikedGameListNoException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        Game otherGame = new Game("marc");
        mainUser.addGameToLikedGameList(game);
        mainUser.removeGameFromLikedGameList(game);
        mainUser.addGameToLikedGameList(otherGame);
        Assertions.assertEquals(mainUser.getUserLikeList().get(0),otherGame);
    }

    @Test
    @DisplayName("Test of removeGameFromLikedGameList method, invalid argument.")
    public void testRemoveGameFromLikedGameListIllegalArgumentException(){
        User mainUser = new User ("Marc", "marc@hotmail.com", "marcooooo", "Penaud");
        Game game = new Game("jean");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                mainUser.removeGameFromLikedGameList(game));
    }
}


