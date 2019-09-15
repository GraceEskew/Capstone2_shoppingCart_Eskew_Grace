//STATUS: Done - as far as I can tell. Review when able.

import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Products } from '../products';
import { ProductsService } from '../products.service'
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  //1. CREATES REACTIVE FORM 8.28 PART 2
  //values should be in array bc they can hold multiple values - 1st one is the initial input, 2nd one is the validator
  //3. Below creates an array of Products
  allProducts: Products[] = [];

  addProductForm = this.fb.group({
    name: [''],
    category: [''],
    price: [''],
    isImported: [''],
    importTax: [''],
    isTaxed: [''],
    salesTax: [''],
    quantity: [''],
    imageUrl: ['']

  });

  productIdBeingEdited: number;
  getSub: Subscription;
  deleteSub: Subscription;
  postSub: Subscription;
  putSub: Subscription;

  //2. added Private fb: FormBuilder
  constructor(private fb: FormBuilder, private productsService: ProductsService) { }

  ngOnInit() {
    this.getProducts();
  }
  
  ngOnDestroy() {
    if(this.getSub) {
      this.getSub.unsubscribe();
    }

    if(this.deleteSub) {
      this.deleteSub.unsubscribe();
    }

    if(this.putSub) {
      this.putSub.unsubscribe();
    }
  }

  getProducts() {
    this.getSub = this.productsService.getProducts().subscribe(
      (res: any) => {
        this.allProducts = res;
      }
    );
  }

  onDeleteProduct(products: Products) {
    this.deleteSub = this.productsService.deleteProduct(products.id).subscribe(
      (res: any) => {
        this.getProducts();
      }
    )
  }
  
  //4. Added onSubmit form - goal is the pull the value from the input boxes, and then call the 
  onSubmitForm() {

    const name = this.addProductForm.value.name;
    const category = this.addProductForm.value.category;
    const price = this.addProductForm.value.price;
    const quantity = this.addProductForm.value.quantity;
    const imageUrl = this.addProductForm.value.imageUrl;

    const newProducts = new Products(name, category, price, quantity, imageUrl)

    if(this.productIdBeingEdited == undefined) {
      this.postSub = this.productsService.addProduct(newProducts).subscribe(
        (res: any) => {
          this.getProducts();
          this.addProductForm.reset();
        }
      )
    } else {
      newProducts.id = this.productIdBeingEdited;
      this.putSub = this.productsService.updateProduct(this.productIdBeingEdited, newProducts).subscribe (
        (res: any) => {
          this.onCancelEditProduct();
          this.getProducts();
        }
      )
    }
  }

  onStartEditProduct(products: Products) {
    this.productIdBeingEdited = products.id;
    this.addProductForm.patchValue(products);
  }

  onCancelEditProduct() {
    this.productIdBeingEdited = undefined;
    this.addProductForm.reset();
  }

}
