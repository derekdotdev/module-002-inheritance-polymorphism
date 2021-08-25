package com.javaforbeginners.inheritance.polymorphism;

import java.util.Scanner;

/*
- equals() method in Loan.java looks weird (used CMD+1 in Eclipse for assistance with this one). 
  There's likely a cleaner way to do this..
  
- Why does scanner.nextLine() skip first String input by default? (Why must it be called prior to for loop?)
- Same thing within if statement regarding customerLastName, and else if statement regarding companyName. 
  Without calling scanner.nextLine() at end of if statement, customerLastName is skipped for Loan #2.
  Without calling scanner.nextLine() at end of else if statement, 
  requestLoanInfo() prints to screen before companyName is entered which will likely confuse user.   
  
- Using overloaded printResult() method to accommodate companyName variable which is only present in a BusinessLoan. 
  Is it possible to reduce the amount of duplicate code here?
 * */

public class CreateLoans {


	public static void main(String[] args) {

		// Initialize scanner
		Scanner scanner = new Scanner(System.in);

		// Create array to store loan info
		// Loan[5] throws out of bounds exception
		Loan[] loanList = new Loan[6];

		// Welcome User, ask interest rate
		System.out.println("Welcome to CreateLoans. We build loans in batches of five at a time.\n");
		System.out.println("What is the current prime interest rate?\n");
		double primeInterestRate = scanner.nextDouble();
		System.out.println("Thanks.\n");
		System.out.println("\nFor the following questions, please enter each response individually.");

		// Allow scanner to accept first customerLastNameAsk input
		// Otherwise skips String input and expects Integer (InputMismatchException)
		String customerLastNameAsk = scanner.nextLine();

		// Loop 5 times to build loans
		for (int i = 1; i <= 5; i++) {
			int loanNumber = i;
			String companyName = null;

			// Request loan information
			requestLoanInfo();

			// Collect loan information
			customerLastNameAsk = scanner.nextLine();
			int loanTermAsk = scanner.nextInt();
			int loanAmountAsk = scanner.nextInt();
			int choice = -1;
			
			// Catch incorrect input for loan type. Force choice to be 0 or 1
			while (choice != 0 || choice != 1) {
				choice = scanner.nextInt();
				// Create chosen Loan type
				if (choice == 0) {
					loanList[i] = new PersonalLoan(loanNumber, customerLastNameAsk, loanAmountAsk,
							loanTermAsk, primeInterestRate);
					customerLastNameAsk = scanner.nextLine();
					break;
				} else if (choice == 1) {
					// Collect companyName prior to BusinessLoan instance creation
					System.out.println("Please enter company name: \n");
					scanner.nextLine(); // pause for two reasons:
					// 1) Give user time to input companyName
					// 2) Wait to print next "request loan information" prompt to avoid confusion
					companyName = scanner.nextLine();
					loanList[i] = new BusinessLoan(loanNumber, customerLastNameAsk, companyName, loanAmountAsk,
							loanTermAsk,
							primeInterestRate);
					break;
				} else {
					// Warn user of invalid input
					System.out.println("\nInvalid loan type! Enter 0 for Personal OR 1 for Business");
				}			
			}
		}

		for (int j = 1; j <= 5; j++) {
			System.out.println(loanList[j]);
		}
		System.out.println("\nThanks for choosing CreateLoans! Goodbye.");
		scanner.close();

	}

	private static void requestLoanInfo() {
		System.out.println("\nEnter the customer's last name: ");
		System.out.println("\nEnter 1, 3 or 5 to indicate loan term (in years): ");
		System.out.println("\nEnter the loan amount from 0-50000: ");
		System.out.println("\nEnter 0 for a Personal loan or 1 for a Business loan: ");
	}

}
