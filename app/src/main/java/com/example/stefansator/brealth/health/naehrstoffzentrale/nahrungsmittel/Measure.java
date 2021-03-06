package com.example.stefansator.brealth.health.naehrstoffzentrale.nahrungsmittel;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "uri",
        "label"
})
public class Measure {

    @SerializedName("uri")
    private String uri;
    @SerializedName("label")
    private String label;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}