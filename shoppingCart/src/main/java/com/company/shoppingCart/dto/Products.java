package com.company.shoppingCart.dto;

//IMPORTS
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //updated floats from BigDecimal
    @NotEmpty
    private String name;
    @NotNull
    private Float price;
    @NotNull
    private Boolean isImported;
    @NotNull
    private Float importTax;
    @NotNull
    private Boolean isTaxed;
    @NotNull
    private Float salesTax;
    @NotNull
    private Integer quantity;
    @NotEmpty
    private String category;
//    @NotNull
//    private Float subTotal;
//    @NotNull
//    private Float taxesTotal;
//    @NotNull
//    private Float totalCost;


    //GETTERS & SETTERS
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Float getPrice() {return this.price;}
    public void setPrice(Float price) {this.price = price;}

    public Boolean getIsImported() {return this.isImported;}
    public void setIsImported(Boolean isImported) {this.isImported = isImported;}

    public Float getImportTax() {return this.importTax;}
    public void setImportTax(Float importTax) {this.importTax = importTax;}

    public Boolean getIsTaxed() {return this.isTaxed;}
    public void setIsTaxed(Boolean isTaxed) {this.isTaxed = isTaxed;}

    public Float getSalesTax () {return this.salesTax;}
    public void setSalesTax(Float salesTax) {this.salesTax = salesTax;}

    public Integer getQuantity() {return quantity;}
    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public String getCategory() {return this.category;}
    public void setCategory(String category) {this.category = category;}

//    public Float getSubTotal() {return this.subTotal;}
//    public void setSubTotal(Float subTotal) {this.subTotal = subTotal;}
//
//    public Float getTaxesTotal() {return this.taxesTotal;}
//    public void setTaxesTotal(Float taxesTotal) {this.taxesTotal = taxesTotal;}
//
//    public Float getTotalCost() {return this.totalCost;}
//    public void setTotalCost(Float totalCost) {this.totalCost = totalCost;}
}
