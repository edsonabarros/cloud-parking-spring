package online.edsonabarros.cloudparking.model;

import java.time.LocalDateTime;

public class Parking {

    private String id;
    private String license;


    private String state;
    private String model;
    private String color;
    private LocalDateTime entryDay;
    private LocalDateTime exitDay;
    private Double bill;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getEntryDay() {
        return entryDay;
    }

    public void setEntryDay(LocalDateTime entryDay) {
        this.entryDay = entryDay;
    }

    public LocalDateTime getExitDay() {
        return exitDay;
    }

    public void setExitDay(LocalDateTime exitDay) {
        this.exitDay = exitDay;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

    public Parking() {
    }

    public Parking(String id, String license, String state, String model, String color) {
        this.id = id;
        this.license = license;
        this.state = state;
        this.model = model;
        this.color = color;
    }
}
