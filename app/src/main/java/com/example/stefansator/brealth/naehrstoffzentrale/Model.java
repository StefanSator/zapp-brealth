package com.example.stefansator.brealth.naehrstoffzentrale;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
public class Model {

    @JsonProperty("text")
    private String text;
    @JsonProperty("parsed")
    private List<Object> parsed = null;
    @JsonProperty("hints")
    private List<Hint> hints = null;
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("numPages")
    private Integer numPages;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("parsed")
    public List<Object> getParsed() {
        return parsed;
    }

    @JsonProperty("parsed")
    public void setParsed(List<Object> parsed) {
        this.parsed = parsed;
    }

    @JsonProperty("hints")
    public List<Hint> getHints() {
        return hints;
    }

    @JsonProperty("hints")
    public void setHints(List<Hint> hints) {
        this.hints = hints;
    }

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    @JsonProperty("numPages")
    public Integer getNumPages() {
        return numPages;
    }

    @JsonProperty("numPages")
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