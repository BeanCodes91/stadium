package obj;

import java.util.List;
import jakarta.persistence.*;

/**
 * This class provides the datatype of EventBooking to book tickets for one event.
 * 
 * @author Melanie Knorn
 *
 */

@Entity
@Table

public class EventBooking {

	/**
	 * Field variables
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookingID;
	
	@OneToOne
	private SportsEvent sportsEvent;
	
	@OneToMany
	private List<Ticket> tickets;
	
	/**
	 * Constructor without parameters
	 */
	public EventBooking() {}

	/**
	 * Constructor with event parameter
	 * 
	 * @param sportsEvent	An event
	 */
	public EventBooking(SportsEvent sportsEvent) {
		this.sportsEvent = sportsEvent;
	}

	/**
	 * Getters and Setters
	 */
	public int getBookingID() {
		return bookingID;
	}

	public SportsEvent getSportsEvent() {
		return sportsEvent;
	}

	public void setSportsEvent(SportsEvent sportsEvent) {
		this.sportsEvent = sportsEvent;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	/**
	 * ToString method
	 */
	@Override
	public String toString() {
		return "Ihre Bestellung:\n" + tickets;
	}
}
