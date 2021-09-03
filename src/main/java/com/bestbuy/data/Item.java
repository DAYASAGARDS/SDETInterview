package com.bestbuy.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A POJO matching the contents of the Product table.
 */
public class Item {
    public long id;

    @JsonProperty("product_name")
    public String value;
    public Map<String, Boolean> keys;
    public Map<String, Map<String, List<Long>>> attributes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct() {
        return value;
    }

    public void setProduct(String value) {
        this.value = value;
    }

    public Map<String, Boolean> getKeys() {
        return keys;
    }

    public void setKeys(Map<String, Boolean> keys) {
        this.keys = keys;
    }

    public void addAttributesForFinish(String sku, String finish, List<Long> attributeIds) {
        if(!attributes.containsKey(sku)) {
            attributes.put(sku, new HashMap<>());
        }
        attributes.get(sku).put(finish, attributeIds);
    }

    public List<Long> retrieveAttributesForFinish(String sku, String finish) {
        return attributes.get(sku).computeIfAbsent(finish, s -> Collections.emptyList());
    }
}
