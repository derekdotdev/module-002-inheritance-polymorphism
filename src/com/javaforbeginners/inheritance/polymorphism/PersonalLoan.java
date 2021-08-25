package com.javaforbeginners.inheritance.polymorphism;

public class PersonalLoan extends Loan {

	public PersonalLoan(int loanNumber, String customerLastName, int loanAmount, int loanTerm,
			double primeInterestRate) {
		super(loanNumber, customerLastName, loanAmount, loanTerm);
		this.interestRate = primeInterestRate + 2;
	}


}
