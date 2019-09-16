package com.company.shoppingCart.service;

import com.company.shoppingCart.dao.ProductsRepository;

import com.company.shoppingCart.dto.Products;
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
        invoice.setIsTaxable(purchase.getIsTaxed());
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

        //For now - listing out all accepted variations of 'category'.
        String [] category= {"books", "Books", "food", "Foods",
                "music", "Music", "medical", "Medical", "medical Supplies", "Medical Supplies",
                "luxury", "Luxury", "luxury goods", "Luxury goods", "luxury Goods", "Luxury Goods",
                "clothes", "Clothes"};

        String i = "";

        /*
        Need to compare input with Array of strings.
        If matches - return true (will apply tax rate)
        If input does not match - return false (will not apply tax rate)
        boolean value is then reviewed by the taxes calc portion to decide
        whether or not to apply tax rates, applying accordingly.

        Items commented out are still under review and would otherwise keep app from running
         */


//        if(i.equals(category[]) {
////            return true;
////        }



        // TAXES CALC - IF ITEM CAN BE TAXED BOTH WAYS
        if (invoice.getIsTaxed() && invoice.getIsImported()) {
            invoice.setTotalTax((invoice.getImportTax()*invoice.getQuantity())+
                    (invoice.getSalesTax()+invoice.getQuantity()));
            return invoice.getTotalTax();

            //IF ITEM CAN ONLY BE TAXED - SALES
        } else if (invoice.getIsTaxed() && !invoice.getIsImported()) {
            invoice.setTotalTax((invoice.getSalesTax()*invoice.getQuantity()));
            return invoice.getTotalTax();

            //IF ITEM CAN ONLY BE TAXED - IMPORT
        } else if (!invoice.getIsTaxed() && invoice.getIsImported()) {
            invoice.setTotalTax(invoice.getImportTax()* invoice.getQuantity());
            return invoice.getTotalTax();

            //IF ITEM CANNOT BE TAXED
        } else {
            return 0.0f;
        }
    }

}