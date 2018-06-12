package com.example.stefansator.brealth.naehrstoffzentrale;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//        "ENERC_KCAL",
//        "PROCNT",
//        "FAT",
//        "CHOCDF"
//})
public class Nutrients {

    @SerializedName("ENERC_KCAL")
    private Double calories;
    @SerializedName("PROCNT")
    private Double protein;
    @SerializedName("FAT")
    private Double fat;
    @SerializedName("CHOCDF")
    private Double carbohydrates;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ENERC_KCAL")
    public Double getCalories() {
        return calories;
    }

    @JsonProperty("ENERC_KCAL")
    public void setCalories(Double calories) {
        this.calories = calories;
    }

    @JsonProperty("PROCNT")
    public Double getProtein() {
        return protein;
    }

    @JsonProperty("PROCNT")
    public void setProtein(Double protein) {
        this.protein = protein;
    }

    @JsonProperty("FAT")
    public Double getFat() {
        return fat;
    }

    @JsonProperty("FAT")
    public void setFat(Double fat) {
        this.fat = fat;
    }

    @JsonProperty("CHOCDF")
    public Double getCarbohydrates() {
        return carbohydrates;
    }

    @JsonProperty("CHOCDF")
    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}