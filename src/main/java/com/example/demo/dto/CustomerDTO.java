package com.example.demo.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {
    private Long id;
    private String name;
    private String phone;
    private String team_name;
    private String level;
    private String star;
    private String is_block;
    private String is_delete;
    private String password;
    private String count_reserve;
    private String count_cancel;
    private String verify;
    private String remember_token;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name, String phone, String team_name, String level, String star, String is_block, String is_delete, String password, String count_reserve, String count_cancel, String verify, String remember_token) {
        this.id = id;
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

    public String getCount_reserve() {
        return count_reserve;
    }

    public void setCount_reserve(String count_reserve) {
        this.count_reserve = count_reserve;
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

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", team_name='" + team_name + '\'' +
                ", level='" + level + '\'' +
                ", star='" + star + '\'' +
                ", is_block='" + is_block + '\'' +
                ", is_delete='" + is_delete + '\'' +
                ", password='" + password + '\'' +
                ", count_reserve='" + count_reserve + '\'' +
                ", count_cancel='" + count_cancel + '\'' +
                ", verify='" + verify + '\'' +
                ", remember_token='" + remember_token + '\'' +
                '}';
    }

    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        for (String role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role));
//        }
        return authorities;
    }
}
