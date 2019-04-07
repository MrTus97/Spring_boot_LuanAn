package com.example.demo.dao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "banner_reserve")
public class BannerReserveModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Column(name = "id_owner")
    private Long id_owner;

    @JsonIgnore
    @Column(name = "id_customer")
    private Long id_customer;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_owner", insertable = false, updatable = false)
    private OwnerModel ownerModel;

    @ManyToOne
    @JoinColumn(name = "id_customer", insertable = false, updatable = false)
    private CustomerModel customerModel;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at")
    private java.sql.Timestamp updateAt;

    public BannerReserveModel() {
    }

    public BannerReserveModel(Long id_owner, Long id_customer, String description, OwnerModel ownerModel, CustomerModel customerModel) {
        this.id_owner = id_owner;
        this.id_customer = id_customer;
        this.description = description;
        this.ownerModel = ownerModel;
        this.customerModel = customerModel;
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

    public OwnerModel getOwnerModel() {
        return ownerModel;
    }

    public void setOwnerModel(OwnerModel ownerModel) {
        this.ownerModel = ownerModel;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }
}
