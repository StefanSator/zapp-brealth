
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
    "label",
    "quantity",
    "unit"
})
public class NIA_ {

    @SerializedName("label")
    private String label;
    @SerializedName("quantity")
    private Double quantity;
    @SerializedName("unit")
    private String unit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("label")
    public String getLabel() {
        return label;
    }

    @SerializedName("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @SerializedName("quantity")
    public Double getQuantity() {
        return quantity;
    }

    @SerializedName("quantity")
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @SerializedName("unit")
    public String getUnit() {
        return unit;
    }

    @SerializedName("unit")
    public void setUnit(String unit) {
        this.unit = unit;
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
