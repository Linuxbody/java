/*
    对象比较
 */

class Book{
    private String title ;
    private double price ;

    public String getTitle() {
        return this.title ;
    }
    public double getPrice() {
        return this.price ;
    }

    public Book(String title, double price) {
        this.title = title ;
        this.price = price ;
    }

}
public class Demo5 {
    public static void main(String args[]) {
        Book b1 = new Book("java", 99.9) ;
        Book b2 = new Book("java", 99.9) ;
        Book b3 = new Book("go", 89.8) ;

        if (b1.getTitle().equals(b2.getTitle()) && b1.getPrice() == b2.getPrice()) {
            System.out.println("there the same");
        }else {
            System.out.println("there not the same");
        }

        if (b1.getTitle().equals(b3.getTitle()) && b1.getPrice() == b3.getPrice()) {
            System.out.println("there the same");
        }else {
            System.out.println("there not the same");
        }
    }

}
