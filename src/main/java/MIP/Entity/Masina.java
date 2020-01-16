package MIP.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Masina {

    private int masinaid;
    private String marca;
    private int capacitateMotor;
    private int anFabricatie;
    private int price;

    public Masina(
            @JsonProperty int masinaid,
            @JsonProperty String marca,
            @JsonProperty int capacitateMotor,
            @JsonProperty int anFabricatie,
            @JsonProperty int price) {
        this.masinaid = masinaid;
        this.marca = marca;
        this.capacitateMotor = capacitateMotor;
        this.anFabricatie = anFabricatie;
        this.price = price;
    }

    public int getMasinaid() {
        return masinaid;
    }

    public void setMasinaid(int masinaid) {
        this.masinaid = masinaid;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCapacitateMotor() {
        return capacitateMotor;
    }

    public void setCapacitateMotor(int capacitateMotor) {
        this.capacitateMotor = capacitateMotor;
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
