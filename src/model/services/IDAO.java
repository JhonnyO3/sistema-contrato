package model.services;

public interface IDAO {
	
	public double interest(double amount, int months);
	
	public double paymentFee(double amount);

}
