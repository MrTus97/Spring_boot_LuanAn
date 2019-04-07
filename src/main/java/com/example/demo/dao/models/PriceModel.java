package com.example.demo.dao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "price")
public class PriceModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Column(name = "id_type")
    private Long id_type;

    @ManyToOne
    @JoinColumn(name = "id_type", insertable = false, updatable = false)
    private PitchTypeModel pitchTypeModel;

    @JsonIgnore
    @Column(name = "id_time")
    private Long id_time;

    @ManyToOne
    @JoinColumn(name = "id_time", insertable = false, updatable = false)
    private TimeModel timeModel;

    @Column(name = "price")
    private Double price;

    @Column(name = "date")
    private Date date;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at")
    private java.sql.Timestamp updateAt;

    //region constructor

    public PriceModel() {
    }

    public PriceModel(Long id_type, PitchTypeModel pitchTypeModel, Long id_time, TimeModel timeModel, Double price, Date date, Timestamp createdAt, Timestamp updateAt) {
        this.id_type = id_type;
        this.pitchTypeModel = pitchTypeModel;
        this.id_time = id_time;
        this.timeModel = timeModel;
        this.price = price;
        this.date = date;
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

    public TimeModel getTimeModel() {
        return timeModel;
    }

    public void setTimeModel(TimeModel timeModel) {
        this.timeModel = timeModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_type() {
        return id_type;
    }

    public void setId_type(Long id_type) {
        this.id_type = id_type;
    }

    public Long getId_time() {
        return id_time;
    }

    public void setId_time(Long id_time) {
        this.id_time = id_time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //endregion
}
