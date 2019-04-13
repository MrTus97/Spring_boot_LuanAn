package com.example.demo.dto;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class PriceDTO {
    private Long id;
    private Long id_type;
    private Long id_time;
    private Double price;
    private Date date;

    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updateAt;
    private Double rate_of_change;

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

    public PriceDTO(Long id, Long id_type, Long id_time, Double price, Date date, Timestamp createdAt, Timestamp updateAt, Double rate_of_change) {
        this.id = id;
        this.id_type = id_type;
        this.id_time = id_time;
        this.price = price;
        this.date = date;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.rate_of_change = rate_of_change;
    }

    public Double getRate_of_change() {
        return rate_of_change;
    }

    public void setRate_of_change(Double rate_of_change) {
        this.rate_of_change = rate_of_change;
    }

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

    public PriceDTO() {
    }
}
