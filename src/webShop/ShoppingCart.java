package webShop;

import java.util.HashMap;
import java.util.stream.Collectors;

class ItemQuantity {
	private int quantity;
	private final Article item;
	
	public ItemQuantity(int quantity, Article item) {
		this.setQuantity(quantity);
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Article getItem() {
		return item;
	}
	
	public float totalPrice() {
		return quantity * item.getPrice();
	}
	
	public String toBill() {
		return String.format("%-3d x %-8s - %-30s %8.2f € %8.2f €", quantity, item.getCategory() ,item, item.getPrice(), quantity * item.getPrice());
	}
}

public class ShoppingCart {
	public static HashMap<Integer, Article> shopInventory = new HashMap<Integer, Article>();
	
	static {
		shopInventory.put(1234, new Book(1234, 32.71f, "Luigi Lo Iacono", "Web Sockets", 2015));
		shopInventory.put(5678, new DVD(5678, 14.95f, "Spiel mir das Lied vom Tod", 120, 2));
		shopInventory.put(5789, new DVD(5789, 8.40f, "Casablanca, Classic Collection", 150, 2));
	}
			
	private HashMap<Integer, ItemQuantity> shoppingCartContents = new HashMap<Integer, ItemQuantity>();
	
	public boolean addItem(int articleNumber, int quantity) {
		if(shopInventory.containsKey(articleNumber)) {
			if(shoppingCartContents.containsKey(articleNumber))
				shoppingCartContents.get(articleNumber).setQuantity(shoppingCartContents.get(articleNumber).getQuantity() + quantity);
			else
				shoppingCartContents.put(articleNumber, new ItemQuantity(quantity, shopInventory.get(articleNumber)));
		
			return true;
		}
		return false;
	}
	
	public String showBill() {
		return shoppingCartContents.values().stream().map(pos -> pos.toBill()).collect(Collectors.joining("\n")) +
			   "\n--------------------------------------------" +
			   "\nGesamtpreis: "+cartTotal()+" €";
	}
	
	public float cartTotal() {
		return (float)shoppingCartContents.values().stream().mapToDouble(pos -> pos.totalPrice()).sum();
	}
	
	public static void main(String...args) {
		ShoppingCart sc = new ShoppingCart();
		ShoppingCart sc2 = new ShoppingCart();
		
		sc.addItem(1234, 5);
		sc.addItem(5789, 2);
		sc.addItem(1234, 2);
		sc.addItem(5678, 1);
		System.out.println(sc.showBill());
		
		System.out.println();
		
		sc2.addItem(1234, 10);
		System.out.println(sc2.showBill());
		
	}
}
