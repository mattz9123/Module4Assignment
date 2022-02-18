package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    private List<Wall> wallList;

    public Room (double width, double length, double height) {
        wallList = new ArrayList<>();
        Wall w = new Wall(width, height);
        Wall l = new Wall(length, height);
        wallList.add(w);
        wallList.add(w);
        wallList.add(l);
        wallList.add(l);
    }

    public double getArea () {
        return wallList.get(0).getArea() + wallList.get(1).getArea() +
                wallList.get(2).getArea() + wallList.get(3).getArea();

    }

    public String toString () {
        return Double.toString(getArea());
    }

}
