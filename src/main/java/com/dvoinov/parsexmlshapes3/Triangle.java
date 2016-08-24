package com.dvoinov.parsexmlshapes3;

import java.util.ArrayList;

/**
 * Created by Михаил on 09.10.2015.
 */
public class Triangle extends Shape {

    private ArrayList<Double> side = new ArrayList<Double>();

    public void addSide(Double side)
    {
        this.side.add(side);
    }

    public ArrayList<Double> getSide() {
        return side;
    }

    public double calcShapeArea(double sideA, double sideB, double sideC)
    {
        double p = (sideA+sideB+sideC)/2;
        double sq = Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
        sq = Math.round(sq*100);
        return sq/100;
    }

}
