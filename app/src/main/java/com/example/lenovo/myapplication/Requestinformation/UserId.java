
package com.example.lenovo.myapplication.Requestinformation;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserId {

    @SerializedName("services")
    @Expose
    private Integer services;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("tokens")
    @Expose
    private List<Object> tokens = null;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public Integer getServices() {
        return services;
    }

    public void setServices(Integer services) {
        this.services = services;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getTokens() {
        return tokens;
    }

    public void setTokens(List<Object> tokens) {
        this.tokens = tokens;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
