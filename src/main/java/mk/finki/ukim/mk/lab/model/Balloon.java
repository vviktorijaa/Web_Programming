package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Balloon {
    private String name;
    private String description;
    private Long id;
    private Manufacturer m;

    public Balloon(String name, String description, Manufacturer m) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.m = m;
    }
}
