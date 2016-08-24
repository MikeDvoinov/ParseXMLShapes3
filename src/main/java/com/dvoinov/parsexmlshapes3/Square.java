package com.dvoinov.parsexmlshapes3;

/**
 * Created by Михаил on 09.10.2015.
 */
public class Square extends Shape {

    private double side;

    public void setSide(double side)
    {
        this.side = side;
    }
    public double getSide(){ return side; }

    public double calcShapeArea(double side)
    {
        double s = Math.round(Math.pow(side, 2)*100);
        return s/100;
    }
}
