package application;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;

public class application {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Enter contract data: ");
			
			System.out.println("Number: ");
			int number = sc.nextInt();
			
			System.out.println("Date (dd/MM/yyyy ");
			Date date = sdf.parse(sc.next());
			
			System.out.println("Contract Value: ");
			double value = sc.nextDouble();
			
			System.out.println("Enter number of installments: ");
			int installments = sc.nextInt();
			
			
			ContractService cs = new ContractService(installments, value, new PaypalService());
			
			Contract co = new Contract(number, date, value);
			
			cs.processContract(co, installments);
			
			System.out.println("Installments: ");
			System.out.println(co);
			
			sc.close();
				
				
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}



}
