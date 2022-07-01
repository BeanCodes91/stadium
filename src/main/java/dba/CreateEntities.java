package dba;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import obj.*;

public class CreateEntities {
	
	private static Session				sessionCreate;
	private static List<StadiumSeat> 	seats;
	private static List<StadiumRow> 	rows;
	private static List<StadiumBlock>	blocks;
	private static StadiumStand[]		stands		= {	new StadiumStand("Haupttribüne"), new StadiumStand("Südtribüne"),
														new StadiumStand("Osttribüne"),new StadiumStand("Nordtribüne")};
	private static SportsEvent[]		sportevents = {	new SportsEvent("FC Kassel 05 - Schalke 04", "02.07.2022"),
														new SportsEvent("FC Kassel 05 - BVB 09", "16.07.2022"),
														new SportsEvent("FC Kassel 05 - Bayern München", "30.07.2022")};
	
	public CreateEntities(Session session) {
		sessionCreate = session;
		createSeats();
		createRows();
		createStands();
		createBlocks();
		createSportEvents();
	}
	
	/**
	 * Creates an ArrayList of StadiumSeat and fills it with 50 newly created objects, 
	 * which are then added to the database.
	 */
	public void createSeats() {
		seats 	= new ArrayList<StadiumSeat>();
		for(int i = 0; i < 50; i++) {
			seats.add(new StadiumSeat());
			sessionCreate.persist(seats.get(i));
		}
	}	// createSeats()
	
	/**
	 * Creates an ArrayList of StadiumRow and fills it with 10 newly created objects,
	 * which are then added to the database.
	 */
	public void createRows() {
		rows 	= new ArrayList<StadiumRow>();
		for(int i = 0; i < 10; i++) {
			rows.add(new StadiumRow((char)('A'+i), seats));
			sessionCreate.persist(rows.get(i));
		}
	}	// createRows()
	
	/**
	 * Adds each element of the array stands to the database.
	 */
	public void createStands() {
		for(StadiumStand stand: stands) {
			sessionCreate.persist(stand);
		}
	}	// createStands()
	
	/**
	 * Creates an ArrayList of StadiumBlock and fills it with 36 newly created objects,
	 * which are then added to the database.
	 * Before adding the elements to the database, the correct stand and price are determined.
	 */
	public void createBlocks() {
		
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
			sessionCreate.persist(block);
		}
	}	// createBlocks()
	
	/**
	 *  Adds each element of the array sportevents to the database.
	 */
	public void createSportEvents() {
		for(SportsEvent se: sportevents) {
			sessionCreate.persist(se);
		}
	}	// createSportEvents()

}
