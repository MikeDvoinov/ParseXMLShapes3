package com.dvoinov.parsexmlshapes3;
/**
 * Created by Михаил on 09.10.2015.
 */
public class Circle extends Shape {

    private double diameter;

    public void setDiameter(double diameter)
    {
        this.diameter = diameter;
    }

    public double getDiameter(){ return diameter; }

    public double calcShapeArea(double diameter)
    {
        double s = (Math.round(Math.PI*Math.pow(diameter/2,2)*100));
        return  s/100;
    }
}
