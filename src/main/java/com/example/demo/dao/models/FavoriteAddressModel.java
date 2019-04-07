package com.example.demo.dao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "favorite_address")
public class FavoriteAddressModel implements Serializable {
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

    @ManyToOne
    @JoinColumn(name = "id_customer", insertable = false, updatable = false)
    private CustomerModel customerModel;

    @ManyToOne
    @JoinColumn(name = "id_owner", insertable = false, updatable = false)
    private OwnerModel ownerModel;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at")
    private java.sql.Timestamp updateAt;

    public FavoriteAddressModel() {
    }

    public FavoriteAddressModel(Long id_owner, Long id_customer, CustomerModel customerModel, OwnerModel ownerModel, Timestamp createdAt, Timestamp updateAt) {
        this.id_owner = id_owner;
        this.id_customer = id_customer;
        this.customerModel = customerModel;
        this.ownerModel = ownerModel;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
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

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public OwnerModel getOwnerModel() {
        return ownerModel;
    }

    public void setOwnerModel(OwnerModel ownerModel) {
        this.ownerModel = ownerModel;
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
}
