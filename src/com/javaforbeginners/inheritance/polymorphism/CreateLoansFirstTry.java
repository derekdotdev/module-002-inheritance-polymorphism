package com.javaforbeginners.inheritance.polymorphism;

import java.util.Scanner;

public class CreateLoansFirstTry {


	public static void main(String[] args) {

		// Initialize scanner
		Scanner scanner = new Scanner(System.in);

		// Create array to store loan info (5 throws out of bounds exception)
		Loan[] loanList = new Loan[6];

		// Welcome User, ask interest rate
		System.out.println("Welcome to CreateLoans. We build loans in batches of five at a time.\n");
		System.out.println("What is the current prime interest rate?\n");
		double primeInterestRate = scanner.nextDouble();
		System.out.println("Thanks. Please answer a few questions to build your loans.\n");

		// Loop 5 times to build loans
		for (int i = 1; i <= 5; i++) {
			int loanNumber = i;
			String companyName = null; //
			int choice = collectLoanType(scanner);
			String customerLastNameAsk = collectLastName(scanner);
			System.out.println("Last name is: " + customerLastNameAsk);
			int loanAmountAsk = collectLoanAmount(scanner);
			int loanTermAsk = collectLoanTerm(scanner);

			if (choice == 0) {
				loanList[i] = new PersonalLoan(loanNumber, customerLastNameAsk, loanAmountAsk,
						loanTermAsk, primeInterestRate);
			} else if (choice == 1) {
				System.out.println("Company name (camelCase): \n");
				companyName = scanner.next();
				loanList[i] = new BusinessLoan(i, customerLastNameAsk, companyName, loanAmountAsk, loanTermAsk,
						primeInterestRate);
			} else {
				System.out.println("Invalid loan type! (0 for Personal - 1 for Business)");

			}

		}

		for (int j = 1; j <= 5; j++) {
			System.out.println(loanList[j]);
		}
		System.out.println("\nThanks for choosing CreateLoans! Goodbye.");
		scanner.close();
	}

	private static int collectLoanType(Scanner scanner) {
		int choice;
		System.out.println("Enter 0 for a Personal loan or 1 for a Business loan.\n");
		choice = scanner.nextInt();
		return choice;
	}

	private static int collectLoanTerm(Scanner scanner) {
		System.out.println("Loan Term (years): \n");
		System.out.println("Enter 1,3 or 5. \n");
		int loanTermAsk = scanner.nextInt();
		return loanTermAsk;
	}

	private static int collectLoanAmount(Scanner scanner) {
		System.out.println("Enter the loan amount from 0-50000: \n");
		int loanAmountAsk = scanner.nextInt();
		return loanAmountAsk;
	}

	private static String collectLastName(Scanner scanner) {
		System.out.println("Customer's last name: \n");
		String customerLastNameAsk = scanner.nextLine();
		return customerLastNameAsk;
	}
}
