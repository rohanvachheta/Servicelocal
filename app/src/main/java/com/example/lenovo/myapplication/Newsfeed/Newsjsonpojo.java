
package com.example.lenovo.myapplication.Newsfeed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Newsjsonpojo {


    public Newsjsonpojo(String location) {
        this.location = location;
    }

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("service_provider")
    @Expose
    private String serviceProvider;
    @SerializedName("show")
    @Expose
    private Boolean show;
    @SerializedName("creator")
    @Expose
    private String creator;
    @SerializedName("content_title")
    @Expose
    private String contentTitle;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("photolink")
    @Expose
    private String photolink;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhotolink() {
        return photolink;
    }

    public void setPhotolink(String photolink) {
        this.photolink = photolink;
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
