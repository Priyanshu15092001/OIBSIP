package com.ors.controller;

import java.util.Scanner;

import com.ors.entity.Reservation;
import com.ors.entity.Users;

public class ReservationController {

	public static Reservation book(Users user) {
		
		Scanner kb=new Scanner(System.in);
		System.out.println("------------------------------------");
		System.out.print("Enter train number: ");
		int trainNum=kb.nextInt();
		System.out.print("Enter class type: ");
		String classType=kb.next();
		System.out.print("Enter the date of boarding(dd/mm/yyyy): ");
		String date=kb.next();
		System.out.print("Enter boarding point: ");
		String board=kb.next();
		System.out.print("Enter destination point: ");
		String dest=kb.next();
		
		Reservation reservation=new Reservation(trainNum,classType,date,board,dest,user.getUserId());
		return reservation;
		
		
	}

	public static int delete() {
		Scanner kb=new Scanner(System.in);
		System.out.println("------------------------------------");
		System.out.print("\nEnter the PNR NUMBER: ");
		int pnr=kb.nextInt();
		return pnr;
	}

}
