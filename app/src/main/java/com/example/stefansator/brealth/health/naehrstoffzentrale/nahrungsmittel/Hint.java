package com.example.stefansator.brealth.health.naehrstoffzentrale.nahrungsmittel;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "food",
        "measures"
})
/**
 * Represents the top most node in the JSON object, which the API call returns
 */
public class Hint {

    @SerializedName("food")
    private Food food;
    @SerializedName("measures")
    private List<Measure> measures = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("food")
    public Food getFood() {
        return food;
    }

    @SerializedName("food")
    public void setFood(Food food) {
        this.food = food;
    }

    @SerializedName("measures")
    public List<Measure> getMeasures() {
        return measures;
    }

    @SerializedName("measures")
    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
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