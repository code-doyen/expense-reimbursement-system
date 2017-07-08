package com.revature.day3.oop;

import java.awt.print.Book;

public class Delta implements Airlines {

	public static void main(String[] args) {
		Delta d1 = new Delta();
		d1.bookAFlight();
		d1.baggageAllowane();
		d1.fareRules();
		d1.onlineCheckIn();
	}

	@Override
	public void bookAFlight() {
		System.out.println("book a flight");
	}

	@Override
	public void onlineCheckIn() {
		System.out.println("perform online checkin");
	}

	@Override
	public void baggageAllowane() {
		System.out.println("do we have to pay for the checked-in bags? really??");
	}

	@Override
	public void fareRules() {
		System.out.println("ticket price is also called fares");
	}

	@Override
	public void numberOfStops() {
		System.out.println("non-stop flights only");
	}

	
}
