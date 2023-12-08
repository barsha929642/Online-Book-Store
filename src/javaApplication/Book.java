package javaApplication;

public class Book {
	
	private int no;
    private String name;
    private double price;
    private String Author;

    public Book(int no, String name, double price, String Author) {
        this.no = no;
        this.name = name;
        this.price = price;
        this.Author = Author;
    }

    

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }
    

    @Override
    public String toString() {
        return ","+no+","+name + "," +Author+","+ price+","+"\n";
    }

}
