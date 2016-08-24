package com.dvoinov.parsexmlshapes3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Михаил on 14.10.2015.
 */
public class TriangleTest {

    @Test
    public void testCalcShapeArea() throws Exception {

        Triangle triangle = new Triangle();

        double s = triangle.calcShapeArea(5,5,6);
        assertEquals(12 , s, 0.001);
    }
}