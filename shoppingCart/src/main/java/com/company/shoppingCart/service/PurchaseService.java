package com.company.shoppingCart.service;

import com.company.shoppingCart.dao.ProductsRepository;

import com.company.shoppingCart.dto.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseService {

    @Autowired
    private ProductsRepository productsRepo;

    public Purchase generateInvoice(Purchase purchase) {
        Purchase invoice = new Purchase();

        invoice.setProductId(purchase.getProductId());
        invoice.setCategory(purchase.getCategory());
        invoice.setIsTaxable(purchase.getIsTaxable());
        invoice.setIsImported(purchase.getIsImported());
        invoice.setUnitPrice(purchase.getUnitPrice());
        invoice.setQuantity(purchase.getQuantity());
        invoice.setSubTotal(purchase.getSubTotal());
        invoice.setSalesTax(purchase.getSalesTax());
        invoice.setImportTax(purchase.getImportTax());
        invoice.setTotalTax(addTaxes(invoice));

        //running into variable issue between invoice and Float for addTaxes();. Commented out while investigating.
//        invoice = addTaxes(invoice);
        invoice.setTotalCost(purchase.getTotalCost());
//        invoice = totalCost(invoice);

        return invoice;
    }

    private Float addTaxes(Purchase invoice) {
        //OPT B FOR CALCULATIONS - UnitPrice*1.05 or 1.10 = combinedTotal - UnitPrice = TaxTotal

        //IF ITEM CAN BE TAXED BOTH WAYS
        if (invoice.getIsTaxable() && invoice.getIsImported()) {
            invoice.setTotalTax((invoice.getImportTax()*invoice.getQuantity())+
                    (invoice.getSalesTax()+invoice.getQuantity()));
            return invoice.getTotalTax();

            //IF ITEM CAN ONLY BE TAXED - SALES
        } else if (invoice.getIsTaxable() && !invoice.getIsImported()) {
            invoice.setTotalTax((invoice.getSalesTax()*invoice.getQuantity()));
            return invoice.getTotalTax();

            //IF ITEM CAN ONLY BE TAXED - IMPORT
        } else if (!invoice.getIsTaxable() && invoice.getIsImported()) {
            invoice.setTotalTax(invoice.getImportTax()* invoice.getQuantity());
            return invoice.getTotalTax();

            //IF ITEM CANNOT BE TAXED
        } else {
            return 0.0f;
        }
    }

}