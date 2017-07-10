package com.revature.day4.collections;

import java.util.Comparator;

public class HatColorComparator implements Comparator<Hat> {

	@Override
	public int compare(Hat h1, Hat h2) {
		return h1.getColor().compareTo(h2.getColor());
	}

}
