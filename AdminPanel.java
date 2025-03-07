package commerce;



public class AdminPanel extends Panel{

	public AdminPanel() {
		new Panel();
	}
	
	public void addProduct(Product product) {
		this.productList.addLast(product);
	}
	
	public Boolean removeProduct(int index) {
		if(!this.productExist(index)) {
			return false;
		}
		this.productList.remove(index);
		return true;
	}
	
	
	//Metodi per modificare prodotto
	public Boolean updateProduct(int index, String name) {
		if(!this.productExist(index)) {
			return false;
		}
		
		this.productList.get(index).setName(name);
		return true;
	}
	
	public Boolean updateProduct(int index, Double price) {
		if(!this.productExist(index)) {
			return false;
		}
		
		this.productList.get(index).setPrice(price);
		return true;
	}
	
	public Boolean updateProduct(int index, int stock) {
		if(!this.productExist(index)) {
			return false;
		}
		
		this.productList.get(index).setStock(stock);
		return true;
	}
	
}
