package dba;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;

//import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class DBAccess {

	static Session session;
	static Transaction transaction;

	public static void main(String[] args) {
		//Configuration c = new Configuration().configure();
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory sf = md.getSessionFactoryBuilder().build();
		session = sf.openSession();
		transaction = session.beginTransaction();
//		session.persist(new SportsEvent());
//		session.persist(new EventBooking());	
		transaction.commit();
	}

	public static void createEntities() {
	
	}
}