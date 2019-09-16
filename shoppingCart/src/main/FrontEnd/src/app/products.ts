export class Products {
    id: number;
    name: String;
    category: String;
    price: number;
    isImported: String;
    importTax: number;
    isTaxed: String;
    salesTax: number;
    quantity: number;
    imgUrl: String;
    available: number; 


    constructor(name: String, category: String, price: number, isImported: String, importTax: number, isTaxed: String, salesTax: number, quantity: number, imgUrl: String, available?: number) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.isImported = isImported;
        this.importTax = importTax;
        this.isTaxed = isTaxed;
        this.salesTax = salesTax;
        this.quantity = quantity;
        this.imgUrl = this.imgUrl;
        this.available = available;
    }
}