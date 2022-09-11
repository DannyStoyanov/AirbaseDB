package commands;

import java.io.Serializable;

public class AirplaneRecord implements Serializable {
    private int id;
    private String name;
    private String type;
    private int flights;

    public AirplaneRecord() {
        this.id = 0;
        this.name = "";
        this.type = "";
        this.flights = 0;
    }

    public AirplaneRecord(int id, String name, String type, int flights) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.flights = flights;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getFlights() {
        return flights;
    }

    public String toString() {
        String space = "    ";
        return "[ID:" + this.id + space + " Plane:" + this.name + space + " Type:" +  this.type + space + " Flights:" + this.flights + "]";
    }
}
