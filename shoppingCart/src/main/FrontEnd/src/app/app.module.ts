import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { CartComponent } from './cart/cart.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductCardComponent } from './product-list/product-card/product-card.component';
import { SearchPipe } from './shared/search.pipe';
import { ProductsMasterComponent } from './product-list/product-card/products-master/products-master.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

//added ClientModule to remove "Uncaught (in promise) Console error
import { HttpClientModule } from '@angular/common/http';
// import { CategorySearchPipe } from './category-search.pipe';


@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCardComponent,
    NavbarComponent,
    SearchPipe,
    PageNotFoundComponent,
    CartComponent,
    AdminComponent,
    ProductsMasterComponent,
    ProductDetailComponent,
    // CategorySearchPipe,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
