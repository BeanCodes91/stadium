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
	private static StadiumStand[]		stands		= {new StadiumStand("Haupttribüne"), new StadiumStand("Südtribüne"),
														new StadiumStand("Osttribüne"),new StadiumStand("Nordtribüne")};
	private static SportsEvent[]		sportevents = {new SportsEvent("FC Kassel 05 - Schalke 04", "02.07.2022"),
														new SportsEvent("FC Kassel 05 - BVB 09", "16.07.2022"),
														new SportsEvent("FC Kassel 05 - Bayern München", "30.07.2022")};
	
	public static void main(String[] args) {
		//Configuration 				c 			= new Configuration().configure();
		StandardServiceRegistry 		registry	= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata 						md 			= new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory 					sf 			= md.getSessionFactoryBuilder().build();
										session 	= sf.openSession();
		
//		createEntities();
	}	// main()
	
	public static void createEntities() {
		
		transaction = session.beginTransaction();
		
		createSeats();
		createRows();
		createStands();
		createBlocks();
		createSportEvents();

		transaction.commit();
	}	// createEntities()
	
	public static void createSeats() {
		seats 	= new ArrayList<StadiumSeat>();
		for(int i = 0; i < 50; i++) {
			seats.add(new StadiumSeat());
			session.persist(seats.get(i));
		}
	}	// createSeats()
	
	public static void createRows() {
		rows 	= new ArrayList<StadiumRow>();
		for(int i = 0; i < 10; i++) {
			rows.add(new StadiumRow((char)('A'+i), seats));
			session.persist(rows.get(i));
		}
	}	// createRows()
	
	public static void createStands() {
		for(StadiumStand stand: stands) {
			session.persist(stand);
		}
	}	// createStands()
	
	public static void createBlocks() {
		
		StadiumStand stand;
		double price;
		
		blocks = new ArrayList<StadiumBlock>();
		
		for(int i = 1; i <= 36; i++) {
			if(i <= 16) {
				stand = stands[0];
				if		(i <= 4 || i >=13) 	price = 10.0;
				else if	(i >= 7 && i <= 10) price = 18.0;
				else 						price = 15.0;
			}
			else if(i <= 22) {
				stand = stands[1];
				price = 8.0;
			}
			else if(i <= 29) {
				stand = stands[2];
				price = 12.0;
			}
			else {
				stand = stands[3];
				price = 8.0;
			}
			
			blocks.add(new StadiumBlock(stand, price, rows));
			session.persist(blocks.get(i-1));
		}
	}	// createBlocks()
	
	public static void createSportEvents() {
		for(SportsEvent se: sportevents) {
			session.persist(se);
		}
	}	// createSportEvents()
}