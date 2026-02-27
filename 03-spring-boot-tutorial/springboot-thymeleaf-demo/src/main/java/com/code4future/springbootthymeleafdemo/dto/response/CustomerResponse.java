package com.code4future.springbootthymeleafdemo.dto.response;

public class CustomerResponse {

    private String fullName;
    private Long id;
    private String shippingAddress;


    public CustomerResponse(String fullName, Long id, String shippingAddress) {
        this.fullName = fullName;
        this.id = id;
        this.shippingAddress = shippingAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
