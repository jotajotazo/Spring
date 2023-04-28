package com.ejercicios.SpringSesion4_5_6Ejercicios1_2_3.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "laptops")
public class Laptop {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String processor;
    private Integer ram;
    private Integer hardDrive;
    private Integer screenSize;
    private Integer screenResolution;
    private Integer batteryCapacity;
    private Double price;
    private String operatingSystem;
    private Boolean wifi;
    private Boolean bluetooth;

    // Constructores
        public Laptop() {
    }

    public Laptop(Long id, String brand, String model, String processor, Integer ram, Integer hardDrive,
                  Integer screenSize, Integer screenResolution, Integer batteryCapacity, Double price,
                  String operatingSystem, Boolean wifi, Boolean bluetooth) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.screenSize = screenSize;
        this.screenResolution = screenResolution;
        this.batteryCapacity = batteryCapacity;
        this.price = price;
        this.operatingSystem = operatingSystem;
        this.wifi = wifi;
        this.bluetooth = bluetooth;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(Integer hardDrive) {
        this.hardDrive = hardDrive;
    }

    public Integer getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Integer screenSize) {
        this.screenSize = screenSize;
    }

    public Integer getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(Integer screenResolution) {
        this.screenResolution = screenResolution;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }
}
