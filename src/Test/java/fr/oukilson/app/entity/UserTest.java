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

    // Testing regex => setNickname, setFirstname, setLastname, setEmail
    // => test min/max length, valid/invalid input
    @Test
    @DisplayName("Test of nickname setter, valid argument")
    public void testSetNicknameEquals(){
    User user = new User();
    user.setNickname("Jean");
    String string = "Jean";
    Assertions.assertEquals(user.getNickname(), string);
    }

    @Test
    @DisplayName("Test of nickname setter, invalid input")
    public void testSetNicknameIllegalArgumentExceptionInvalid(){
        User user = new User();
        String string = "!:zefgojo;   ";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.setNickname(string));
    }

    @Test
    @DisplayName("Test of nickname setter, too short argument")
    public void testSetNicknameIllegalArgumentExceptionTooShort(){
        User user = new User();
        String string = "Je";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.setNickname(string));
    }

    @Test
    @DisplayName("Test of nickname setter, too long argument")
    public void testSetNicknameIllegalArgumentExceptionTooLong(){
        User user = new User();
        String string = "Jeazdefgtrdyujhogkozaijdfeoihlshgziomjzqoighqzolefhlqzihejlfijqzleijflzqiejf";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.setNickname(string));
    }

    @Test
    @DisplayName("Test of firstname setter, valid argument")
    public void testSetFirstnameEquals(){
        User user = new User("Jean");
        user.setFirstName("Jean");
        String string = "Jean";
        Assertions.assertEquals(user.getFirstName(), string);
    }

    @Test
    @DisplayName("Test of firstname setter, invalid input")
    public void testSetFirstnameIllegalArgumentExceptionInvalid(){
        User user = new User("Jean");
        String string = "13578adzdg";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.setFirstName(string));
    }

    @Test
    @DisplayName("Test of firstname setter, too short argument")
    public void testSetfirstnameIllegalArgumentExceptionTooShort(){
        User user = new User("Jean");
        String string = "J";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.setFirstName(string));
    }

    @Test
    @DisplayName("Test of firstname setter, too long argument")
    public void testSetfirstnameIllegalArgumentExceptionTooLong(){
        User user = new User("Jean");
        String string = "Jeazdefgtrdyujhogkozaijdfeoihlshgziomjzqoighqzolefhlqzihejlfijqzleijflzqiejf";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.setFirstName(string));
    }

    @Test
    @DisplayName("Test of lastname setter, valid argument")
    public void testSetLastnameEquals(){
        User user = new User("Jean");
        user.setLastName("Jean");
        String string = "Jean";
        Assertions.assertEquals(user.getLastName(), string);
    }

    @Test
    @DisplayName("Test of lastname setter, invalid input")
    public void testSetLastnameIllegalArgumentExceptionInvalid(){
        User user = new User("Jean");
        String string = "13578adzdg";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.setLastName(string));
    }

    @Test
    @DisplayName("Test of lastname setter, too short argument")
    public void testSetLastnameIllegalArgumentExceptionTooShort(){
        User user = new User("Jean");
        String string = "J";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.setLastName(string));
    }

    @Test
    @DisplayName("Test of lastname setter, too long argument")
    public void testSetLastnameIllegalArgumentExceptionTooLong(){
        User user = new User("Jean");
        String string = "Jeazdefgtrdyujhogkozaijdfeoihlshgziomjzqoighqzolefhlqzihejlfijqzleijflzqiejf";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.setLastName(string));
    }

    @Test
    @DisplayName("Test of the email setter regex, valid argument")
    public void testEmailSetterNoException(){
        User user = new User("kean");
        String email = "jean@email.com";
        user.setEmail(email);
        Assertions.assertEquals(user.getEmail(), email);
    }

    @Test
    @DisplayName("Test of the email setter regex, invalid argument : too short")
    public void testEmailSetterIllegalArgumentExceptionShort() {
        User user = new User("kean");
        String email = "n@el.com";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.setEmail(email));
    }

    @Test
    @DisplayName("Test of the email setter regex, invalid argument : too long")
    public void testEmailSetterIllegalArgumentExceptionLong() {
        User user = new User("kean");
        String email = "azdazfzefgslrkgoerktglisjerlgjizlmerjglesjrgergsergserthjtyjsrgsergsgsergn@eergerhl.com";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.setEmail(email));
    }

    @Test
    @DisplayName("Test of the email setter regex, invalid argument")
    public void testEmailSetterIllegalArgumentExceptionIncorrect() {
        User user = new User("kean");
        String email = "nazfafg@elazd.c";
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                user.setEmail(email));
    }
}


