package com.ors.controller;

import java.util.Scanner;

import com.ors.entity.Users;

public class UserController {
	
	static Scanner kb=new Scanner(System.in);

	public static Users createAccount()
	{
		System.out.println("------------------------------------");
		System.out.print("Enter your First Name: ");
		String firstName=kb.next();
		System.out.println();
		
		System.out.print("Enter your Last Name: ");
		String lastName=kb.next();
		System.out.println();
		
		System.out.print("Enter your Email: ");
		String email=kb.next();
		System.out.println();
		
		System.out.print("Enter your Password: ");
		String password=kb.next();
		System.out.println();
		
		Users user=new Users(firstName,lastName,email,password);
		
		return user;
	}

	public static Users login() {
		
		System.out.println("------------------------------------");
		System.out.print("Enter your Email: ");
		String email=kb.next();
		
		
		System.out.print("Enter your Password: ");
		String password=kb.next();
	
		
		System.out.println();
		
		Users user=new Users(email,password);
		return user;
	}
	
}