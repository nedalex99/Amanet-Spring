package MIP.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bijuterie {
    private int bijuterieid;
    private String name;
    private String material;
    private int gramaj;
    private int price;

    public Bijuterie(
            @JsonProperty int bijuterieid,
            @JsonProperty String name,
            @JsonProperty String material,
            @JsonProperty int gramaj,
            @JsonProperty int price) {
        this.bijuterieid = bijuterieid;
        this.name = name;
        this.material = material;
        this.gramaj = gramaj;
        this.price = price;
    }

    public int getBijuterieid() {
        return bijuterieid;
    }

    public void setBijuterieid(int bijuterieid) {
        this.bijuterieid = bijuterieid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getGramaj() {
        return gramaj;
    }

    public void setGramaj(int gramaj) {
        this.gramaj = gramaj;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
