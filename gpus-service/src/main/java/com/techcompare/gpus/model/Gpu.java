package com.techcompare.gpus.model;

import jakarta.persistence.*;

@Entity
public class Gpu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int modelYear;
    private double price;
    private String vram;
    private String tech;
    private int cudaCores;
    private String baseClock;
    private String boostClock;
    private String memoryBus;
    private String tdp;
    private String image;

    public Gpu() {}

    public Gpu(String model,
               int modelYear,
               double price,
               String vram,
               String tech,
               int cudaCores,
               String baseClock,
               String boostClock,
               String memoryBus,
               String tdp,
               String image) {
        this.model = model;
        this.modelYear = modelYear;
        this.price = price;
        this.vram = vram;
        this.tech = tech;
        this.cudaCores = cudaCores;
        this.baseClock = baseClock;
        this.boostClock = boostClock;
        this.memoryBus = memoryBus;
        this.tdp = tdp;
        this.image = image;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getModelYear() { return modelYear; }
    public void setModelYear(int modelYear) { this.modelYear = modelYear; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getVram() { return vram; }
    public void setVram(String vram) { this.vram = vram; }
    public String getTech() { return tech; }
    public void setTech(String tech) { this.tech = tech; }
    public int getCudaCores() { return cudaCores; }
    public void setCudaCores(int cudaCores) { this.cudaCores = cudaCores; }
    public String getBaseClock() { return baseClock; }
    public void setBaseClock(String baseClock) { this.baseClock = baseClock; }
    public String getBoostClock() { return boostClock; }
    public void setBoostClock(String boostClock) { this.boostClock = boostClock; }
    public String getMemoryBus() { return memoryBus; }
    public void setMemoryBus(String memoryBus) { this.memoryBus = memoryBus; }
    public String getTdp() { return tdp; }
    public void setTdp(String tdp) { this.tdp = tdp; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
