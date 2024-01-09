package com.ors;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ors.controller.UserController;
import com.ors.entity.Users;
import com.ors.route.ReservationForm;

public class App {

	public static void main(String[] args) {
	java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		

		boolean flag = true;

		while (flag) {
			
			
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
					.buildSessionFactory();

			Session session = factory.getCurrentSession();
			
			
			
			System.out.println("------------------------------------");
			System.out.println("Press the number you want to perform:");
			System.out.println("1. Create a account");
			System.out.println("2. Login");
			System.out.println("3. Exit");

			Scanner kb = new Scanner(System.in);
			int ch = kb.nextInt();
			
			System.out.println();
			switch (ch) {
			case 1: {
				Users user = UserController.createAccount();
				try {

					session.beginTransaction();
					session.save(user);
					session.getTransaction().commit();
					System.out.println("Account created");
					System.out.println("------------------------------------");
				} finally {
					session.close();
					factory.close();
					flag = true;
				}
			}
				break;

			case 2:{
				List<Users>list;
				Users user=UserController.login();
				try {

					session.beginTransaction();
					list= session.createQuery("from users where email=:email AND password=:password")
							.setString("email", user.getEmail())
							.setString("password", user.getPassword())
							.getResultList();
					user=list.get(0);
					//System.out.println(user.toString());
					ReservationForm.form(user);

				} finally {
					session.close();
					factory.close();
					flag = true;
				}
			}
				break;

			case 3:
				
				session.close();
				factory.close();
				flag = false;
				System.out.println("------------------------------------");
				break;

			}
		}

	}

}