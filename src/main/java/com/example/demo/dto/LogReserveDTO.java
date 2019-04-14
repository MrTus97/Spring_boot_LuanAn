package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;
import java.util.Date;

@JsonIgnoreProperties(value = "customer")
public class LogReserveDTO {
    private Long id;
    private String type;
    private String status;
    private Date date;
    private PriceDTO price;
    private PitchDTO pitch;
    private TimeDTO time;
    private CustomerDTO customer;
    private Double week_amount;
    private Date date_end;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updateAt;

    public LogReserveDTO() {
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public LogReserveDTO(Long id, String type, String status, Date date, PriceDTO price, PitchDTO pitch, TimeDTO time, CustomerDTO customer, Double week_amount, Date date_end, Timestamp createdAt, Timestamp updateAt) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.date = date;
        this.price = price;
        this.pitch = pitch;
        this.time = time;
        this.customer = customer;
        this.week_amount = week_amount;
        this.date_end = date_end;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PriceDTO getPrice() {
        return price;
    }

    public void setPrice(PriceDTO price) {
        this.price = price;
    }

    public PitchDTO getPitch() {
        return pitch;
    }

    public void setPitch(PitchDTO pitch) {
        this.pitch = pitch;
    }

    public TimeDTO getTime() {
        return time;
    }

    public void setTime(TimeDTO time) {
        this.time = time;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public Double getWeek_amount() {
        return week_amount;
    }

    public void setWeek_amount(Double week_amount) {
        this.week_amount = week_amount;
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
