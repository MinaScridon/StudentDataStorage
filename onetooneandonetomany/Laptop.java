package com.onetooneandonetomany;

import jakarta.persistence.*;

@Entity
@Table(name = "Laptop")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LaptopID")
    private Integer id;

    @Column(name = "Producer")
    private String producer;

    @Column(name = "Processor", nullable = false, unique = true)
    private String processor;

    @Column(name = "RAM", nullable = false)
    private String ram;

    @Column(name = "HDD", nullable = false)
    private String hdd;

    @Column(name = "Color")
    private String color;

    @Column(name = "Guarantee")
    private Integer guarantee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Integer guarantee) {
        this.guarantee = guarantee;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", producer='" + producer + '\'' +
                ", processor='" + processor + '\'' +
                ", ram=" + ram +
                ", hdd='" + hdd + '\'' +
                ", color='" + color + '\'' +
                ", guarantee=" + guarantee +
                '}';
    }
}
