package com.example.demo.dao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "pair")
public class PairModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Column(name = "id_customer")
    private Long id_customer;

    @ManyToOne
    @JoinColumn(name = "id_customer", insertable = false, updatable = false)
    private CustomerModel customerModel;

    @JsonIgnore
    @Column(name = "id_time")
    private Long id_time;

    @ManyToOne
    @JoinColumn(name = "id_time", insertable = false, updatable = false)
    private TimeModel timeModel;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "pair")
    private String pair;

    @Column(name = "date")
    private Date date;

    @Column(name = "is_verify")
    private String is_verify;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at")
    private java.sql.Timestamp updateAt;

    //region constructor
    public PairModel() {
    }

    public PairModel(Long id_customer, CustomerModel customerModel, Long id_time, TimeModel timeModel, String description, String status, String pair, Date date, String is_verify, Timestamp createdAt, Timestamp updateAt) {
        this.id_customer = id_customer;
        this.customerModel = customerModel;
        this.id_time = id_time;
        this.timeModel = timeModel;
        this.description = description;
        this.status = status;
        this.pair = pair;
        this.date = date;
        this.is_verify = is_verify;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    //endregion

    //region Get, set

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

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public Long getId_time() {
        return id_time;
    }

    public void setId_time(Long id_time) {
        this.id_time = id_time;
    }

    public TimeModel getTimeModel() {
        return timeModel;
    }

    public void setTimeModel(TimeModel timeModel) {
        this.timeModel = timeModel;
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

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    //endregion
}
