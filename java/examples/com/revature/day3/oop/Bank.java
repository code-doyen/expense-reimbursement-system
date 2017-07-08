package com.revature.day3.oop;

public class Bank {

	private int accountNumber;
	private double accountBalance;
	private float rateOfInterest;
	private int fees;
	private String accountName;
	
	public Bank() {
		super();
	}

	public Bank(double accountBalance, float rateOfInterest) {
		super();
		this.accountBalance = accountBalance;
		this.rateOfInterest = rateOfInterest;
	}

	public Bank(int accountNumber, double accountBalance, float rateOfInterest, int fees, String accountName) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.rateOfInterest = rateOfInterest;
		this.fees = fees;
		this.accountName = accountName;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getAccountNumber() {
		System.out.println("AccountNumber : " + accountNumber + " AccountBalance " + this.accountBalance);
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + accountNumber;
		result = prime * result + fees;
		result = prime * result + Float.floatToIntBits(rateOfInterest);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (accountNumber != other.accountNumber)
			return false;
		if (fees != other.fees)
			return false;
		if (Float.floatToIntBits(rateOfInterest) != Float.floatToIntBits(other.rateOfInterest))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Bank [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + "]";
	}
	
}
