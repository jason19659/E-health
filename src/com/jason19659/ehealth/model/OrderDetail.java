package com.jason19659.ehealth.model;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.jason19659.ehealth.utils.JsonDateSerializer;

public class OrderDetail {
    private String id;

    private String orderId;

    private Date orderDate;

    private String medicinalId;

    private String userId;

    private String status;

    private BigDecimal price;

    private Integer amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }
    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getMedicinalId() {
        return medicinalId;
    }

    public void setMedicinalId(String medicinalId) {
        this.medicinalId = medicinalId == null ? null : medicinalId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}