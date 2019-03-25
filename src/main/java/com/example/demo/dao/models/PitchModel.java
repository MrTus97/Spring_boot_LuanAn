package com.example.demo.dao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.type.TypeModifier;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "pitch")
public class PitchModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Column(name = "id_type")
    private Long pitchType;

    @ManyToOne
    @JoinColumn(name = "id_type", insertable = false, updatable = false)
    private PitchTypeModel pitchTypeModel;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "count")
    private Double count;

    @Column(name ="is_use")
    private String is_use;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at")
    private java.sql.Timestamp updateAt;

    //region constructor

    public PitchModel() {
    }

    public PitchModel(Long pitchType, PitchTypeModel pitchTypeModel, String name, String description, String image, Double count, String is_use, Timestamp createdAt, Timestamp updateAt) {
        this.pitchType = pitchType;
        this.pitchTypeModel = pitchTypeModel;
        this.name = name;
        this.description = description;
        this.image = image;
        this.count = count;
        this.is_use = is_use;
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

    public PitchTypeModel getPitchTypeModel() {
        return pitchTypeModel;
    }

    public void setPitchTypeModel(PitchTypeModel pitchTypeModel) {
        this.pitchTypeModel = pitchTypeModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPitchType() {
        return pitchType;
    }

    public void setPitchType(Long pitchType) {
        this.pitchType = pitchType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public String getIs_use() {
        return is_use;
    }

    public void setIs_use(String is_use) {
        this.is_use = is_use;
    }

    //endregion
}
