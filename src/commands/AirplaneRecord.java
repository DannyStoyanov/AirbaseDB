package commands;

import java.io.Serializable;

public class AirplaneRecord implements Comparable<AirplaneRecord>, Serializable {
    public int id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFlights(int flights) {
        this.flights = flights;
    }

    public String toString() {
        String space = "    ";
        return "[ID:" + this.id + space + " Name:" + this.name + space + " Type:" +  this.type + space + " Flights:" + this.flights + "]";
    }
    public int compareTo(AirplaneRecord otherRecord) {
        if(this.id > otherRecord.getId()) {
            return 1;
        } else if(this.id < otherRecord.getId()) {
            return -1;
        }
        return 0;
    }
}
