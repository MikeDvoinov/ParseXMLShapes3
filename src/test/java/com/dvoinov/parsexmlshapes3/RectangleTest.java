package com.dvoinov.parsexmlshapes3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Михаил on 14.10.2015.
 */
public class RectangleTest {

    @Test
    public void testCalcShapeArea() throws Exception {

        Rectangle rectangle = new Rectangle();

        assertEquals(6.05, (float)(rectangle.calcShapeArea(2.01,3.01)), 0.001);

    }
}