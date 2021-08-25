package com.javaforbeginners.inheritance.polymorphism;

public abstract class Loan implements LoanConstants {

	private int loanNumber;
	private int loanAmount;
	protected double interestRate;
	protected double primeInterestRate;
	private int loanTerm;
	private String customerLastName;
	protected String companyName;

	public Loan(int loanNumber, String customerLastName, int loanAmount, int loanTerm) {
		this.loanNumber = loanNumber;
		this.customerLastName = customerLastName;

		// Prevent unauthorized loanAmounts
		if (loanAmount >= 0 && loanAmount <= maxLoanAmount) {
			this.loanAmount = loanAmount;
		} else {
			this.loanAmount = 0;
			System.out.println("Error: Loan Request Exceeds Limit. Loan Amount set to $0");
		}

		if (loanTerm != shortTerm && loanTerm != mediumTerm && loanTerm != longTerm) {
			this.loanTerm = shortTerm;
		} else {
			this.loanTerm = loanTerm;
		}
	}

	public int getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getPrimeInterestRate() {
		return primeInterestRate;
	}

	public void setPrimeInterestRate(double primeInterestRate) {
		this.primeInterestRate = primeInterestRate;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public int getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		String result;
		if (companyName == null) {
			result = printResult();
		} else {
			result = printResult(companyName);
		}
		return result;
	}

	private String printResult(String companyName) {
		return "Loan #: " + loanNumber + ", " + "Customer Last Name: " + customerLastName + ", " + "Company Name: "
				+ companyName + ", " + "Loan Amount: $" + loanAmount + ", " + "Loan Term: " + loanTerm + ", "
				+ "Interest Rate: " + interestRate + "%.";
	}

	private String printResult() {
		return "Loan #: " + loanNumber + ", " + "Customer Last Name: " + customerLastName + ", "
				+ "Loan Amount: $" + loanAmount + ", " + "Loan Term: " + loanTerm + ", " + "Interest Rate: "
				+ interestRate + "%.";
	}

	@Override
	public boolean equals(Object o) {
		if (this.loanAmount == ((Loan) o).getLoanAmount() && this.loanTerm == ((Loan) o).getLoanTerm()) {
			return true;
		} else {
			return false;
		}
	}

}
