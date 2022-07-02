package dba;

import java.util.ArrayList;
import obj.*;

public class GetAvailableLists {
	
	private static GetAllLists gal;
	
	private static ArrayList<EventBooking>	bookingList;
	private static ArrayList<SportsEvent>	eventsList; 
	private static ArrayList<StadiumBlock>	blockList;
	private static ArrayList<StadiumRow>	rowList;
	private static ArrayList<StadiumSeat>	seatList;
	private static ArrayList<StadiumStand> 	standList;
	private static ArrayList<Ticket>		ticketList;
	
	public GetAvailableLists() {
		
		gal 		= new GetAllLists();
		bookingList	= gal.getAllBookings();
		eventsList	= gal.getAllEvents();
		blockList	= gal.getAllBlocks();
		rowList		= gal.getAllRows();
		seatList	= gal.getAllSeats();
		standList	= gal.getAllStands();
		ticketList	= gal.getAllTickets();
		
	}

	public ArrayList<StadiumBlock> getAvailableBlocks(int ticketAmount) {
		
		for(int i = 0; i < blockList.size(); i++) {
			if(blockList.get(i).getBlockCap() <= (500 - ticketAmount)) blockList.remove(i--);
		}
		
		return blockList;
	}
}
