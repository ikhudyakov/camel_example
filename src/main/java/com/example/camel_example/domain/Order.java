package com.example.camel_example.domain;

import java.util.Date;

public class Order {
    private String orderId;
    private Date initDate;
    private Date modifiedDate;
    private String status;

    public Order(String orderId, Date initDate, Date modifiedDate, String status) {
        this.orderId = orderId;
        this.initDate = initDate;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "\"orderId\":\"" + orderId + '\"' +
                ", \"initDate\":\"" + initDate + '\"' +
                ", \"modifiedDate\":\"" + modifiedDate + '\"' +
                ", \"status\":\"" + status + '\"' +
                '}';
    }
}
