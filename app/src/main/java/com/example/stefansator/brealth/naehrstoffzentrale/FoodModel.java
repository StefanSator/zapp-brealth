package com.example.stefansator.brealth.naehrstoffzentrale;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "text",
        "parsed",
        "hints",
        "page",
        "numPages"
})
public class FoodModel {

    @SerializedName("text")
    private String text;
    @SerializedName("parsed")
    private List<Object> parsed = null;
    @SerializedName("hints")
    private List<Hint> hints = null;
    @SerializedName("page")
    private Integer page;
    @SerializedName("numPages")
    private Integer numPages;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("text")
    public String getText() {
        return text;
    }

    @SerializedName("text")
    public void setText(String text) {
        this.text = text;
    }

    @SerializedName("parsed")
    public List<Object> getParsed() {
        return parsed;
    }

    @SerializedName("parsed")
    public void setParsed(List<Object> parsed) {
        this.parsed = parsed;
    }

    @SerializedName("hints")
    public List<Hint> getHints() {
        return hints;
    }

    @SerializedName("hints")
    public void setHints(List<Hint> hints) {
        this.hints = hints;
    }

    @SerializedName("page")
    public Integer getPage() {
        return page;
    }

    @SerializedName("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    @SerializedName("numPages")
    public Integer getNumPages() {
        return numPages;
    }

    @SerializedName("numPages")
    public void setNumPages(Integer numPages) {
        this.numPages = numPages;
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