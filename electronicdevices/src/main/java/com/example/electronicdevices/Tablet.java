package com.example.electronicdevices;
public class Tablet extends Device {
    private double batteryLife;
    private boolean hasStylus;

    public Tablet(String name, double price, double weight, double batteryLife, boolean hasStylus) {
        super(DeviceType.TABLET, name, price, weight);
        this.batteryLife = batteryLife;
        this.hasStylus = hasStylus;
    }

    @Override
    public String toString() {
        return String.format("%s (Tablet): $%.2f, %.2f kg, %.1f hrs battery life, Stylus: %s",
                getName(), getPrice(), getWeight(), batteryLife, hasStylus ? "Yes" : "No");
    }
}
