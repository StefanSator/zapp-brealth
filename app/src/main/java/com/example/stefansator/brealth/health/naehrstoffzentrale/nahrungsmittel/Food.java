package com.example.stefansator.brealth.health.naehrstoffzentrale.nahrungsmittel;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "uri",
        "label",
        "nutrients",
        "source",
        "brand",
        "foodContentsLabel"
})

public class Food {

    @SerializedName("uri")
    private String uri;
    @SerializedName("label")
    private String label;
    @SerializedName("nutrients")
    private Nutrients nutrients;
    @SerializedName("source")
    private String source;
    @SerializedName("brand")
    private String brand;
    @SerializedName("foodContentsLabel")
    private String foodContentsLabel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("uri")
    public String getUri() {
        return uri;
    }

    @SerializedName("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @SerializedName("label")
    public String getLabel() {
        return label;
    }

    @SerializedName("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @SerializedName("nutrients")
    public Nutrients getNutrients() {
        return nutrients;
    }

    @SerializedName("nutrients")
    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    @SerializedName("source")
    public String getSource() {
        return source;
    }

    @SerializedName("source")
    public void setSource(String source) {
        this.source = source;
    }

    @SerializedName("brand")
    public String getBrand() {
        return brand;
    }

    @SerializedName("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @SerializedName("foodContentsLabel")
    public String getFoodContentsLabel() {
        return foodContentsLabel;
    }

    @SerializedName("foodContentsLabel")
    public void setFoodContentsLabel(String foodContentsLabel) {
        this.foodContentsLabel = foodContentsLabel;
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