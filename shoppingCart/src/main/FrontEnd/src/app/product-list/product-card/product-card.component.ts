import { Component, OnInit, Input } from '@angular/core';
import { Products } from 'src/app/products';
import { CartService } from 'src/app/cart.service';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.scss']
})

export class ProductCardComponent implements OnInit {
  @Input() products: Products;
  buttonText  = "Add to Cart"
  qtyToPurchase = 1;

  constructor(private cartService: CartService) { }

  ngOnInit() { }

  onAddToCart(product: Products) {
    if(this.qtyToPurchase > 0 && this.qtyToPurchase <= product.quantity) {
      this.cartService.addToCart(product, this.qtyToPurchase);
      this.buttonText = "Added";

      setTimeout(() => {
        this.buttonText = "Add to Cart"
      }, 1500);
    }
  }

}
