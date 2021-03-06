package com.example.demo.dao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "pitch_type")
public class PitchTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Column(name = "id_owner")
    private Long id_owner;

    @ManyToOne
    @JoinColumn(name = "id_owner", insertable = false, updatable = false)
    private OwnerModel ownerModel;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at")
    private java.sql.Timestamp updateAt;

    //region constructor

    public PitchTypeModel() {
    }

    public PitchTypeModel(Long id_owner, OwnerModel ownerModel, String name, Timestamp createdAt, Timestamp updateAt) {
        this.id_owner = id_owner;
        this.ownerModel = ownerModel;
        this.name = name;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    //endregion

    //region get, set
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public OwnerModel getOwnerModel() {
        return ownerModel;
    }

    public void setOwnerModel(OwnerModel ownerModel) {
        this.ownerModel = ownerModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_owner() {
        return id_owner;
    }

    public void setId_owner(Long id_owner) {
        this.id_owner = id_owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
}
