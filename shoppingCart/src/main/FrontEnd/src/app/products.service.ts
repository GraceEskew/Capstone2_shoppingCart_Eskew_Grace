//STATUS: BASIC ROUTES DONE - MAY ND TO REVIST FOR SPECIFICS

import { Injectable } from '@angular/core';
import { Products } from './products';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  apiUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }
  
  //REST ROUTES - BASICS
  //GET ALL PRODUCTS (JAVA: GET METHOD)
  getProducts(): Observable<Products[]> {
    const url = `${this.apiUrl}/products`;
    return this.http.get<Products[]>(url);
  }

  //ADD A PRODUCT (JAVA: POST METHOD)
  addProduct(products: Products): Observable<Products> {
    const url = `${this.apiUrl}/products`;
    return this.http.post<Products>(url, products);
  }

  //UPDATE A PRODUCT (JAVA: PUT METHOD)
  updateProduct(id: number, products: Products): Observable<Products> {
    const url = `${this.apiUrl}/products/${id}`;
    return this.http.put<Products>(url, products);
  }

  //DELETE A PRODUCT (JAVA: DELETE METHOD)
  deleteProduct(id: number): Observable<Products> {
    const url = `${this.apiUrl}/products/${id}`;
    return this.http.delete<Products>(url);
  }

}
