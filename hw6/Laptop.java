package hw6;

import java.time.LocalDate;
import java.util.*;

public class Laptop {
    private String brandName;
    private String modelName;
    private LocalDate manufactureDate;
    private String cpu;
    private int ram;
    private int hardDiskSize;
    private String systemOS;
    private List<String> colors = new ArrayList<>();
    private int price;

    public Laptop(String brandName, String modelName, LocalDate manufactureDate, String cpu, int ram, int hardDiskSize, String systemOS, int price) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.manufactureDate = manufactureDate;
        this.cpu = cpu;
        this.ram = ram;
        this.hardDiskSize = hardDiskSize;
        this.systemOS = systemOS;
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHardDiskSize() {
        return hardDiskSize;
    }

    public void setHardDiskSize(int hardDiskSize) {
        this.hardDiskSize = hardDiskSize;
    }

    public String getSystemOS() {
        return systemOS;
    }

    public void setSystemOS(String systemOS) {
        this.systemOS = systemOS;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addColor(String color) {
        this.colors.add(color);
    }

    public String getColor() {
        return colors.toString();
    }

    @Override
    public String toString() {
        return "--- Ноутбук ---\n" + 
                "- бренд: " + brandName + "\n" +
                "- модель: " + modelName + "\n" +
                "- дата производства: " + manufactureDate + "\n" +
                "- CPU: " + cpu + "\n" +
                "- RAM: " + ram + " Gb" + "\n" +
                "- размер жесткого диска: " + hardDiskSize + " Gb" + "\n" +
                "- операционная система: " + systemOS + "\n" +
                "- цвет: " + colors.toString().replace('[', ' ').replace(']', ' ') + "\n" +
                "- цена: " + price + "\n\n";
    }

}