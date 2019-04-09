package com.example.demo.dao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "log_reserve")
public class LogReserveModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Column(name = "id_price")
    private Long id_price;

    @JsonIgnore
    @Column(name = "id_pitch")
    private Long id_pitch;

    @JsonIgnore
    @Column(name = "id_time")
    private Long id_time;

    @JsonIgnore
    @Column(name = "id_customer")
    private Long id_customer;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_price", insertable = false, updatable = false)
    private PriceModel priceModel;

    @ManyToOne
    @JoinColumn(name = "id_pitch", insertable = false, updatable = false)
    private PitchModel pitchModel;

    @ManyToOne
    @JoinColumn(name = "id_time", insertable = false, updatable = false)
    private TimeModel timeModel;

    @ManyToOne
    @JoinColumn(name = "id_customer", insertable = false, updatable = false)
    private CustomerModel customerModel;

    @Column(name = "week_amount")
    private double week_amount;

    @Column(name = "date_end")
    private java.sql.Date date_end;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at")
    private java.sql.Timestamp updateAt;

    public LogReserveModel() {
    }

    public java.sql.Date getDate_end() {
        return date_end;
    }

    public void setDate_end(java.sql.Date date_end) {
        this.date_end = date_end;
    }

    public LogReserveModel(Long id_price, Long id_pitch, Long id_time, Long id_customer, String type, String status, Date date, PriceModel priceModel, PitchModel pitchModel, TimeModel timeModel, CustomerModel customerModel, double week_amount, java.sql.Date date_end, Timestamp createdAt, Timestamp updateAt) {
        this.id_price = id_price;
        this.id_pitch = id_pitch;
        this.id_time = id_time;
        this.id_customer = id_customer;
        this.type = type;
        this.status = status;
        this.date = date;
        this.priceModel = priceModel;
        this.pitchModel = pitchModel;
        this.timeModel = timeModel;
        this.customerModel = customerModel;
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

    public PriceModel getPriceModel() {
        return priceModel;
    }

    public void setPriceModel(PriceModel priceModel) {
        this.priceModel = priceModel;
    }

    public PitchModel getPitchModel() {
        return pitchModel;
    }

    public void setPitchModel(PitchModel pitchModel) {
        this.pitchModel = pitchModel;
    }

    public TimeModel getTimeModel() {
        return timeModel;
    }

    public void setTimeModel(TimeModel timeModel) {
        this.timeModel = timeModel;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public double getWeek_amount() {
        return week_amount;
    }

    public void setWeek_amount(double week_amount) {
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

    @Override
    public String toString() {
        return "LogReserveModel{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", priceModel=" + priceModel +
                ", pitchModel=" + pitchModel +
                ", timeModel=" + timeModel +
                ", customerModel=" + customerModel +
                ", week_amount=" + week_amount +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
