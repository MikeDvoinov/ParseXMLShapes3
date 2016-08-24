package com.dvoinov.parsexmlshapes3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Михаил on 14.10.2015.
 */
public class CircleTest {

    @Test
    public void testCalcShapeArea() throws Exception {

        Circle circle = new Circle();

        assertEquals(3.14, (float)(circle.calcShapeArea(2)), 0.001);
    }
}