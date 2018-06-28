package com.example.stefansator.brealth.health.naehrstoffzentrale.nahrungsmittel;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "quantity",
        "measureURI",
        "foodURI"
})
public class Ingredient {

    @SerializedName("quantity")
    private Double quantity;
    @SerializedName("measureURI")
    private String measureURI;
    @SerializedName("foodURI")
    private String foodURI;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Ingredient(Double quantity, String measureURI, String foodURI) {
        this.quantity = quantity;
        this.measureURI = measureURI;
        this.foodURI = foodURI;
    }

    @SerializedName("quantity")
    public Double getQuantity() {
        return quantity;
    }

    @SerializedName("quantity")
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @SerializedName("measureURI")
    public String getMeasureURI() {
        return measureURI;
    }

    @SerializedName("measureURI")
    public void setMeasureURI(String measureURI) {
        this.measureURI = measureURI;
    }

    @SerializedName("foodURI")
    public String getFoodURI() {
        return foodURI;
    }

    @SerializedName("foodURI")
    public void setFoodURI(String foodURI) {
        this.foodURI = foodURI;
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