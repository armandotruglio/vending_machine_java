package commerce;

public class Wallet {
	private double credit;

	public Wallet(double credit) {
		this.credit = credit;
	}
	
	public void addCredit(double amount) {
		this.credit += amount;
	}
	
	public void decreseCredit(double amount) {
		this.credit -= amount;
	}
	
	public double getCredit() {
		return this.credit;
	}
	
	
}
