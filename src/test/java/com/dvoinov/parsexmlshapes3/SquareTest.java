package com.dvoinov.parsexmlshapes3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Михаил on 14.10.2015.
 */
public class SquareTest {

    @Test
    public void testCalcShapeArea() throws Exception {

        Square square = new Square();

        assertEquals(4.84,square.calcShapeArea(2.2),0.001);
    }
}