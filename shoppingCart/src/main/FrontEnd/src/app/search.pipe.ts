import { Pipe, PipeTransform } from '@angular/core';
import { Products } from './products';

@Pipe({
    name: 'search'
})

export class SearchPipe implements PipeTransform {
    transform(value: Products[], searchTerm: string): Products[] {
        return value.filter(v => v.name.toLowerCase().includes(searchTerm.toLowerCase()));
    }
}