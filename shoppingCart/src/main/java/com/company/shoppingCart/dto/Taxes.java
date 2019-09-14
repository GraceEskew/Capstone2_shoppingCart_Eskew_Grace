package com.company.shoppingCart.dto;

import java.math.BigDecimal;

public class Taxes {

    //switched to Float from BigDecimal
    private String category;
    private Float salesTax;
    private Float importTax;
    private Boolean isImported;
    private Boolean isTaxable;

    public String getCategory() {return this.category;}
    public void setCategory(String category) {this.category = category;}

    public Float getSalesTax() {return this.salesTax;}
    public void setSalesTax(Float salesTax) {this.salesTax = salesTax;}

    public Float getImportTax() {return this.importTax;}
    public void setImportTax(Float importTax) {this.importTax = importTax;}

    public Boolean getIsImported() {return this.isImported;}
    public void setIsImported(Boolean isImported) {this.isImported = isImported;}

    public Boolean getIsTaxable() {return this.isTaxable;}
    public void setIsTaxable(Boolean isTaxed) {this.isTaxable = isTaxed;}

    void salesTax() {};
    void importTax() {};

}
