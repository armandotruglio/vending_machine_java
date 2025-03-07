package commerce;

public class Menu {
	
	public static void printMenu() {
		System.out.println("\n\nScegli cosa fare:");
		System.out.println("1. Aggiorna Credito");
		System.out.println("2. Acquista Prodotto");
		System.out.println("3. Accedi al pannello di controllo");
		System.out.println("0. Esci / Eroga resto");
	}
	
	public static void printAdminMenu() {
		System.out.println("\n\nScegli cosa fare:");
		System.out.println("1. Aggiungi prodotto");
		System.out.println("2. Rimuovi Prodotto");
		System.out.println("3. Modifica prodotto");
		System.out.println("0. Esci");
	}
	
	public static void printEditMenu() {
		System.out.println("\n\nScegli cosa modificare:");
		System.out.println("1. Nome");
		System.out.println("2. Prezzo");
		System.out.println("3. Quantità");
		System.out.println("0. Esci");
	}
}
