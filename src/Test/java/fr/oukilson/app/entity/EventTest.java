package fr.oukilson.app.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventTest {

    // testing the player number setter (valid, min < 2, max < 2, min > max)
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

    // testing setPlayersNumber function with min & max being the same
    @Test
    @DisplayName("Testing the function to set the number of players if they're equal, valid arguments.")
    public void testsetPlayersNumberIfEqualNoException(){
        
    }
}
