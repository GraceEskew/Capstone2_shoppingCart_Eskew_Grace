package com.company.shoppingCart.controller;

import com.company.shoppingCart.dto.Purchase;
import com.company.shoppingCart.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @RequestMapping(value="/purchase", method = RequestMethod.POST)
    public Purchase createInvoice(@RequestBody @Valid Purchase invoice) {
            return purchaseService.generateInvoice(invoice);
    }

}
