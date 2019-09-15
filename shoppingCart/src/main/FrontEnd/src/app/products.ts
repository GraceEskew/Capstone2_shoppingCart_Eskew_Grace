export class Products {
    id: number;
    name: String;
    category: String;
    price: number;
    salesTax: number;
    quantity: number;
    available: number; 
    imageUrl: String;

    constructor(name: String, category: String, price: number, salesTax: number, quantity: number, available?: number) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.available = available;
        this.imageUrl = this.imageUrl;
    }
}