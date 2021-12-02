package fr.oukilson.app.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class EventTest {

    // testing the player number setter (valid(min & max), min < 2, max < 2, min > max)
    @Test
    @DisplayName("Testing the function to set the number of players, valid arguments")
    public void testSetPlayersNumberNoExceptionMin(){
        Event event = new Event ("Event 1");
        int min = 5;
        int max = 7;
        event.setPlayersNumber(min, max);
        Assertions.assertEquals(event.getMinPlayer(), min);
    }

    @Test
    @DisplayName("Testing the function to set the number of players, valid arguments")
    public void testSetPlayersNumberNoExceptionMax(){
        Event event = new Event ("Event 1");
        int min = 5;
        int max = 7;
        event.setPlayersNumber(min, max);
        Assertions.assertEquals(event.getMaxPlayer(), max);
    }

    @Test
    @DisplayName("Testing the function to set the number of players, invalid arguments : min < 2")
    public void testSetPlayersNumberIllegalArgumentExceptionMin(){
        Event event = new Event ("Event 1");
        int min = 1;
        int max = 7;
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                event.setPlayersNumber(min, max));
    }

    @Test
    @DisplayName("Testing the function to set the number of players, invalid arguments : max < 2 & min > max")
    public void testSetPlayersNumberIllegalArgumentExceptionMax(){
        Event event = new Event ("Event 1");
        int min = 5;
        int max = 1;
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                event.setPlayersNumber(min, max));
    }

    // testing setPlayersNumber function with min & max being the same (valid(min & max), minmax < 2)
    @Test
    @DisplayName("Testing the function to set the number of players if they're equal, valid arguments.")
    public void testSetPlayersNumberIfEqualNoExceptionMin(){
        Event event = new Event ("Event 1");
        int minmax = 5;
        event.setPlayersNumber(minmax);
        Assertions.assertEquals(event.getMinPlayer(), minmax);
    }

    @Test
    @DisplayName("Testing the function to set the number of players if they're equal, valid arguments.")
    public void testSetPlayersNumberIfEqualNoExceptionMax(){
        Event event = new Event ("Event 1");
        int minmax = 5;
        event.setPlayersNumber(minmax);
        Assertions.assertEquals(event.getMaxPlayer(), minmax);
    }

    @Test
    @DisplayName("Testing the function to set the number of players if they're equal, invalid argument.")
    public void testSetPlayersNumberIfEqualIllegalArgumentException(){
        Event event = new Event("Event 1");
        int minmax = 1;
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                event.setPlayersNumber(minmax));
    }

    // testing function to add a user to an event's waiting queue(valid, list > max)
    @Test
    @DisplayName("Testing the function to add a user to an event's waiting list, valid arguements : returns true")
    public void testAddUserInEventWaitingQueueAssertTrue(){
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 5, 7,false);
        User user = new User ("Jean");
        Assertions.assertTrue(event.addUserInEventWaitingQueue(user));
    }
            // TODO waiting list can't be accessed so can't check if the user is put it it
    @Test
    @DisplayName("Testing the function to add a user to an event's waiting list, valid arguements : user in queue")
    public void testAddUserInEventWaitingQueueAssertTrueUser(){
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 5, 7,false);
        User user = new User ("Jean");
        event.addUserInEventWaitingQueue(user);
        Assertions.assertEquals(event.getWaitingUsers().get(user.getUUID()), user);
    }

    @Test
    @DisplayName("Testing the function to add a user to an event's waiting list, invalid arguements(list full) : returns false")
    public void testAddUserInEventWaitingQueueAssertFalse() {
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 2, 5, false);
        User user = new User("Jean");
        User user2 = new User("Jean");
        User user3 = new User("Jean");
        User user4 = new User("Jean");
        User user5 = new User("Jean");
        User user6 = new User("Jean");
        event.addUserInEventWaitingQueue(user);
        event.addUserInEventWaitingQueue(user2);
        event.addUserInEventWaitingQueue(user3);
        event.addUserInEventWaitingQueue(user4);
        event.addUserInEventWaitingQueue(user5);
        Assertions.assertFalse(event.addUserInEventWaitingQueue(user6));
    }

    // testing function to remove a user from an event's waiting queue(valid(user removed, user wasn't in queue =>null)
    @Test
    @DisplayName("Testing the function to remove a user from an event's waiting list, valid argument, removed")
    public void testRemoveUserInEventWaitingQueue(){
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 2, 5, false);
        User user = new User("Jean");
        event.addUserInEventWaitingQueue(user);
        Assertions.assertTrue(event.removeUserInEventWaitingQueue(user.getUUID()));
        //Assertions.assertNull(event.getWaitingUsers().get(user.getUUID()));
    }

    @Test
    @DisplayName("Testing the function to remove a user from an event's waiting list, invalid argument, null")
    public void testRemoveUserInEventWaitingQueueNull() {
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 2, 5, false);
        User user = new User("Jean");
        Assertions.assertNull(event.removeUserInEventWaitingQueue(user.getUUID()));
    }

    // testing function to get a user from an event's waiting queue(valid(user gotten, user wasn't in queue =>null)
    @Test
    @DisplayName("Testing the function to get a user from an event's waiting list, valid argument, gotten")
    public void testGetUserFromEventWaitingQueue(){
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 2, 5, false);
        User user = new User("Jean");
        event.addUserInEventWaitingQueue(user);
        Assertions.assertEquals(event.getUserFromEventWaitingQueue(user.getUUID()), user);
    }

    @Test
    @DisplayName("Testing the function to get a user from an event's waiting list, invalid argument, null")
    public void testGetUserFromEventWaitingQueueNull() {
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 2, 5, false);
        User user = new User("Jean");
        Assertions.assertNull(event.getUserFromEventWaitingQueue(user.getUUID()));
    }

    // testing function to add a user to an event(valid(user in, true), false)
    @Test
    @DisplayName("Testing the function to add a user to an event, valid argument, true")
    public void testAddUserInEventTrue(){
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 2, 5, false);
        User user = new User("Jean");
        Assertions.assertTrue(event.addUserInEvent(user));
    }

    @Test
    @DisplayName("Testing the function to add a user to an event, valid argument, user in")
    public void testAddUserInEventUserIn(){
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 2, 5, false);
        User user = new User("Jean");
        event.addUserInEvent(user);
        Assertions.assertEquals(event.getRegisteredUsers().get(user.getUUID()), user);
    }

    @Test
    @DisplayName("Testing the function to add a user to an event, invalid argument, false")
    public void testAddUserInEventFalse() {
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 2, 5, false);
        User user = new User("Jean");
        User user2 = new User("Jean");
        User user3 = new User("Jean");
        User user4 = new User("Jean");
        User user5 = new User("Jean");
        User user6 = new User("Jean");
        event.addUserInEvent(user);
        event.addUserInEvent(user2);
        event.addUserInEvent(user3);
        event.addUserInEvent(user4);
        event.addUserInEvent(user5);
        Assertions.assertFalse(event.addUserInEvent(user6));
    }

    // testing function to remove a user from an event(valid(user removed), invalid(user not in queue))
    @Test
    @DisplayName("Testing the function to remove a user from an event, valid argument, user removed")
    public void testRemoveUserInEvent(){
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 2, 5, false);
        User user = new User("Jean");
        event.addUserInEvent(user);
        Assertions.assertTrue(event.removeUserInEvent(user.getUUID()));
    }

    @Test
    @DisplayName("Testing the function to remove a user from an event, valid argument, user not in queue")
    public void testRemoveUserInEventNull(){
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 2, 5, false);
        User user = new User("Jean");
        Assertions.assertNull(event.removeUserInEvent(user.getUUID()));
    }

    // testing the function to get a user from an event(valid(user in event), invalid(user not in event))
    @Test
    @DisplayName("Testing the function to get a user from an event, valid argument, user removed")
    public void testGetUserFromEvent(){
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 2, 5, false);
        User user = new User("Jean");
        event.addUserInEvent(user);
        Assertions.assertTrue(event.getUserFromEvent(user.getUUID()), user);
    }

    @Test
    @DisplayName("Testing the function to get a user from an event, valid argument, user not in queue")
    public void testGetUserFromEvent(){
        long millis = System.currentTimeMillis();
        Date creationDate = new Date((long) (millis * 0.98));
        Date startingDate = new Date(millis);
        Event event = new Event("Event 1", creationDate, startingDate, 2, 5, false);
        User user = new User("Jean");
        Assertions.assertNull(event.getUserFromEvent(user.getUUID()));
    }
}
