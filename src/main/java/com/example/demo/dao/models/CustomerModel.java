package com.example.demo.dao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "customer")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "team_name")
    private String team_name;

    @Column(name = "level")
    private String level;

    @Column(name = "star")
    private String star;

    @Column(name = "is_block")
    private String is_block;

    @Column(name = "is_delete")
    private String is_delete;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "count_reserve")
    private Double count_reserve;

    @Column(name = "count_cancel")
    private Double count_cancel;

    @Column(name = "verify")
    private String verify;

    @Column(name = "remember_token")
    private String remember_token;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Column(name = "updated_at")
    private java.sql.Timestamp updateAt;



    public CustomerModel() {
    }

    public CustomerModel(String name, String phone, String team_name, String level, String star, String is_block, String is_delete, String password, Double count_reserve, Double count_cancel, String verify, String remember_token, String avatar, Timestamp createdAt, Timestamp updateAt) {
        this.name = name;
        this.phone = phone;
        this.team_name = team_name;
        this.level = level;
        this.star = star;
        this.is_block = is_block;
        this.is_delete = is_delete;
        this.password = password;
        this.count_reserve = count_reserve;
        this.count_cancel = count_cancel;
        this.verify = verify;
        this.remember_token = remember_token;
        this.avatar = avatar;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getIs_block() {
        return is_block;
    }

    public void setIs_block(String is_block) {
        this.is_block = is_block;
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getCount_reserve() {
        return count_reserve;
    }

    public void setCount_reserve(Double count_reserve) {
        this.count_reserve = count_reserve;
    }

    public Double getCount_cancel() {
        return count_cancel;
    }

    public void setCount_cancel(Double count_cancel) {
        this.count_cancel = count_cancel;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
