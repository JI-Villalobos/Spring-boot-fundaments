package com.fundaments.boot.fundaments.entity;

import javax.persistence.*;

@Entity
@Table(name = "token")
public class ArtifactToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_token", nullable = false, unique = true)
    private Long id;
    @Column(name = "id_owner")
    private Integer idOwner;
    private String token;
    private Double ipo;

    @ManyToOne
    @JoinColumn(name = "owner_id", insertable = false, updatable = false)
    private Owner owner;

    public ArtifactToken() {
    }

    public ArtifactToken(Integer idOwner, Double ipo) {
        this.idOwner = idOwner;
        this.ipo = ipo;
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

    public void setToken() {
        this.token = java.util.UUID.randomUUID().toString();
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
