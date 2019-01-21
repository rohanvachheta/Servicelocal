
package com.example.lenovo.myapplication.Requestinformation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Showyourrequeststatus {

    @SerializedName("show")
    @Expose
    private Boolean show;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("User_id")
    @Expose
    private UserId userId;
    @SerializedName("service_provider")
    @Expose
    private ServiceProvider serviceProvider;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("Mobile")
    @Expose
    private String mobile;
    @SerializedName("vehicleNumber")
    @Expose
    private String vehicleNumber;
    @SerializedName("vehiclesesrvicename")
    @Expose
    private String vehiclesesrvicename;
    @SerializedName("serviceExpectedDate")
    @Expose
    private String serviceExpectedDate;
    @SerializedName("serviceExpectedTime")
    @Expose
    private String serviceExpectedTime;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehiclesesrvicename() {
        return vehiclesesrvicename;
    }

    public void setVehiclesesrvicename(String vehiclesesrvicename) {
        this.vehiclesesrvicename = vehiclesesrvicename;
    }

    public String getServiceExpectedDate() {
        return serviceExpectedDate;
    }

    public void setServiceExpectedDate(String serviceExpectedDate) {
        this.serviceExpectedDate = serviceExpectedDate;
    }

    public String getServiceExpectedTime() {
        return serviceExpectedTime;
    }

    public void setServiceExpectedTime(String serviceExpectedTime) {
        this.serviceExpectedTime = serviceExpectedTime;
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
