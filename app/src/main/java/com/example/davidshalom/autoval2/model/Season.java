package com.example.davidshalom.autoval2.model;


import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Season {
    public abstract String caption();
    public abstract int id();

    public static TypeAdapter<Season> typeAdapter(Gson gson) {
        return new AutoValue_Season.GsonTypeAdapter(gson);
    }
}