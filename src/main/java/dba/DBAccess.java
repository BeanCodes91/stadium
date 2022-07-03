package dba;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;

import dba_obj.BlockLists;
import dba_obj.GetAllLists;

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
	static GetAllLists	dbLists;
	
	/**
	 * Starts database transaction and calls methods to create the database entities.
	 * Lastly commits the transaction. 
	 */
	public static void createEntities() {
		
		transaction = session.beginTransaction();
		
		new CreateEntities(session);
	
		transaction.commit();
	}	// createEntities()
	
	/**
	 * Starts the transaction to handle queries for the database. 
	 * Lastly commits the transaction.
	 */
	public static void queryMethods() {
		transaction = session.beginTransaction();
		
		dbLists = new GetAllLists(session);
		BlockLists bList	= new BlockLists();
		System.out.println(dbLists.getAllBlocks());
		System.out.println(bList.getAllBlocksWithSeats());
		transaction.commit();
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
			StandardServiceRegistry	registry	= 	new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata 				md 			= 	new MetadataSources(registry).getMetadataBuilder().build();
			SessionFactory 			sf 			= 	md.getSessionFactoryBuilder().build();
									session 	= 	sf.openSession();
							
			queryMethods();						
			createEntities();
		}	// main()
}