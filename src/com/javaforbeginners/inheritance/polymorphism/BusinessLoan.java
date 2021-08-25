package com.javaforbeginners.inheritance.polymorphism;

public class BusinessLoan extends Loan {

	public BusinessLoan(int loanNumber, String customerLastName, String companyName, int loanAmount, int loanTerm,
			double primeInterestRate) {
		super(loanNumber, customerLastName, loanAmount, loanTerm);
		this.interestRate = primeInterestRate + 1;
		this.companyName = companyName;

	}

}
