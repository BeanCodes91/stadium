package dba_obj;

import java.util.ArrayList;
import org.hibernate.*;
import jakarta.persistence.TypedQuery;
import obj.*;

/**
 * This class provides ArrayLists containing all data for an obj class
 * 
 * @author Melanie Knorn
 *
 */
public class AllLists {

	/**
	 * Field variables
	 */
	private	static Session					sessionList;
			static TypedQuery<EventBooking>	bookingQuery;
			static ArrayList<EventBooking>	bookingList;
			static TypedQuery<SportsEvent>	eventsQuery; 
			static ArrayList<SportsEvent>	eventsList; 
			static TypedQuery<StadiumBlock>	blockQuery;
			static ArrayList<StadiumBlock>	blockList;
			static TypedQuery<StadiumRow>	rowQuery;
			static ArrayList<StadiumRow>	rowList;
			static TypedQuery<StadiumSeat>	seatQuery;
			static ArrayList<StadiumSeat>	seatList;
			static TypedQuery<StadiumStand> standQuery;
			static ArrayList<StadiumStand> 	standList;
			static TypedQuery<Ticket>		ticketQuery;
			static ArrayList<Ticket>		ticketList;
	
	/**
	 * Constructor without parameters
	 */
	public AllLists() {}
	
	/**
	 * Constructor with session parameter
	 */
	public AllLists(Session session) {
		sessionList = session;
	}
	
	/**
	 * Gets an ArrayList of all the seats in the database
	 * 
	 * @return	seatList	All the seats
	 */
	public ArrayList<StadiumSeat> getAllSeats() {
		
		seatQuery	= sessionList.createQuery("from StadiumSeat", StadiumSeat.class);
		seatList	= (ArrayList<StadiumSeat>)(seatQuery.getResultList());
		
		return seatList;
	}
	
	/**
	 * Gets an ArrayList of all the rows in the database
	 * 
	 * @return	rowList		All the rows
	 */
	public ArrayList<StadiumRow> getAllRows() {
		
		rowQuery 	= sessionList.createQuery("from StadiumRow where", StadiumRow.class);
		rowList		= (ArrayList<StadiumRow>)(rowQuery.getResultList());
		
		return rowList;
	}
	
	/**
	 * Gets an ArrayList of all the blocks in the database
	 * 
	 * @return	blockList	All the blocks
	 */
	public ArrayList<StadiumBlock> getAllBlocks() {
		
		blockQuery 	= sessionList.createQuery("from StadiumBlock", StadiumBlock.class);
		blockList	= (ArrayList<StadiumBlock>)(blockQuery.getResultList());
		
		return blockList;
	}
	
	/**
	 * Gets an ArrayList of all the stands in the database
	 * 
	 * @return	blockList	All the stands
	 */
	public ArrayList<StadiumStand> getAllStands() {
		
		standQuery	= sessionList.createQuery("from StadiumStand", StadiumStand.class);
		standList	= (ArrayList<StadiumStand>)(standQuery.getResultList());
		
		return standList;
	}
	
	/**
	 * Gets an ArrayList of all the events in the database
	 * 
	 * @return	blockList	All the events
	 */
	public ArrayList<SportsEvent> getAllEvents() {
		
		eventsQuery = sessionList.createQuery("from SportsEvent", SportsEvent.class);
		eventsList	= (ArrayList<SportsEvent>)(eventsQuery.getResultList());
		
		return eventsList;
	}
	
	/**
	 * Gets an ArrayList of all the tickets in the database
	 * 
	 * @return	blockList	All the tickets
	 */
	public ArrayList<Ticket> getAllTickets() {
		
		ticketQuery		= sessionList.createQuery("from Ticket", Ticket.class);
		ticketList		= (ArrayList<Ticket>)(ticketQuery.getResultList());
		
		return ticketList;
	}
	
	/**
	 * Gets an ArrayList of all the bookings in the database
	 * 
	 * @return	blockList	All the bookings
	 */
	public ArrayList<EventBooking> getAllBookings() {
		
		bookingQuery	= sessionList.createQuery("from EventBooking", EventBooking.class);
		bookingList		= (ArrayList<EventBooking>)(bookingQuery.getResultList());
		
		return bookingList;
	}
}
