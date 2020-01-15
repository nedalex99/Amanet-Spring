package MIP.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Laptop {
    private int laptopId;
    private String model;
    private String procesor;
    private String placaVideo;
    private int stocare;
    private int ram;
    private int price;

    public Laptop(@JsonProperty("laptopid") int laptopId,
                  @JsonProperty("model") String model,
                  @JsonProperty("procesor") String procesor,
                  @JsonProperty("placavideo") String placaVideo,
                  @JsonProperty("stocare") int stocare,
                  @JsonProperty("ram") int ram,
                  @JsonProperty("price") int price) {
        this.laptopId = laptopId;
        this.model = model;
        this.procesor = procesor;
        this.placaVideo = placaVideo;
        this.stocare = stocare;
        this.ram = ram;
        this.price = price;
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public String getPlacaVideo() {
        return placaVideo;
    }

    public void setPlacaVideo(String placaVideo) {
        this.placaVideo = placaVideo;
    }

    public int getStocare() {
        return stocare;
    }

    public void setStocare(int stocare) {
        this.stocare = stocare;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
