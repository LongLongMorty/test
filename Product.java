// I want to be Diana's dog !
public class Product {
    private String code;
    private String description;
    private double price;
    public Product(){

    }
    public Product(String initialCode,String initialDescription,double initialPrice){
        this.code = initialCode;
        this.description = initialDescription;
        this.price = initialPrice;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
    //Override equals()
    public boolean equals(Object object){
        if(this == object)return true;
        if(object == null || getClass() != object.getClass())return false;
        Product product = (Product) object;
        return code.equals(product.code);
    }
    //Override toStrings()
    public String toString(){
        return code + "_" + description + "_" + price;
    }
}