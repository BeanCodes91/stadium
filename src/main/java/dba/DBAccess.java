package dba;

import java.util.*;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;

import obj.*;

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
			static Session 				session;
			static Transaction 			transaction;
	private static List<StadiumSeat> 	seats;
	private static List<StadiumRow> 	rows;
	private static List<StadiumBlock>	blocks;
	private static StadiumStand[]		stands		= {	new StadiumStand("Haupttribüne"), new StadiumStand("Südtribüne"),
														new StadiumStand("Osttribüne"),new StadiumStand("Nordtribüne")};
	private static SportsEvent[]		sportevents = {	new SportsEvent("FC Kassel 05 - Schalke 04", "02.07.2022"),
														new SportsEvent("FC Kassel 05 - BVB 09", "16.07.2022"),
														new SportsEvent("FC Kassel 05 - Bayern München", "30.07.2022")};
	
	public static void main(String[] args) {
		StandardServiceRegistry 		registry	= 	new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata 						md 			= 	new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory 					sf 			= 	md.getSessionFactoryBuilder().build();
										session 	= 	sf.openSession();
		
										
//		createEntities();
	}	// main()
	
	/**
	 * Starts database transaction and calls methods to create the database entities.
	 * Lastly commits the transaction. 
	 */
	public static void createEntities() {
		
		transaction = session.beginTransaction();
		
		createSeats();
		createRows();
		createStands();
		createBlocks();
		createSportEvents();

		transaction.commit();
	}	// createEntities()
	
	/**
	 * Creates an ArrayList of StadiumSeat and fills it with 50 newly created objects, 
	 * which are then added to the database.
	 */
	public static void createSeats() {
		seats 	= new ArrayList<StadiumSeat>();
		for(int i = 0; i < 50; i++) {
			seats.add(new StadiumSeat());
			session.persist(seats.get(i));
		}
	}	// createSeats()
	
	/**
	 * Creates an ArrayList of StadiumRow and fills it with 10 newly created objects,
	 * which are then added to the database.
	 */
	public static void createRows() {
		rows 	= new ArrayList<StadiumRow>();
		for(int i = 0; i < 10; i++) {
			rows.add(new StadiumRow((char)('A'+i), seats));
			session.persist(rows.get(i));
		}
	}	// createRows()
	
	/**
	 * Adds each element of the array stands to the database.
	 */
	public static void createStands() {
		for(StadiumStand stand: stands) {
			session.persist(stand);
		}
	}	// createStands()
	
	/**
	 * Creates an ArrayList of StadiumBlock and fills it with 36 newly created objects,
	 * which are then added to the database.
	 * Before adding the elements to the database, the correct stand and price are determined.
	 */
	public static void createBlocks() {
		
		// Initialization
		blocks = new ArrayList<StadiumBlock>();
		
		for(int i = 1; i <= 36; i++) {
			
			StadiumBlock block = new StadiumBlock(rows);
			
			// block is in main stand
			if(i <= 16) {
				block.setStandName(stands[0]);
				if		(i <= 4 || i >=13) {
					block.setBlockPrice(10.0);
					block.setRows(null);
				}
				else if	(i >= 7 && i <= 10) {
					block.setBlockPrice(18.0);
				}
				else {
					block.setBlockPrice(15.0);
				}
			}
			// block is in southern stand
			else if(i <= 22) {
				block.setStandAndPrice(stands[1], 8.0);
				block.setRows(null);
			}
			// block is in eastern stand
			else if(i <= 29) {
				block.setStandAndPrice(stands[2], 12.0);
			}
			// block is in northern stand
			else {
				block.setStandAndPrice(stands[3], 8.0);
				block.setRows(null);
			}
			
			blocks.add(block);
			session.persist(block);
		}
	}	// createBlocks()
	
	/**
	 *  Adds each element of the array sportevents to the database.
	 */
	public static void createSportEvents() {
		for(SportsEvent se: sportevents) {
			session.persist(se);
		}
	}	// createSportEvents()
}