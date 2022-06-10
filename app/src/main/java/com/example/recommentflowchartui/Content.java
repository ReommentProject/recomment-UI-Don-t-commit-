package com.example.recommentflowchartui;

import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("id")
    private String user_Id;

    @SerializedName("password")
    private String user_Pwd;

    @SerializedName("nickname")
    private String title;

    @SerializedName("introduce")
    private String content;

    @SerializedName("gender")
    private Boolean gender;

    @SerializedName("profile_Image")
    private String thumbnail;


    public Content(String user_Id, String user_Pwd, String title, String content, Boolean gender, String thumbnail) {
        this.user_Id = user_Id;
        this.user_Pwd = user_Pwd;
        this.title = title;
        this.content = content;
        this.gender = gender;
        this.thumbnail = thumbnail;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public String getUser_Pwd() {
        return user_Pwd;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Boolean getGender() {
        return gender;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}