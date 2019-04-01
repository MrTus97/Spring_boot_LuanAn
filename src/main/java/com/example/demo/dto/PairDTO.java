package com.example.demo.dto;

import com.example.demo.dao.models.CustomerModel;
import com.example.demo.dao.models.TimeModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

public class PairDTO {
    private Long id;
    private CustomerModel customerModel;
    private TimeModel timeModel;
    private String description;
    private String status;
    private String pair;
    private Date date;
    private String is_verify;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updateAt;

    public PairDTO() {
    }

    public PairDTO(Long id, CustomerModel customerModel, TimeModel timeModel, String description, String status, Date date, String is_verify, Timestamp createdAt, Timestamp updateAt, String pair) {
        this.id = id;
        this.customerModel = customerModel;
        this.timeModel = timeModel;
        this.description = description;
        this.status = status;
        this.date = date;
        this.is_verify = is_verify;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.pair = pair;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
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

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
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
}
