package com.example.lenovo.myapplication.ServiceProviderside;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("towing")
    @Expose
    private String towing;
    @SerializedName("User_id")
    @Expose
    private String userId;
    @SerializedName("service_provider")
    @Expose
    private String serviceProvider;
    @SerializedName("payment")
    @Expose
    private String payment;
    @SerializedName("requestid")
    @Expose
    private String requestid;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTowing() {
        return towing;
    }

    public void setTowing(String towing) {
        this.towing = towing;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRequestid() {
        return requestid;
    }

    public void setRequestid(String requestid) {
        this.requestid = requestid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}