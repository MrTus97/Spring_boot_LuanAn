package com.example.demo.dto;

import javax.persistence.*;
import java.util.Date;

public class LogReserveDTO {
    private Long id;
    private Long id_price;
    private Long id_pitch;
    private Long id_time;
    private Long id_customer;
    private String type;
    private String status;
    private Date date;

    @Override
    public String toString() {
        return "LogReserveDTO{" +
                "id=" + id +
                ", id_price=" + id_price +
                ", id_pitch=" + id_pitch +
                ", id_time=" + id_time +
                ", id_customer=" + id_customer +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_price() {
        return id_price;
    }

    public void setId_price(Long id_price) {
        this.id_price = id_price;
    }

    public Long getId_pitch() {
        return id_pitch;
    }

    public void setId_pitch(Long id_pitch) {
        this.id_pitch = id_pitch;
    }

    public Long getId_time() {
        return id_time;
    }

    public void setId_time(Long id_time) {
        this.id_time = id_time;
    }

    public Long getId_customer() {
        return id_customer;
    }

    public void setId_customer(Long id_customer) {
        this.id_customer = id_customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
