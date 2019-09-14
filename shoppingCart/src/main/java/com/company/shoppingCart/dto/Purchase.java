package com.company.shoppingCart.dto;

public class Purchase {

private Integer productId;
private String category;
private Boolean isTaxable;
private Boolean isImported;
private Float unitPrice;
private Float quantity;
private Float subTotal;
private Float salesTax;
private Float importTax;
private Float totalTax;
private Float totalCost;

//GETTERS & SETTERS
//switched to Float from BigDecimal
//switched to Float from Integer on SubTotal
public Integer getProductId() {return this.productId;}
public void setProductId(Integer productId) {this.productId = productId;}

public String getCategory() {return this.category;}
public void setCategory(String category) {this.category = category;}

public Boolean getIsTaxable() {return this.isTaxable;}
public void setIsTaxable(Boolean isTaxable) {this.isTaxable = isTaxable;}

public Boolean getIsImported() {return this.isImported;}
public void setIsImported(Boolean isImported) {this.isImported = isImported;}

public Float getUnitPrice() {return this.unitPrice;}
public void setUnitPrice(Float unitPrice) {this.unitPrice = unitPrice;}

public Float getQuantity() {return this.quantity;}
public void setQuantity(Float quantity) {this.quantity = quantity;}

public Float getSubTotal() {return this.subTotal;}
public void setSubTotal(Float subTotal) {this.subTotal = subTotal;}

public Float getSalesTax() {return this.salesTax;}
public void setSalesTax(Float salesTax) {this.salesTax = salesTax;}

public Float getImportTax() {return this.importTax;}
public void setImportTax(Float importTax) {this.importTax = importTax;}

public Float getTotalTax() {return this.totalTax;}
public void setTotalTax(Float totalTax) {this.totalTax = totalTax;}

public Float getTotalCost() {return this.totalCost;}
public void setTotalCost(Float totalCost) {this.totalCost = totalCost;}
}
