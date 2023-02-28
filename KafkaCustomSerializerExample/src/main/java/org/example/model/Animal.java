package org.example.model;

public class Animal {
    private String Name;
    private String color;
    private String animalType;


    @Override
    public String toString() {
        return "Animal{" +
                "Name='" + Name + '\'' +
                ", color='" + color + '\'' +
                ", animalType='" + animalType + '\'' +
                '}';
    }

    public Animal() {
    }

    public Animal(String name, String color, String animalType) {
        Name = name;
        this.color = color;
        this.animalType = animalType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
}
