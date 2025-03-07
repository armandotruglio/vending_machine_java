package commerce;



public class AdminPanel extends Panel{

	public AdminPanel() {
		super();
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

	//Metodo per stampare lista di tutti prodotti
	public void printAdminList() {
		if(this.productList.isEmpty()) {
			System.out.println("Non ci sono prodotti disponibili");
		} else {
			System.out.println("\n\n");
			System.out.printf("%-20s%-20s%-20s\n","Nome","Prezzo","Quantità");
			System.out.println("-------------------------------------------");
			for(Product product : this.productList) {
				System.out.print(productList.lastIndexOf(product) + " ");
				System.out.printf("%-20s%-20s%-20s\n",
						product.getName(),product.getPrice(), product.getStock());

			}
		}
	}
	
}
