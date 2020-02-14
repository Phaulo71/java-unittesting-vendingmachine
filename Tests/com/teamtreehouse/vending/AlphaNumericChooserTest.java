package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AlphaNumericChooserTest {

    private AlphaNumericChooser chooser;

    @Rule
    public ExpectedException thrownException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        chooser = new AlphaNumericChooser(26, 10);
    }

    @Test
    public void validInputReturnsProperLocation() throws Exception {
        AlphaNumericChooser.Location loc = chooser.locationFromInput("B4");

        assertEquals("proper row ",1, loc.getRow());
        assertEquals("proper column",3, loc.getColumn());
    }

    // This method will expect the exception, else the test fails
    @Test(expected = InvalidLocationException.class)
    public void choosingWrongInputIsNotAllowed() throws Exception {
        // Fails the regular expression statement
        chooser.locationFromInput("WRONG!");
    }

    @Test(expected = InvalidLocationException.class)
    public void choosingLargerThanMaxIsNotAllowed() throws  Exception {
        // Fails the max value if statement
        chooser.locationFromInput("B26");
    }

    @Test
    public void constructingLargerAlphabetNotAllowed() throws Exception {
        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Maximum rows supported is 26");

        new AlphaNumericChooser(27, 10);
    }
}