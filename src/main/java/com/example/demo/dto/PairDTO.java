package com.example.demo.dto;

import javax.persistence.*;
import java.util.Date;

public class PairDTO {
    private Long id;
    private Long id_customer;
    private Long id_time;
    private String description;
    private String status;
    private Date date;
    private String is_verify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_customer() {
        return id_customer;
    }

    public void setId_customer(Long id_customer) {
        this.id_customer = id_customer;
    }

    public Long getId_time() {
        return id_time;
    }

    public void setId_time(Long id_time) {
        this.id_time = id_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getIs_verify() {
        return is_verify;
    }

    public void setIs_verify(String is_verify) {
        this.is_verify = is_verify;
    }

    @Override
    public String toString() {
        return "PairDTO{" +
                "id=" + id +
                ", id_customer=" + id_customer +
                ", id_time=" + id_time +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", is_verify='" + is_verify + '\'' +
                '}';
    }
}
