package model.entities;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Contract {
	private int number;
	private Date date;
	private double totalValue;
	private List<Installment> installments;
	
	private Installment installment;

	public Contract(int number, Date date, double totalValue) {
		super();
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	
	}
	
	

	public List<Installment> getInstallments() {
		return installments;
	}



	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}



	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public Installment getInstallment() {
		return installment;
	}

	public void setInstallment(Installment installment) {
		this.installment = installment;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("##,###.##"); 
		StringBuilder sb = new StringBuilder();
 
		for (Installment installment : installments) {
			sb.append(sdf.format(installment.getDueDate()) + " - R$");
			sb.append(df.format(installment.getAmount()));
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	
	
	

}
