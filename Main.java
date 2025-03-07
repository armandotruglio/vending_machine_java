package commerce;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		AdminPanel panel = new AdminPanel();
		Product water = new Product("Water", 0.50 , 5);
		Product chips = new Product("Chips", 1.50 , 2);
		Product coke = new Product("Coke", 2.00, 6);
		Product lemonade = new Product("Lemonade", 2.5 , 10);
		panel.addProduct(water);
		panel.addProduct(chips);
		panel.addProduct(coke);
		panel.addProduct(lemonade);
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Benvenuto!\n\n");
		while(true) {
			System.out.println("MENU PRINCIPALE");
			System.out.println("-------------------------------------------");
			System.out.println("Credito Residuo: " + panel.getCredit());
			System.out.println("-------------------------------------------");
			Menu.printMenu();
			String choice = scanner.nextLine();
			
			if(Integer.parseInt(choice) == 1) {
				System.out.println("-------------------------------------------");
				System.out.println("Digitare somma da inserire: ");
				Double credit = Double.parseDouble(scanner.nextLine());
				panel.addCredit(credit);
			}
			else if(Integer.parseInt(choice) == 2) {
				System.out.println("Lista prodotti        Credito: " + panel.getCredit());
				System.out.println("-------------------------------------------");
				panel.printList();
				System.out.println("-------------------------------------------");
				System.out.println("Scegli il prodotto da acquistare: ");
				int id = Integer.parseInt(scanner.nextLine());
				
				int outcome = panel.buyProduct(id);
				
				if(outcome==1) {
					System.out.println("Erogazione prodotto...\n\n");
				} else if (outcome==0){
					System.out.println("Prodotto non disponibile\n\n");
				} else {
					System.out.println("Credito Insufficiente\n\n");
				}
				
			}
			else if(Integer.parseInt(choice) == 0) {
				if(panel.wallet.getCredit()>0) {
					System.out.println("Erogazione resto...");					
				}
				break;
			}
			else if(Integer.parseInt(choice) == 3) {
				System.out.println("Inserisci password: ");
				String password = scanner.nextLine().trim().toString();
				
				if(password.equals("password")) {
					
					while(true) {
						System.out.println("MENU ADMIN");
						Menu.printAdminMenu();
						String adminChoice = scanner.nextLine();
						if(Integer.parseInt(adminChoice) == 1) {
							
							System.out.println("-------------------------------------------");
							System.out.println("Digitare nome prodotto da inserire: ");
							String name = scanner.nextLine().trim();
							
							System.out.println("Digitare prezzo prodotto da inserire: ");
							double price = Double.parseDouble(scanner.nextLine());
							
							System.out.println("Digitare quantità prodotto da inserire: ");
							int stock = Integer.parseInt(scanner.nextLine());
							
							panel.addProduct(new Product(name,price,stock));
							
							System.out.println("Prodotto aggiunto con successo");
						}
						else if(Integer.parseInt(adminChoice) == 2) {
							panel.printAdminList();
							System.out.println("-------------------------------------------");
							System.out.println("Digitare ID prodotto da rimuovere: ");
							int id = Integer.parseInt(scanner.nextLine());
							
							if(panel.removeProduct(id)) {
								System.out.println("Prodotto rimosso con successo");
							} else {
								System.out.println("Id non valido");
							}
						}
						else if(Integer.parseInt(adminChoice) == 3) {
							panel.printAdminList();
							System.out.println("-------------------------------------------");
							System.out.println("Digitare ID prodotto da modificare: ");
							int id = Integer.parseInt(scanner.nextLine());
							
							if(!panel.productExist(id)) {
								System.out.println("Il prodotto non esiste");
							} else {
								while(true) {
									System.out.println("MENU MODIFICA PRODOTTO");
									panel.printAdminList();
									Menu.printEditMenu();
									String editChoice = scanner.nextLine();
									if(Integer.parseInt(editChoice) == 1) {
										System.out.println("Digitare nuovo nome prodotto: ");
										String name = scanner.nextLine().trim();
										
										panel.updateProduct(id, name);
									}
									else if(Integer.parseInt(editChoice) == 2) {
										System.out.println("Digitare nuovo prezzo prodotto: ");
										double price = Double.parseDouble(scanner.nextLine());
										
										panel.updateProduct(id, price);
										
									}
									else if(Integer.parseInt(editChoice) == 3) {
										System.out.println("Digitare nuova quantità prodotto: ");
										int stock = Integer.parseInt(scanner.nextLine());
										
										panel.updateProduct(id, stock);
									}
									else if(Integer.parseInt(editChoice) == 0) {
										break;
									}
								}
							}
						}
						else if(Integer.parseInt(adminChoice) == 0) {
							break;
						}
					}
				} else {
					System.out.println("Password Errata");
					
				}
			}
		}
		
		scanner.close();
		
		
	}

}
