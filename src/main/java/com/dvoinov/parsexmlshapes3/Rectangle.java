package com.dvoinov.parsexmlshapes3;
import java.util.ArrayList;

/**
 * Created by Михаил on 09.10.2015.
 */
public class Rectangle extends Shape {

    private ArrayList<Double> side = new ArrayList<Double>();

    public void addSide(Double side)
    {
        this.side.add(side);
    }

    public ArrayList<Double> getSide() {
        return side;
    }

    public double calcShapeArea(double sideA, double sideB)
    {
        double s = Math.round(sideA*sideB*100);
        return  s/100;
    }
}

