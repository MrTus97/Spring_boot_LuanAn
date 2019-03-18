package com.example.demo.dao.models;

import javax.persistence.*;

@Entity
@Table(name = "CustomerDTO")
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

    @Column(name = "password")
    private String password;

    @Column(name = "count_resever")
    private String count_resever;

    @Column(name = "count_cancel")
    private String count_cancel;

    @Column(name = "verify")
    private String verify;

    @Column(name = "remember_token")
    private String remember_token;

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

    public String getCount_resever() {
        return count_resever;
    }

    public void setCount_resever(String count_resever) {
        this.count_resever = count_resever;
    }

    public String getCount_cancel() {
        return count_cancel;
    }

    public void setCount_cancel(String count_cancel) {
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
}
