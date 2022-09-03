package model.services;

public class PaypalService implements IDAO {
	
	@Override
	public double paymentFee(double amount) {
		double installmentPaymentFee = amount + (amount * 0.02) ;
		return installmentPaymentFee;
		
	}
	@Override

	public double interest(double amount, int months) {
		Double interestRateInstallment = amount + (amount * 0.01) * months;
		
		return interestRateInstallment;
		
	}

}
