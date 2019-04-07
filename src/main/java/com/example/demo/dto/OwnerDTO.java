package com.example.demo.dto;

public class OwnerDTO {
    private Long id;
    private String name;
    private String phone;
    private String address;
    private String is_block;
    private String is_delete;
    private String password;
    private String verify;
    private String remember_token;
    private String district;
    private Double lat;
    private Double lng;

    public OwnerDTO() {
    }

    public OwnerDTO(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public OwnerDTO(Long id, String name, String phone, String address, String is_block, String is_delete, String password, String verify, String remember_token, String district, Double lat, Double lng) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.is_block = is_block;
        this.is_delete = is_delete;
        this.password = password;
        this.verify = verify;
        this.remember_token = remember_token;
        this.district = district;
        this.lat = lat;
        this.lng = lng;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "OwnerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", is_block='" + is_block + '\'' +
                ", is_delete='" + is_delete + '\'' +
                ", password='" + password + '\'' +
                ", verify='" + verify + '\'' +
                ", remember_token='" + remember_token + '\'' +
                ", district='" + district + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
