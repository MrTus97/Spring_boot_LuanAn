package com.example.demo.dto;

import javax.persistence.*;

public class BannerReserveDTO {
    private Long id;
    private Long id_owner;
    private Long id_customer;
    private String description;

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

    public Long getId_customer() {
        return id_customer;
    }

    public void setId_customer(Long id_customer) {
        this.id_customer = id_customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BannerReserveDTO{" +
                "id=" + id +
                ", id_owner=" + id_owner +
                ", id_customer=" + id_customer +
                ", description='" + description + '\'' +
                '}';
    }
}
