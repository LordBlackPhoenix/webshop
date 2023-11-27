package webShop;

public abstract class Article {
	private int articleNumber;
	private float price;
	
	public float getPrice() {
		return price;
	}
	
	abstract public String getCategory();
	
	public Article(int articleNumber, float price) {
		this.articleNumber = articleNumber;
		this.price = price;
	}
}
