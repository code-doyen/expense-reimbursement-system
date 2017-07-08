package com.classmembers;

public class Retailer {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer David = new Customer("David", "Vollmar", "405 Biglow Ave.", "419-333-2222");
		Customer Leah = new Customer("Leah", "Vollmar", "109 Colly Dr.", "419-333-1291");
		David.setClientContacts("123 Zippy Ave.");
		David.setClientContacts("125 Pippy St.", "419-343-4333");
		Leah.setClientContacts("103 Happy Ave.");
		Leah.setClientContacts("169 Chipper St.", "419-222-3333");
		System.out.println(David.id +" " + David.year +" " + David.nameFirst+" " + David.nameLast +" " + David.location+ " " + David.contact);

		System.out.println(Leah.id +" " + Leah.year +" " + Leah.nameFirst+" " + Leah.nameLast+" " + Leah.location+ " " + Leah.contact);
		}

}
