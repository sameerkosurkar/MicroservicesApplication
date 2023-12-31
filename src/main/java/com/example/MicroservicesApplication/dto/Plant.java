package com.example.MicroservicesApplication.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Plant {
    @SerializedName("id")
    private Integer id;
    @SerializedName("genus")
    private String genus;
    @SerializedName("species")
    private String species;
    @SerializedName("cultivar")
    private String cultivar;
    @SerializedName("common")
    private String common;

    public String toString() {
        return this.common;
    }
}
