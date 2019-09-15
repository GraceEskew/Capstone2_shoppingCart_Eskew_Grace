import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Products } from '../products';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})


export class CartComponent implements OnInit {
  productsInCart: Products[] = [];
  total = 0;
  infoText = "No Items currently in your cart";
  apiUrl = "";

  constructor(private cartService: CartService, private router: Router) { }

  ngOnInit() {
    this.getProductsInCart();
    this.calculateTotal();
  }

  onRemoveProductsFromCart(index: number) {
    this.cartService.removeProductFromCart(index);
    this.getProductsInCart();
    this.calculateTotal();
  }

  getProductsInCart() {
    this.productsInCart = this.cartService.getProductsInCart();
  }

  onPurchase() {
    this.cartService.purchase(this.productsInCart).subscribe(
      (res: any) => {
        this.cartService.emptyCart();
        this.productsInCart = [];
        this.infoText = "Thank you for your purchase! Redirecting you back to the home page.";
        
        setTimeout(() => {
          this.router.navigate(["/products"]);
        }, 1500);
      }
    );
  }

  //CAN I MESS WITH THE TAX CALC HERE? - nope. BE.
  calculateTotal() {
    this.total = this.productsInCart.reduce((total, currVal) => total + (currVal.price * currVal.quantity), 0)
  }

  onDecreaseQty(item: Products) {
    if(item.quantity > 0) {
      item.quantity--;
      this.calculateTotal();
    }
  }

  onIncreaseQty(item: Products) {
    if(item.quantity < item.available) {
      item.quantity++;
      this.calculateTotal();
    }
  }

}
