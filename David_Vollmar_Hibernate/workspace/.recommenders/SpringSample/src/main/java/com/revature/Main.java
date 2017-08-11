package com.revature;

import com.revature.service.JediService;
import com.revature.service.JediServiceForce;

public class Main {
	public static void main(String[] args) {
		JediService jediService = new JediServiceForce();
		
		System.out.println(jediService.getAllJedis());
	}
}
