package commerce;

public class Product {
	private String name;
	private double price;
	private int stock;
	
	
	public Product(String name, double price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
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
	
	public void setPrice(Double price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}

	
	public boolean isInStock() {
		return this.stock > 0;
	}
	
	public boolean decreaseStock() {
		if(this.isInStock()) {
			this.stock--;
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	
	
}
