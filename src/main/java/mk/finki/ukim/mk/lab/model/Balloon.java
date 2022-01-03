package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Balloon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private Manufacturer m;

    public Balloon(String name, String description, Manufacturer m) {
        this.name = name;
        this.description = description;
        this.m = m;
    }

    public Balloon() {}
}
