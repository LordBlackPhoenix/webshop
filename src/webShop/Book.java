package webShop;

public class Book extends Article {
	public final float VAT = 0.07f;
	
	private String author;
	private String title;
	private int year;
	
	public String getCategory() {
		return "Buch";
	}
	
	public float getPrice() {
		return (1 + VAT) * super.getPrice();
	}
	
	public Book(int articleNumber, float price, String author, String title, int year) {
		super(articleNumber, price);
		
		this.author = author;
		this.title = title;
		this.year = year;
	}
	
	public String toString() {
		return author + ": " + title;
	}
}
