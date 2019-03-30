package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties(value = "customer")
public class FavoriteAddressDTO {
    private Long id;
    private OwnerDTO owner;
    private CustomerDTO customer;

    public FavoriteAddressDTO() {
    }

    public FavoriteAddressDTO(Long id, OwnerDTO owner, CustomerDTO customer) {
        this.id = id;
        this.owner = owner;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "FavoriteAddressDTO{" +
                "id=" + id +
                ", owner=" + owner +
                ", customer=" + customer +
                '}';
    }
}
