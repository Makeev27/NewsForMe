package com.android.example.newsforme.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class source {

    @SerializedName("name")
    @Expose
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
