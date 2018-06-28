
package com.example.stefansator.brealth.health.naehrstoffzentrale.nahrungsmittel.apiclasses;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "quantity",
    "measure",
    "food",
    "foodId",
    "foodURI",
    "weight",
    "retainedWeight",
    "measureURI",
    "status"
})
public class Parsed {

    @SerializedName("quantity")
    private Double quantity;
    @SerializedName("measure")
    private String measure;
    @SerializedName("food")
    private String food;
    @SerializedName("foodId")
    private String foodId;
    @SerializedName("foodURI")
    private String foodURI;
    @SerializedName("weight")
    private Integer weight;
    @SerializedName("retainedWeight")
    private Integer retainedWeight;
    @SerializedName("measureURI")
    private String measureURI;
    @SerializedName("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("quantity")
    public Double getQuantity() {
        return quantity;
    }

    @SerializedName("quantity")
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @SerializedName("measure")
    public String getMeasure() {
        return measure;
    }

    @SerializedName("measure")
    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @SerializedName("food")
    public String getFood() {
        return food;
    }

    @SerializedName("food")
    public void setFood(String food) {
        this.food = food;
    }

    @SerializedName("foodId")
    public String getFoodId() {
        return foodId;
    }

    @SerializedName("foodId")
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    @SerializedName("foodURI")
    public String getFoodURI() {
        return foodURI;
    }

    @SerializedName("foodURI")
    public void setFoodURI(String foodURI) {
        this.foodURI = foodURI;
    }

    @SerializedName("weight")
    public Integer getWeight() {
        return weight;
    }

    @SerializedName("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @SerializedName("retainedWeight")
    public Integer getRetainedWeight() {
        return retainedWeight;
    }

    @SerializedName("retainedWeight")
    public void setRetainedWeight(Integer retainedWeight) {
        this.retainedWeight = retainedWeight;
    }

    @SerializedName("measureURI")
    public String getMeasureURI() {
        return measureURI;
    }

    @SerializedName("measureURI")
    public void setMeasureURI(String measureURI) {
        this.measureURI = measureURI;
    }

    @SerializedName("status")
    public String getStatus() {
        return status;
    }

    @SerializedName("status")
    public void setStatus(String status) {
        this.status = status;
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
