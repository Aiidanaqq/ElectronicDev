package com.example.electronicdevices;
public class Smartphone extends Device {
    private double screenSize;
    private double cameraResolution;

    public Smartphone(String name, double price, double weight, double screenSize, double cameraResolution) {
        super(DeviceType.SMARTPHONE, name, price, weight);
        this.screenSize = screenSize;
        this.cameraResolution = cameraResolution;
    }

    @Override
    public String toString() {
        return String.format("%s (Smartphone): $%.2f, %.2f kg, %.1f\" screen, %.1f MP camera",
                getName(), getPrice(), getWeight(), screenSize, cameraResolution);
    }
}
