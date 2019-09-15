import { Pipe, PipeTransform } from '@angular/core';
import { Products } from './products';

@Pipe({
    name: 'search'
})


//cnt add addtnl rtrn because it would be unreachable
//can't add .category after name, type issue
//can't add 2nd transform method - duplicate method

export class SearchPipe implements PipeTransform {
    transform(value: Products[], searchTerm: string): Products[] {
        return value.filter(v => v.name.toLowerCase().includes(searchTerm.toLowerCase()));
    }
}


/*
import {Pipe, PipeTransform } from '@angular/core';
@Pipe({
    name: 'personSearch'
})
export class PersonSearchPipe implements PipeTransform {
    transform(items: Array, nameSearch: string, emailSearch: string, companySearch: string){
        if (items && items.length){
            return items.filter(item =>{
                if (nameSearch && item.name.toLowerCase().indexOf(nameSearch.toLowerCase()) === -1){
                    return false;
                }
                if (emailSearch && item.email.toLowerCase().indexOf(emailSearch.toLowerCase()) === -1){
                    return false;
                }
                if (companySearch && item.company.toLowerCase().indexOf(companySearch.toLowerCase()) === -1){
                    return false;
                }
                return true;
           })
        }
        else{
            return items;
        }
    }
}

*/