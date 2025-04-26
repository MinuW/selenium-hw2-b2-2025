package com.pragmatic.selenium.util;

import java.math.BigDecimal;

public class Products {
    private String Name;
    private String Price;
    private BigDecimal priceValue;
    private String description;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        String stringPriceValue = price.replace("$","");
        priceValue= new BigDecimal(stringPriceValue);
        Price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
