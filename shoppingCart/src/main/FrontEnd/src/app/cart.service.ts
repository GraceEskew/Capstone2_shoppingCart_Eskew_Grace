import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Products } from './products';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CartService {
  productsInCart: Products[] = [];
  apiUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  addToCart(products: Products, qty: number) {
    let productAlreadyInCart = false;
    this.productsInCart = this.productsInCart.map( i => {
      if (i.id == products.id) {
        i.quantity += qty;
        productAlreadyInCart = true;
      }
      return i;
    });

    if (!productAlreadyInCart) {
      const newProducts = new Products(products.name, products.category, products.price, products.salesTax, qty, products.quantity);
      newProducts.id = products.id;
      this.productsInCart.push(newProducts);
    }
  }

  getProductsInCart(): Products[] {
    return this.productsInCart;
  }

  removeProductFromCart(index: number) {
    this.productsInCart.splice(index, 1);
  }

  emptyCart() {
    this.productsInCart = [];
  }

  //THIS WORKS WITH THE PURCHASE METHODS IN JAVA
  purchase(productItems: Products[]): Observable<null> {
    const url= `${this.apiUrl}/purchase`;
    return this.http.post<null>(url, productItems);
  }
}
