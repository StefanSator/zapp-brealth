package com.example.stefansator.brealth.health.naehrstoffzentrale.nahrungsmittel;

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
        "yield",
        "ingredients"
})
public class NutrientPostDetails {

    @SerializedName("yield")
    private Integer yield;
    @SerializedName("ingredients")
    private List<Ingredient> ingredients = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public NutrientPostDetails(Integer yield, List<Ingredient> ingredients) {
        this.yield = yield;
        this.ingredients = ingredients;
    }

    @SerializedName("yield")
    public Integer getYield() {
        return yield;
    }

    @SerializedName("yield")
    public void setYield(Integer yield) {
        this.yield = yield;
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