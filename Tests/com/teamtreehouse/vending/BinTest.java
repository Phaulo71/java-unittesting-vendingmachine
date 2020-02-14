package com.teamtreehouse.vending;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BinTest {
    
    private Bin bin;

    @Rule
    public ExpectedException thrownException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        bin = new Bin(10);
    }

    @Test
    public void restockingWithDifferentItemsIsNotAllowed() throws Exception {
        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Cannot restock Cheetos with Doritos");

        bin.restock("Cheetos", 1, 100, 50);
        bin.restock("Doritos", 1, 100, 50);
    }

    @Test
    public void whenEmptyPriceIsZero() throws Exception {
        assertEquals(0, bin.getItemPrice());
    }

    @Test
    public void whenEmptyNameIsNull() throws Exception {
        assertNull(bin.getItemName());
    }

    // Test uses rules to redefine behavior in the method test
    @Test
    public void overstockingNotAllowed() throws Exception {
        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("There are only 10 spots left");

        bin.restock("Fritos", 2600, 100, 50);
    }


}