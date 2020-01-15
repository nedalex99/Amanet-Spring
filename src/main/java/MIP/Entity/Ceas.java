package MIP.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ceas {
    private int ceasId;
    private String model;
    private int anFabricatie;
    private int price;

    public Ceas(
            @JsonProperty("ceasid") Integer ceasId,
            @JsonProperty("model") String model,
            @JsonProperty("anfabricatie") Integer anFabricatie,
            @JsonProperty("price") int price) {
        this.ceasId = ceasId;
        this.model = model;
        this.anFabricatie = anFabricatie;
        this.price = price;
    }

    public int getCeasId() {
        return ceasId;
    }

    public void setCeasId(int ceasId) {
        this.ceasId = ceasId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
