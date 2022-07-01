package dba;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;

/**
 * This class manages the database access
 * 
 * @author Melanie Knorn
 *
 */

public class DBAccess {

	/*
	 * Field variables
	 */
	static Session 		session;
	static Transaction	transaction;
	static ListsFromDB	dbLists;
	
	public static void main(String[] args) {
		StandardServiceRegistry	registry	= 	new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata 				md 			= 	new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory 			sf 			= 	md.getSessionFactoryBuilder().build();
								session 	= 	sf.openSession();
						
		queryMethods();						
		createEntities();
	}	// main()
	
	/**
	 * Starts database transaction and calls methods to create the database entities.
	 * Lastly commits the transaction. 
	 */
	public static void createEntities() {
		
		transaction = session.beginTransaction();
		
		new CreateEntities(session);
	
		transaction.commit();
	}	// createEntities()
	
	public static void queryMethods() {
		transaction = session.beginTransaction();
		
		dbLists = new ListsFromDB(session);
//		System.out.println(dbLists.getBlocksWithSpace());
		transaction.commit();
	}
}