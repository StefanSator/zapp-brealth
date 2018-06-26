
package com.example.stefansator.brealth.naehrstoffzentrale.apiclasses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "uri",
    "yield",
    "calories",
    "totalWeight",
    "dietLabels",
    "healthLabels",
    "cautions",
    "totalNutrients",
    "totalDaily",
    "ingredients"
})
public class ResponseObject {

    @SerializedName("uri")
    private String uri;
    @SerializedName("yield")
    private Integer yield;
    @SerializedName("calories")
    private Integer calories;
    @SerializedName("totalWeight")
    private Integer totalWeight;
    @SerializedName("dietLabels")
    private List<String> dietLabels = null;
    @SerializedName("healthLabels")
    private List<String> healthLabels = null;
    @SerializedName("cautions")
    private List<Object> cautions = null;
    @SerializedName("totalNutrients")
    private TotalNutrients totalNutrients;
    @SerializedName("totalDaily")
    private TotalDaily totalDaily;
    @SerializedName("ingredients")
    private List<Ingredient> ingredients = null;
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

    @SerializedName("yield")
    public Integer getYield() {
        return yield;
    }

    @SerializedName("yield")
    public void setYield(Integer yield) {
        this.yield = yield;
    }

    @SerializedName("calories")
    public Integer getCalories() {
        return calories;
    }

    @SerializedName("calories")
    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @SerializedName("totalWeight")
    public Integer getTotalWeight() {
        return totalWeight;
    }

    @SerializedName("totalWeight")
    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    @SerializedName("dietLabels")
    public List<String> getDietLabels() {
        return dietLabels;
    }

    @SerializedName("dietLabels")
    public void setDietLabels(List<String> dietLabels) {
        this.dietLabels = dietLabels;
    }

    @SerializedName("healthLabels")
    public List<String> getHealthLabels() {
        return healthLabels;
    }

    @SerializedName("healthLabels")
    public void setHealthLabels(List<String> healthLabels) {
        this.healthLabels = healthLabels;
    }

    @SerializedName("cautions")
    public List<Object> getCautions() {
        return cautions;
    }

    @SerializedName("cautions")
    public void setCautions(List<Object> cautions) {
        this.cautions = cautions;
    }

    @SerializedName("totalNutrients")
    public TotalNutrients getTotalNutrients() {
        return totalNutrients;
    }

    @SerializedName("totalNutrients")
    public void setTotalNutrients(TotalNutrients totalNutrients) {
        this.totalNutrients = totalNutrients;
    }

    @SerializedName("totalDaily")
    public TotalDaily getTotalDaily() {
        return totalDaily;
    }

    @SerializedName("totalDaily")
    public void setTotalDaily(TotalDaily totalDaily) {
        this.totalDaily = totalDaily;
    }

    @SerializedName("ingredients")
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @SerializedName("ingredients")
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
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
