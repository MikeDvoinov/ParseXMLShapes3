package com.dvoinov.parsexmlshapes3;

/**
 * Created by Михаил on 09.10.2015.
 */
abstract class Shape {

    private String color;
    private double shapeArea;
    private long index;

    public void setColor(String color)
    {
        this.color = color;
    }
    public void setShapeArea(double shapeArea)
    {
        this.shapeArea = shapeArea;
    }
    public void setIndex(long index)
    {
        this.index = index;
    }

    public String getColor()
    {
        return color;
    }
    public double getShapeArea()
    {
        return shapeArea;
    }
    public long getIndex()
    {
        return index;
    }

    public String toString() {
        return index + ": " + color + " - " + shapeArea;
    }
}
