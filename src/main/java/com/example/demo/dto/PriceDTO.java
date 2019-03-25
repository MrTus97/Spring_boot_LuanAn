package com.example.demo.dto;

import javax.persistence.*;
import java.util.Date;

public class PriceDTO {
    private Long id;
    private Long id_type;
    private Long id_time;
    private Double price;
    private Date date;

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

    @Override
    public String toString() {
        return "PriceDTO{" +
                "id=" + id +
                ", id_type=" + id_type +
                ", id_time=" + id_time +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
