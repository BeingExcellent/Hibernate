package com.beingExcellent.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beingExcellent.model.entity.User;

public class ConnectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User userDetails = new User();
		/**
		 *  Here no need to set userId since we have given GeneratedValue(strategy = GenerationType.IDENTITY), 
		 *  hence Hibernate will create and set the value
		 *  Point to be noted : if we are setting useId with some value also, Hibbernate will ignore this value
		 *  and will put the auto generated value
		 */
		userDetails.setFirstName("Bikramjit");
		userDetails.setLastName("Rajbongshi");
		userDetails.setEmail("bikram.rajbongshi@gmail.com");
		Session session = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(userDetails);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.getTransaction().commit();
			}
		}
	}

}
