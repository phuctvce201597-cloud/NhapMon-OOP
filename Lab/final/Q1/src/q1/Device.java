/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author Admin
 */
interface ISmartDevice {

    public String getDeviceInfo();

    public String checkStatus();
}

public abstract class Device implements ISmartDevice {

    private String deviceId;
    private String modeName;
    private String brand;
    private double price;

    public Device() {
    }

    public Device(String deviceId, String modeName, String brand, double price) {
        this.deviceId = deviceId;
        this.modeName = modeName;
        this.brand = brand;
        this.price = price;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String addData();

    @Override
    public String getDeviceInfo() {
        return "";
    }

    @Override
    public String checkStatus() {
        return "";
    }

}

class SmartPhone extends Device {

    private int storage;
    private double cameraMP;
    private boolean isOn;

    public SmartPhone() {
    }

    public SmartPhone(String deviceId, String modeName, String brand, double price, int storage, double cameraMP, boolean isOn) {
        super(deviceId, modeName, brand, price);
        this.storage = storage;
        this.cameraMP = cameraMP;
        this.isOn = isOn;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getCameraMP() {
        return cameraMP;
    }

    public void setCameraMP(double cameraMP) {
        this.cameraMP = cameraMP;
    }

    public boolean isIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    @Override
    public String addData() {
        return String.format(
                "SmartPhone(%s,%s,%s,%d GB,%.1f MP,%s,%.2f) is added",
                this.getDeviceId(),
                this.getModeName(),
                this.getBrand(),
                this.storage,
                this.cameraMP,
                this.checkStatus(),
                this.getPrice()
        );
    }

    @Override
    public String getDeviceInfo() {
       return String.format(
        "SmartPhone(%s,%s,%s,%d GB,%.1f MP,%s,$%.2f)",
        this.getDeviceId(),
        this.getModeName(),
        this.getBrand(),
        this.storage,
        this.cameraMP,
        this.checkStatus(),
        this.getPrice()
);
    }

    @Override
    public String checkStatus() {
        if (isOn == true) {
            return "On";
        } else {
            return "Off";
        }
    }

}

class Tablet extends Device {

    private double screenSize;
    private boolean hasStylus;
    private boolean isOn;

    public Tablet() {
    }

    public Tablet(String deviceId, String modeName, String brand, double price, double screenSize, boolean hasStylus, boolean isOn) {
        super(deviceId, modeName, brand, price);
        this.screenSize = screenSize;
        this.hasStylus = hasStylus;
        this.isOn = isOn;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public boolean isHasStylus() {
        return hasStylus;
    }

    public void setHasStylus(boolean hasStylus) {
        this.hasStylus = hasStylus;
    }

    public boolean isIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public String checkhasStylus() {
        if (hasStylus == true) {
            return "Stylus";
        } else {
            return "No Stylus";
        }
    }

    @Override
    public String addData() {
        return String.format("Tablet(%s,%s,%s,%.1f inch,%s,%s,%.2f) is added",
                this.getDeviceId(), this.getModeName(), this.getBrand(), this.screenSize, this.checkhasStylus(),
                this.checkStatus(), this.getPrice());
    }

    @Override
    public String getDeviceInfo() {
        return String.format("Tablet(%s,%s,%s,%.1f inch,%s,%s,$%.2f)",
                this.getDeviceId(), this.getModeName(), this.getBrand(), this.screenSize, this.checkhasStylus(),
                this.checkStatus(), this.getPrice());
    }

    @Override
    public String checkStatus() {
        if (isOn == true) {
            return "On";
        } else {
            return "Off";
        }
    }

}
