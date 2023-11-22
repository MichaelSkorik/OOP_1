package create_java.create3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Laptop {
    private String model;
    private int ram;
    private int storageCapacity;
    private String operatingSystem;
    private String color;

    // Constructor of the class
    public Laptop(String model, int ram, int storageCapacity, String operatingSystem, String color) {
        this.model = model;
        this.ram = ram;
        this.storageCapacity = storageCapacity;
        this.operatingSystem = operatingSystem;
        this.color = color;

    }
    
    // Getters to retrieve the values of the fields
    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public void setModel(String value) {
        this.model = value;
    }

    public void setRam(int value) {
        this.ram = value;
    }

    public void setStorageCapacity(int value) {
        this.storageCapacity = value;
    }

    public void setOperatingSystem(String value) {
        this.operatingSystem = value;
    }

    public void setColor(String value) {
        this.color = value;
    }

    private String getinfo() {
        return String.format("model: %s; ram: %d; storageCapacity: %d; operatingSystem: %s; color: %s", model, ram,
                storageCapacity, operatingSystem, color);
    }

    @Override
    public String toString() {
        return getinfo();
    }
}