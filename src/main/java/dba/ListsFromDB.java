package dba;

import java.util.ArrayList;

import org.hibernate.*;

import jakarta.persistence.TypedQuery;



import obj.*;

public class ListsFromDB {

	private static Session					sessionList;
	private static TypedQuery<EventBooking>	bookingQuery;
	private static TypedQuery<SportsEvent>	eventsQuery; 
	private static TypedQuery<StadiumBlock>	blockQuery;
	private static TypedQuery<StadiumRow>	rowQuery;
	private static TypedQuery<StadiumSeat>	seatQuery;
	private static TypedQuery<StadiumStand> standQuery;
	private static TypedQuery<Ticket>		ticketQuery;
	
	public ListsFromDB(Session session) {
		sessionList = session;
	}
	
	public ArrayList<SportsEvent> getAllEvents() {
		
		eventsQuery = sessionList.createQuery("from SportsEvent", SportsEvent.class);
		
		return (ArrayList<SportsEvent>)(eventsQuery.getResultList());
	}
	
	public ArrayList<StadiumBlock> getBlocksWithSpace() {
		
		blockQuery = (TypedQuery<StadiumBlock>) (sessionList.createQuery("from StadiumBlock where blockCap <= 500", StadiumBlock.class));
		
		return (ArrayList<StadiumBlock>)(blockQuery.getResultList());
	}
}
