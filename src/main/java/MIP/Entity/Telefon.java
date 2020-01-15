package MIP.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Telefon {
    private int telefonId;
    private String marca;
    private String model;
    private int stocare;
    private int price;

    public Telefon(){}

    public Telefon(@JsonProperty("telefonid") int telefonId,
                   @JsonProperty("marca") String marca,
                   @JsonProperty("model") String model,
                   @JsonProperty("stocare") int stocare,
                   @JsonProperty("price") int price) {
        this.telefonId = telefonId;
        this.marca = marca;
        this.model = model;
        this.stocare = stocare;
        this.price = price;
    }

    public int getTelefonId() {
        return telefonId;
    }

    public void setTelefonId(int telefonId) {
        this.telefonId = telefonId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getStocare() {
        return stocare;
    }

    public void setStocare(int stocare) {
        this.stocare = stocare;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
