package com.uin2020.crud_registro.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneradorPassword {
	public static void main(String[] args) {
	
		BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder(4);
		
		System.out.println(passwordEncoder.encode("1234"));
		System.out.println(passwordEncoder.encode("222"));
		System.out.println(passwordEncoder.encode("JosueEsMiNovio"));

	}
}
