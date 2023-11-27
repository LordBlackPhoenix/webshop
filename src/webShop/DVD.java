package webShop;

public class DVD extends Article {
	public final float VAT = 0.19f;
	
	private String name;
	private int duration;
	private int countryCode;
	
	public String getCategory() {
		return "DVD";
	}
	
	public float getPrice() {
		return (1 + VAT) * super.getPrice();
	}

	public DVD(int articleNumber, float price, String name, int duration, int countryCode) {
		super(articleNumber, price);
		
		this.name = name;
		this.duration = duration;
		this.countryCode = countryCode;
	}
	
	public String toString() {
		return name;
	}
}
