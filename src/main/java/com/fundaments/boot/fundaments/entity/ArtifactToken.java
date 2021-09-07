package com.fundaments.boot.fundaments.entity;

import javax.persistence.*;

@Entity
@Table(name = "token")
public class ArtifactToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_token", nullable = false, unique = true)
    private Long id;
    private String token;
    private Double ipo;

    @ManyToOne
    private Owner owner;

    public ArtifactToken() {
    }

    public ArtifactToken(String token, Double ipo, Owner owner) {
        this.token = token;
        this.ipo = ipo;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Double getIpo() {
        return ipo;
    }

    public void setIpo(Double ipo) {
        this.ipo = ipo;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "ArtifactToken{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", ipo=" + ipo +
                ", owner=" + owner +
                '}';
    }
}
