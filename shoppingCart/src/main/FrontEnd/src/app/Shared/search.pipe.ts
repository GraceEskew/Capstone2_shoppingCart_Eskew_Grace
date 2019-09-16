import { Pipe, PipeTransform } from '@angular/core';
import { Products } from './products';

@Pipe({
    name: 'search'
})


//SEARCH FOR EITHER NAME OF PRODUCT OR PRODUCT CATEGORY
export class SearchPipe implements PipeTransform {

    transform(value: Products[], filterText: string): Products[] {
      let productsMatching = value.filter((products: Products) => {
        if (products.name && products.name.toLowerCase().includes(filterText.toLowerCase())) {
          return true;
        }
        if (products.category && products.category.toLowerCase().includes(filterText.toLowerCase())) {
          return true;
        }
        
        return false;
      });
  
      return productsMatching;
    }
}
  
