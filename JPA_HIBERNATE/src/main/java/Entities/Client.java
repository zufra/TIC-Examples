package Entities;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "client_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "client_name", nullable = false)
    private String name;

    @Column(name = "client_age", nullable = false)
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
