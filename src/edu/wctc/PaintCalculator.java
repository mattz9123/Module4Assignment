package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {
    private List<Room> roomList = new ArrayList<>();

    public void addRoom(double length, double width, double height) {
        Room r = new Room(width, length, height);
        roomList.add(r);
    }
    public String toString() {
        if (roomList.isEmpty()){
            return "No rooms available";
        }

        String allRooms = "";
        for (int i = 0; i < roomList.size(); i++) {
            allRooms = allRooms + roomList.get(i).getArea() + " ";
        }
        return allRooms;
    }


}
