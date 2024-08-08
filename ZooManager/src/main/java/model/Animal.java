package model;

public abstract class Animal {
    private String name;
    private int legs;
    private boolean isPredator;
    private String color;
    private String location;

    public Animal(String name, int legs, boolean isPredator, String color, String location) {
        this.name = name;
        this.legs = legs;
        this.isPredator = isPredator;
        this.color = color;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public boolean isPredator() {
        return isPredator;
    }

    public void setPredator(boolean predator) {
        isPredator = predator;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "name= " + name + ", legs= " + legs + ", isPredator= " + isPredator + ", color= " + color + ", location= " + location;
    }
}
