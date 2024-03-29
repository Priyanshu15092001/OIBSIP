package com.ors.route;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ors.controller.ReservationController;
import com.ors.entity.Reservation;
import com.ors.entity.Users;

public class ReservationForm {

	public static void form(Users user) {
		Scanner kb = new Scanner(System.in);
		
	
		
		boolean flag = true;
		while (flag) {
			
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Reservation.class)
					.buildSessionFactory();

			Session session = factory.getCurrentSession();
			
			
			
			
			System.out.println("Press the number you want to perform:");
			System.out.println("1. Booking");
			System.out.println("2. Cancel Booking");
			System.out.println("3. All Bookings");
			System.out.println("4. Logout");
			int ch = kb.nextInt();

			switch (ch) {
			case 1: {

				Reservation reservation=ReservationController.book(user);
				
				try {

					session.beginTransaction();
					session.save(reservation);
					session.getTransaction().commit();
					System.out.println("\n   Booking Confirmed");
					System.out.println("------------------------------------");
				} finally {
					session.close();
					factory.close();
					flag = true;
				}
				
				break;
			}
			
			case 2: {
				int pnrNum=ReservationController.delete();
				try {
					session.beginTransaction();
					session.createQuery("update reservation set status='CANCELLED' where pnr_number=:pnr")
					.setInteger("pnr", pnrNum)
					.executeUpdate();
					
					
					
					System.out.println("Booking Cancelled \n");
					System.out.println("------------------------------------");
				} finally {
					session.close();
					factory.close();
					flag = true;
				}
				
				
				
				break;
			}
			
			case 3:{
				
				List<Reservation>list;
				
				try {

					session.beginTransaction();
					list= session.createQuery("from reservation where user_id=:uid")
							.setString("uid", user.getUserId())
							.getResultList();
	
					
					System.out.println("All Bookings:");
					System.out.println();
					for(Reservation res:list)
					{
						System.out.println("------------------------------------");
						System.out.println("PNR Number: "+res.getPnrNumber() );
						System.out.println("Train Number: "+res.getTrainNumber());
						System.out.println("Class Type: "+res.getClassType());
						System.out.println("Date of Journey: "+res.getDate());
						System.out.println("Boarding Point: "+res.getBoardingPoint());
						System.out.println("Destination Point: "+res.getDestinationPoint());
						System.out.println("Status: "+res.getStatus());
						System.out.println("------------------------------------");
						System.out.println();
						
					}
					

				} finally {
					session.close();
					factory.close();
					flag = true;
				}
				
				break;
			}

			case 4: {
				session.close();
				factory.close();
				flag = false;
				System.out.println("------------------------------------");
				break;
			}

			}
		}

		return;

	}

}
