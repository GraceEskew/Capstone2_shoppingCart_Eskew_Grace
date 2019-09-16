import { Component, OnInit, OnDestroy } from '@angular/core';
import { Products } from 'src/app/shared/products';
import { ProductsService } from '../shared/products.service';
import { Subscription } from 'rxjs';


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit, OnDestroy {
  allProducts: Products[] = [];
  searchTerm = "";
  getSub: Subscription;

  constructor(private productsService: ProductsService) { }

  ngOnInit() {
    this.getProducts();
  }

  ngOnDestroy() {
    if(this.getSub) {
      this.getSub.unsubscribe();
    }
  }

  getProducts() {
    this.getSub = this.productsService.getProducts().subscribe(
      (res: any) => {
        this.allProducts = res;
      },
      err => {
        console.log(err);
      }
    )
  }

}
