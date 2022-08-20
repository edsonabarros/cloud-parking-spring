package online.edsonabarros.cloudparking.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL) // NÃO MOSTRAR VALORES NULOS QUANDO PUXADOS DAQUI
public class ParkingDTO {


    private String id;
    private String license;
    private String state;
    private String model;
    private String color;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime entryDay;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
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


}
