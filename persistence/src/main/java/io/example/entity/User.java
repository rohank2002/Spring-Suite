package io.example.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
public class User {
    @Id
    @Column(columnDefinition = "VARCHAR(36) ")
    private String id;
    private String fisrstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @ManyToOne
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFisrstName() {
        return fisrstName;
    }

    public void setFisrstName(String fisrstName) {
        this.fisrstName = fisrstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
