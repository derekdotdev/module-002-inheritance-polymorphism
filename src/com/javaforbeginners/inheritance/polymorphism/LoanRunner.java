package com.javaforbeginners.inheritance.polymorphism;

public class LoanRunner {

	public static void main(String[] args) {

		// int loanNumber, String customerLastName, int loanAmount, int loanTerm
		PersonalLoan personalLoan1 = new PersonalLoan(1, "DiLeo", 50000, 3, 1.25);
		System.out.println(personalLoan1);

		PersonalLoan personalLoan2 = new PersonalLoan(2, "Lyon", 50000, 3, 1.25);
		System.out.println(personalLoan2);

		System.out.println(personalLoan2.equals(personalLoan1));

		// BusinessLoan businessLoan1 = new BusinessLoan(2, "DiLeo", "Super Sound",
		// 50000, 2);
		// System.out.println(businessLoan1);

	}

}
