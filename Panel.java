package commerce;

import java.util.ArrayList;

public class Panel {
	ArrayList<Product> productList;
	Wallet wallet;

	public Panel() {
		this.productList = new ArrayList<>();
		this.wallet = new Wallet(0);
	}
	
	
	//Metodo per acquistare un prodotto
	
	public int buyProduct(int index) {
		if(!this.productExist(index)) {
			return 0;
		}
		Product product = productList.get(index);
		
		
		if(wallet.getCredit()<product.getPrice()) {
			return -1;
		}
		
		if(product.isInStock()) {
			//Diminuisco la quantità del prodotto
			product.decreaseStock();
			//Diminuisco il credito
			wallet.decreseCredit(product.getPrice());
			
			return 1;
		}
		
		return 0;
	}
	
	//Metodi per gestire il credito dall'esterno
	
	public void addCredit(double credit) {
		wallet.addCredit(credit);
	}
	
	public double getCredit() {
		return wallet.getCredit();
	}
	
	
	
	//Metodo per stampare lista prodotti
	
	public void printList() {
		if(this.productList.isEmpty()) {
			System.out.println("Non ci sono prodotti disponibili");
		} else {
			System.out.printf("%-20s%-20s%-20s\n","Nome","Prezzo","Quantità");
			System.out.println("-------------------------------------------");
			for(Product product : this.productList) {
				if(product.isInStock()) {
					System.out.print(productList.lastIndexOf(product) + " ");
					System.out.printf("%-20s%-20s%-20s\n",
							product.getName(),product.getPrice(), product.getStock());
				}
				
			}			
		}
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
	
	
	//Metodo per verificare che l'id del prodotto sia nel range
	public Boolean productExist(int index) {
		if(index>=0 && index<this.productList.size()) {
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
}
