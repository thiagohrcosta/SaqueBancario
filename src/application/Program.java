package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter account data: ");
		System.out.print("Number : ");
		int number = sc.nextInt();
		System.out.print("Holder name : ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Inicial balance : ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw Limit : ");
		double withdrawLimit = sc.nextDouble();
		System.out.println("========================================");
		
		Account account1 = new Account(number, holder, balance, withdrawLimit);
		
		System.out.print("Enter the amount to withdraw Mr(s)." + account1.getHolder() + " : ");
		
		double amount = sc.nextDouble();
		try {
			account1.withdraw(amount);
			System.out.println("New balance: $ " + String.format("%.2f", account1.getBalance()));
		}
		catch (DomainException e) {
			System.out.println("Witdraw error: " + e.getMessage());
			
		}	
		
		
		sc.close();

	}

}
