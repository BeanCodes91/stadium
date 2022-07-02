package dba;

import java.util.ArrayList;
import org.hibernate.*;
import jakarta.persistence.TypedQuery;
import obj.*;

public class ListsFromDB {

	private static Session					sessionList;
	
	private static TypedQuery<EventBooking>	bookingQuery;
	private static ArrayList<EventBooking>	bookingList;
	
	private static TypedQuery<SportsEvent>	eventsQuery; 
	private static ArrayList<SportsEvent>	eventsList; 
	
	private static TypedQuery<StadiumBlock>	blockQuery;
	private static ArrayList<StadiumBlock>	blockList;
	
	private static TypedQuery<StadiumRow>	rowQuery;
	private static ArrayList<StadiumRow>	rowList;
	
	private static TypedQuery<StadiumSeat>	seatQuery;
	private static ArrayList<StadiumSeat>	seatList;
	
	private static TypedQuery<StadiumStand> standQuery;
	private static ArrayList<StadiumStand> 	standList;
	
	private static TypedQuery<Ticket>		ticketQuery;
	private static ArrayList<Ticket>		ticketList;
	
	public ListsFromDB(Session session) {
		sessionList = session;
	}
	
	public ArrayList<StadiumSeat> getAllSeats() {
		
		seatQuery	= sessionList.createQuery("from StadiumSeat", StadiumSeat.class);
		seatList	= (ArrayList<StadiumSeat>)(seatQuery.getResultList());
		
		return seatList;
	}
	
	public ArrayList<StadiumRow> getAllRows() {
		
		rowQuery 	= sessionList.createQuery("from StadiumRow where", StadiumRow.class);
		rowList		= (ArrayList<StadiumRow>)(rowQuery.getResultList());
		
		return rowList;
	}
	
	public ArrayList<StadiumBlock> getAllBlocks() {
		
		blockQuery 	= sessionList.createQuery("from StadiumBlock", StadiumBlock.class);
		blockList	= (ArrayList<StadiumBlock>)(blockQuery.getResultList());
		
		return blockList;
	}
	
	public ArrayList<StadiumStand> getAllStands() {
		
		standQuery	= sessionList.createQuery("from StadiumStand", StadiumStand.class);
		standList	= (ArrayList<StadiumStand>)(standQuery.getResultList());
		
		return standList;
	}
	
	public ArrayList<SportsEvent> getAllEvents() {
		
		eventsQuery = sessionList.createQuery("from SportsEvent", SportsEvent.class);
		eventsList	= (ArrayList<SportsEvent>)(eventsQuery.getResultList());
		
		return eventsList;
	}
	
	public ArrayList<Ticket> getAllTickets() {
		
		ticketQuery		= sessionList.createQuery("from Ticket", Ticket.class);
		ticketList		= (ArrayList<Ticket>)(ticketQuery.getResultList());
		
		return ticketList;
	}
	
	public ArrayList<EventBooking> getAllBookings() {
		
		bookingQuery	= sessionList.createQuery("from EventBooking", EventBooking.class);
		bookingList		= (ArrayList<EventBooking>)(bookingQuery.getResultList());
		
		return bookingList;
	}
	
	
	public ArrayList<StadiumBlock> getAvailableBlocks() {
		
		blockQuery 	= sessionList.createQuery("from StadiumBlock where blockCap < 500", StadiumBlock.class);
		blockList	= (ArrayList<StadiumBlock>)(blockQuery.getResultList());
		
		return blockList;
	}
	
	public ArrayList<StadiumBlock> getAvailableBlocksWithSeats() {
		
		blockList	= getAvailableBlocks();
		
		for(int i = 0; i < blockList.size(); i++) {
			if(blockList.get(i).getRows().isEmpty()) {
				blockList.remove(i);
				i--;
			}
		}
		return blockList;
	}
	
	
	public ArrayList<StadiumRow> getAvailableRowsFromBlock(int numberSeats) {
		
		rowQuery 	= sessionList.createQuery("from StadiumRow where seatsAvailable >= " + numberSeats, StadiumRow.class);
		rowList		= (ArrayList<StadiumRow>)(rowQuery.getResultList());
		
		return rowList;
	}
}
