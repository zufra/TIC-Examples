package Entities;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @Column(name = "restaurant_id", nullable = false, unique = true)
    private int id;

    @Column(name = "restaurant_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
