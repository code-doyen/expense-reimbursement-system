package com.revature.day3.oop;

public class PointGuard extends Player {

	public static void main(String[] args) {

		Player p1 = new Player();
		Player p2 = new PointGuard();
		PointGuard p3 = new PointGuard();
		// PointGuard p4 = new Player();

		p1.age(); // 57
		p1.name();
		p1.nationality();

		p2.age(); // 27
		p2.name();
		p2.nationality();

		p3.age(); // 27
		p3.name();
		p3.nationality();
		p3.makePoints();
	}

	@Override
	void age() {
		System.out.println("27");
	}

	void makePoints() {
		System.out.println("Point Guard make points");
	}

	@Override
	void nationality() {
		System.out.println("British");
	}

}
