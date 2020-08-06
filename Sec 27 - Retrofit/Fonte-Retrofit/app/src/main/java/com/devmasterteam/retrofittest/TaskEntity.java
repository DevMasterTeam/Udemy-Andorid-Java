package com.devmasterteam.retrofittest;

import com.google.gson.annotations.SerializedName;

public class TaskEntity {

    @SerializedName("albumId")
    private int userId;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("completed")
    private boolean completed;
}
