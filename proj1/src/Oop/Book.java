package Oop;

/**
 * @author lyf
 */
public class Book {
    private String title;
    private double price;
    private static int count;
    public Book(){
        count++;
    }
    public Book(String title,double price){
        this.title=title;
        this.price=price;
        count++;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public String getTitle(){
        return this.title;
    }
    public double getPrice(){
        return this.price;
    }
    public void show(){
        System.out.println("书名："+this.title+"，价格："+this.price);
    }
    public int getCount(){
        return count;
    }
}
