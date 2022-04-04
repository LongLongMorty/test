public class OrderItem extends Product{
    private int quantity;
    Product product;
    public OrderItem(Product initialProduct, int initialQuantity){
        product = initialProduct;
        this.quantity = initialQuantity;
    }
    public Product getProduct(){
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }
    public double getValue(){
        return quantity * product.getPrice();
    }
    //Override toString
    public String toString(){
        return quantity + " " + product.getCode() + " " + product.getPrice();
    }
}
