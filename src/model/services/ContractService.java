package model.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private int months;
	private double value;
	private IDAO idao;
	
	public ContractService() {
		
	}

	public ContractService(int months, double value, IDAO idao) {
		super();
		this.months = months;
		this.value = value;
		this.idao = idao;
	}

//Revisar mais tarde

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public IDAO getIdao() {
		return idao;
	}

	public void setIdao(IDAO idao) {
		this.idao = idao;
	}

	public void processContract(Contract contract, int months) {
		double totalValue = contract.getTotalValue() / months;
		List<Installment> installmentList = new ArrayList<>();

		for (int i = 0; i < this.months; i++) {

			Double interestRateInstallment = idao.interest(totalValue, i);
			Calendar calendar = Calendar.getInstance();

			calendar.setTime(contract.getDate());
			calendar.add(Calendar.MONTH, i);

			Installment installment = new Installment(calendar.getTime(), idao.paymentFee(interestRateInstallment));
			installmentList.add(installment);

		}
		contract.setInstallments(installmentList);

	}

}
