package com.example.demo.dto;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

public class LogReserveDTO {
    private Long id;
    private String type;
    private String status;
    private Date date;
    private PriceDTO priceDTO;
    private PitchDTO pitchDTO;
    private TimeDTO timeDTO;
    private CustomerDTO customerDTO;
    private double week_amount;
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

    public LogReserveDTO(Long id, String type, String status, Date date, PriceDTO priceDTO, PitchDTO pitchDTO, TimeDTO timeDTO, CustomerDTO customerDTO, double week_amount, Date date_end, Timestamp createdAt, Timestamp updateAt) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.date = date;
        this.priceDTO = priceDTO;
        this.pitchDTO = pitchDTO;
        this.timeDTO = timeDTO;
        this.customerDTO = customerDTO;
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

    public PriceDTO getPriceDTO() {
        return priceDTO;
    }

    public void setPriceDTO(PriceDTO priceDTO) {
        this.priceDTO = priceDTO;
    }

    public PitchDTO getPitchDTO() {
        return pitchDTO;
    }

    public void setPitchDTO(PitchDTO pitchDTO) {
        this.pitchDTO = pitchDTO;
    }

    public TimeDTO getTimeDTO() {
        return timeDTO;
    }

    public void setTimeDTO(TimeDTO timeDTO) {
        this.timeDTO = timeDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
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
        return "LogReserveDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", priceDTO=" + priceDTO +
                ", pitchDTO=" + pitchDTO +
                ", timeDTO=" + timeDTO +
                ", customerDTO=" + customerDTO +
                ", week_amount=" + week_amount +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
